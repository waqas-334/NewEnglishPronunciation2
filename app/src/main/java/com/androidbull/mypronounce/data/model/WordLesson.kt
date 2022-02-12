package com.androidbull.mypronounce.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "WordLesson")
data class WordLesson(@PrimaryKey val id: Int,
                      @ColumnInfo val title: String,
                      @ColumnInfo val subtitle: String,
                      @ColumnInfo val isLocked: Boolean,
                      @ColumnInfo val wordCount: Int = 0,
                      @ColumnInfo var wordsCompleted: Int = 0,
                      @ColumnInfo var lessonProgress: Int = 0,
                      @ColumnInfo var lessonPrevProgress: Int = 0,
                      @ColumnInfo val unLockThreshold: Int) : Serializable
