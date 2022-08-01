package com.android.buddhapalace.quotes.ui.favorites

import com.android.buddhapalace.quotes.ui.quotes.QuotesState
import com.android.data.database.entity.quotes.Quote


sealed class FavoritesState {
    object Suspense : FavoritesState()
    object Loading : FavoritesState()
    data class Error(val message : String) : FavoritesState()
    data class Success(val list : List<Quote>) : FavoritesState()
    object EmptyList : FavoritesState()
}