package com.androidbull.mypronounce.data.local.database.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'J\b\u0010\t\u001a\u00020\nH\'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH\'J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'J\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\f2\u0006\u0010\u0010\u001a\u00020\nH\'J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\nH\'J\b\u0010\u0013\u001a\u00020\nH\'J!\u0010\u0014\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0015\"\u00020\u0005H\'\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\'J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u001c"}, d2 = {"Lcom/androidbull/mypronounce/data/local/database/dao/WordDao;", "", "delete", "", "word", "Lcom/androidbull/mypronounce/data/model/Word;", "deleteAll", "words", "", "getAccurateWords", "", "getAccurateWordsLive", "Landroidx/lifecycle/LiveData;", "getAll", "getAllByLessonId", "", "lessonId", "getById", "id", "getTotalWordCount", "insert", "", "([Lcom/androidbull/mypronounce/data/model/Word;)V", "insertAll", "loadAllByIds", "Ids", "", "update", "app_freeDebug"})
public abstract interface WordDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Word")
    public abstract java.util.List<com.androidbull.mypronounce.data.model.Word> getAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Word WHERE id IN (:Ids)")
    public abstract java.util.List<com.androidbull.mypronounce.data.model.Word> loadAllByIds(@org.jetbrains.annotations.NotNull()
    int[] Ids);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM Word WHERE id = :id")
    public abstract com.androidbull.mypronounce.data.model.Word getById(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Word WHERE lessonId IN (:lessonId)")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.androidbull.mypronounce.data.model.Word>> getAllByLessonId(int lessonId);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.androidbull.mypronounce.data.model.Word... word);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.androidbull.mypronounce.data.model.Word> words);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.androidbull.mypronounce.data.model.Word word);
    
    @androidx.room.Delete()
    public abstract void deleteAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.androidbull.mypronounce.data.model.Word> words);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.androidbull.mypronounce.data.model.Word word);
    
    @androidx.room.Query(value = "SELECT COUNT(id) FROM Word")
    public abstract int getTotalWordCount();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT COUNT(id) FROM Word where isAccurate == 1")
    public abstract androidx.lifecycle.LiveData<java.lang.Integer> getAccurateWordsLive();
    
    @androidx.room.Query(value = "SELECT COUNT(id) FROM Word where isAccurate == 1")
    public abstract int getAccurateWords();
}