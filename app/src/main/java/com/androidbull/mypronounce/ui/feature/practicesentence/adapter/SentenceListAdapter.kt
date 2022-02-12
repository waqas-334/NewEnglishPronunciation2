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
import com.androidbull.mypronounce.data.model.Sentence
import com.androidbull.mypronounce.ui.helper.ClickableTextView
import com.androidbull.mypronounce.ui.helper.PronunciationAccuracyChecker
import com.androidbull.mypronounce.util.GeneralUtils.Companion.getWrongWords


class SentenceListAdapter(private val sentenceList: List<Sentence>) :
        RecyclerView.Adapter<SentenceListAdapter.SentenceViewHolder>() {

    private var onSentenceItemChildViewClickListener: OnSentenceItemChildViewClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): SentenceViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_sentence, parent, false)

        return SentenceViewHolder(view)
    }


    override fun onBindViewHolder(holder: SentenceViewHolder, position: Int) {
        val sentence: Sentence = sentenceList[position]
        holder.bind(sentence, position)
    }


    override fun getItemCount(): Int = sentenceList.size

    inner class SentenceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var tvSentenceWords: TextView = view.findViewById(R.id.tvSentenceWords)
        private var tvAccuracyPercentage: TextView = view.findViewById(R.id.tvAccuracyPercentage)
        private var ctvSpeechResult: ClickableTextView = view.findViewById(R.id.tvSpeechResult)
        private var tvSpeechOutput: TextView = view.findViewById(R.id.tvSpeechOutput)
        private var ibSpeech: ImageButton = view.findViewById(R.id.ibSpeech)
        private var ibTranslate: ImageButton = view.findViewById(R.id.ibTranslate)
        private var llAccuracy: LinearLayout = view.findViewById(R.id.llAccuracy)

        fun bind(sentence: Sentence, position: Int) {
            tvSentenceWords.text = sentence.words

            if (!sentence.isAccurate)
                tvSpeechOutput.text = sentence.speechResult

            if (!TextUtils.isEmpty(sentence.speechResult)) {
                val wrongWords = getWrongWords(sentence.words, sentence.speechResult)
                val clickableWords = mutableListOf<ClickableTextView.ClickableWord>()

                //TODO to separate
                for (wrongWord in wrongWords) {
                    val clickableSpan = object : ClickableSpan() {
                        override fun onClick(p0: View) {
                            onSentenceItemChildViewClickListener?.onWrongSentenceClick(wrongWord)
                        }
                    }
                    val clickableWord = ClickableTextView.ClickableWord(wrongWord, clickableSpan)
                    clickableWords.add(clickableWord)
                }
                ctvSpeechResult.setTextWithClickableWords(sentence.words, clickableWords)
            } else {
                ctvSpeechResult.text = ""
            }


            if (PronunciationAccuracyChecker.isAccuratePronunciation(sentence.accuracy)) {
                llAccuracy.background = ContextCompat.getDrawable(llAccuracy.context, R.drawable.bg_accuracy_good)
                llAccuracy.visibility = View.VISIBLE
            } else if ((sentence.accuracy >= 0) && (!PronunciationAccuracyChecker.isAccuratePronunciation(sentence.accuracy))) {
                llAccuracy.background = ContextCompat.getDrawable(llAccuracy.context, R.drawable.bg_accuracy_bad)
                llAccuracy.visibility = View.VISIBLE
            } else {
                llAccuracy.visibility = View.INVISIBLE
            }

            tvAccuracyPercentage.text = tvAccuracyPercentage.context.getString(R.string.tv_accuracy_percentage, sentence.accuracy)


            ibSpeech.setOnClickListener {
                onSentenceItemChildViewClickListener?.onSpeechViewClick(sentence, position)
            }

            ibTranslate.setOnClickListener {
                onSentenceItemChildViewClickListener?.onTranslateViewClick(sentence, position)
            }
        }
    }

    fun setOnSentenceItemChildViewClickListener(onSentenceItemChildViewClickListener: OnSentenceItemChildViewClickListener) {
        this.onSentenceItemChildViewClickListener = onSentenceItemChildViewClickListener
    }

    interface OnSentenceItemChildViewClickListener {
        fun onTranslateViewClick(sentence: Sentence, position: Int)
        fun onSpeechViewClick(sentence: Sentence, position: Int)
        fun onWrongSentenceClick(sentence: String)
    }
}