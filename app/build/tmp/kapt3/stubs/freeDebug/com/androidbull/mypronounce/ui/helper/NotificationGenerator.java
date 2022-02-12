package com.androidbull.mypronounce.ui.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/androidbull/mypronounce/ui/helper/NotificationGenerator;", "", "()V", "Companion", "app_freeDebug"})
public final class NotificationGenerator {
    public static final com.androidbull.mypronounce.ui.helper.NotificationGenerator.Companion Companion = null;
    
    public NotificationGenerator() {
        super();
    }
    
    public static final void generateDailyLessonNotification(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.androidbull.mypronounce.data.model.DailyLesson lesson) {
    }
    
    public static final void generateDailyLessonLaterNotification(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.androidbull.mypronounce.data.model.DailyLesson lesson) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u00a8\u0006\u0015"}, d2 = {"Lcom/androidbull/mypronounce/ui/helper/NotificationGenerator$Companion;", "", "()V", "buildNotification", "", "context", "Landroid/content/Context;", "lesson", "Lcom/androidbull/mypronounce/data/model/DailyLesson;", "notificationId", "", "notificationChannelId", "", "notificationActions", "", "Landroidx/core/app/NotificationCompat$Action;", "bitmap", "Landroid/graphics/Bitmap;", "generateDailyLessonLaterNotification", "generateDailyLessonNotification", "getNotificationActions", "app_freeDebug"})
    public static final class Companion {
        
        public final void generateDailyLessonNotification(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.androidbull.mypronounce.data.model.DailyLesson lesson) {
        }
        
        public final void generateDailyLessonLaterNotification(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.androidbull.mypronounce.data.model.DailyLesson lesson) {
        }
        
        private final java.util.List<androidx.core.app.NotificationCompat.Action> getNotificationActions(android.content.Context context, com.androidbull.mypronounce.data.model.DailyLesson lesson) {
            return null;
        }
        
        private final void buildNotification(android.content.Context context, com.androidbull.mypronounce.data.model.DailyLesson lesson, int notificationId, java.lang.String notificationChannelId, java.util.List<? extends androidx.core.app.NotificationCompat.Action> notificationActions, android.graphics.Bitmap bitmap) {
        }
        
        private Companion() {
            super();
        }
    }
}