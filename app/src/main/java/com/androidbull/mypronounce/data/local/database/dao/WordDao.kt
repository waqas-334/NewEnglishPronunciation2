package com.androidbull.mypronounce.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androidbull.mypronounce.data.model.Word


@Dao
interface WordDao {

    @Query("SELECT * FROM Word")
    fun getAll(): List<Word>

    @Query("SELECT * FROM Word WHERE id IN (:Ids)")
    fun loadAllByIds(Ids: IntArray): MutableList<Word>

    @Query("SELECT * FROM Word WHERE id = :id")
    fun getById(id: Int): Word?

    @Query("SELECT * FROM Word WHERE lessonId IN (:lessonId)")
    fun getAllByLessonId(lessonId: Int): LiveData<MutableList<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg word: Word)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(words: List<Word>)

    @Delete
    fun delete(word: Word)

    @Delete
    fun deleteAll(words: List<Word>)

    @Update
    fun update(word: Word)

    @Query("SELECT COUNT(id) FROM Word")
    fun getTotalWordCount(): Int

    @Query("SELECT COUNT(id) FROM Word where isAccurate == 1")
    fun getAccurateWordsLive(): LiveData<Int>

    @Query("SELECT COUNT(id) FROM Word where isAccurate == 1")
    fun getAccurateWords(): Int

}