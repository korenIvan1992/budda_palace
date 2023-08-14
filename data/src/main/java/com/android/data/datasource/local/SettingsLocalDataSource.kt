package com.android.data.datasource.local

import android.content.Context
import com.android.data.database.dao.quotes.SettingsNotificationDao
import com.android.data.database.entity.settings.SettingsNotification
import com.android.data.database.model.settings.DayWeek
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class SettingsLocalDataSource(
    private val context: Context,
    private val settingsNotificationDao: SettingsNotificationDao
) {
    var settingsNotification: SettingsNotification? = null
    
    suspend fun getSetting(): SettingsNotification {
        if (settingsNotification != null) return settingsNotification as SettingsNotification
        else {
            settingsNotificationDao.allNotification().let {
                if (it.isEmpty()) {
                    settingsNotification = SettingsNotification(
                        id = 1,
                        state = false,
                        mapDayWeek = mutableMapOf(
                            DayWeek.MONDAY.name to false,
                            DayWeek.TUESDAY.name to false,
                            DayWeek.WEDNESDAY.name to false,
                            DayWeek.THURSDAY.name to false,
                            DayWeek.FRIDAY.name to false,
                            DayWeek.SATURDAY.name to false,
                            DayWeek.SUNDAY.name to false,
                            DayWeek.ALL_DAY.name to false
                        ),
                        time = Date()
                    )
                    settingsNotificationDao.insert(settingsNotification!!).let {
                        return settingsNotification!!
                    }
                } else {
                    settingsNotification = it[0]
                    return settingsNotification as SettingsNotification
                }
            }
        }
    }

    fun changeSettingDay(dayWeek: DayWeek) {

        var mapDay = settingsNotification!!.mapDayWeek
        CoroutineScope(Dispatchers.IO).launch {
            mapDay[dayWeek.name] = !mapDay[dayWeek.name]!!
            mapDay[DayWeek.ALL_DAY.name] = false
              settingsNotification = SettingsNotification(
                    id = settingsNotification!!.id,
                    state = settingsNotification!!.state,
                    mapDayWeek = mapDay,
                    time = Date()
                )
            settingsNotificationDao.update(settingsNotification!!)
        }
    }

    fun allDay(){
        settingsNotification = SettingsNotification(
            id = settingsNotification!!.id,
            state = settingsNotification!!.state,
            mapDayWeek = mutableMapOf(
                DayWeek.MONDAY.name to false,
                DayWeek.TUESDAY.name to false,
                DayWeek.WEDNESDAY.name to false,
                DayWeek.THURSDAY.name to false,
                DayWeek.FRIDAY.name to false,
                DayWeek.SATURDAY.name to false,
                DayWeek.SUNDAY.name to false,
                DayWeek.ALL_DAY.name to true
            ),
            time = Date()
        )
    }

    fun changeAllowNotification(state: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            settingsNotification!!.state = state
            settingsNotificationDao.update(settingsNotification!!)
        }
    }
}