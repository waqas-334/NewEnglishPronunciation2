package com.androidbull.mypronounce.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.text.TextUtils
import com.androidbull.mypronounce.ui.helper.PronunciationAccuracyChecker
import java.util.*


class GeneralUtils {

    companion object {

        @JvmStatic
        fun getWrongWords(actualString: String, speechResult: String): List<String> {

            val actualStringWordList = actualString.toLowerCase(Locale.ROOT).split("\\s".toRegex()).toList()
            val speechResultWordList = speechResult.toLowerCase(Locale.ROOT).split("\\s".toRegex()).toList()
            val wrongWordsList = mutableListOf<String>()

            if (!TextUtils.isEmpty(speechResult)) {
                if (actualStringWordList.size == speechResultWordList.size) {
                    for ((index, word) in actualStringWordList.withIndex()) {
                        val pronunciationAccuracy = PronunciationAccuracyChecker.checkAccuracy(actualStringWordList[index], speechResultWordList[index])
                        if (!PronunciationAccuracyChecker.isAccuratePronunciation(pronunciationAccuracy)) {
                            wrongWordsList.add(word)
                        }
                    }
                    return wrongWordsList
                }
            }

            wrongWordsList.addAll(actualStringWordList.toList()) //Default behaviour
            return wrongWordsList
        }

        @JvmStatic
        fun isOnline(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val n = cm.activeNetwork
                if (n != null) {
                    val nc = cm.getNetworkCapabilities(n)
                    return nc!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                }
                return false
            } else {
                val netInfo = cm.activeNetworkInfo
                return netInfo != null && netInfo.isConnectedOrConnecting
            }
        }
    }

}