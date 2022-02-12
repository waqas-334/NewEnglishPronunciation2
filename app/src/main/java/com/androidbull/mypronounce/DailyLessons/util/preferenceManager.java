package com.androidbull.mypronounce.DailyLessons.util;

import android.content.Context;
import android.content.SharedPreferences;


public class preferenceManager {

    private final String STORAGE = "data.shower.preference.manager";
    private SharedPreferences preferences;
    private static preferenceManager instance;
    private SharedPreferences.Editor editor;

    public static preferenceManager getInstance(Context context) {
        if (instance == null)
            instance = new preferenceManager(context.getApplicationContext());
        return instance;
    }

    private preferenceManager(Context context) {
        preferences = context.getSharedPreferences(STORAGE, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void userHasInstalledApp() {
        editor.putBoolean(AppConstants.HAS_APP_INSTALLED, true);
        editor.apply();
    }

    public boolean isAppPreviouslyInstalled() {
        return preferences.getBoolean(AppConstants.HAS_APP_INSTALLED, false);
    }

    public Long getTimePointer() {
        return preferences.getLong(AppConstants.TIME_POINTER, Long.valueOf("1573557900000"));
    }

    public void setTimePointer() {
        if (System.currentTimeMillis() > getTimePointer()) {
            editor.putLong(AppConstants.TIME_POINTER, System.currentTimeMillis());
            editor.apply();
        }
    }

    public int getLessonLimit() {
        return preferences.getInt(AppConstants.LESSON_DAY, 0);
    }

    public void incrementLessonLimit() {
        int prev = getLessonLimit();
        editor.putInt(AppConstants.LESSON_DAY, prev + 1);
        editor.apply();
    }
    public void resetLessonLimit() {
        editor.putInt(AppConstants.LESSON_DAY, 0);
        editor.apply();
    }

    public boolean getIsFirstNotification() {
        return preferences.getBoolean(AppConstants.FIRST_NOTIFICATION, true);
    }
    public void setIsFirstNotification(Boolean isFirstNotification) {
        editor.putBoolean(AppConstants.FIRST_NOTIFICATION, isFirstNotification);
    }
    public int getLessonNo() {
        return preferences.getInt(AppConstants.LESSON_NO, 0);
    }
    public void setLessonNo(int lessonNo) {
        editor.putInt(AppConstants.LESSON_NO, lessonNo);
    }
}
