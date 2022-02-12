package com.androidbull.mypronounce.constant;

/**
 * Created by admin on 7/14/2017.
 */

public class Constants {

    public static final String PAID_STATE = "PAID_STATE";
    public static final String FIREBASE_DAILY_LESSON_ROOT_NODE = "android_tuts_app_db";


    public static final String IS_VIP = "isVip";

    public static final String IS_FIRST_LAUNCH = "isFirstLaunch";
    public static final String LESSON_NO = "lessonToRead";

    public static final String DAILY_LESSON_NOTIFICATION_TIME = "dailyLessonTime";

    public static final int DAILY_LESSON_ALARM_LATER_REQUEST_CODE = 456;
    public static final String INTENT_ACTION_LATER_NOTIFIER = "DAILY_LESSON_LATER_NOTIFIER";

    public static final String DAILY_LESSON_LIST_OPENED = "daily_lesson_opened_nav";
    public static final String DAILY_LESSON_LIST_OPENED_PARAM = "source";

    public static final String DAILY_LESSON_DETAIL_OPENED = "daily_lesson_opened";
    public static final String DAILY_LESSON_DETAIL_OPENED_PARAM_SOURCE = "source";
    public static final String DAILY_LESSON_DETAIL_OPENED_PARAM_LESSON_ID = "lesson_id";

    public static final int DAILY_LESSON_NOTIFIER_REQUEST_CODE = 786;
    public static final String INTENT_ACTION_DAILY_LESSON_NOTIFIER = "DAILY_LESSON_NOTIFICATION";

    // EVENT LOGS
    public static final String DAILY_LESSON_NOTIFICATION_DELETE_EVENT = "lesson_dismissed";
    public static final String DAILY_LESSON_NOTIFICATION_DELETE_PARAM_LESSON_ID = "lesson_id";
    public static final String DAILY_LESSON_NOTIFY_LATER_EVENT_PARAM_LESSON_ID = "lesson_id";
    public static final String DAILY_LESSON_NOTIFICATION_DELIVERED_EVENT_PARAM_LESSON_ID = "lesson_id";
    public static final String DAILY_LESSON_NOTIFY_LATER_EVENT = "lesson_later";
    public static final String DAILY_LESSON_NOTIFICATION_DELIVERED_EVENT = "lesson_delivered";

    // DELETE NOTIFICATION INTENT
    public static final String INTENT_ACTION_DELETE_NOTIFICATION = "DELETE_NOTIFICATION";
    public static final String INTENT_EXTRA_DELETE_NOTIFICATION = "DELETE_NOTIFICATION_LESSON";
    public static final String INTENT_EXTRA_DELETE_NOTIFICATION_ID = "NOTIFICATION_ID";

    // DELETE READ MORE INTENT
    public static final String INTENT_ACTION_READ_MORE = "READ_MORE";
    public static final String INTENT_EXTRA_READ_MORE = "LESSON_READ_MORE";
    public static final String INTENT_EXTRA_READ_MORE_NOTIFICATION_ID = "NOTIFICATION_ID";

    // DELETE NOTIFY LATER INTENT
    public static final String INTENT_ACTION_NOTIFY_LATER = "NOTIFY_LATER";
    public static final String INTENT_EXTRA_NOTIFY_LATER = "LESSON_NOTIFY_LATER";
    public static final String INTENT_EXTRA_NOTIFY_LATER_NOTIFICATION_ID = "NOTIFICATION_ID";

    public static final String DAILY_LESSON_NOTIFICATION_CHANNEL_ID = "DAILY_LESSON_NOTIFICATION_CHANNEL";
    public static final int DAILY_LESSON_NOTIFICATION_ID = 888;

    public static final String DAILY_LESSON_NOTIFICATION_LATER_CHANNEL_ID = "DAILY_LESSON_LATER_NOTIFICATION_CHANNEL";
    public static final int DAILY_LESSON_NOTIFICATION_LATER_ID = 777;

    public static final String UNREAD_LESSON = "isUnreadLesson";

}
