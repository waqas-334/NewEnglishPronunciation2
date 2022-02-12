package com.androidbull.mypronounce.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androidbull.mypronounce.data.model.Sentence
import com.androidbull.mypronounce.data.model.Word


@Dao
interface SentenceDao {

    @Query("SELECT * FROM Sentence")
    fun getAll(): List<Sentence>

    @Query("SELECT * FROM Sentence WHERE id IN (:Ids)")
    fun loadAllByIds(Ids: IntArray): MutableList<Sentence>

    @Query("SELECT * FROM Sentence WHERE id = :id")
    fun getById(id: Int): Sentence?

    @Query("SELECT * FROM Sentence WHERE lessonId IN (:lessonId)")
    fun getAllByLessonId(lessonId: Int): LiveData<MutableList<Sentence>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg sentence: Sentence)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(sentences: List<Sentence>)

    @Delete
    fun delete(sentence: Sentence)

    @Delete
    fun deleteAll(sentences: List<Sentence>)

    @Update
    fun update(sentence: Sentence)

    @Query("SELECT COUNT(id) FROM Sentence")
    fun getTotalSentenceCount(): Int

    @Query("SELECT COUNT(id) FROM Sentence where isAccurate == 1")
    fun getAccurateSentencesLive(): LiveData<Int>

    @Query("SELECT COUNT(id) FROM Sentence where isAccurate == 1")
    fun getAccurateSentencess(): Int

}