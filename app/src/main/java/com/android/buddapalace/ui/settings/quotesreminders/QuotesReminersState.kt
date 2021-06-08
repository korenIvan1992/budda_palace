package com.android.buddapalace.ui.settings.quotesreminders


sealed class QuotesReminersState {
    object Suspense : QuotesReminersState()
    object Loading : QuotesReminersState()
    object Back : QuotesReminersState()
}