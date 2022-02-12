package com.androidbull.mypronounce;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.androidbull.mypronounce.activities.MainActivity;

/**
 * Created by admin on 7/14/2017.
 */

public class IAPPrefrences {

    //Save and retrieve the number of times an app is opened
    public static void saveOpenState(String key, int value, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getOpenState(String key, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(key, 0);
    }

    // /Save and retrieve is user already rated our app
    public static void savePurchasedState(String key, boolean isPurchased, Context context) {
        Log.i(MainActivity.TAG, "savePurchasedState: isPurchachased saved: " +isPurchased+  "\nFrom Activity: " + context.getClass().getSimpleName());
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, isPurchased);
        editor.apply();
    }

    public static boolean isPaid(String key, Context context) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(key, false);
    }
}