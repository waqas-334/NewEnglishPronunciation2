package com.androidbull.mypronounce.ui.helper

import android.content.Context
import com.androidbull.mypronounce.data.local.database.AppDatabase
import kotlinx.coroutines.*

class ProgressCalculator {

    companion object {
        //TODO get count in one query COUNT SUM
        @JvmStatic
        fun getDailyLessonProgress(context: Context): Double = runBlocking {
            val totalLessonCount = GlobalScope.async { AppDatabase.invoke(context).dailyLessonDao().getTotalLessonCount() }.await()
            val totalLessonReadCount = GlobalScope.async { AppDatabase.invoke(context).dailyLessonDao().getLessonReadCount() }.await()
            if (totalLessonCount > 0 && totalLessonCount >= totalLessonReadCount) {
                return@runBlocking ((totalLessonReadCount.toDouble() / totalLessonCount.toDouble()) * 100.00)
            }
            return@runBlocking 0.00
        }

        //TODO get count in one query COUNT SUM
        @JvmStatic
        fun getWordLessonProgress(context: Context): Double = runBlocking {
            val totalWords = GlobalScope.async { AppDatabase.invoke(context).wordDao().getTotalWordCount() }.await()
            val totalWordsCompleted = GlobalScope.async { AppDatabase.invoke(context).wordDao().getAccurateWords() }.await()
            if (totalWords > 0 && totalWords >= totalWordsCompleted) {
                return@runBlocking ((totalWordsCompleted.toDouble() / totalWords.toDouble()) * 100.00)
            }
            return@runBlocking 0.00
        }

        //TODO get count in one query COUNT SUM
        @JvmStatic
        fun getSentenceLessonProgressPercentage(context: Context): Double = runBlocking {
            val totalSentences = GlobalScope.async { AppDatabase.invoke(context).sentenceDao().getTotalSentenceCount() }.await()
            val totalSentencesCompleted = GlobalScope.async { AppDatabase.invoke(context).sentenceDao().getAccurateSentencess() }.await()
            if (totalSentences > 0 && totalSentences >= totalSentencesCompleted) {
                return@runBlocking ((totalSentencesCompleted.toDouble() / totalSentences.toDouble()) * 100.00)
            }
            return@runBlocking 0.00
        }
    }
}