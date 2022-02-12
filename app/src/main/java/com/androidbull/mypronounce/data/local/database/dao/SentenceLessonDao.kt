package com.androidbull.mypronounce.data.local.database.dao

import androidx.room.*
import com.androidbull.mypronounce.data.model.WordLesson
import com.androidbull.mypronounce.data.model.LessonTuple
import com.androidbull.mypronounce.data.model.SentenceLesson

@Dao
interface SentenceLessonDao {

    @Query("SELECT * FROM SentenceLesson")
    fun getAll(): List<SentenceLesson>


    @Query("select * , (select COUNT(*) from Sentence s where s.lessonId = sl.id AND s.isAccurate == 1) sentencesCompleted , (select COUNT(*) from Sentence s where s.lessonId = sl.id) sentenceCount from SentenceLesson sl")
    fun getAllWithChildCount(): List<SentenceLesson>?


    @Query("SELECT * FROM SentenceLesson WHERE id IN (:Ids)")
    fun loadAllByIds(Ids: IntArray): MutableList<SentenceLesson>

    @Query("SELECT * FROM SentenceLesson WHERE id = :id")
    fun getById(id: Int): SentenceLesson?

    @Query("SELECT * FROM SentenceLesson WHERE isLocked = 1")
    fun getLockedLesson(): SentenceLesson?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg sentenceLesson: SentenceLesson)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(sentenceLessons: List<SentenceLesson>)

    @Delete
    fun delete(sentenceLesson: SentenceLesson)

    @Delete
    fun deleteAll(sentenceLessons: List<SentenceLesson>)

    @Update
    fun update(sentenceLesson: SentenceLesson)

    @Query("UPDATE SentenceLesson SET isLocked = 0 WHERE id = :lessonId")
    fun unLockSentenceLesson(lessonId: Int)


    @Query("SELECT COUNT(id) FROM SentenceLesson")
    fun getTotalLessonCount(): Int

    @Query("SELECT COUNT(id) FROM SentenceLesson WHERE isLocked = 1")  //const val TRUE = 1  const val FALSE = 0
    fun getLessonLockedCount(): Int

    @Query("SELECT id,unLockThreshold FROM SentenceLesson where unLockThreshold > 0")  //const val TRUE = 1  const val FALSE = 0
    fun getLessonUnlockThresholds(): List<LessonTuple>?

    @Query("UPDATE SentenceLesson SET isLocked = 0 WHERE isLocked = 1")
    fun unLockAllLessons()
}