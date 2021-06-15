package com.android.data.repository.settings

import com.android.data.datasource.local.QuotesLocalDataSource
import com.android.data.datasource.local.SettingsLocalDataSource
import com.android.data.datasource.remoute.QuotesRemoteDataSource

class SettingsRepositories(
    val settingsLocalDataSource: SettingsLocalDataSource) {

    fun getDataLocalSettings() : SettingsLocalDataSource{
        return settingsLocalDataSource
    }
}