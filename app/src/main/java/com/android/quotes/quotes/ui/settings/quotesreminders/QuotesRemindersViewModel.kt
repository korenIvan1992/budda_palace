package com.android.buddapalace.ui.settings.quotesreminders

import com.android.buddapalace.ui.allglobal.BaseViewModel
import com.android.core.extensions.set

class QuotesRemindersViewModel(
) : BaseViewModel<QuotesRemindersState>(QuotesRemindersState.Suspense) {

    fun back() {
        state.set(QuotesRemindersState.Back)
    }

    fun onCheckedChanged(checked: Boolean) {
        state.set(QuotesRemindersState.VisibleDescription(checked))
    }
}

