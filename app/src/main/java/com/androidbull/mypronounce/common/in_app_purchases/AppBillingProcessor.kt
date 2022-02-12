package com.androidbull.mypronounce.common.in_app_purchases

import android.content.Context
import android.util.Log
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.ui.helper.PreferenceManager
import com.anjlab.android.iab.v3.BillingProcessor
import com.anjlab.android.iab.v3.BillingProcessor.IBillingHandler
import com.anjlab.android.iab.v3.TransactionDetails

private const val TAG = "AppBillingProcessor"

object AppBillingProcessor : IBillingHandler {

    interface InitListener {
        fun onInitialized()
    }

    private var billingProcessor: BillingProcessor? = null
    private var iBillingHandler: IBillingHandler? = null
    private var initListener: InitListener? = null

    fun initialize(context: Context) {
        billingProcessor = BillingProcessor(context.applicationContext, context.getString(R.string.base64_key), this)
    }

    fun getInstance(): BillingProcessor {
        if (billingProcessor == null)
            throw IllegalStateException("AppBilling Processor is not initialized. call AppBillingProcessor.initialize()")
        return billingProcessor!!
    }

    fun getInstance(iBillingHandler: IBillingHandler): BillingProcessor {
        this.iBillingHandler = iBillingHandler
        if (billingProcessor == null)
            throw IllegalStateException("AppBilling Processor is not initialized. call AppBillingProcessor.initialize()")
        return billingProcessor!!
    }


    fun getInstance(initListener: InitListener): BillingProcessor? {
        this.initListener = initListener
        if (billingProcessor == null)
            throw IllegalStateException("AppBilling Processor is not initialized. call AppBillingProcessor.initialize()")
        return billingProcessor
    }


    override fun onBillingInitialized() {
        Log.d(TAG, "onBillingInitialized: ")
        iBillingHandler?.onBillingInitialized()
        initListener?.onInitialized()
    }

    override fun onPurchaseHistoryRestored() {
        Log.d(TAG, "onPurchaseHistoryRestored: ")
        iBillingHandler?.onPurchaseHistoryRestored()
    }

    override fun onProductPurchased(productId: String, details: TransactionDetails?) {
        Log.d(TAG, "onProductPurchased: ")
        iBillingHandler?.onProductPurchased(productId, details)
    }

    override fun onBillingError(errorCode: Int, error: Throwable?) {
        Log.d(TAG, "onBillingError: ")
        iBillingHandler?.onBillingError(errorCode, error)
    }
}

/*  private var billingProcessor: BillingProcessor? = null
  var isInitialized = false
      private set
  var error = ""

  fun initialize(context: Context) {

      if (!BillingProcessor.isIabServiceAvailable(context)) {

          billingProcessor = BillingProcessor(context, context.getString(R.string.base64_key), object : IBillingHandler {
              override fun onProductPurchased(productId: String, details: TransactionDetails?) {
//                IAPPrefrences.savePurchasedState(Constants.PAID_STATE, true, this@MainActivity)
              }

              override fun onBillingError(errorCode: Int, error: Throwable?) {
//                showToast("onBillingError: $errorCode")
              }

              override fun onBillingInitialized() {

                  isInitialized = true

                  Log.d("IAPTesting", "onBillingInitialized | Is App Paid : " + billingProcessor.isPurchased(getString(R.string.remove_ad_id)))
                  val skuDetails: SkuDetails = billingProcessor.getPurchaseListingDetails(getString(R.string.remove_ad_id))
                  if (skuDetails != null) {
                      showToast(skuDetails.priceText)
                  } else {
                      showToast("skuDetails null")
                  }


                  *//*if (!billingProcessor.isPurchased(getString(R.string.remove_ad_id))) {
            IAPPrefrences.savePurchasedState(Constants.PAID_STATE, false, this);
            loadAds();
        } else {
            IAPPrefrences.savePurchasedState(Constants.PAID_STATE, true, this);
            removeAds();
        }*//*
                }

                override fun onPurchaseHistoryRestored() {
                    *//* showToast("onPurchaseHistoryRestored");
                for (String sku : bp.listOwnedProducts())
                    Log.d(LOG_TAG, "Owned Managed Product: " + sku);
                for (String sku : bp.listOwnedSubscriptions())
                    Log.d(LOG_TAG, "Owned Subscription: " + sku);
                updateTextViews();*//*
                }
            })

            billingProcessor?.initialize()

        } else {
            isInitialized = false
            error = (context.getString(R.string.err_In_app_billing_service_is_unavailable))
        }
    }*/


