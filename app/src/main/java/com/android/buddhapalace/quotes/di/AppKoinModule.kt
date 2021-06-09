package com.android.buddhapalace.quotes.di


import com.android.buddhapalace.quotes.ui.quotes.QuotesViewModel
import com.android.buddhapalace.quotes.ui.settings.SettingsViewModel
import com.android.buddhapalace.quotes.ui.settings.quotesreminders.QuotesRemindersViewModel
import com.android.core.KoinModule
import com.google.auto.service.AutoService
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { QuotesViewModel( quotesRepositories = get()) }
    viewModel { SettingsViewModel() }
    viewModel { QuotesRemindersViewModel() }
}

@AutoService(KoinModule::class)
class AppKoinModule : KoinModule {
    override val modulesList = listOf(
        viewModelModule
    )
}