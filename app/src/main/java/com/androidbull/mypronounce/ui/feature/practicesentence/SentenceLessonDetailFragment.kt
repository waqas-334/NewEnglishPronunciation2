package com.androidbull.mypronounce.ui.feature.practicesentence

import android.Manifest
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.media.MediaPlayer
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import androidx.recyclerview.widget.SnapHelper
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.ui.helper.CenterZoomLinearLayoutManager
import com.androidbull.mypronounce.ui.helper.CirclePagerHorizontalIndicatorDecoration
import com.androidbull.mypronounce.ui.helper.PronunciationAccuracyChecker
import com.androidbull.mypronounce.data.local.database.AppDatabase
import com.androidbull.mypronounce.data.model.Sentence
import com.androidbull.mypronounce.data.model.SentenceLesson
import com.androidbull.mypronounce.ui.dialogs.TextTranslationDialog
import com.androidbull.mypronounce.ui.feature.dailylesson.adapter.SentenceListAdapter
import com.androidbull.mypronounce.ui.helper.CirclePagerVerticalIndicatorDecoration
import com.androidbull.mypronounce.ui.helper.PronunciationAccuracyChecker.isAccuratePronunciation
import com.androidbull.mypronounce.util.GeneralUtils
import com.androidbull.mypronounce.util.HasAccuracy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.launch
import net.gotev.speech.GoogleVoiceTypingDisabledException
import net.gotev.speech.Speech
import net.gotev.speech.SpeechDelegate
import net.gotev.speech.SpeechRecognitionNotAvailable
import net.gotev.speech.ui.SpeechProgressView
import java.util.*

private const val ARG_PARAM_SENTENCE_LESSON = "sentenceLesson"
private const val RECORD_AUDIO_REQUEST_CODE = 101

class SentenceLessonDetailFragment : Fragment() {
    private val logTag = javaClass.name
    private var paramSentenceLesson: SentenceLesson? = null

    private lateinit var rvSentences: RecyclerView
    private lateinit var sentenceListAdapter: SentenceListAdapter
    private lateinit var snapHelper: SnapHelper
    private var snapPosition = NO_POSITION
    private var prevSnapPosition = NO_POSITION
    private val sentenceList = mutableListOf<Sentence>()

    private lateinit var ibMic: ImageButton
    private lateinit var spvRecording: SpeechProgressView
    private lateinit var llRecordingView: LinearLayout
    private var isFirstRun = true


    companion object {
        @JvmStatic
        fun newInstance(sentenceLesson: SentenceLesson) =
                SentenceLessonDetailFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(ARG_PARAM_SENTENCE_LESSON, sentenceLesson)
                    }
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramSentenceLesson = it.getSerializable(ARG_PARAM_SENTENCE_LESSON) as SentenceLesson
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sentence_lesson_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        initActions()

        setWordRecyclerView()
        getSentences()
    }

    private fun initViews(view: View) {
        ibMic = view.findViewById(R.id.ibMic)
        spvRecording = view.findViewById(R.id.spvRecording)
        rvSentences = view.findViewById(R.id.rvSentences)
        llRecordingView = view.findViewById(R.id.llRecordingView)
    }

    private fun initActions() {
        ibMic.setOnClickListener {
            if (Speech.getInstance().isListening) {
                Speech.getInstance().stopListening()
            } else {
                if (hasRecordPermissions()) {
                    if (GeneralUtils.isOnline(requireContext().applicationContext)) {
                        refreshCardView()   // remove previous result values from card view
                        startListening()
                    } else {
                        Toast.makeText(requireContext(), getString(R.string.err_internet_required), Toast.LENGTH_SHORT).show()
                    }

                } else {
                    requestRecordPermissions()
                }
            }
        }
    }

    private fun getSentences() {

        paramSentenceLesson?.let { sentenceLesson ->
            AppDatabase.invoke(requireContext().applicationContext).sentenceDao().getAllByLessonId(sentenceLesson.id).observe(this, Observer { sentenceList ->
                if (sentenceList.isNotEmpty()) {
                    updateAdapters(sentenceList)
                    scrollToInAccurateSentence()
                }
            })
        }
    }

    private fun scrollToInAccurateSentence() {
        if (isFirstRun) {
            if (sentenceList.isNotEmpty()) {
                isFirstRun = false
                for ((index, sentence) in sentenceList.withIndex()) {
                    if (!sentence.isAccurate) {
                        rvSentences.scrollToPosition(index)
                        break
                    }
                }
            }
        }
    }


    private fun updateAdapters(sl: List<Sentence>) {
        sentenceList.clear()
        sentenceList.addAll(sl)
        sentenceListAdapter.notifyDataSetChanged()
    }

    private fun setWordRecyclerView() {

        snapHelper = PagerSnapHelper()
        sentenceListAdapter = SentenceListAdapter(sentenceList)
        rvSentences.apply {
            adapter = sentenceListAdapter
            val currentOrientation = resources.configuration.orientation
            if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
                layoutManager = CenterZoomLinearLayoutManager(requireContext())
                snapHelper.attachToRecyclerView(this)
                addItemDecoration(CirclePagerHorizontalIndicatorDecoration(sentenceList as List<HasAccuracy>))
            } else {
                layoutManager = LinearLayoutManager(requireContext())
                snapHelper.attachToRecyclerView(this)
                addItemDecoration(CirclePagerVerticalIndicatorDecoration(sentenceList as List<HasAccuracy>))
            }
        }

        rvSentences.addOnScrollListener(object : OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                notifySnapPositionChange(recyclerView)
            }
        })

        sentenceListAdapter.setOnSentenceItemChildViewClickListener(object : SentenceListAdapter.OnSentenceItemChildViewClickListener {
            override fun onSpeechViewClick(sentence: Sentence, position: Int) {
                speak(sentence.words)
            }

            override fun onTranslateViewClick(sentence: Sentence, position: Int) {
                showWordTranslationDialog(sentence.words)
            }

            override fun onWrongSentenceClick(sentence: String) {
                speak(sentence)
            }
        })
    }


    private fun showWordTranslationDialog(text: String) {
        TextTranslationDialog.newInstance(text).show(childFragmentManager, "textTranslationDialog")
    }

    private fun onSnapPositionChange(position: Int) {
        val word = sentenceList[position]
        speak(word.words)
    }

    private fun speak(text: String) {
        Speech.getInstance().stopTextToSpeech()
        Speech.getInstance().say(text)
    }

    private fun notifySnapPositionChange(recyclerView: RecyclerView) {

        prevSnapPosition = snapPosition

        val snapPosition = snapHelper.getSnapPosition(recyclerView)
        val snapPositionChanged = this.snapPosition != snapPosition
        if (snapPositionChanged) {
            onSnapPositionChange(snapPosition)
            this.snapPosition = snapPosition
        }
    }

    private fun SnapHelper.getSnapPosition(recyclerView: RecyclerView): Int {
        val layoutManager = recyclerView.layoutManager ?: return NO_POSITION
        val snapView = findSnapView(layoutManager) ?: return NO_POSITION
        return layoutManager.getPosition(snapView)
    }

    private fun refreshCardView() {
        rvSentences.post(Runnable {
            val viewItem = rvSentences.layoutManager?.findViewByPosition(snapPosition)
            viewItem?.let {

                val llAccuracy = viewItem.findViewById<LinearLayout>(R.id.llAccuracy)
                llAccuracy.visibility = View.INVISIBLE
                val tvSpeechResult = viewItem.findViewById<TextView>(R.id.tvSpeechResult)
                val tvSpeechOutput = viewItem.findViewById<TextView>(R.id.tvSpeechOutput)
                tvSpeechResult.text = ""
                tvSpeechOutput.text = ""
            }
        })
    }

    private fun startListening() {

        try {
            Speech.getInstance().startListening(spvRecording, object : SpeechDelegate {
                override fun onStartOfSpeech() {
                    showRecordingAmplitude()
                    Log.i(logTag, "speech recognition is now active")
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
                    hideRecordingAmplitude()
                    processResult(result)
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
    }

    private fun showRecordingAmplitude() {
        llRecordingView.visibility = View.VISIBLE
    }

    private fun hideRecordingAmplitude() {
        llRecordingView.visibility = View.INVISIBLE
    }

    private fun processResult(speechResult: String) {

        val actualSentence = sentenceList[snapPosition]
        val pronunciationAccuracy = PronunciationAccuracyChecker.checkAccuracy(actualSentence.words.toLowerCase(Locale.ROOT), speechResult.toLowerCase(Locale.ROOT))
        updateSentenceAndLesson(actualSentence, pronunciationAccuracy, speechResult)

        if (isAccuratePronunciation(pronunciationAccuracy)) {
            moveToNextWord()
        } else {
            playWrongPronunciationSound()
        }
    }

    private fun updateSentenceAndLesson(actualSentence: Sentence, pronunciationAccuracy: Int, speechResult: String) {

        val isPronunciationAccurate = isAccuratePronunciation(pronunciationAccuracy)
        val sentence = actualSentence.copy(accuracy = pronunciationAccuracy, speechResult = speechResult.toLowerCase(Locale.ROOT), isAccurate = isPronunciationAccurate)
        GlobalScope.launch(Dispatchers.IO) {
            AppDatabase.invoke(requireContext()).sentenceDao().update(sentence)

            paramSentenceLesson?.let {
                if (isPronunciationAccurate && (!actualSentence.isAccurate)) // only increment when current pronunciation is accurate and previous pronunciation is inaccurate
                {
                    it.sentencesCompleted += 1  // local copy of sentence lesson (paramSentenceLesson.sentencesCompleted)
                } else if ((!isPronunciationAccurate) && (actualSentence.isAccurate)) { // only increment when current pronunciation is inaccurate and previous pronunciation is accurate
                    it.sentencesCompleted -= 1
                }

                val lessonPrevProgress = it.lessonProgress
                val lessonUpdatedProgress = ((it.sentencesCompleted.toDouble() / it.sentenceCount.toDouble()) * 100.00).toInt()
                val sentenceLesson = it.copy(lessonPrevProgress = lessonPrevProgress, lessonProgress = lessonUpdatedProgress)
                AppDatabase.invoke(requireContext()).sentenceLessonDao().update(sentenceLesson)
            }
        }
    }

    private fun moveToNextWord() {
        val lastPosition = sentenceList.size
        if (snapPosition < lastPosition) {
            rvSentences.postDelayed(Runnable {
                rvSentences.smoothScrollToPosition((snapPosition + 1))
            }, 1000L)
        }
    }

    private fun playWrongPronunciationSound() {
        val mediaPlayer = MediaPlayer.create(context, R.raw.incorrect_buzzer)
        mediaPlayer.setOnCompletionListener { mp ->
            mp?.apply {
                reset()
                release()
            }
        }
        mediaPlayer.start()
    }


// region Permissions

    private fun hasRecordPermissions(): Boolean {
        return ContextCompat.checkSelfPermission(requireContext(),
                Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestRecordPermissions() {
        ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.RECORD_AUDIO), RECORD_AUDIO_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            RECORD_AUDIO_REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() &&
                                grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    if (GeneralUtils.isOnline(requireContext().applicationContext)) {
                        startListening()
                    } else {
                        Toast.makeText(requireContext(), getString(R.string.err_internet_required), Toast.LENGTH_SHORT).show()
                    }
                } else {
                    showPermissionDeniedError()
                }
                return
            }
        }
    }

    private fun showPermissionDeniedError() {
        Toast.makeText(requireContext(),
                getString(R.string.error_record_permissions),
                Toast.LENGTH_SHORT).show()
    }

// endregion


    override fun onDestroyView() {
        super.onDestroyView()
        Speech.getInstance().stopListening()
        Speech.getInstance().stopTextToSpeech()
    }

}
