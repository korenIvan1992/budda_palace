package com.android.buddhapalace.quotes.ui.quotes

import com.android.data.database.entity.quotes.Quote


sealed class QuotesState {
    object Suspense : QuotesState()
    object Loading : QuotesState()
    data class Error(val message : String) : QuotesState()
    data class Success(val list : List<Quote>) : QuotesState()
}