package com.androidbull.mypronounce.data.local.database.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\'J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\'J\b\u0010\f\u001a\u00020\u000bH\'J$\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\'J\b\u0010\u0011\u001a\u00020\u000bH\'J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\'J!\u0010\u0013\u001a\u00020\u00032\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0015\"\u00020\u0005H\'\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\'J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u001c"}, d2 = {"Lcom/androidbull/mypronounce/data/local/database/dao/DailyLessonDao;", "", "delete", "", "dailyLesson", "Lcom/androidbull/mypronounce/data/model/DailyLesson;", "deleteAll", "", "getAll", "getById", "lessonId", "", "getLessonReadCount", "getLessons", "Landroidx/lifecycle/LiveData;", "from", "To", "getTotalLessonCount", "getUnreadLesson", "insert", "dailyLessons", "", "([Lcom/androidbull/mypronounce/data/model/DailyLesson;)V", "insertAll", "loadAllByIds", "lessonIds", "", "update", "app_freeDebug"})
public abstract interface DailyLessonDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM DailyLesson")
    public abstract java.util.List<com.androidbull.mypronounce.data.model.DailyLesson> getAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM DailyLesson WHERE lessonId IN (:lessonIds)")
    public abstract java.util.List<com.androidbull.mypronounce.data.model.DailyLesson> loadAllByIds(@org.jetbrains.annotations.NotNull()
    int[] lessonIds);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM DailyLesson WHERE lessonId = :lessonId")
    public abstract com.androidbull.mypronounce.data.model.DailyLesson getById(int lessonId);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM DailyLesson WHERE isRead = 0")
    public abstract com.androidbull.mypronounce.data.model.DailyLesson getUnreadLesson();
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.androidbull.mypronounce.data.model.DailyLesson... dailyLessons);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.androidbull.mypronounce.data.model.DailyLesson> dailyLessons);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.androidbull.mypronounce.data.model.DailyLesson dailyLesson);
    
    @androidx.room.Delete()
    public abstract void deleteAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.androidbull.mypronounce.data.model.DailyLesson> dailyLesson);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.androidbull.mypronounce.data.model.DailyLesson dailyLesson);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM DailyLesson WHERE lessonId BETWEEN :from AND :To")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.androidbull.mypronounce.data.model.DailyLesson>> getLessons(int from, int To);
    
    @androidx.room.Query(value = "SELECT COUNT(lessonId) FROM DailyLesson")
    public abstract int getTotalLessonCount();
    
    @androidx.room.Query(value = "SELECT COUNT(lessonId) FROM DailyLesson WHERE isRead = 1")
    public abstract int getLessonReadCount();
}