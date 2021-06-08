package com.android.buddapalace.ui.quotes


sealed class QuotesState {
    object Suspense : QuotesState()
    object Loading : QuotesState()
}