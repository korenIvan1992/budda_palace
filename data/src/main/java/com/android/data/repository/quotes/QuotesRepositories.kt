package com.android.data.repository.quotes

import com.android.data.database.entity.quotes.Quote
import com.android.data.datasource.local.QuotesLocalDataSource
import com.android.data.datasource.remoute.QuotesRemoteDataSource
import com.android.data.network.model.Result
import com.android.data.utils.converter.ConverterQuotes.convertQuotes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class QuotesRepositories(
    val quotesLocalDataSource: QuotesLocalDataSource,
    val quotesRemoteDataSource: QuotesRemoteDataSource
) {

    fun getQuotes(): Flow<List<Quote>> = flow {

        quotesLocalDataSource.getQuotes().let {

            if (it.isEmpty()) {
                val result = quotesRemoteDataSource.getQuotes()

                // Return exception
                if (result is Result.Error) {
                    error(result.exception)
                }

                if (result is Result.Success) {
                    val listQuote = convertQuotes(result.data)
                    //add local base
                    CoroutineScope(Dispatchers.IO).launch {
                        quotesLocalDataSource.setQuote(listQuote)
                    }

                    // Emit the Quote
                    emit(listQuote)
                }
            } else emit(it)

        }
    }

    fun getFavoriteQuotes(): Flow<List<Quote>> = flow {

        quotesLocalDataSource.getQuotes().let {

            if (it.isEmpty()) {
                emit(mutableListOf())
            } else {
                val list = it.filter { quote -> quote.like }
                emit(list)
            }
        }
    }


    fun updateLike(quote: Quote) {
        CoroutineScope(Dispatchers.IO).launch {
            quotesLocalDataSource.update(quote)
        }
    }
}