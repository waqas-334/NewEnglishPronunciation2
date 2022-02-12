package com.androidbull.mypronounce.data.model

class TranslationSupportedLanguage(val code: String, val languageName: String, val nativeLanguageName: String) {

    //to display object as a string in spinner
    override fun toString(): String {
        return nativeLanguageName
    }


}