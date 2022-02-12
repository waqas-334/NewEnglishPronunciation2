package com.androidbull.mypronounce.ui.helper

import android.content.Context
import com.androidbull.mypronounce.data.local.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LessonUnLocker {

    companion object
    {

        @JvmStatic
        fun unlockWordLesson(context: Context, wordScore: Int) {

            GlobalScope.launch(Dispatchers.IO) {
                var lessonToUnlock = -1

                val lessonUnlockThresholds = AppDatabase.invoke(context.applicationContext).wordLessonDao().getLessonUnlockThresholds()
                lessonUnlockThresholds?.let {
                    if (it.isNotEmpty()) {
                        for (lessonTuple in it) {
                            if (wordScore >= lessonTuple.unLockThreshold) {
                                lessonToUnlock = lessonTuple.id
                            }
                        }
                    }
                }

                if (lessonToUnlock > 0) {
                    AppDatabase.invoke(context.applicationContext).wordLessonDao().unLockWordLesson(lessonToUnlock)
                }
            }
        }

        @JvmStatic
        fun unLockSentenceLesson(context: Context, sentenceScore: Int) {

            GlobalScope.launch(Dispatchers.IO) {
                var lessonToUnlock = -1

                val lessonUnlockThresholds = AppDatabase.invoke(context.applicationContext).sentenceLessonDao().getLessonUnlockThresholds()
                lessonUnlockThresholds?.let {
                    if (it.isNotEmpty()) {
                        for (lessonTuple in it) {
                            if (sentenceScore >= lessonTuple.unLockThreshold) {
                                lessonToUnlock = lessonTuple.id
                            }
                        }
                    }
                }

                if (lessonToUnlock > 0) {
                    AppDatabase.invoke(context.applicationContext).sentenceLessonDao().unLockSentenceLesson(lessonToUnlock)
                }
            }
        }
    }

}