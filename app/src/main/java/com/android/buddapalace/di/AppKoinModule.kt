package com.android.buddapalace.di


import com.android.buddapalace.ui.quotes.QuotesViewModel
import com.android.buddapalace.ui.settings.SettingsViewModel
import com.android.buddapalace.ui.settings.quotesreminders.QuotesRemindersViewModel
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