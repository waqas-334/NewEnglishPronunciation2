package com.androidbull.mypronounce.DailyLessons.receiver;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.util.Log;

import com.androidbull.mypronounce.DailyLessons.model.lesson;
import com.androidbull.mypronounce.DailyLessons.util.AppConstants;
import com.androidbull.mypronounce.DailyLessons.util.preferenceManager;
import com.androidbull.mypronounce.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NotificationReceiver extends BroadcastReceiver {
    private static final String TAG = "NotificationReceiver";
    private String lessonTitle = "";
    private boolean notificationFired = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: Fire Notification at: " + System.currentTimeMillis());
        notificationFired = true;

        //Increment the lesson limit
        preferenceManager.getInstance(context).incrementLessonLimit();

        final Context context1 = context;

        Log.i(TAG, "onReceive: lesson limit: " + preferenceManager.getInstance(context).getLessonLimit());
        FirebaseDatabase.getInstance().getReference()
                .child(AppConstants.FIREBASE_DATABASE_ROOT)
                .child(AppConstants.LESSONS_TABLE)
                .child(preferenceManager.getInstance(context).getLessonLimit() + "")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        lesson lesson = dataSnapshot.getValue(lesson.class);
                        if (lesson != null) {
                            //Checking if notification was fired by the alarm service, then we show the notification
                            //As this method could be called when some data in Database is changed, so we don't want to
                            //keep sending notification everytime some data is changed

                            //Also checking if the lesson is one - means app opened for the first time - no need to show notification
                            if (notificationFired && preferenceManager.getInstance(context1).getLessonLimit() != 1) {
                                lessonTitle = lesson.getTitle();
                                createNotification(context1, lessonTitle);
                                Log.i(TAG, "onDataChange: lesson title: " + lessonTitle);
                            }
                        } else {
                            //We may have crossed the lessons limit
                            //So reset the lessons limit
                            preferenceManager.getInstance(context1).resetLessonLimit();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


    }

    private void createNotification(Context context, String title) {
        String DailNotificationChannelId = "daily_notification";
        Log.i(TAG, "createNotification: title: " + title);
        NotificationCompat.Builder builder;
        NotificationChannel defaultChannel;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            defaultChannel = new NotificationChannel(DailNotificationChannelId, "Daily lesson Notifications", NotificationManager.IMPORTANCE_HIGH);
            defaultChannel.setDescription(context.getString(R.string.str_notification_channel_desc));

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(defaultChannel);
        }

        //Pending Intent when notification opened
        Intent intent = new Intent(context, NotificationClickedReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        //Pending Intent when notification closed
        Intent delIntent = new Intent(context, NotificationDismissReceiver.class);
        PendingIntent delPendingIntent = PendingIntent.getBroadcast(context, 0, delIntent, 0);

        builder = new NotificationCompat.Builder(context, DailNotificationChannelId)
                .setSmallIcon(R.drawable.ic_alarm_white)
                .setContentTitle(title)
                .setContentText("Daily Lesson")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setDeleteIntent(delPendingIntent)
                //autocancel will remove the notification when tapped
                .setAutoCancel(true)

                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(1000, builder.build());


    }
}
