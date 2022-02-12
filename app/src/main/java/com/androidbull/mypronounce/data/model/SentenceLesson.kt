package com.androidbull.mypronounce.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "SentenceLesson")
data class SentenceLesson(@PrimaryKey val id: Int,
                          @ColumnInfo val title: String,
                          @ColumnInfo val subtitle: String,
                          @ColumnInfo val isLocked: Boolean,
                          @ColumnInfo val sentenceCount: Int = 0,
                          @ColumnInfo var sentencesCompleted: Int = 0,
                          @ColumnInfo var lessonProgress: Int = 0,
                          @ColumnInfo var lessonPrevProgress: Int = 0,
                          @ColumnInfo val unLockThreshold: Int) : Serializable
