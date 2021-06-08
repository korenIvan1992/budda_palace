package com.android.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences


@SuppressLint("CommitPrefEdits")
class PreferenceManager
internal constructor(context: Context) {


    private val pref: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        pref = context.getSharedPreferences(PREF_NAME, 0)
        editor = pref.edit()
    }

    companion object {
        private const val PREF_NAME = "PreferenceManager.QUOTES_BP"
        private const val TEST = "PreferenceManager.QUOTES_BP.TEST"

    }

    fun setTestPref(isUserLogin: String) {
        editor.putString(TEST, isUserLogin)
        editor.commit()
    }

    fun getTestPref(): String {
        return pref.getString(TEST, "").toString()
    }



}
