package com.androidbull.mypronounce.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androidbull.mypronounce.data.model.DailyLesson

@Dao
interface DailyLessonDao {

    @Query("SELECT * FROM DailyLesson")
    fun getAll(): List<DailyLesson>?

    @Query("SELECT * FROM DailyLesson WHERE lessonId IN (:lessonIds)")
    fun loadAllByIds(lessonIds: IntArray): List<DailyLesson>

    @Query("SELECT * FROM DailyLesson WHERE lessonId = :lessonId")
    fun getById(lessonId: Int): DailyLesson?

    @Query("SELECT * FROM DailyLesson WHERE isRead = 0") //const val TRUE = 1  const val FALSE = 0
    fun getUnreadLesson(): DailyLesson?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg dailyLessons: DailyLesson)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(dailyLessons: List<DailyLesson>)

    @Delete
    fun delete(dailyLesson: DailyLesson)

    @Delete
    fun deleteAll(dailyLesson: List<DailyLesson>)

    @Update
    fun update(dailyLesson: DailyLesson)

    @Query("SELECT * FROM DailyLesson WHERE lessonId BETWEEN :from AND :To")
    fun getLessons(from: Int, To: Int): LiveData<List<DailyLesson>>

    @Query("SELECT COUNT(lessonId) FROM DailyLesson")
    fun getTotalLessonCount(): Int

    @Query("SELECT COUNT(lessonId) FROM DailyLesson WHERE isRead = 1")  //const val TRUE = 1  const val FALSE = 0

    fun getLessonReadCount(): Int
}