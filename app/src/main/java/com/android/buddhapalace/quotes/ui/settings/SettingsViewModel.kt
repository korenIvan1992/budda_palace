package com.android.buddhapalace.quotes.ui.settings

import android.content.Intent
import android.net.Uri
import android.view.View
import com.android.buddhapalace.quotes.MainActivity
import com.android.buddhapalace.quotes.R
import com.android.buddhapalace.quotes.ui.allglobal.BaseViewModel
import com.android.buddhapalace.quotes.ui.settings.SettingsState
import java.math.BigDecimal

class SettingsViewModel(
) : BaseViewModel<SettingsState>(SettingsState.Suspense) {


    fun clickRate(view: View) {
        val f = BigDecimal(".")
//        view.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.growmeup.android")))
    }
    fun clickDailyReminder(view: View) {
        (view.context as MainActivity).navController.navigate(R.id.action_settings_to_quotes_reminder)
    }
}