package com.androidbull.mypronounce.ui.feature.dailylesson.receiver;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0011\u0010\u0013\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/androidbull/mypronounce/ui/feature/dailylesson/receiver/DailyLessonNotificationManager;", "Landroid/content/BroadcastReceiver;", "()V", "mContext", "Landroid/content/Context;", "deleteNotification", "", "intent", "Landroid/content/Intent;", "getLesson", "Lcom/androidbull/mypronounce/data/model/DailyLesson;", "getLessonFromDB", "nextLessonId", "", "getLessonFromSP", "logLessonLaterEvent", "lesson", "logNotificationDeleteEvent", "logNotificationDelivered", "notifyDailyLesson", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceive", "context", "saveLessonToRemind", "setDailyLessonNotifier", "setLaterReminderNotifier", "setNotifier", "milliseconds", "", "pendingIntent", "Landroid/app/PendingIntent;", "showNewLessonBadge", "updateLessonNumber", "app_freeDebug"})
public final class DailyLessonNotificationManager extends android.content.BroadcastReceiver {
    private android.content.Context mContext;
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    private final void showNewLessonBadge() {
    }
    
    private final com.androidbull.mypronounce.data.model.DailyLesson getLessonFromSP() {
        return null;
    }
    
    private final void saveLessonToRemind(com.androidbull.mypronounce.data.model.DailyLesson lesson) {
    }
    
    private final void deleteNotification(android.content.Intent intent) {
    }
    
    private final void setLaterReminderNotifier() {
    }
    
    private final void setDailyLessonNotifier() {
    }
    
    private final void setNotifier(long milliseconds, android.app.PendingIntent pendingIntent) {
    }
    
    private final com.androidbull.mypronounce.data.model.DailyLesson getLesson() {
        return null;
    }
    
    private final com.androidbull.mypronounce.data.model.DailyLesson getLessonFromDB(int nextLessonId) {
        return null;
    }
    
    private final void updateLessonNumber(int nextLessonId) {
    }
    
    private final void logNotificationDeleteEvent(com.androidbull.mypronounce.data.model.DailyLesson lesson) {
    }
    
    private final void logLessonLaterEvent(com.androidbull.mypronounce.data.model.DailyLesson lesson) {
    }
    
    private final void logNotificationDelivered(com.androidbull.mypronounce.data.model.DailyLesson lesson) {
    }
    
    public DailyLessonNotificationManager() {
        super();
    }
}