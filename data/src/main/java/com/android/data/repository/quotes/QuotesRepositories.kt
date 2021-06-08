package com.android.data.repository.quotes

import com.android.data.datasource.local.QuotesLocalDataSource
import com.android.data.datasource.remoute.QuotesRemoteDataSource

class QuotesRepositories(
    val quotesLocalDataSource: QuotesLocalDataSource,
    val quotesRemoteDataSource: QuotesRemoteDataSource
) {
}