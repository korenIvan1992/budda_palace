package com.android.buddhapalace.quotes.ui.settings

import androidx.fragment.app.Fragment


sealed class SettingsState {
    object Suspense : SettingsState()
    object Loading : SettingsState()
    data class OpenFragment(val fr: Fragment) : SettingsState()
}