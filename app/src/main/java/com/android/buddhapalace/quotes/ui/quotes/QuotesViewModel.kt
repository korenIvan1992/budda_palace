package com.android.buddhapalace.quotes.ui.quotes

import androidx.lifecycle.viewModelScope
import com.android.buddhapalace.quotes.ui.allglobal.BaseViewModel
import com.android.core.extensions.set
import com.android.data.database.entity.quotes.Quote
import com.android.data.repository.quotes.QuotesRepositories
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import java.util.*

class QuotesViewModel(
    val quotesRepositories: QuotesRepositories
) : BaseViewModel<QuotesState>(QuotesState.Suspense) {

    fun setQuotes() {
        state.set(QuotesState.Loading)
        viewModelScope.launch {
            quotesRepositories.getQuotes().catch {
                it.localizedMessage?.let { error ->
                    state.set(QuotesState.Error(error))
                }
            }.collect {
                state.set(QuotesState.Success(LinkedList(it)))
            }
        }
    }

    fun likeQuotes(state: Quote) {
        quotesRepositories.updateLike(state)
    }
}