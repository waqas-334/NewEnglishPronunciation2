package com.androidbull.mypronounce.ui.dialogs

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.fragment.app.DialogFragment
import com.androidbull.mypronounce.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ConsentDialog : DialogFragment(), View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private lateinit var mBtnLetsGo: Button
    private lateinit var mBtnRemoveAds: Button
    private lateinit var mCbAds: CheckBox
    private var onClickListener: View.OnClickListener? = null

    companion object {
        @JvmStatic
        fun newInstance() = ConsentDialog()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_consnet, null)
        onViewCreated(dialogView, savedInstanceState)
        return MaterialAlertDialogBuilder(requireContext())
                .setView(dialogView)
                .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
        initActions()
    }


    private fun initView(view: View) {
        mBtnLetsGo = view.findViewById(R.id.letsGoButton)
        mBtnRemoveAds = view.findViewById(R.id.removeAds)
        mCbAds = view.findViewById(R.id.adCheckBox)
        isCancelable = false
    }


    private fun initActions() {
        mBtnRemoveAds.setOnClickListener(this)
        mBtnLetsGo.setOnClickListener(this)
        mCbAds.setOnCheckedChangeListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.letsGoButton -> dismiss()
            R.id.removeAds -> {
                onClickListener?.onClick(view)
                dismiss()
            }
        }
    }

    fun setListener(onClickListener: View.OnClickListener){
        this.onClickListener = onClickListener
    }

    override fun onCheckedChanged(p0: CompoundButton?, isChecked: Boolean) {
        mBtnLetsGo.isEnabled = isChecked
    }
}