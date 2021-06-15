package com.android.data.di

import com.android.data.PreferenceManager
import com.android.data.database.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { AppDatabase.getInstance(get()) }
    single { PreferenceManager(get()) }
    single { get<AppDatabase>().quotesDao }
    single { get<AppDatabase>().settingsNotificationDao }
}