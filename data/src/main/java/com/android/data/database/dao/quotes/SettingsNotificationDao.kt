package com.android.data.database.dao.quotes

import androidx.room.*
import com.android.data.database.entity.settings.SettingsNotification

@Dao
interface SettingsNotificationDao {
    @Query("SELECT * FROM settingsNotification")
    suspend fun allNotification(): List<SettingsNotification>

    @Insert
    suspend fun insert(settingsNotification: SettingsNotification)

    @Insert
    fun insertList(list: List<SettingsNotification>)

    @Update
    suspend fun update(settings: SettingsNotification)

    @Update
    suspend fun updateList(list: List<SettingsNotification>)

    @Delete
    suspend fun delete(catalog: SettingsNotification)

    @Query("DELETE FROM SettingsNotification")
    suspend fun deleteAll()
}