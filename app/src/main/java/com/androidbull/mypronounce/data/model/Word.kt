package com.androidbull.mypronounce.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.androidbull.mypronounce.util.HasAccuracy

/*foreignKeys = [ForeignKey(entity = WordLesson::class,
parentColumns = arrayOf("id"),
childColumns = arrayOf("lessonId"),
onDelete = RESTRICT)]*/

@Entity(tableName = "Word")
data class Word(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                @ColumnInfo val spelling: String,
                @ColumnInfo val phonetic: String,
                @ColumnInfo val lessonId: Int,
                @ColumnInfo val accuracy: Int = -1,
                @ColumnInfo val speechResult: String = "",
                @ColumnInfo val isAccurate: Boolean = false
) : HasAccuracy {
    override fun isAccuratePronunciation() = isAccurate
}