package com.androidbull.mypronounce.ui.dialogs

import android.app.Dialog
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.common.in_app_purchases.AppBillingProcessor
import com.anjlab.android.iab.v3.BillingProcessor
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class VipDialog : DialogFragment() {

    private var onClickListener: View.OnClickListener? = null
    private lateinit var tvDiscountedPrice: TextView
    private lateinit var tvPrice: TextView
    private var billingProcessor: BillingProcessor? = null


    companion object {
        @JvmStatic
        fun newInstance() = VipDialog()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_vip, null)
        onViewCreated(dialogView, savedInstanceState)
        return MaterialAlertDialogBuilder(requireContext())
                .setView(dialogView)
                .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        billingProcessor = AppBillingProcessor.getInstance()

        initView(view)
        initActions(view)
        setPrice()
    }

    private fun setPrice() {
        val skuDetails = billingProcessor?.getPurchaseListingDetails(getString(R.string.remove_ad_id))
        if (skuDetails != null) {

            val discountedPrice = skuDetails.priceValue
            val actualPrice = getActualPrice(discountedPrice)

            tvDiscountedPrice.text = getString(R.string.tv_discounted_price, skuDetails.currency, discountedPrice)
            tvPrice.text = getString(R.string.tv_discounted_price, skuDetails.currency, actualPrice)

        } else {
            tvPrice.text = getString(R.string.blank_line)
            Toast.makeText(requireContext(), getString(R.string.err_internet_connection_for_price), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getActualPrice(discountedPrice: Double) = ((discountedPrice / 3) * 4)


    private fun initView(view: View) {
        tvDiscountedPrice = view.findViewById(R.id.tvDiscountedPrice)
        tvPrice = view.findViewById(R.id.tvPrice)
        tvPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

    }


    private fun initActions(view: View) {
        view.findViewById<Button>(R.id.btnLater).setOnClickListener { btnLater ->
            onClickListener?.onClick(btnLater)
            dismiss()
        }

        view.findViewById<Button>(R.id.btnUpgrade).setOnClickListener { btnUpgrade ->
            onClickListener?.onClick(btnUpgrade)
            dismiss()
        }
    }

    fun setOnClickListener(onClickListener: View.OnClickListener) {
        this.onClickListener = onClickListener
    }

}