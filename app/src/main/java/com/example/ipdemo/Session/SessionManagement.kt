package com.example.ipdemo.Session

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.ipdemo.Utils.Constants
import kotlinx.coroutines.flow.StateFlow


class SessionManagement(context: Context) {

    private var SHARED_PREF_NAME = "IP"
    private var SESSION_LANGUAGE = "IP_LANGUAGE"
    private var SESSION_NOTIFICATION = "IP_NOTIFICATION"
    private var SESSION_VERSION = "IP_VERSION"

    var sharedPreferences: SharedPreferences? =
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
    var editor: SharedPreferences.Editor? = sharedPreferences!!.edit()

    fun saveLanguage(lang: String?) {
        editor!!.putString(SESSION_LANGUAGE, lang)
        editor!!.commit()
    }

    fun getLanguage(): String? {
        return sharedPreferences!!.getString(SESSION_LANGUAGE, Constants.DEFAULT_LANG)
    }

    fun saveNotificationState(state: Boolean) {
        editor!!.putBoolean(SESSION_NOTIFICATION, state)
        editor!!.commit()
    }

    fun getNotificationState(): Boolean {
        return sharedPreferences!!.getBoolean(SESSION_NOTIFICATION, false)
    }

    fun saveVersion(text: String?) {
        editor!!.putString(SESSION_VERSION, text)
        editor!!.commit()
    }

    fun getVersion(): String? {
        return sharedPreferences!!.getString(SESSION_VERSION, "")
    }



}