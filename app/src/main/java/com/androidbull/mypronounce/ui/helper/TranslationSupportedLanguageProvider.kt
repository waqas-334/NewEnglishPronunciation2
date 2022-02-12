package com.androidbull.mypronounce.ui.helper

import com.androidbull.mypronounce.data.model.TranslationSupportedLanguage

class TranslationSupportedLanguageProvider {

    companion object {

        private val supportedLanguageList = mutableListOf<TranslationSupportedLanguage>()

        @JvmStatic
        fun getSupportedLanguagesList(): List<TranslationSupportedLanguage> {

            if (supportedLanguageList.isEmpty()) {
                supportedLanguageList.add(TranslationSupportedLanguage(code = "af", languageName = "Afrikaans", nativeLanguageName = "Afrikaans"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "sq", languageName = "Albanian", nativeLanguageName = "Shqip"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "ar", languageName = "Arabic", nativeLanguageName = "عربي"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "hy", languageName = "Armenian", nativeLanguageName = "Հայերէն"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "az", languageName = "Azerbaijani", nativeLanguageName = "آذربایجان دیلی"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "eu", languageName = "Basque", nativeLanguageName = "Euskara"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "be", languageName = "Belarusian", nativeLanguageName = "Беларуская"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "bg", languageName = "Bulgarian", nativeLanguageName = "Български"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "ca", languageName = "Catalan", nativeLanguageName = "Català"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "zh-CN", languageName = "Chinese (Simplified)", nativeLanguageName = "中文简体"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "zh-TW", languageName = "Chinese (Traditional)", nativeLanguageName = "中文繁體"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "hr", languageName = "Croatian", nativeLanguageName = "Hrvatski"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "cs", languageName = "Czech", nativeLanguageName = "Čeština"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "da", languageName = "Danish", nativeLanguageName = "Dansk"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "nl", languageName = "Dutch", nativeLanguageName = "Nederlands"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "en", languageName = "English", nativeLanguageName = "English"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "et", languageName = "Estonian", nativeLanguageName = "Eesti keel"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "tl", languageName = "Filipino", nativeLanguageName = "Filipino"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "fi", languageName = "Finnish", nativeLanguageName = "Suomi"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "fr", languageName = "French", nativeLanguageName = "Français"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "gl", languageName = "Galician", nativeLanguageName = "Galego"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "ka", languageName = "Georgian", nativeLanguageName = "ქართული"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "de", languageName = "German", nativeLanguageName = "Deutsch"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "el", languageName = "Greek", nativeLanguageName = "Ελληνικά"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "ht", languageName = "Haitian Creole", nativeLanguageName = "Kreyòl ayisyen"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "iw", languageName = "Hebrew", nativeLanguageName = "עברית"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "hi", languageName = "Hindi", nativeLanguageName = "हिन्दी"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "hu", languageName = "Hungarian", nativeLanguageName = "Magyar"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "is", languageName = "Icelandic", nativeLanguageName = "Íslenska"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "id", languageName = "Indonesian", nativeLanguageName = "Bahasa Indonesia"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "ga", languageName = "Irish", nativeLanguageName = "Gaeilge"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "it", languageName = "Italian", nativeLanguageName = "Italiano"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "ja", languageName = "Japanese", nativeLanguageName = "日本語"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "ko", languageName = "Korean", nativeLanguageName = "한국어"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "lv", languageName = "Latvian", nativeLanguageName = "Latviešu"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "lt", languageName = "Lithuanian", nativeLanguageName = "Lietuvių kalba"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "mk", languageName = "Macedonian", nativeLanguageName = "Македонски"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "ms", languageName = "Malay", nativeLanguageName = "Malay"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "mt", languageName = "Maltese", nativeLanguageName = "Malti"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "no", languageName = "Norwegian", nativeLanguageName = "Norsk"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "fa", languageName = "Persian", nativeLanguageName = "فارسی"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "pl", languageName = "Polish", nativeLanguageName = "Polski"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "pt", languageName = "Portuguese", nativeLanguageName = "Português"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "ro", languageName = "Romanian", nativeLanguageName = "Română"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "ru", languageName = "Russian", nativeLanguageName = "Русский"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "sr", languageName = "Serbian", nativeLanguageName = "Српски"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "sk", languageName = "Slovak", nativeLanguageName = "Slovenčina"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "sl", languageName = "Slovenian", nativeLanguageName = "Slovensko"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "es", languageName = "Spanish", nativeLanguageName = "Español"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "sw", languageName = "Swahili", nativeLanguageName = "Kiswahili"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "sv", languageName = "Swedish", nativeLanguageName = "Svenska"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "th", languageName = "Thai", nativeLanguageName = "ไทย"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "tr", languageName = "Turkish", nativeLanguageName = "Türkçe"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "uk", languageName = "n", nativeLanguageName = "Українська"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "ur", languageName = "Urdu", nativeLanguageName = "اردو"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "vi", languageName = "Vietnamese", nativeLanguageName = "Tiếng Việt"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "cy", languageName = "Welsh", nativeLanguageName = "Cymraeg"))
                supportedLanguageList.add(TranslationSupportedLanguage(code = "yi", languageName = "Yiddish", nativeLanguageName = "ייִדיש"))
            }

            return supportedLanguageList
        }
    }
}