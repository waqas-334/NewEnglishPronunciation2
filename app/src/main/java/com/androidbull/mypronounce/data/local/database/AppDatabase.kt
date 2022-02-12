package com.androidbull.mypronounce.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androidbull.mypronounce.data.local.database.dao.*
import com.androidbull.mypronounce.data.model.*

private const val DATABASE_NAME = "EPDatabase.db"

@Database(entities = [DailyLesson::class, WordLesson::class, Word::class, SentenceLesson::class, Sentence::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dailyLessonDao(): DailyLessonDao
    abstract fun wordLessonDao(): WordLessonDao
    abstract fun sentenceLessonDao(): SentenceLessonDao
    abstract fun wordDao(): WordDao
    abstract fun sentenceDao(): SentenceDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
                ?: synchronized(LOCK) {
                    instance
                            ?: buildDatabase(context).also {
                                instance = it
                            }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DATABASE_NAME
                ).build()
    }
}
