package com.androidbull.mypronounce.ui.helper

import android.content.Context
import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.util.AttributeSet


/**
 * Defines a TextView widget where user can click on different words to see different actions
 */
class ClickableTextView : androidx.appcompat.widget.AppCompatTextView {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {}

    fun setTextWithClickableWords(text: String, clickableWords: List<ClickableWord>) {
        movementMethod = LinkMovementMethod.getInstance()
        setText(addClickablePart(text, clickableWords), BufferType.SPANNABLE)
    }

    private fun addClickablePart(str: String, clickableWords: List<ClickableWord>): SpannableStringBuilder {
        val spannableStringBuilder = SpannableStringBuilder(str)
        for (clickableWord in clickableWords) {
            var startIndex = str.indexOf(clickableWord.word)
            var endIndex: Int
            while (startIndex != -1) {
                endIndex = startIndex + clickableWord.word.length
                spannableStringBuilder.setSpan(clickableWord.clickableSpan, startIndex, endIndex, 0)
                spannableStringBuilder.setSpan(ForegroundColorSpan(Color.RED), startIndex, endIndex, 0)
                spannableStringBuilder.setSpan(UnderlineSpan(), startIndex, endIndex, 0);
                startIndex = str.indexOf(clickableWord.word, endIndex)
            }
        }
        return spannableStringBuilder
    }

    class ClickableWord(
            val word: String,
            val clickableSpan: ClickableSpan)
}