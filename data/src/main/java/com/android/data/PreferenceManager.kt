package com.android.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


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
        private const val STATE_ACTIVE_SETTINGS_DAY = "PreferenceManager.QUOTES_BP.STATE_ACTIVE_SETTINGS_DAY"
        private const val LIST_DAY_INT = "PreferenceManager.QUOTES_BP.LIST_DAY_INT"
        private const val DAY_INT = "PreferenceManager.QUOTES_BP.DAY_INT"

    }

    fun setTestPref(isUserLogin: String) {
        editor.putString(TEST, isUserLogin)
        editor.commit()
    }

    fun getTestPref(): String {
        return pref.getString(TEST, "").toString()
    }

    fun setActiveDescNotificationDay(state: Boolean) {
        editor.putBoolean(STATE_ACTIVE_SETTINGS_DAY, state)
        editor.commit()
    }

    fun getActiveDescNotificationDay(): Boolean {
        return pref.getBoolean(STATE_ACTIVE_SETTINGS_DAY, false)
    }

    fun setListDay(list: List<Int>) {
        val gson = Gson()
        val json = gson.toJson(list)
        setDay(json)
    }

    fun getListDay(): List<Int> {
        val gson = Gson()
        var listDay: List<Int>?
        val string = pref.getString(LIST_DAY_INT ,null)
        val type = object : TypeToken<List<Int>?>() {}.type
        listDay = gson.fromJson(string, type)
        if (listDay == null) listDay = ArrayList()
        return listDay
    }


    fun setDay(value: String) {
        editor.putString(DAY_INT, value)
        editor.commit()
    }

}
