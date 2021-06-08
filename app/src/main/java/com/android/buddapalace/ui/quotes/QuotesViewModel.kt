package com.android.buddapalace.ui.quotes

import com.android.buddapalace.ui.allglobal.BaseViewModel
import com.android.data.repository.quotes.QuotesRepositories

class QuotesViewModel(
    val quotesRepositories: QuotesRepositories
) : BaseViewModel<QuotesState>(QuotesState.Suspense) {

}