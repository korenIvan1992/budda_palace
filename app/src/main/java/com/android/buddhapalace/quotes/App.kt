package com.android.buddhapalace.quotes

import android.app.Application
import com.android.core.KoinModule
import net.danlew.android.joda.JodaTimeAndroid
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.androidx.fragment.koin.fragmentFactory
import java.util.*
import org.koin.core.context.startKoin

class App : Application() {

    private val koinModules =
        ServiceLoader
            .load(KoinModule::class.java)
            .flatMap { it.modulesList }

    override fun onCreate() {
        super.onCreate()
        JodaTimeAndroid.init(this);
        startKoin {
            androidContext(this@App)
            androidFileProperties("koin.${BuildConfig.FLAVOR}.properties")
            fragmentFactory()
            modules(koinModules)
        }
    }
}