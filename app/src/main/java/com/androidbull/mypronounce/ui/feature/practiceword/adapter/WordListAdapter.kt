package com.androidbull.mypronounce.ui.feature.dailylesson.adapter

import android.text.TextUtils
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.ui.helper.ClickableTextView
import com.androidbull.mypronounce.data.model.Word
import com.androidbull.mypronounce.ui.helper.PronunciationAccuracyChecker
import com.androidbull.mypronounce.util.GeneralUtils.Companion.getWrongWords


class WordListAdapter(private val wordList: List<Word>) :
        RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private var onWordItemChildViewClickListener: OnWordItemChildViewClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_word, parent, false)

        return WordViewHolder(view)
    }


    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word: Word = wordList[position]
        holder.bind(word, position)
    }


    override fun getItemCount(): Int = wordList.size

    inner class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var tvWordSpelling: TextView = view.findViewById(R.id.tvWordSpelling)
        private var tvWordPhonetic: TextView = view.findViewById(R.id.tvWordPhonetic)
        private var tvAccuracyPercentage: TextView = view.findViewById(R.id.tvAccuracyPercentage)
        private var ctvSpeechResult: ClickableTextView = view.findViewById(R.id.tvSpeechResult)
        private var tvSpeechOutput: TextView = view.findViewById(R.id.tvSpeechOutput)
        private var ibSpeech: ImageButton = view.findViewById(R.id.ibSpeech)
        private var ibTranslate: ImageButton = view.findViewById(R.id.ibTranslate)
        private var llAccuracy: LinearLayout = view.findViewById(R.id.llAccuracy)

        fun bind(word: Word, position: Int) {
            tvWordSpelling.text = word.spelling
            tvWordPhonetic.text = word.phonetic

            if (!word.isAccurate)
                tvSpeechOutput.text = word.speechResult

            if (!TextUtils.isEmpty(word.speechResult)) {
                val wrongWords = getWrongWords(word.spelling, word.speechResult)
                val clickableWords = mutableListOf<ClickableTextView.ClickableWord>()

                //TODO to separate
                for (wrongWord in wrongWords) {
                    val clickableSpan = object : ClickableSpan() {
                        override fun onClick(p0: View) {
                            onWordItemChildViewClickListener?.onWrongWordClick(wrongWord)
                        }
                    }
                    val clickableWord = ClickableTextView.ClickableWord(wrongWord, clickableSpan)
                    clickableWords.add(clickableWord)
                }
                ctvSpeechResult.setTextWithClickableWords(word.spelling, clickableWords)
            } else {
                ctvSpeechResult.text = ""
            }


            if (PronunciationAccuracyChecker.isAccuratePronunciation(word.accuracy)) {
                llAccuracy.background = ContextCompat.getDrawable(llAccuracy.context, R.drawable.bg_accuracy_good)
                llAccuracy.visibility = View.VISIBLE
            } else if ((word.accuracy >= 0) && (!PronunciationAccuracyChecker.isAccuratePronunciation(word.accuracy))) {
                llAccuracy.background = ContextCompat.getDrawable(llAccuracy.context, R.drawable.bg_accuracy_bad)
                llAccuracy.visibility = View.VISIBLE
            } else {
                llAccuracy.visibility = View.INVISIBLE
            }

            tvAccuracyPercentage.text = tvAccuracyPercentage.context.getString(R.string.tv_accuracy_percentage, word.accuracy)


            ibSpeech.setOnClickListener {
                onWordItemChildViewClickListener?.onSpeechViewClick(word, position)
            }

            ibTranslate.setOnClickListener {
                onWordItemChildViewClickListener?.onTranslateViewClick(word, position)
            }
        }
    }

    fun setOnWordItemChildViewClickListener(onWordItemChildViewClickListener: OnWordItemChildViewClickListener) {
        this.onWordItemChildViewClickListener = onWordItemChildViewClickListener
    }

    interface OnWordItemChildViewClickListener {
        fun onTranslateViewClick(word: Word, position: Int)
        fun onSpeechViewClick(word: Word, position: Int)
        fun onWrongWordClick(word: String)
    }
}