package com.androidbull.mypronounce.receiver;

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.os.Build
import android.text.TextUtils
import com.androidbull.mypronounce.constant.Constants
import com.androidbull.mypronounce.constant.Constants.DAILY_LESSON_NOTIFIER_REQUEST_CODE
import com.androidbull.mypronounce.ui.feature.dailylesson.receiver.DailyLessonNotificationManager
import com.androidbull.mypronounce.ui.helper.PreferenceManager.Companion.getInstance
import java.util.*

//TODO move to DailyLessonNotificationManager
class BootBroadcastReceiver : BroadcastReceiver() {

    private lateinit var mContext: Context

    override fun onReceive(context: Context, intent: Intent) {

        mContext = context

        if (!TextUtils.isEmpty(intent.action)) {
            setDailyLessonNotifier()
        }
    }

    //TODO separate class for Notifiers
    private fun setDailyLessonNotifier() {


        val dailyLessonAlarmScheduleTime = getInstance(mContext).getLong(Constants.DAILY_LESSON_NOTIFICATION_TIME)

        val dailyLessonAlarmScheduleCal = Calendar.getInstance()
        dailyLessonAlarmScheduleCal.timeInMillis = dailyLessonAlarmScheduleTime

        val currentCal = Calendar.getInstance()
        currentCal[Calendar.HOUR] = currentCal[Calendar.HOUR]
        currentCal[Calendar.MINUTE] = currentCal[Calendar.MINUTE]
        currentCal[Calendar.SECOND] = currentCal[Calendar.SECOND]

        val intendedTime = currentCal.timeInMillis

        val dailyLessonNotificationIntent = Intent(mContext, DailyLessonNotificationManager::class.java)
        dailyLessonNotificationIntent.action = Constants.INTENT_ACTION_DAILY_LESSON_NOTIFIER
        val pendingIntent = PendingIntent.getBroadcast(mContext, DAILY_LESSON_NOTIFIER_REQUEST_CODE, dailyLessonNotificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        setNotifier(intendedTime, pendingIntent)
    }


    private fun setNotifier(intendedTime: Long, pendingIntent: PendingIntent) {

        val alarmManager = mContext.getSystemService(ALARM_SERVICE) as AlarmManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, intendedTime, pendingIntent)
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val alarmClockInfo = AlarmManager.AlarmClockInfo(intendedTime, null)
            alarmManager.setAlarmClock(alarmClockInfo, pendingIntent)
        }
        //setExact for 19
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, intendedTime, pendingIntent)
        } else {
            alarmManager[AlarmManager.RTC_WAKEUP, intendedTime] = pendingIntent
        }
    }
}