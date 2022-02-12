package com.androidbull.mypronounce.ui.feature.pronunciationchecker

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.TextUtils
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.androidbull.mypronounce.activities.SpeakActivity
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.ui.AdNetwork
import com.androidbull.mypronounce.ui.BaseActivity
import com.androidbull.mypronounce.util.HelperMethods.closeKeyboard
import com.androidbull.mypronounce.ui.dialogs.PronunciationResultFragment
import com.androidbull.mypronounce.ui.dialogs.RecordPronunciationFragment
import com.androidbull.mypronounce.ui.helper.PronunciationAccuracyChecker
import com.androidbull.mypronounce.util.GeneralUtils
import com.google.android.material.appbar.MaterialToolbar
import net.gotev.speech.Logger
import net.gotev.speech.Speech
import net.gotev.speech.SpeechDelegate
import java.util.*

private const val RECORD_AUDIO_REQUEST_CODE = 100

class PronunciationCheckerActivity : BaseActivity(), SpeechDelegate {

    private lateinit var etWord: EditText
    private lateinit var recordPronunciationFragment: RecordPronunciationFragment
    private lateinit var pronunciationResultFragment: PronunciationResultFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Speech.init(this)
        Logger.setLogLevel(Logger.LogLevel.DEBUG)

    }

    override fun getLayoutResourceId() = R.layout.activity_pronunciation_checker
    override fun getBannerAdID() =  if (super.adNetwork === AdNetwork.FACEBOOK) getString(R.string.test_pronunciation_bottom_banner_ad) else getString(R.string.admob_test_pronunciation_bottom_banner_ad)
    override fun getBannerAdView(): LinearLayout? = findViewById(R.id.llAdsBannerContainer)

    override fun initViews() {
        etWord = findViewById(R.id.etWord)
        setToolbar()
    }

    override fun initActions() {
        findViewById<Button>(R.id.btnPronounce).setOnClickListener {
            if (isValidWord(getUserInput())) {
                closeKeyboard(this)
                if (hasRecordPermissions()) {
                    if (GeneralUtils.isOnline(this.applicationContext)) {
                        showRecordPronunciationFragment(getUserInput())
                    } else {
                        Toast.makeText(this, getString(R.string.err_internet_required), Toast.LENGTH_SHORT).show()
                    }
                } else {
                    requestRecordPermissions()
                }
            } else {
                showInputError()
            }
        }
    }

    override fun hideAdRelatedViews() {}


    private fun setToolbar() {
        val tbCheckPronunciation = findViewById<MaterialToolbar>(R.id.tbCheckPronunciation)
        setSupportActionBar(tbCheckPronunciation)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = getString(R.string.btn_check_pronunciation)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //region UI
    private fun getUserInput() = etWord.text.toString()

    private fun showInputError() {
        etWord.apply {
            requestFocus()
            error = getString(R.string.err_required)
        }
    }

    private fun showPermissionDeniedError() {
        Toast.makeText(this,
                getString(R.string.error_record_permissions),
                Toast.LENGTH_SHORT).show()
    }

    //endregion

    // region Permissions
    private fun hasRecordPermissions(): Boolean {
        return ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestRecordPermissions() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECORD_AUDIO), RECORD_AUDIO_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            RECORD_AUDIO_REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() &&
                                grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    if (GeneralUtils.isOnline(this.applicationContext)) {
                        showRecordPronunciationFragment(getUserInput())
                    } else {
                        Toast.makeText(this, getString(R.string.err_internet_required), Toast.LENGTH_SHORT).show()
                    }
                } else {
                    showPermissionDeniedError()
                }
                return
            }
        }
    }

    // endregion

    override fun onStartOfSpeech() {
    }

    override fun onSpeechPartialResults(results: MutableList<String>?) {
    }

    override fun onSpeechRmsChanged(value: Float) {
    }

    override fun onSpeechResult(speechResult: String?) {
        dismissRecordPronunciationFragment()
        if (!TextUtils.isEmpty(speechResult)) {
            val userInput = getUserInput().toLowerCase(Locale.ROOT)
            val pronunciationAccuracy = PronunciationAccuracyChecker.checkAccuracy(userInput, speechResult!!.toLowerCase(Locale.ROOT)).toString()
            showPronunciationResultFragment(userInput, speechResult, pronunciationAccuracy)
        } else {
            Toast.makeText(this, getString(R.string.err_result_not_match_speak), Toast.LENGTH_SHORT).show()
        }

    }

    /*//region Speech Recognition

    override fun onPartialResults(partialResults: Bundle) {}

    override fun onResults(results: Bundle) {
//        val scores = results.getFloatArray(SpeechRecognizer.CONFIDENCE_SCORES)
        val matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)

        matches?.let {
            if (matches.isNotEmpty()) {
                val speechResult = matches.get(0).toLowerCase(Locale.ROOT)
                val userInput = getUserInput().toLowerCase(Locale.ROOT)
                val pronunciationAccuracy = PronunciationAccuracyChecker.checkAccuracy(userInput, speechResult).toString()
                showPronunciationResultFragment(userInput, speechResult, pronunciationAccuracy)
            }
        }
    }


    override fun onReadyForSpeech(params: Bundle?) {
        Log.d(localClassName, "onReadyForSpeech: ")
    }

    override fun onRmsChanged(rmsdB: Float) {
        Log.d(localClassName, "onRmsChanged: ")
    }

    override fun onBufferReceived(buffer: ByteArray?) {
        Log.d(localClassName, "onBufferReceived: ")
    }

    override fun onEvent(eventType: Int, params: Bundle?) {
        Log.d(localClassName, "onEvent: ")
    }

    override fun onBeginningOfSpeech() {
        Log.d(localClassName, "onBeginningOfSpeech: ")
    }

    override fun onEndOfSpeech() {
        Log.d(localClassName, "onEndOfSpeech: ")
        dismissRecordPronunciationFragment()
    }

    override fun onError(error: Int) {
        for (speechRecognitionError in SpeechRecognitionError.values()) {
            if (error == speechRecognitionError.errCode) {
                val errStr = getString(R.string.err_speech_recognition, speechRecognitionError.name, speechRecognitionError.errString)
                Log.d("test", "onError: " + errStr)
                break
            }
        }
        dismissRecordPronunciationFragment()

    }
    //endregion*/

    //region fragments
    private fun showRecordPronunciationFragment(userInput: String) {
        recordPronunciationFragment = RecordPronunciationFragment.newInstance(userInput)
        recordPronunciationFragment.setRecognitionListener(this)
        recordPronunciationFragment.show(supportFragmentManager, "pronunciationCheckerFragment")
    }

    private fun dismissRecordPronunciationFragment() {
        recordPronunciationFragment.dismiss()
    }

    private fun showPronunciationResultFragment(userInput: String, speechResult: String, pronunciationAccuracy: String) {
        pronunciationResultFragment = PronunciationResultFragment.newInstance(userInput, speechResult, pronunciationAccuracy)
        pronunciationResultFragment.setOnClickListener(View.OnClickListener {
            if (it.id == R.id.btnTryAgain)
                showRecordPronunciationFragment(getUserInput())
            else if (it.id == R.id.btnSecond)
                startSpeakActivity(getUserInput())
        })
        pronunciationResultFragment.show(supportFragmentManager, "pronunciationResultFragment")
    }


    //endregion

    private fun isValidWord(word: String) = !TextUtils.isEmpty(word)


    private fun startSpeakActivity(userInput: String) {
        Intent(this, SpeakActivity::class.java).apply {
            action = "android.intent.action.PROCESS_TEXT"
            putExtra("android.intent.extra.PROCESS_TEXT", userInput)
            startActivity(this)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            Speech.getInstance().shutdown()
        } catch (ex: IllegalStateException) {
            ex.printStackTrace()
        }
    }


}
