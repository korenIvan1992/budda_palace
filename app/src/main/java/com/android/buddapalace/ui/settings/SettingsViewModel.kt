package com.android.buddapalace.ui.settings

import android.content.Intent
import android.net.Uri
import android.view.View
import com.android.buddapalace.MainActivity
import com.android.buddapalace.R
import com.android.buddapalace.ui.allglobal.BaseViewModel

class SettingsViewModel(
) : BaseViewModel<SettingsState>(SettingsState.Suspense) {


    fun clickRate(view: View) {
        view.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.growmeup.android")))
    }
    fun clickDailyReminder(view: View) {
        (view.context as MainActivity).navController.navigate(R.id.quotes_reminder)
    }
}