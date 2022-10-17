package com.android.buddhapalace.quotes.ui.favorites

import androidx.lifecycle.viewModelScope
import com.android.buddhapalace.quotes.ui.allglobal.BaseViewModel
import com.android.core.extensions.set
import com.android.data.database.entity.quotes.Quote
import com.android.data.repository.quotes.QuotesRepositories
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val quotesRepositories: QuotesRepositories
) : BaseViewModel<FavoriteState>(FavoriteState.Suspense) {

    fun setQuotes() {
        state.set(FavoriteState.Loading)
        viewModelScope.launch {
            quotesRepositories.getFavoriteQuotes().catch {
                it.localizedMessage?.let { error ->
                    state.set(FavoriteState.Error(error))
                }
            }.collect {
                if (it.isEmpty())
                    state.set(FavoriteState.EmptyList)
                else
                    state.set(FavoriteState.Success(it))
            }
        }
    }

    fun deleteItem(quote: Quote) {
        quote.like = !quote.like
        quotesRepositories.updateLike(quote)
    }
}