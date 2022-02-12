package com.androidbull.mypronounce.DailyLessons.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.androidbull.mypronounce.DailyLessons.util.preferenceManager;
import com.androidbull.mypronounce.FacebookLogger;

public class NotificationDismissReceiver extends BroadcastReceiver {
    private static final String TAG = "NotificationDismissRece";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: Notification Dismissed");
        FacebookLogger.log(context,"Notification Dismissed at: " + preferenceManager.getInstance(context).getLessonLimit());

    }
}
