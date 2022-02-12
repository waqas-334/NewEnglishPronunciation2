package com.androidbull.mypronounce.DailyLessons.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.androidbull.mypronounce.DailyLessons.ui.LessonActivity;
import com.androidbull.mypronounce.DailyLessons.util.preferenceManager;
import com.androidbull.mypronounce.FacebookLogger;

public class NotificationClickedReceiver extends BroadcastReceiver {
    private static final String TAG = "NotificationClickedRece";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: Notification Clicked" );
        Intent intent_ = new Intent(context, LessonActivity.class);
        intent_.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent_);
        FacebookLogger.log(context,"Notification Clicked at: " + preferenceManager.getInstance(context).getLessonLimit());
    }
}
