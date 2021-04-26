package com.android.buddapalace.di


import com.android.core.KoinModule
import com.google.auto.service.AutoService
import org.koin.dsl.module

val viewModelModule = module {
//    viewModel { LoginViewModel(get(), get()) }
}

@AutoService(KoinModule::class)
class AppKoinModule : KoinModule {
    override val modulesList = listOf(
        viewModelModule
    )
}