package com.android.buddhapalace.quotes.ui.settings

import androidx.fragment.app.Fragment


sealed class SettingsState {
    object Suspense : SettingsState()
    object Loading : SettingsState()
    data class OpenFragmentChild(val fr: Fragment) : SettingsState()
    data class OpenFragmentReplace(val fr: Fragment) : SettingsState()
}