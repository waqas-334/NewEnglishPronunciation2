package com.androidbull.mypronounce.ui.feature.dailylesson.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.data.local.database.AppDatabase
import com.androidbull.mypronounce.data.model.SentenceLesson
import com.vaibhavlakhera.circularprogressview.CircularProgressView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SentenceLessonAdapter(private val sentenceLessonList: List<SentenceLesson>, private val onLessonItemClick: (sentenceLesson: SentenceLesson) -> Unit) :
        RecyclerView.Adapter<SentenceLessonAdapter.SentenceLessonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): SentenceLessonViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_sentence_lesson, parent, false)

        return SentenceLessonViewHolder(view)
    }


    override fun onBindViewHolder(holder: SentenceLessonViewHolder, position: Int) {
        val sentenceLesson: SentenceLesson = sentenceLessonList[position]
        holder.bind(sentenceLesson)
    }

    override fun getItemCount(): Int = sentenceLessonList.size

    inner class SentenceLessonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var tvTitleLesson: TextView = view.findViewById(R.id.tvTitleLesson)
        private var tvLessonSubtitle: TextView = view.findViewById(R.id.tvLessonSubtitle)
        private var ivLessonLocked: ImageView = view.findViewById(R.id.ivLessonLocked)
        private var tvSentencesCompleted: TextView = view.findViewById(R.id.tvSentencesCompleted)
        private var cpvLessonSentences: CircularProgressView = view.findViewById(R.id.cpvLessonSentences)

        init {
            itemView.setOnClickListener {
                onLessonItemClick.invoke(sentenceLessonList[adapterPosition])
            }
        }

        fun bind(sentenceLesson: SentenceLesson) {
            tvTitleLesson.text = sentenceLesson.title
            tvLessonSubtitle.text = sentenceLesson.subtitle
            tvSentencesCompleted.text = tvSentencesCompleted.context.getString(R.string.words_completed, sentenceLesson.sentencesCompleted, sentenceLesson.sentenceCount)


            cpvLessonSentences.setProgress(sentenceLesson.lessonPrevProgress, false)
            cpvLessonSentences.setProgress(sentenceLesson.lessonProgress, true)

            if (sentenceLesson.isLocked) {
                tvTitleLesson.isEnabled = false
                tvLessonSubtitle.isEnabled = false
                tvSentencesCompleted.visibility = View.GONE
                ivLessonLocked.visibility = View.VISIBLE
            } else {
                itemView.isEnabled = true
                ivLessonLocked.visibility = View.GONE
                tvSentencesCompleted.visibility = View.VISIBLE
                tvTitleLesson.isEnabled = true
                tvLessonSubtitle.isEnabled = true
            }


            GlobalScope.launch(Dispatchers.IO) {
                val updateSentenceLesson = sentenceLesson.copy(lessonPrevProgress = sentenceLesson.lessonProgress)
                AppDatabase.invoke(cpvLessonSentences.context.applicationContext).sentenceLessonDao().update(updateSentenceLesson)
            }
        }
    }
}