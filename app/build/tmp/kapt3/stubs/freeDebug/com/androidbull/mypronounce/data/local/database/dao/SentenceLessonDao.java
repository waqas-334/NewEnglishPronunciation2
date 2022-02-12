package com.androidbull.mypronounce.data.local.database.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\'J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\'J\b\u0010\u000e\u001a\u00020\rH\'J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\bH\'J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\'J\b\u0010\u0012\u001a\u00020\rH\'J!\u0010\u0013\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0014\"\u00020\u0005H\'\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\'J\b\u0010\u001b\u001a\u00020\u0003H\'J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\rH\'J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u001f"}, d2 = {"Lcom/androidbull/mypronounce/data/local/database/dao/SentenceLessonDao;", "", "delete", "", "sentenceLesson", "Lcom/androidbull/mypronounce/data/model/SentenceLesson;", "deleteAll", "sentenceLessons", "", "getAll", "getAllWithChildCount", "getById", "id", "", "getLessonLockedCount", "getLessonUnlockThresholds", "Lcom/androidbull/mypronounce/data/model/LessonTuple;", "getLockedLesson", "getTotalLessonCount", "insert", "", "([Lcom/androidbull/mypronounce/data/model/SentenceLesson;)V", "insertAll", "loadAllByIds", "", "Ids", "", "unLockAllLessons", "unLockSentenceLesson", "lessonId", "update", "app_freeDebug"})
public abstract interface SentenceLessonDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM SentenceLesson")
    public abstract java.util.List<com.androidbull.mypronounce.data.model.SentenceLesson> getAll();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * , (select COUNT(*) from Sentence s where s.lessonId = sl.id AND s.isAccurate == 1) sentencesCompleted , (select COUNT(*) from Sentence s where s.lessonId = sl.id) sentenceCount from SentenceLesson sl")
    public abstract java.util.List<com.androidbull.mypronounce.data.model.SentenceLesson> getAllWithChildCount();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM SentenceLesson WHERE id IN (:Ids)")
    public abstract java.util.List<com.androidbull.mypronounce.data.model.SentenceLesson> loadAllByIds(@org.jetbrains.annotations.NotNull()
    int[] Ids);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM SentenceLesson WHERE id = :id")
    public abstract com.androidbull.mypronounce.data.model.SentenceLesson getById(int id);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM SentenceLesson WHERE isLocked = 1")
    public abstract com.androidbull.mypronounce.data.model.SentenceLesson getLockedLesson();
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.androidbull.mypronounce.data.model.SentenceLesson... sentenceLesson);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.androidbull.mypronounce.data.model.SentenceLesson> sentenceLessons);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.androidbull.mypronounce.data.model.SentenceLesson sentenceLesson);
    
    @androidx.room.Delete()
    public abstract void deleteAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.androidbull.mypronounce.data.model.SentenceLesson> sentenceLessons);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.androidbull.mypronounce.data.model.SentenceLesson sentenceLesson);
    
    @androidx.room.Query(value = "UPDATE SentenceLesson SET isLocked = 0 WHERE id = :lessonId")
    public abstract void unLockSentenceLesson(int lessonId);
    
    @androidx.room.Query(value = "SELECT COUNT(id) FROM SentenceLesson")
    public abstract int getTotalLessonCount();
    
    @androidx.room.Query(value = "SELECT COUNT(id) FROM SentenceLesson WHERE isLocked = 1")
    public abstract int getLessonLockedCount();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT id,unLockThreshold FROM SentenceLesson where unLockThreshold > 0")
    public abstract java.util.List<com.androidbull.mypronounce.data.model.LessonTuple> getLessonUnlockThresholds();
    
    @androidx.room.Query(value = "UPDATE SentenceLesson SET isLocked = 0 WHERE isLocked = 1")
    public abstract void unLockAllLessons();
}