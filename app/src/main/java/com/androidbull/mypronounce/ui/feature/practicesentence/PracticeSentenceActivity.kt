package com.androidbull.mypronounce.ui.feature.practicesentence

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.common.in_app_purchases.AppBillingProcessor
import com.androidbull.mypronounce.data.local.database.AppDatabase
import com.androidbull.mypronounce.data.model.SentenceLesson
import com.androidbull.mypronounce.ui.AdNetwork
import com.androidbull.mypronounce.ui.BaseActivity
import com.androidbull.mypronounce.ui.dialogs.VipDialog
import com.androidbull.mypronounce.ui.helper.LessonUnLocker
import com.anjlab.android.iab.v3.BillingProcessor
import com.anjlab.android.iab.v3.TransactionDetails
import com.google.android.material.appbar.MaterialToolbar
import net.gotev.speech.Logger
import net.gotev.speech.Speech


private const val SCORE_PER_ACCURATE_PRONUNCIATION = 5

class PracticeSentenceActivity : BaseActivity() {

    private lateinit var tvScoreSentences: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Speech.init(this)
        Logger.setLogLevel(Logger.LogLevel.DEBUG)


        setToolbar()
        setInitialFragment(savedInstanceState)
        getSentenceScore()
    }

    override fun getLayoutResourceId() = R.layout.activity_practice_sentence
    override fun getBannerAdID() =  if (super.adNetwork === AdNetwork.FACEBOOK) getString(R.string.practice_sentences_bottom_banner_ad) else getString(R.string.admob_practice_sentences_bottom_banner_ad)
    override fun getBannerAdView(): LinearLayout? = findViewById(R.id.llAdsBannerContainer)

    override fun initViews() {
        tvScoreSentences = findViewById(R.id.tvScoreSentences)
        setToolbar()
    }

    override fun initActions() {}
    override fun hideAdRelatedViews() {}


    private fun setToolbar() {
        val tbSentenceLessons = findViewById<MaterialToolbar>(R.id.tbSentenceLessons)
        setSupportActionBar(tbSentenceLessons)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = getString(R.string.sentence)
        }
    }

    private fun getSentenceScore() {
        AppDatabase.invoke(applicationContext).sentenceDao().getAccurateSentencesLive().observe(this, Observer { accurateSentences ->
            val sentenceScore = accurateSentences * SCORE_PER_ACCURATE_PRONUNCIATION
            tvScoreSentences.text = getString(R.string.sentence_score, sentenceScore)

            LessonUnLocker.unLockSentenceLesson(applicationContext, sentenceScore)
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setInitialFragment(savedInstanceState: Bundle?) {
        if (findViewById<FrameLayout>(R.id.fragmentContainer) != null) {
            if (savedInstanceState != null) {
                return
            }
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainer, SentenceLessonListFragment.newInstance())
                    .commit()
        }
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (fragment is SentenceLessonListFragment) {
            fragment.setLessonDetailRequestHandler(::onLessonDetailClick)
        }
    }


    private fun onLessonDetailClick(sentenceLesson: SentenceLesson) {
        if (sentenceLesson.isLocked) {
            showVipDialog()
        } else {
            replaceFragment(SentenceLessonDetailFragment.newInstance(sentenceLesson))
            setToolbarTitle(sentenceLesson.subtitle)
        }
    }

    private fun showVipDialog() {

        val vipDialog = VipDialog.newInstance()
        vipDialog.setOnClickListener(View.OnClickListener { view: View ->
            if (view.id == R.id.btnUpgrade) {
                if (AppBillingProcessor.getInstance().isOneTimePurchaseSupported) {
                    AppBillingProcessor.getInstance(object : BillingProcessor.IBillingHandler {
                        override fun onProductPurchased(productId: String, details: TransactionDetails?) {
                            unlockVip()
                        }

                        override fun onPurchaseHistoryRestored() {}
                        override fun onBillingError(errorCode: Int, error: Throwable?) {}
                        override fun onBillingInitialized() {}
                    }).purchase(this, getString(R.string.remove_ad_id))
                } else {
                    Toast.makeText(this@PracticeSentenceActivity, getString(R.string.err_In_app_billing_service_is_unavailable), Toast.LENGTH_SHORT).show()
                }
            }
        })


        vipDialog.show(supportFragmentManager, "vipDialog")
    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
    }


    override fun onDestroy() {
        super.onDestroy()
        try {
            Speech.getInstance().shutdown()
        } catch (ex: IllegalStateException) {
            ex.printStackTrace()
        }
    }

    private fun setToolbarTitle(title: String) {
        supportActionBar?.apply {
            setTitle(title)
        }
    }

}