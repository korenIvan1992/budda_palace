package com.android.data.database.entity.settings

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.data.database.model.settings.DayWeek
import org.joda.time.DateTime
import java.util.*

@Entity
data class SettingsNotification(
    @PrimaryKey
    val id: Long,
    var state: Boolean = false,
    var mapDayWeek: MutableMap<String, Boolean> =
        mutableMapOf(
            DayWeek.MONDAY.name to false,
            DayWeek.TUESDAY.name to false,
            DayWeek.WEDNESDAY.name to false,
            DayWeek.THURSDAY.name to false,
            DayWeek.FRIDAY.name to false,
            DayWeek.SATURDAY.name to false,
            DayWeek.SUNDAY.name to false,
            DayWeek.ALL_DAY.name to false
        ),
    val time: Date
)
