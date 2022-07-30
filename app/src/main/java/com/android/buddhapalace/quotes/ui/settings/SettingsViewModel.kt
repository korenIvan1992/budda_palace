package com.android.buddhapalace.quotes.ui.settings

import android.content.Intent
import android.net.Uri
import android.view.View
import com.android.buddhapalace.quotes.BuildConfig
import com.android.buddhapalace.quotes.R
import com.android.buddhapalace.quotes.ui.allglobal.BaseViewModel
import com.android.buddhapalace.quotes.ui.settings.quotesreminders.QuotesRemindersFragments
import com.android.core.extensions.set


class SettingsViewModel(
    private val linkAboutBuddhaPalace: String
) : BaseViewModel<SettingsState>(SettingsState.Suspense) {

    fun clickRate(view: View) {
        view.context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("market://details?id=${BuildConfig.APPLICATION_ID}")
            )
        )
    }

    fun clickDailyReminder(view: View) {
        state.set(SettingsState.OpenFragment(QuotesRemindersFragments()))

    }

    fun openWebUrl(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(linkAboutBuddhaPalace))
        view.context.startActivity(browserIntent)
    }

    fun recommendApp(view: View) {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(
            Intent.EXTRA_TEXT,
            "${view.context.getString(R.string.hello_text)}: https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}"
        )
        sendIntent.type = "text/plain"
        view.context.startActivity(sendIntent)
    }
}