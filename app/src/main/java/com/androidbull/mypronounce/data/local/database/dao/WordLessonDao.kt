package com.androidbull.mypronounce.data.local.database.dao

import androidx.room.*
import com.androidbull.mypronounce.data.model.WordLesson
import com.androidbull.mypronounce.data.model.LessonTuple

@Dao
interface WordLessonDao {

    @Query("SELECT * FROM WordLesson")
    fun getAll(): List<WordLesson>


    @Query("select * , (select COUNT(*) from Word w where w.lessonId = wl.id AND w.isAccurate == 1) wordsCompleted , (select COUNT(*) from Word w where w.lessonId = wl.id) wordCount from WordLesson wl")
    fun getAllWithChildCount(): List<WordLesson>?


    @Query("SELECT * FROM WordLesson WHERE id IN (:Ids)")
    fun loadAllByIds(Ids: IntArray): MutableList<WordLesson>

    @Query("SELECT * FROM WordLesson WHERE id = :id")
    fun getById(id: Int): WordLesson?

    @Query("SELECT * FROM WordLesson WHERE isLocked = 1") //const val TRUE = 1  const val FALSE = 0
    fun getLockedLesson(): WordLesson?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg wordLesson: WordLesson)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(wordLessons: List<WordLesson>)

    @Delete
    fun delete(wordLesson: WordLesson)

    @Delete
    fun deleteAll(wordLessons: List<WordLesson>)

    @Update
    fun update(wordLesson: WordLesson)

    @Query("UPDATE WordLesson SET isLocked = 0 WHERE id = :lessonId")
    fun unLockWordLesson(lessonId: Int)

    @Query("SELECT COUNT(id) FROM WordLesson")
    fun getTotalLessonCount(): Int

    @Query("SELECT COUNT(id) FROM WordLesson WHERE isLocked = 1")  //const val TRUE = 1  const val FALSE = 0
    fun getLessonLockedCount(): Int

    @Query("SELECT id,unLockThreshold FROM WordLesson where unLockThreshold > 0")  //const val TRUE = 1  const val FALSE = 0
    fun getLessonUnlockThresholds(): List<LessonTuple>?

    @Query("UPDATE WordLesson SET isLocked = 0 WHERE isLocked = 1")
    fun unLockAllLessons()
}