package com.android.buddapalace

import android.app.Application
import com.android.core.KoinModule
import net.danlew.android.joda.JodaTimeAndroid
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.util.*

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
            modules(koinModules)
        }
    }
}