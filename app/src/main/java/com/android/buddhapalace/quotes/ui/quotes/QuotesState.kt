package com.android.buddhapalace.quotes.ui.quotes


sealed class QuotesState {
    object Suspense : QuotesState()
    object Loading : QuotesState()
}