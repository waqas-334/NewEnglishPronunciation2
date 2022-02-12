package com.androidbull.mypronounce.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "DailyLesson")
data class DailyLesson(@PrimaryKey val lessonId: Int,
                       @ColumnInfo val title: String,
                       @ColumnInfo val subtitle: String,
                       @ColumnInfo val description: String,
                       @ColumnInfo val lessonImage: String,
                       @ColumnInfo var isRead: Boolean = false) : Serializable {
    constructor() : this(0, "", "", "", "", false)
}