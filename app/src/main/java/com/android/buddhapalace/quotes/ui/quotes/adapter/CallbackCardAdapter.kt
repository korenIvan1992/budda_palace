package com.android.buddhapalace.quotes.ui.quotes.adapter

import com.android.data.database.entity.quotes.Quote

interface CallbackCardAdapter {
    fun back()
    fun early()
    fun like(quote:Quote)
}