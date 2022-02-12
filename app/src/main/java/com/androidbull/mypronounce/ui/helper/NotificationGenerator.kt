package com.androidbull.mypronounce.ui.helper

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.constant.Constants
import com.androidbull.mypronounce.constant.Constants.*
import com.androidbull.mypronounce.data.model.DailyLesson
import com.androidbull.mypronounce.ui.feature.dailylesson.DailyLessonActivity
import com.androidbull.mypronounce.ui.feature.dailylesson.receiver.DailyLessonNotificationManager
import com.androidbull.mypronounce.util.GeneralUtils.Companion.isOnline
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class NotificationGenerator {

    companion object {
        @JvmStatic
        fun generateDailyLessonNotification(context: Context, lesson: DailyLesson) {

            val notificationActions = getNotificationActions(context, lesson)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = DAILY_LESSON_NOTIFICATION_CHANNEL_ID
                val descriptionText = DAILY_LESSON_NOTIFICATION_CHANNEL_ID
                val importance = NotificationManager.IMPORTANCE_HIGH
                val channel = NotificationChannel(DAILY_LESSON_NOTIFICATION_CHANNEL_ID, name, importance).apply {
                    description = descriptionText
                }
                val notificationManager: NotificationManager =
                        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }

            if (isOnline(context)) {
                Glide.with(context)
                        .asBitmap().load(lesson.lessonImage)
                        .listener(object : RequestListener<Bitmap?> {
                            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Bitmap?>?, isFirstResource: Boolean): Boolean {
                                buildNotification(context, lesson, DAILY_LESSON_NOTIFICATION_ID, DAILY_LESSON_NOTIFICATION_CHANNEL_ID, notificationActions, null)
                                return false
                            }

                            override fun onResourceReady(resource: Bitmap?, model: Any?, target: Target<Bitmap?>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                                buildNotification(context, lesson, DAILY_LESSON_NOTIFICATION_ID, DAILY_LESSON_NOTIFICATION_CHANNEL_ID, notificationActions, resource)
                                return true
                            }
                        }
                        ).submit()
            } else {
                buildNotification(context, lesson, DAILY_LESSON_NOTIFICATION_ID, DAILY_LESSON_NOTIFICATION_CHANNEL_ID, notificationActions, null)
            }
        }

        @JvmStatic
        fun generateDailyLessonLaterNotification(context: Context, lesson: DailyLesson) {

            val notificationActions = getNotificationActions(context, lesson)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = DAILY_LESSON_NOTIFICATION_LATER_CHANNEL_ID
                val descriptionText = DAILY_LESSON_NOTIFICATION_LATER_CHANNEL_ID
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel(DAILY_LESSON_NOTIFICATION_LATER_CHANNEL_ID, name, importance).apply {
                    description = descriptionText
                }
                val notificationManager: NotificationManager =
                        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }

            if (isOnline(context)) {

                Glide.with(context)
                        .asBitmap().load(lesson.lessonImage)
                        .listener(object : RequestListener<Bitmap?> {
                            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Bitmap?>?, isFirstResource: Boolean): Boolean {
                                buildNotification(context, lesson, DAILY_LESSON_NOTIFICATION_LATER_ID, DAILY_LESSON_NOTIFICATION_LATER_CHANNEL_ID, notificationActions, null)
                                return false
                            }

                            override fun onResourceReady(resource: Bitmap?, model: Any?, target: Target<Bitmap?>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                                buildNotification(context, lesson, DAILY_LESSON_NOTIFICATION_LATER_ID, DAILY_LESSON_NOTIFICATION_LATER_CHANNEL_ID, notificationActions, resource)
                                return true
                            }
                        }
                        ).submit()
            } else {
                buildNotification(context, lesson, DAILY_LESSON_NOTIFICATION_LATER_ID, DAILY_LESSON_NOTIFICATION_LATER_CHANNEL_ID, notificationActions, null)
            }

        }

        private fun getNotificationActions(context: Context, lesson: DailyLesson): List<NotificationCompat.Action>? {

            val readMoreIntent = Intent(context, DailyLessonActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                action = INTENT_ACTION_READ_MORE
                putExtra(INTENT_EXTRA_READ_MORE, lesson)
                putExtra(INTENT_EXTRA_READ_MORE_NOTIFICATION_ID, Constants.DAILY_LESSON_NOTIFICATION_ID)
            }
            val readMorePendingIntent: PendingIntent =
                    PendingIntent.getActivity(context, 0, readMoreIntent, PendingIntent.FLAG_UPDATE_CURRENT)


            val laterIntent = Intent(context, DailyLessonNotificationManager::class.java).apply {
                action = INTENT_ACTION_NOTIFY_LATER
                putExtra(INTENT_EXTRA_NOTIFY_LATER, lesson)
                putExtra(INTENT_EXTRA_NOTIFY_LATER_NOTIFICATION_ID, Constants.DAILY_LESSON_NOTIFICATION_ID)
            }
            val laterPendingIntent: PendingIntent =
                    PendingIntent.getBroadcast(context, 0, laterIntent, PendingIntent.FLAG_UPDATE_CURRENT)


            val readMoreAction: NotificationCompat.Action = NotificationCompat.Action(R.drawable.app_icon, context.getString(R.string.str_read_more_notification_action), readMorePendingIntent)
            val laterAction: NotificationCompat.Action = NotificationCompat.Action(R.drawable.app_icon, context.getString(R.string.str_later_notification_action), laterPendingIntent)

            return listOf(readMoreAction, laterAction)
        }

        private fun buildNotification(context: Context, lesson: DailyLesson, notificationId: Int, notificationChannelId: String, notificationActions: List<NotificationCompat.Action>?, bitmap: Bitmap?) {

            //TODO make it generic
            val deleteIntent = Intent(context, DailyLessonNotificationManager::class.java).apply {
                action = INTENT_ACTION_DELETE_NOTIFICATION
                putExtra(INTENT_EXTRA_DELETE_NOTIFICATION, lesson)
                putExtra(INTENT_EXTRA_DELETE_NOTIFICATION_ID, DAILY_LESSON_NOTIFICATION_ID)
            }

            val deletePendingIntent: PendingIntent =
                    PendingIntent.getBroadcast(context, 0, deleteIntent, PendingIntent.FLAG_UPDATE_CURRENT)

            val notificationBuilder = NotificationCompat.Builder(context, notificationChannelId)
                    .setSmallIcon(R.drawable.app_icon)
                    .setContentTitle(lesson.title)
                    .setContentText(lesson.subtitle)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setDeleteIntent(deletePendingIntent)
                    .setAutoCancel(true)

            notificationActions?.let {
                if (it.isNotEmpty()) {
                    for (notificationAction in notificationActions) {
                        notificationBuilder.addAction(notificationAction)
                    }
                }
            }

            bitmap?.let {
                notificationBuilder.setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            }

            with(NotificationManagerCompat.from(context)) {
                notify(notificationId, notificationBuilder.build())
            }
        }

    }
}