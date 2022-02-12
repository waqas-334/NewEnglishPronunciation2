package com.androidbull.mypronounce.ui.feature.practiceword

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.common.in_app_purchases.AppBillingProcessor.getInstance
import com.androidbull.mypronounce.data.local.database.AppDatabase
import com.androidbull.mypronounce.data.model.WordLesson
import com.androidbull.mypronounce.ui.AdNetwork
import com.androidbull.mypronounce.ui.BaseActivity
import com.androidbull.mypronounce.ui.dialogs.VipDialog.Companion.newInstance
import com.androidbull.mypronounce.ui.helper.LessonUnLocker
import com.anjlab.android.iab.v3.BillingProcessor
import com.anjlab.android.iab.v3.BillingProcessor.IBillingHandler
import com.anjlab.android.iab.v3.TransactionDetails
import com.google.android.material.appbar.MaterialToolbar
import net.gotev.speech.Logger
import net.gotev.speech.Speech


private const val SCORE_PER_ACCURATE_PRONUNCIATION = 5

class PracticeWordActivity : BaseActivity() {

    private lateinit var tvScoreWords: TextView
    private var billingProcessor: BillingProcessor? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Speech.init(this)
        Logger.setLogLevel(Logger.LogLevel.DEBUG)


        setInitialFragment(savedInstanceState)
        getWordScore()

        billingProcessor = getInstance()

    }

    override fun getLayoutResourceId() = R.layout.activity_practice_words
    override fun getBannerAdID() = if (super.adNetwork === AdNetwork.FACEBOOK)
        getString(R.string.practice_words_bottom_banner_ad) else getString(R.string.admob_practice_words_bottom_banner_ad)
    override fun getBannerAdView(): LinearLayout? = findViewById(R.id.llAdsBannerContainer)

    override fun initViews() {
        tvScoreWords = findViewById(R.id.tvScoreWords)
        setToolbar()
    }

    override fun initActions() {}
    override fun hideAdRelatedViews() {}


    private fun setToolbar() {
        val tbWordLessons = findViewById<MaterialToolbar>(R.id.tbWordLessons)
        setSupportActionBar(tbWordLessons)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = getString(R.string.words)
        }
    }

    private fun getWordScore() {
        AppDatabase.invoke(applicationContext).wordDao().getAccurateWordsLive().observe(this, Observer { accurateWords ->
            val wordScore = accurateWords * SCORE_PER_ACCURATE_PRONUNCIATION
            tvScoreWords.text = getString(R.string.word_score, wordScore)

            LessonUnLocker.unlockWordLesson(applicationContext, wordScore)
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
                    .add(R.id.fragmentContainer, WordLessonListFragment.newInstance())
                    .commit()
        }
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (fragment is WordLessonListFragment) {
            fragment.setLessonDetailRequestHandler(::onLessonDetailClick)
        }
    }


    private fun onLessonDetailClick(wordLesson: WordLesson) {
        if (wordLesson.isLocked) {
            showVipDialog()
        } else {
            replaceFragment(WordLessonDetailFragment.newInstance(wordLesson))
            setToolbarTitle(wordLesson.subtitle)
        }
    }

    private fun showVipDialog() {

        val vipDialog = newInstance()
        vipDialog.setOnClickListener(View.OnClickListener { view: View ->
            if (view.id == R.id.btnUpgrade) {
                if (getInstance().isOneTimePurchaseSupported) {
                    getInstance(object : IBillingHandler {
                        override fun onProductPurchased(productId: String, details: TransactionDetails?) {
                            unlockVip()
                        }

                        override fun onPurchaseHistoryRestored() {}
                        override fun onBillingError(errorCode: Int, error: Throwable?) {}
                        override fun onBillingInitialized() {}
                    }).purchase(this, getString(R.string.remove_ad_id))
                } else {
                    Toast.makeText(this@PracticeWordActivity, getString(R.string.err_In_app_billing_service_is_unavailable), Toast.LENGTH_SHORT).show()
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        billingProcessor?.let {
            if (!it.handleActivityResult(requestCode, resultCode, data)) {
                super.onActivityResult(requestCode, resultCode, data)
            }
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

    private fun setToolbarTitle(title: String) {
        supportActionBar?.apply {
            setTitle(title)
        }
    }


}