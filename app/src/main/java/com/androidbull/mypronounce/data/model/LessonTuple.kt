package com.androidbull.mypronounce.data.model

import androidx.room.ColumnInfo


// For WordLessonDao.getLessonUnlockThreshold()
// For SentenceLessonDao.getLessonUnlockThreshold()
data class LessonTuple(
        @ColumnInfo
        val id: Int,
        @ColumnInfo
        val unLockThreshold: Int)
