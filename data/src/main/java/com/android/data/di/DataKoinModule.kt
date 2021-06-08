package com.android.data.di

import com.android.core.KoinModule
import com.google.auto.service.AutoService

@AutoService(KoinModule::class)
class DataKoinModule : KoinModule {
    override val modulesList = listOf(
        networkModule,
        databaseModule,
        repositoryModule,
        dataSourceModule
    )
}