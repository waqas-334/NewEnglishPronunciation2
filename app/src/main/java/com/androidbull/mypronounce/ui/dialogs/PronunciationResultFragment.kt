package com.androidbull.mypronounce.ui.dialogs

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.androidbull.mypronounce.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

private const val ARG_PARAM_SPEECH_RESULT = "speechResult"
private const val ARG_PARAM_USER_INPUT = "userInput"
private const val ARG_PARAM_PRONUNCIATION_ACCURACY = "pronunciationAccuracy"

private const val AVERAGE_ACCURACY = 60

class PronunciationResultFragment : DialogFragment() {

    private var speechResult: String? = null
    private var userInput: String? = null
    private var pronunciationAccuracy: String? = null
    private lateinit var onClickListener: View.OnClickListener

    companion object {
        @JvmStatic
        fun newInstance(userInput: String, speechResult: String, pronunciationAccuracy: String) =
                PronunciationResultFragment()
                        .apply {
                            arguments = Bundle().apply {
                                putString(ARG_PARAM_SPEECH_RESULT, speechResult)
                                putString(ARG_PARAM_USER_INPUT, userInput)
                                putString(ARG_PARAM_PRONUNCIATION_ACCURACY, pronunciationAccuracy)
                            }
                        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            speechResult = it.getString(ARG_PARAM_SPEECH_RESULT)
            userInput = it.getString(ARG_PARAM_USER_INPUT)
            pronunciationAccuracy = it.getString(ARG_PARAM_PRONUNCIATION_ACCURACY)
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_pronunciation_result, null)
        onViewCreated(dialogView, savedInstanceState)
        return MaterialAlertDialogBuilder(requireContext())
                .setView(dialogView)
                .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
        initActions(view)

    }

    private fun initView(view: View) {
        view.findViewById<TextView>(R.id.tvAccuracyPercentage).text = getString(R.string.str_accuracy_percentage, pronunciationAccuracy)
        view.findViewById<TextView>(R.id.tvSpeechResult).text = getString(R.string.tv_speech_result, speechResult)
        view.findViewById<Button>(R.id.btnSecond).text =
                if (isPronunciationAccuracyBelowAverage()) getString(R.string.btn_teach_me) else getString(R.string.btn_another_word)
        if (isPronunciationAccuracyBelowAverage())
            view.findViewById<Button>(R.id.btnTryAgain).setBackgroundColor(ContextCompat.getColor(requireContext().applicationContext,
                    R.color.white))
    }

    private fun initActions(view: View) {
        view.findViewById<Button>(R.id.btnTryAgain).setOnClickListener { btnTryAgain ->
            onClickListener.onClick(btnTryAgain)
            dismiss()
        }

        view.findViewById<Button>(R.id.btnSecond).setOnClickListener { btnSecond ->
            if (isPronunciationAccuracyBelowAverage()) {
                onClickListener.onClick(btnSecond)
                dismiss()
            } else {
                dismiss()   // btnAnotherWord
            }
        }
    }

    private fun isPronunciationAccuracyBelowAverage(): Boolean {
        pronunciationAccuracy?.let { accuracy ->
            if (accuracy.toInt() >= AVERAGE_ACCURACY)
                return false
        }
        return true
    }

    fun setOnClickListener(onClickListener: View.OnClickListener) {
        this.onClickListener = onClickListener
    }
}