package com.androidbull.mypronounce.ui.feature.dailylesson.receiver

import android.app.AlarmManager
import android.app.AlarmManager.AlarmClockInfo
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import com.androidbull.mypronounce.constant.Constants.*
import com.androidbull.mypronounce.data.local.database.AppDatabase
import com.androidbull.mypronounce.data.model.DailyLesson
import com.androidbull.mypronounce.ui.helper.NotificationGenerator
import com.androidbull.mypronounce.ui.helper.PreferenceManager
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*


class DailyLessonNotificationManager : BroadcastReceiver() {

    private lateinit var mContext: Context

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("test", "onHandleIntent: in daily lesson notifier broadcast")
        mContext = context

        if (!TextUtils.isEmpty(intent.action)) {
            when {
                intent.action.equals(INTENT_ACTION_DAILY_LESSON_NOTIFIER) -> {

                    setDailyLessonNotifier()
                    GlobalScope.launch(Dispatchers.IO) {
                        notifyDailyLesson()
                    }
                }
                intent.action.equals(INTENT_ACTION_DELETE_NOTIFICATION) -> {
                    intent.extras?.let {
                        val lesson = it.getSerializable(INTENT_EXTRA_DELETE_NOTIFICATION) as DailyLesson
                        logNotificationDeleteEvent(lesson)
                    }
                }
                intent.action.equals(INTENT_ACTION_NOTIFY_LATER) -> {

                    deleteNotification(intent)

                    intent.extras?.let {
                        val lesson = it.getSerializable(INTENT_EXTRA_NOTIFY_LATER) as DailyLesson
                        saveLessonToRemind(lesson)
                        setLaterReminderNotifier()
                        logLessonLaterEvent(lesson)
                    }
                }
                intent.action.equals(INTENT_ACTION_LATER_NOTIFIER) -> {
                    getLessonFromSP()?.let {
                        NotificationGenerator.generateDailyLessonLaterNotification(context, it)
                        showNewLessonBadge()
                    }
                }
            }
        }
    }

    private fun showNewLessonBadge() {
        PreferenceManager.getInstance(mContext).setBoolean(UNREAD_LESSON, true)
    }

    private fun getLessonFromSP(): DailyLesson? {
        val lessonStr = PreferenceManager.getInstance(mContext).getString("lessonToRemind")
        if (!TextUtils.isEmpty(lessonStr)) {
            return Gson().fromJson(lessonStr, DailyLesson::class.java)
        }

        return null
    }

    private fun saveLessonToRemind(lesson: DailyLesson) {
        PreferenceManager.getInstance(mContext).setString("lessonToRemind", Gson().toJson(lesson))
    }


    private fun deleteNotification(intent: Intent) {
        val notificationId = intent.getIntExtra(INTENT_EXTRA_NOTIFY_LATER_NOTIFICATION_ID, -1)
        if (notificationId > 0) {
            val notificationManager = mContext
                    .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.cancel(notificationId)
        }
    }


    private suspend fun notifyDailyLesson() {
//        val pendingResult: PendingResult = goAsync()
        val lessonNumber = getLesson()
        withContext(Dispatchers.Main) {
            lessonNumber?.let {
                NotificationGenerator.generateDailyLessonNotification(mContext, it)
                showNewLessonBadge()
                updateLessonNumber(it.lessonId)
                logNotificationDelivered(it)
//                pendingResult.finish()
            }
        }
    }


    private fun setLaterReminderNotifier() {

        val milliseconds = 3600000L // 1 hour
        val laterIntent = Intent(mContext, DailyLessonNotificationManager::class.java)
        laterIntent.action = INTENT_ACTION_LATER_NOTIFIER

        val pendingIntent: PendingIntent =
                PendingIntent.getBroadcast(mContext, DAILY_LESSON_ALARM_LATER_REQUEST_CODE, laterIntent, FLAG_UPDATE_CURRENT)

        setNotifier(milliseconds, pendingIntent)
    }

    private fun setDailyLessonNotifier() {

        val milliseconds = 86400000L
        val dailyLessonNotificationIntent = Intent(mContext, DailyLessonNotificationManager::class.java)
        dailyLessonNotificationIntent.action = INTENT_ACTION_DAILY_LESSON_NOTIFIER
        val pendingIntent = PendingIntent.getBroadcast(mContext, DAILY_LESSON_NOTIFIER_REQUEST_CODE, dailyLessonNotificationIntent, FLAG_UPDATE_CURRENT)
        setNotifier(milliseconds, pendingIntent)
    }


    private fun setNotifier(milliseconds: Long, pendingIntent: PendingIntent) {

        val alarmManager = mContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, Calendar.getInstance().timeInMillis + milliseconds, pendingIntent)
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val alarmClockInfo = AlarmClockInfo(Calendar.getInstance().timeInMillis + milliseconds, null)
            alarmManager.setAlarmClock(alarmClockInfo, pendingIntent)
        }
        //setExact for 19
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, Calendar.getInstance().timeInMillis + milliseconds, pendingIntent)
        } else {
            alarmManager[AlarmManager.RTC_WAKEUP, Calendar.getInstance().timeInMillis + milliseconds] = pendingIntent
        }
    }


    //TODO lesson verification
    private fun getLesson(): DailyLesson? {
        val nextLesson = (PreferenceManager.getInstance(mContext).getInt(LESSON_NO) + 1)
        return getLessonFromDB(nextLesson)
    }

    private fun getLessonFromDB(nextLessonId: Int) = AppDatabase.invoke(mContext).dailyLessonDao().getById(nextLessonId)

    private fun updateLessonNumber(nextLessonId: Int) {
        PreferenceManager.getInstance(mContext).setInt(LESSON_NO, nextLessonId)
    }


    private fun logNotificationDeleteEvent(lesson: DailyLesson) {
        val params = Bundle()
        params.putInt(DAILY_LESSON_NOTIFICATION_DELETE_PARAM_LESSON_ID, lesson.lessonId)
        FirebaseAnalytics.getInstance(mContext).logEvent(DAILY_LESSON_NOTIFICATION_DELETE_EVENT + "_" + lesson.lessonId, params)
    }

    private fun logLessonLaterEvent(lesson: DailyLesson) {
        val params = Bundle()
        params.putInt(DAILY_LESSON_NOTIFY_LATER_EVENT_PARAM_LESSON_ID, lesson.lessonId)
        FirebaseAnalytics.getInstance(mContext).logEvent(DAILY_LESSON_NOTIFY_LATER_EVENT + "_" + lesson.lessonId, params)
    }

    private fun logNotificationDelivered(lesson: DailyLesson) {
        val params = Bundle()
        params.putInt(DAILY_LESSON_NOTIFICATION_DELIVERED_EVENT_PARAM_LESSON_ID, lesson.lessonId)
        FirebaseAnalytics.getInstance(mContext).logEvent(DAILY_LESSON_NOTIFICATION_DELIVERED_EVENT + "_" + lesson.lessonId, params)
    }
}