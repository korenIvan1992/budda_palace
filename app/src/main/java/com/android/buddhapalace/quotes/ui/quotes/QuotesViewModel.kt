package com.android.buddhapalace.quotes.ui.quotes

import androidx.lifecycle.viewModelScope
import com.android.buddhapalace.quotes.ui.allglobal.BaseViewModel
import com.android.core.extensions.set
import com.android.data.repository.quotes.QuotesRepositories
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class QuotesViewModel(
    val quotesRepositories: QuotesRepositories
) : BaseViewModel<QuotesState>(QuotesState.Suspense) {

    fun setQuotes() {
        state.set(QuotesState.Loading)
        viewModelScope.launch {
            quotesRepositories.getQuotes().catch {
                val ex = it
                state.set(QuotesState.Error(ex.localizedMessage))
            }.collect {
                state.set(QuotesState.Success(it))
            }
        }
    }
}