package com.android.buddapalace.ui.settings.quotesreminders

import com.android.buddapalace.ui.allglobal.BaseViewModel
import com.android.core.extensions.set
import timber.log.Timber

class QuotesRemindersViewModel(
) : BaseViewModel<QuotesReminersState>(QuotesReminersState.Suspense) {

    fun back() {
        state.set(QuotesReminersState.Back)
    }

    fun onCheckedChanged(checked: Boolean) {
        Timber.d("")
    }
}

