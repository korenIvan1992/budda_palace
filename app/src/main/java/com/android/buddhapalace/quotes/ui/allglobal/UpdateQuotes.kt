package com.android.buddhapalace.quotes.ui.allglobal

import com.android.data.database.entity.quotes.Quote

interface UpdateQuotes {
    fun update(quote: Quote)
}