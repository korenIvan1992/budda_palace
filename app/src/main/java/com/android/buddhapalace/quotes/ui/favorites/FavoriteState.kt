package com.android.buddhapalace.quotes.ui.favorites

import com.android.data.database.entity.quotes.Quote


sealed class FavoriteState {
    object Suspense : FavoriteState()
    object Loading : FavoriteState()
    data class Error(val message : String) : FavoriteState()
    data class Success(val list : List<Quote>) : FavoriteState()
    object EmptyList : FavoriteState()
}