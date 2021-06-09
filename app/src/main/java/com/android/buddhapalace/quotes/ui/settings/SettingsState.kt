package com.android.buddhapalace.quotes.ui.settings


sealed class SettingsState {
    object Suspense : SettingsState()
    object Loading : SettingsState()
}