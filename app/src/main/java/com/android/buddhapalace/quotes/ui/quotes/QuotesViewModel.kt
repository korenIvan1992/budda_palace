package com.android.buddhapalace.quotes.ui.quotes

import com.android.buddhapalace.quotes.ui.allglobal.BaseViewModel
import com.android.buddhapalace.quotes.ui.quotes.QuotesState
import com.android.data.database.entity.quotes.Quote
import com.android.data.repository.quotes.QuotesRepositories

class QuotesViewModel(
    val quotesRepositories: QuotesRepositories
) : BaseViewModel<QuotesState>(QuotesState.Suspense) {

    fun getQuotes() = quotesRepositories.getQuotes()

}