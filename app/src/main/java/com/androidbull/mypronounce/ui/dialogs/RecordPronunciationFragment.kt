package com.androidbull.mypronounce.ui.dialogs

import android.app.Dialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.androidbull.mypronounce.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import net.gotev.speech.GoogleVoiceTypingDisabledException
import net.gotev.speech.Speech
import net.gotev.speech.SpeechDelegate
import net.gotev.speech.SpeechRecognitionNotAvailable

private const val ARG_PARAM_WORD = "word"

class RecordPronunciationFragment : DialogFragment() {

    private val logTag = javaClass.name

    private var paramWord: String? = null
    private var speechDelegate: SpeechDelegate? = null

    companion object {
        @JvmStatic
        fun newInstance(word: String) =
                RecordPronunciationFragment()
                        .apply {
                            arguments = Bundle().apply {
                                putString(ARG_PARAM_WORD, word)
                            }
                        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            paramWord = it.getString(ARG_PARAM_WORD)
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_record_pronunciation, null)
        onViewCreated(dialogView, savedInstanceState)
        return MaterialAlertDialogBuilder(requireContext())
                .setView(dialogView)
                .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tvSpeakWord).text = getString(R.string.tv_speak_word, paramWord)
        startListening()
    }

    fun setRecognitionListener(speechDelegate: SpeechDelegate) {
        this.speechDelegate = speechDelegate
    }


    private fun startListening() {

        try {
            Speech.getInstance().startListening(object : SpeechDelegate {
                override fun onStartOfSpeech() {
                }

                override fun onSpeechRmsChanged(value: Float) {
                    Log.d(logTag, "rms is now: $value")
                }

                override fun onSpeechPartialResults(results: List<String>) {
                    val str = StringBuilder()
                    for (res in results) {
                        str.append(res).append(" ")
                    }
                    Log.i(logTag, "partial result: " + str.toString().trim { it <= ' ' })
                }

                override fun onSpeechResult(result: String) {
                    Log.i(logTag, "result: $result")
                    speechDelegate?.onSpeechResult(result)
                }
            })
        } catch (exc: SpeechRecognitionNotAvailable) {
            Log.e(logTag, getString(R.string.err_speech_recognition_not_available))
            if (!TextUtils.isEmpty(exc.message))
                showSpeechRecognitionError(exc.message.toString())
            // You can prompt the user if he wants to install Google App to have
            // speech recognition, and then you can simply call:
            // SpeechUtil.redirectUserToGoogleAppOnPlayStore(this);
            // to redirect the user to the Google App page on Play Store
        } catch (exc: GoogleVoiceTypingDisabledException) {
            Log.e(logTag, getString(R.string.err_google_voice_typing_not_enabled))
            if (!TextUtils.isEmpty(exc.message))
                showSpeechRecognitionError(exc.message.toString())
        }
    }

    private fun showSpeechRecognitionError(errorStr: String) {
        Toast.makeText(requireContext(), errorStr, Toast.LENGTH_SHORT).show()
        dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Speech.getInstance().stopListening()
    }
}