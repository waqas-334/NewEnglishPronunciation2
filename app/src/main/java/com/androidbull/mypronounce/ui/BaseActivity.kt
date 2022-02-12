package com.androidbull.mypronounce.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.constant.Constants.IS_VIP
import com.androidbull.mypronounce.data.local.database.AppDatabase
import com.androidbull.mypronounce.ui.helper.PreferenceManager
import com.facebook.ads.*
import com.facebook.ads.AdView.AdViewLoadConfig
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


enum class AdNetwork {
    FACEBOOK,
    ADMOB
}

abstract class BaseActivity : AppCompatActivity() {


    //TODO Change the following var to switch between Facebook and AdMob Ads
    var adNetwork: AdNetwork = AdNetwork.ADMOB;

    private val tag = "Base_Activity"

    private lateinit var sharedPreferences: PreferenceManager
    private var bannerAdView: AdView? = null
    private var llAdsBannerContainer: LinearLayout? = null
    private var interstitialAd: InterstitialAd? = null
    private var bannerAdId: String = ""


    private lateinit var mAdMobInterstitialAd: com.google.android.gms.ads.InterstitialAd
    private lateinit var mAdMobBannerAd: com.google.android.gms.ads.AdView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResourceId())
        MobileAds.initialize(this) {}

        sharedPreferences = PreferenceManager.getInstance(this)
        llAdsBannerContainer = getBannerAdView()
        bannerAdId = getBannerAdID()

        initViews()
        initActions()

        if (isVip() || isProVersion()) {
            unlockVip()
        } else {
            loadInterstitialAd()
            if (!TextUtils.isEmpty(bannerAdId))
                loadBannerAdView()
        }

    }

    override fun onResume() {
        if (isVip()) {
            unlockVip()
        }
        super.onResume()
    }

    protected fun isVip() = sharedPreferences.getBoolean(IS_VIP)
    protected fun isProVersion() = packageName == "com.androidbull.mypronounce.paid"

    private fun removeBannerAds() {
        llAdsBannerContainer?.removeAllViews()
        llAdsBannerContainer?.visibility = View.GONE
        bannerAdView?.destroy()
        bannerAdView = null
    }

    protected fun unlockVip() {
        PreferenceManager.getInstance(this).setBoolean(IS_VIP, true)
        removeBannerAds()
        unLockLessons()
        hideAdRelatedViews()
    }

    private fun unLockLessons() {
        GlobalScope.launch {
            launch { AppDatabase.invoke(this@BaseActivity).wordLessonDao().unLockAllLessons() }
            launch { AppDatabase.invoke(this@BaseActivity).sentenceLessonDao().unLockAllLessons() }
        }
    }


    protected abstract fun getLayoutResourceId(): Int
    protected abstract fun getBannerAdID(): String
    protected abstract fun getBannerAdView(): LinearLayout?
    protected abstract fun initViews()
    protected abstract fun initActions()
    protected abstract fun hideAdRelatedViews()

    private fun loadBannerAdView() {
        if (adNetwork == AdNetwork.FACEBOOK)
            loadFacebookBannerAD()
        else
            loadAdMobBannerAd()
    }

    private fun loadAdMobBannerAd() {

        llAdsBannerContainer?.visibility = View.VISIBLE
        mAdMobBannerAd = com.google.android.gms.ads.AdView(this);
        mAdMobBannerAd.adUnitId = bannerAdId
        val isTablet = resources.getBoolean(R.bool.is_tablet)
        mAdMobBannerAd.adSize = if(isTablet)com.google.android.gms.ads.AdSize.BANNER else com.google.android.gms.ads.AdSize.SMART_BANNER
        llAdsBannerContainer?.addView(mAdMobBannerAd)
        mAdMobBannerAd.loadAd(AdRequest.Builder().build())

        mAdMobBannerAd.adListener = object : com.google.android.gms.ads.AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i(tag, "onAdLoaded: ADMob Banner Ad Loaded")
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                // Code to be executed when an ad request fails.
                Log.e(tag, "onAdLoaded: ADMob Banner Ad Failed: " + adError.responseInfo + "\n" + adError.message)
                mAdMobBannerAd.loadAd(AdRequest.Builder().build())
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.e(tag, "onAdLoaded: ADMob Banner Ad Opened")
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Log.e(tag, "onAdLoaded: ADMob Banner Ad Clicked")
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.e(tag, "onAdLoaded: ADMob Banner Ad Left Application")

            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Log.e(tag, "onAdLoaded: ADMob Banner Ad Closed")

            }
        }


    }

    private fun loadFacebookBannerAD() {
        llAdsBannerContainer?.visibility = View.VISIBLE
        val isTablet = resources.getBoolean(R.bool.is_tablet)
        bannerAdView = AdView(this, bannerAdId,
                if (isTablet) AdSize.BANNER_HEIGHT_90 else AdSize.BANNER_HEIGHT_50)
        llAdsBannerContainer?.addView(bannerAdView)
        val adListener: AdListener = object : AdListener {
            override fun onError(ad: Ad, adError: AdError) {
                // Ad error callback
            }

            override fun onAdLoaded(ad: Ad) {
                // Ad loaded callback
            }

            override fun onAdClicked(ad: Ad) {
                // Ad clicked callback
            }

            override fun onLoggingImpression(ad: Ad) {
                // Ad impression logged callback
            }
        }
        val loadAdConfig: AdViewLoadConfig? = bannerAdView?.buildLoadAdConfig()
                ?.withAdListener(adListener)
                ?.build()
        loadAdConfig?.let {
            bannerAdView?.loadAd(it)
        }
    }

    private fun loadInterstitialAd() {
        if (adNetwork == AdNetwork.FACEBOOK)
            loadFacebookInterstitialAd()
        else {
            loadAdMobInterstitialAd()
        }
    }

    private fun loadAdMobInterstitialAd() {

        mAdMobInterstitialAd = com.google.android.gms.ads.InterstitialAd(this)
        mAdMobInterstitialAd.adUnitId = getString(R.string.admob_interstitial_ad_id)
        mAdMobInterstitialAd.loadAd(AdRequest.Builder().build())
        mAdMobInterstitialAd.adListener = object : com.google.android.gms.ads.AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i(tag, "onAdLoaded: AdMob Int Ad Loaded")
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                // Code to be executed when an ad request fails.
                Log.e(tag, "onAdLoaded: AdMob Int Ad Failed: " + adError.responseInfo + "\n" + adError.message)

            }

            override fun onAdOpened() {
                // Code to be executed when the ad is displayed.
                Log.i(tag, "onAdOpened: AdMob Int Ad opened")
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Log.i(tag, "onAdOpened: AdMob Int Ad clicked")
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i(tag, "onAdOpened: AdMob Int Ad Left Applciation")

            }

            override fun onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
                Log.i(tag, "onAdOpened: AdMob Int Ad Closed")

            }
        }


    }

    private fun loadFacebookInterstitialAd() {
        interstitialAd = InterstitialAd(this, getString(R.string.main_int_ad))
        // Set listeners for the Interstitial Ad
        val interstitialAdListener: InterstitialAdListener = object : InterstitialAdListener {
            override fun onInterstitialDisplayed(ad: Ad) {
                // Interstitial ad displayed callback
                Log.e(tag, "Interstitial ad displayed.")
            }

            override fun onInterstitialDismissed(ad: Ad) {
                // Interstitial dismissed callback
                Log.e(tag, "Interstitial ad dismissed.")
            }

            override fun onError(ad: Ad, adError: AdError) {
                // Ad error callback
                Log.e(tag, "Interstitial ad failed to load: " + adError.errorMessage)
            }

            override fun onAdLoaded(ad: Ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d(tag, "Interstitial ad is loaded and ready to be displayed!")
                // Show the ad
            }

            override fun onAdClicked(ad: Ad) {
                // Ad clicked callback
                Log.d(tag, "Interstitial ad clicked!")
            }

            override fun onLoggingImpression(ad: Ad) {
                // Ad impression logged callback
                Log.d(tag, "Interstitial ad impression logged!")
            }
        }

        interstitialAd?.let {
            it.loadAd(it.buildLoadAdConfig()
                    .withAdListener(interstitialAdListener)
                    .build())
        }
    }

    protected fun showInterstitialAd() {


        if (adNetwork == AdNetwork.FACEBOOK)
            showFacebookInterstitialAd()
        else
            showAdMobInterstitialAd()
    }

    private fun showAdMobInterstitialAd() {
        if (!mAdMobInterstitialAd.isLoaded) {
            loadAdMobInterstitialAd()
        } else
            mAdMobInterstitialAd.show()
    }

    private fun showFacebookInterstitialAd() {
        if (interstitialAd == null || !interstitialAd!!.isAdLoaded || interstitialAd!!.isAdInvalidated) {
            loadInterstitialAd()
        } else {
            interstitialAd!!.show()
        }
    }

    protected fun startEpActivity(intent: Intent) {
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        bannerAdView?.destroy()
    }

}