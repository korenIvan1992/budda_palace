package com.android.data.di

import com.android.data.datasource.local.QuotesLocalDataSource
import com.android.data.datasource.remoute.QuotesRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { QuotesLocalDataSource(get(), get()) }
    single { QuotesRemoteDataSource(get(), get()) }
}
