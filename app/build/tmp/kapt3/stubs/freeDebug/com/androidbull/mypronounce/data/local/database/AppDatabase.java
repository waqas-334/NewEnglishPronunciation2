package com.androidbull.mypronounce.data.local.database;

import java.lang.System;

@androidx.room.Database(entities = {com.androidbull.mypronounce.data.model.DailyLesson.class, com.androidbull.mypronounce.data.model.WordLesson.class, com.androidbull.mypronounce.data.model.Word.class, com.androidbull.mypronounce.data.model.SentenceLesson.class, com.androidbull.mypronounce.data.model.Sentence.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/androidbull/mypronounce/data/local/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "dailyLessonDao", "Lcom/androidbull/mypronounce/data/local/database/dao/DailyLessonDao;", "sentenceDao", "Lcom/androidbull/mypronounce/data/local/database/dao/SentenceDao;", "sentenceLessonDao", "Lcom/androidbull/mypronounce/data/local/database/dao/SentenceLessonDao;", "wordDao", "Lcom/androidbull/mypronounce/data/local/database/dao/WordDao;", "wordLessonDao", "Lcom/androidbull/mypronounce/data/local/database/dao/WordLessonDao;", "Companion", "app_freeDebug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    private static volatile com.androidbull.mypronounce.data.local.database.AppDatabase instance;
    private static final java.lang.Object LOCK = null;
    public static final com.androidbull.mypronounce.data.local.database.AppDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.androidbull.mypronounce.data.local.database.dao.DailyLessonDao dailyLessonDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.androidbull.mypronounce.data.local.database.dao.WordLessonDao wordLessonDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.androidbull.mypronounce.data.local.database.dao.SentenceLessonDao sentenceLessonDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.androidbull.mypronounce.data.local.database.dao.WordDao wordDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.androidbull.mypronounce.data.local.database.dao.SentenceDao sentenceDao();
    
    public AppDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/androidbull/mypronounce/data/local/database/AppDatabase$Companion;", "", "()V", "LOCK", "instance", "Lcom/androidbull/mypronounce/data/local/database/AppDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "invoke", "app_freeDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.androidbull.mypronounce.data.local.database.AppDatabase invoke(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final com.androidbull.mypronounce.data.local.database.AppDatabase buildDatabase(android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}