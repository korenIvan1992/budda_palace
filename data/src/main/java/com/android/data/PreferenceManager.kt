package com.android.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences


@SuppressLint("CommitPrefEdits")
class PreferenceManager @Inject
internal constructor(context: Context) {


    private val pref: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        pref = context.getSharedPreferences(PREF_NAME, 0)
        editor = pref.edit()
    }

    companion object {
        private const val PREF_NAME = "PreferenceManager.QUOTES_BP"
        private const val CHECK_SIGN_APP = "PreferenceManager.QUOTES_BP.CHECK_SIGN_APP"

    }
//
//    fun setUserLogin(isUserLogin: Boolean) {
//        editor.putBoolean(CHECK_SIGN_APP, isUserLogin)
//        editor.commit()
//    }
//
//    fun isUserLogin(): Boolean {
//        return pref.getBoolean(CHECK_SIGN_APP, false)
//    }



}
