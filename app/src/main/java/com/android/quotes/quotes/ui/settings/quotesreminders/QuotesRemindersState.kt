package com.android.buddapalace.ui.settings.quotesreminders


sealed class QuotesRemindersState {
    object Suspense : QuotesRemindersState()
    object Loading : QuotesRemindersState()
    object Back : QuotesRemindersState()
    data class VisibleDescription(val state: Boolean) : QuotesRemindersState()

}