package com.androidbull.mypronounce.ui.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences


class PreferenceManager {

    companion object {
        private val sharePref = PreferenceManager()
        private var mSharedPreferences: SharedPreferences? = null

        fun getInstance(context: Context): PreferenceManager {
            if (mSharedPreferences == null) {
                mSharedPreferences = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
            }
            return sharePref
        }
    }

    fun setString(key: String, value: String) {
        mSharedPreferences?.edit()?.putString(key, value)?.apply()
    }

    fun getString(key: String) = mSharedPreferences!!.getString(key, "")


    fun setInt(key: String, value: Int) {
        mSharedPreferences?.edit()?.putInt(key, value)?.apply()
    }

    fun getInt(key: String) = mSharedPreferences!!.getInt(key, 0)


    fun setLong(key: String, value: Long) {
        mSharedPreferences?.edit()?.putLong(key, value)?.apply()
    }

    fun getLong(key: String) = mSharedPreferences!!.getLong(key, 0)



    fun setBoolean(key: String, value: Boolean) {
        mSharedPreferences?.edit()?.putBoolean(key, value)?.apply()
    }

    fun getBoolean(key: String) = mSharedPreferences!!.getBoolean(key, false)


    fun getBooleanFirstLaunch(key: String) = mSharedPreferences!!.getBoolean(key, true)


    fun clearPreferences() {
        mSharedPreferences?.edit()?.clear()?.apply()
    }
}