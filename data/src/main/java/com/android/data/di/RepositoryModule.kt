package com.android.data.di

import com.android.data.repository.quotes.QuotesRepositories
import org.koin.dsl.module

val repositoryModule = module {
    single {
        QuotesRepositories(
            quotesLocalDataSource = get(),
            quotesRemoteDataSource = get()
        )
    }
}
