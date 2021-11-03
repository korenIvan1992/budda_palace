package com.android.data.datasource.local

import android.content.Context
import com.android.data.database.dao.quotes.QuotesDao
import com.android.data.database.entity.quotes.Quote

class QuotesLocalDataSource(private val context: Context,private val quotesDao: QuotesDao) {

    suspend fun getQuotes(): List<Quote> {
        return quotesDao.allQuotes()
    }

    suspend fun setQuote(list: List<Quote>) {
        quotesDao.insertList(list)
    }
}