package com.androidbull.mypronounce.ui.feature.dailylesson.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.data.local.database.AppDatabase
import com.androidbull.mypronounce.data.model.WordLesson
import com.vaibhavlakhera.circularprogressview.CircularProgressView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WordLessonAdapter(private val wordLessonList: List<WordLesson>, private val onLessonItemClick: (wordLesson: WordLesson) -> Unit) :
        RecyclerView.Adapter<WordLessonAdapter.WordLessonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): WordLessonViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_lesson_words, parent, false)

        return WordLessonViewHolder(view)
    }


    override fun onBindViewHolder(holder: WordLessonViewHolder, position: Int) {
        val wordLesson: WordLesson = wordLessonList[position]
        holder.bind(wordLesson)
    }

    override fun getItemCount(): Int = wordLessonList.size

    inner class WordLessonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var tvTitleLesson: TextView = view.findViewById(R.id.tvTitleLesson)
        private var tvLessonSubtitle: TextView = view.findViewById(R.id.tvLessonSubtitle)
        private var ivLessonLocked: ImageView = view.findViewById(R.id.ivLessonLocked)
        private var tvWordsCompleted: TextView = view.findViewById(R.id.tvSentencesCompleted)
        private var cpvLessonWords: CircularProgressView = view.findViewById(R.id.cpvLessonWords)

        init {
            itemView.setOnClickListener {
                onLessonItemClick.invoke(wordLessonList[adapterPosition])
            }
        }

        fun bind(wordLesson: WordLesson) {
            tvTitleLesson.text = wordLesson.title
            tvLessonSubtitle.text = wordLesson.subtitle
            tvWordsCompleted.text = tvWordsCompleted.context.getString(R.string.words_completed, wordLesson.wordsCompleted, wordLesson.wordCount)


            cpvLessonWords.setProgress(wordLesson.lessonPrevProgress, false)
            cpvLessonWords.setProgress(wordLesson.lessonProgress, true)

            if (wordLesson.isLocked) {
                tvTitleLesson.isEnabled = false
                tvLessonSubtitle.isEnabled = false
                tvWordsCompleted.visibility = View.GONE
                ivLessonLocked.visibility = View.VISIBLE
            } else {
                itemView.isEnabled = true
                ivLessonLocked.visibility = View.GONE
                tvWordsCompleted.visibility = View.VISIBLE
                tvTitleLesson.isEnabled = true
                tvLessonSubtitle.isEnabled = true
            }


            GlobalScope.launch(Dispatchers.IO) {
                val updatedWordLesson = wordLesson.copy(lessonPrevProgress = wordLesson.lessonProgress)
                AppDatabase.invoke(cpvLessonWords.context.applicationContext).wordLessonDao().update(updatedWordLesson)
            }
        }
    }
}