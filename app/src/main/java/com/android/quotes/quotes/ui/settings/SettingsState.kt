package com.android.buddapalace.ui.settings


sealed class SettingsState {
    object Suspense : SettingsState()
    object Loading : SettingsState()
}