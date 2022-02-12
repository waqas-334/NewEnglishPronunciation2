package com.androidbull.mypronounce;

import android.content.Context;

import com.facebook.appevents.AppEventsLogger;

public class FacebookLogger {
    public static final void log(Context context, String message){
        AppEventsLogger.newLogger(context).logEvent(message);

    }
}
