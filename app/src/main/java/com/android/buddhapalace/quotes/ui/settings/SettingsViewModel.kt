package com.android.buddhapalace.quotes.ui.settings

import android.content.Intent
import android.net.Uri
import android.view.View
import com.android.buddhapalace.quotes.BuildConfig
import com.android.buddhapalace.quotes.MainActivity
import com.android.buddhapalace.quotes.R
import com.android.buddhapalace.quotes.ui.allglobal.BaseViewModel
import com.android.core.extensions.toast


class SettingsViewModel(
    val linkAboutBuddhaPalace: String
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
        (view.context as MainActivity).navController.navigate(R.id.action_settings_to_quotes_reminder)
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
            "Hi from Belarus, check out our app: https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}"
        )
        sendIntent.type = "text/plain"
        view.context.startActivity(sendIntent)
    }

    var i = 0
    fun del(view: View) {
        i += 1
        if (i == 10) {
            i = 0
            view.toast("Жыве Беларусь")
        }
    }
}