package com.androidbull.mypronounce.ui.dialogs

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.ui.helper.TranslationSupportedLanguageProvider
import com.androidbull.mypronounce.data.model.TranslationSupportedLanguage
import com.androidbull.mypronounce.util.GeneralUtils.Companion.isOnline
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.*
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URLEncoder.encode
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit


private const val ARG_PARAM_TEXT = "text"

class TextTranslationDialog : DialogFragment() {

    private var paramText: String? = null

    private lateinit var tvTextToTranslate: TextView
    private lateinit var tvTranslatedText: TextView
    private lateinit var btnTranslate: Button
    private lateinit var spnTargetLanguage: Spinner
    private lateinit var pbTranslation: ProgressBar
    private lateinit var supportedLanguageList: List<TranslationSupportedLanguage>
    private var targetLanguageCode = "en" // Default
    private var call: Call? = null

    companion object {
        @JvmStatic
        fun newInstance(text: String) =
                TextTranslationDialog().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM_TEXT, text)
                    }
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramText = it.getString(ARG_PARAM_TEXT)
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_translation, null)
        onViewCreated(dialogView, savedInstanceState)
        return MaterialAlertDialogBuilder(requireContext())
                .setView(dialogView)
                .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
        initActions()
        setLanguagesSpinner()
        if (!TextUtils.isEmpty(paramText))
            tvTextToTranslate.text = paramText
    }

    private fun setLanguagesSpinner() {

        supportedLanguageList = TranslationSupportedLanguageProvider.getSupportedLanguagesList()
        val adapter: ArrayAdapter<TranslationSupportedLanguage> =
                ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, supportedLanguageList)
        spnTargetLanguage.adapter = adapter

        val locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) resources.configuration.locales.get(0) else resources.configuration.locale
        for ((index, languageCode) in supportedLanguageList.withIndex()) {
            if (languageCode.code == locale.language) {
                spnTargetLanguage.setSelection(index)
                break
            }
        }

        spnTargetLanguage.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val targetLanguage = parent.selectedItem as TranslationSupportedLanguage
                targetLanguageCode = targetLanguage.code
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

    }


    private fun initView(view: View) {
        tvTextToTranslate = view.findViewById(R.id.tvTextToTranslate)
        tvTranslatedText = view.findViewById(R.id.tvTranslatedText)
        btnTranslate = view.findViewById(R.id.btnTranslate)
        spnTargetLanguage = view.findViewById(R.id.spnTargetLanguage)
        pbTranslation = view.findViewById(R.id.pbTranslation)
    }


    private fun initActions() {
        btnTranslate.setOnClickListener {
            tvTranslatedText.text = ""
            if (!TextUtils.isEmpty(paramText) && !TextUtils.isEmpty(targetLanguageCode)) {
                if (isOnline(requireContext().applicationContext)) {
                    lifecycleScope.launch(Dispatchers.IO) {
                        googleTranslate(paramText!!, targetLanguageCode)
                    }
                } else {
                    Toast.makeText(requireContext(), getString(R.string.err_internet_not_available), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private suspend fun googleTranslate(text: String, targetLanguageCode: String) {

        withContext(Dispatchers.Main) {
            btnTranslate.apply {
                isEnabled = false
                setText("")
            }
         pbTranslation.visibility = View.VISIBLE
        }

        var translation = ""
        try {
            val textEncoded: String = encode(text, "utf-8")
            val sourceLanguageCode = "en"
            val translationApiUrlFormatted = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=$sourceLanguageCode&tl=$targetLanguageCode&dt=t&q=$textEncoded"

            val okHttpClient = OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(15, TimeUnit.SECONDS)
                    .build()

            val request = Request.Builder()
                    .url(translationApiUrlFormatted)
                    .build()

            call = okHttpClient.newCall(request)
            val resp = call?.execute()
            resp?.let { response ->
                if (response.isSuccessful) {
                    val `in` = response.body()!!.byteStream()
                    val reader = BufferedReader(InputStreamReader(`in`))
                    var result: String?
                    var line = reader.readLine()
                    result = line
                    while (reader.readLine().also { line = it } != null) {
                        result += line
                    }
                    println(result)
                    response.body()!!.close()

                    var aJsonString: String = result
                    aJsonString = aJsonString.replace("[", "")
                    aJsonString = aJsonString.replace("]", "")
                    aJsonString = aJsonString.substring(1)
                    val plusIndex = aJsonString.indexOf('"')

                    translation = aJsonString.substring(0, plusIndex)
                } else {
                    context?.getString(R.string.err_something_went_wrong)
                }
            }


        } catch (ex: UnknownHostException) {
            context?.getString(R.string.err_internet_required)
        } catch (ex: Exception) {
            ex.printStackTrace()
            context?.getString(R.string.err_something_went_wrong)
        }
        withContext(Dispatchers.Main) {

            btnTranslate.apply {
                isEnabled = true
                setText(R.string.btn_translate)
                pbTranslation.visibility = View.GONE
            }

            if (!TextUtils.isEmpty(translation)) {
                tvTranslatedText.text = translation
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        call?.cancel()
    }
}