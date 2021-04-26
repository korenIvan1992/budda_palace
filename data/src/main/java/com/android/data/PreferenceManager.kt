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
        private const val PREF_NAME = "PreferenceManager.GROWMEUP"
        private const val CHECK_SIGN_APP = "PreferenceManager.GROWMEUP.CHECK_SIGN_APP"
        private const val CHECK_RATE = "PreferenceManager.GROWMEUP.CHECK_RATE"
        private const val ATTEMPT_POPUP = "PreferenceManager.GROWMEUP.ATTEMPT_POPUP"
        private const val ATTEMPT_FINISH_TASK_CHECKBOX = "PreferenceManager.GROWMEUP.ATTEMPT_FINISH_TASK_CHECKBOX"
        private const val ATTEMPT_FINISH_TIMER = "PreferenceManager.GROWMEUP.ATTEMPT_FINISH_TIMER"
        private const val TOKEN = "PreferenceManager.GROWMEUP.TOKEN"
        private const val FIRST_SIGN_IN = "PreferenceManager.GROWMEUP.FIRST_SIGN_IN"
        private const val REGISTRATION_NAME = "PreferenceManager.GROWMEUP.REGISTRATION_NAME"
        private const val REGISTRATION_PASSWORD = "PreferenceManager.GROWMEUP.REGISTRATION_PASSWORD"
        private const val REGISTRATION_PASSWORD_REPEAT = "PreferenceManager.GROWMEUP.REGISTRATION_PASSWORD_REPEAT"
        private const val LOGIN_NAME = "PreferenceManager.GROWMEUP.LOGIN_NAME"
        private const val LOGIN_PASSWORD = "PreferenceManager.GROWMEUP.LOGIN_PASSWORD"
        private const val EMAIL = "PreferenceManager.GROWMEUP.EMAIL"
        private const val DATE_REGISTRATION = "PreferenceManager.GROWMEUP.DATE_REGISTRATION"
        private const val STATE_SIGN_IN = "PreferenceManager.GROWMEUP.STATE_SIGN_IN"
        private const val CURRENT_DAY_DEMO = "PreferenceManager.GROWMEUP.CURRENT_DAY_DEMO"
        private const val STATE_EXIT_BUTTON = "PreferenceManager.GROWMEUP.STATE_EXIT_BUTTON"
    }

    fun setUserLogin(isUserLogin: Boolean) {
        editor.putBoolean(CHECK_SIGN_APP, isUserLogin)
        editor.commit()
    }

    fun isUserLogin(): Boolean {
        return pref.getBoolean(CHECK_SIGN_APP, false)
    }

    fun setStatePopupForExitButton(isUserLogin: Boolean) {
        editor.putBoolean(STATE_EXIT_BUTTON, isUserLogin)
        editor.commit()
    }

    fun isStatePopupForExitButton(): Boolean {
        return pref.getBoolean(STATE_EXIT_BUTTON, false)
    }


    fun setToken(token: String) {
        editor.putString(TOKEN, token)
        editor.commit()
    }

    fun getToken(): String? {
        return pref.getString(TOKEN, "")
    }

    fun setDateRegistration(date: Long) {
        editor.putLong(DATE_REGISTRATION, date)
        editor.commit()
    }

    fun getDateRegistration(): Long {
        return pref.getLong(DATE_REGISTRATION, dateDeufalt)
    }

    fun setDayCurrentDemoState(day: Int) {
        editor.putInt(CURRENT_DAY_DEMO, day)
        editor.commit()
    }

    fun getDayCurrentDemoState(): Int {
        return pref.getInt(CURRENT_DAY_DEMO, 10000)
    }


    fun setStateSignIn(state: Boolean) {
        editor.putBoolean(STATE_SIGN_IN, state)
        editor.commit()
    }

    fun isStateSignIn(): Boolean {
        return pref.getBoolean(STATE_SIGN_IN, false)
    }


    fun saveEmail(email: String) {
        editor.putString(EMAIL, email)
        editor.commit()
    }

    fun getEmail(): String {
        return pref.getString(EMAIL, "").toString()
    }

    fun setFirstSignIn(isFirstSignIn: Boolean) {
        editor.putBoolean(FIRST_SIGN_IN, isFirstSignIn)
        editor.commit()
    }

    fun isFirstSignIn(): Boolean {
        return pref.getBoolean(FIRST_SIGN_IN, false)
    }


    fun setRegistrationName(token: String) {
        editor.putString(REGISTRATION_NAME, token)
        editor.commit()
    }

    fun getRegistrationName(): String? {
        return pref.getString(REGISTRATION_NAME, "")
    }

    fun setPasswordRegistration(token: String) {
        editor.putString(REGISTRATION_PASSWORD, token)
        editor.commit()
    }

    fun getPasswordRegistration(): String? {
        return pref.getString(REGISTRATION_PASSWORD, "")
    }

    fun setPasswordRepeatRegistration(token: String) {
        editor.putString(REGISTRATION_PASSWORD_REPEAT, token)
        editor.commit()
    }

    fun getPasswordRepeatRegistration(): String? {
        return pref.getString(REGISTRATION_PASSWORD_REPEAT, "")
    }

    fun setLoginName(token: String) {
        editor.putString(LOGIN_NAME, token)
        editor.commit()
    }

    fun getLoginName(): String? {
        return pref.getString(LOGIN_NAME, "")
    }

    fun setLoginPassword(token: String) {
        editor.putString(LOGIN_PASSWORD, token)
        editor.commit()
    }

    fun getLoginPassword(): String? {
        return pref.getString(LOGIN_PASSWORD, "")
    }

    fun setStatusRateApp(state: Boolean) {
        editor.putBoolean(CHECK_RATE, state)
        editor.commit()
    }

    fun isStateRateApp(): Boolean {
        return pref.getBoolean(CHECK_RATE, false)
    }

    fun addAttemptCallPopup() {
        editor.putInt(ATTEMPT_POPUP, getAttemptCallPopup() + 1)
        editor.commit()
    }

    fun getAttemptCallPopup(): Int {
        return pref.getInt(ATTEMPT_POPUP, 0)
    }

    fun addAttemptFinishTaskCheckBox() {
        editor.putInt(ATTEMPT_FINISH_TASK_CHECKBOX, getAttemptFinishTaskCheckBox() + 1)
        editor.commit()
    }

    fun getAttemptFinishTaskCheckBox(): Int {
        return pref.getInt(ATTEMPT_FINISH_TASK_CHECKBOX, 0)
    }

    fun addAttemptFinishTimer() {
        editor.putInt(ATTEMPT_FINISH_TIMER, getAttemptFinishTimer() + 1)
        editor.commit()
    }

    fun getAttemptFinishTimer(): Int {
        return pref.getInt(ATTEMPT_FINISH_TIMER, 0)
    }


}
