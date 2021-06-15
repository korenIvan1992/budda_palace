package com.android.data.di

import android.media.audiofx.BassBoost
import com.android.data.repository.quotes.QuotesRepositories
import com.android.data.repository.settings.SettingsRepositories
import org.koin.dsl.module

val repositoryModule = module {
    single {
        QuotesRepositories(
            quotesLocalDataSource = get(),
            quotesRemoteDataSource = get()
        )
    }
    single { SettingsRepositories(
            settingsLocalDataSource = get()
        )
    }

}
