package com.android.buddhapalace.quotes.ui.quotes

import com.android.data.database.entity.quotes.Quote
import java.util.*


sealed class QuotesState {
    object Suspense : QuotesState()
    object Loading : QuotesState()
    data class Error(val message : String) : QuotesState()
    data class Success(val list : LinkedList<Quote>) : QuotesState()
}