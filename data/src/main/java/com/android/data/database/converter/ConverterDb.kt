package com.android.data.database.converter

import android.provider.SyncStateContract
import androidx.room.TypeConverter
import com.android.data.database.entity.quotes.Languages
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.joda.time.DateTime
import java.math.BigDecimal
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime.ofInstant
import java.util.*

class ConverterDb {

    @TypeConverter
    fun fromBigDecimal(value: BigDecimal?): String? {
        return value.toString()
    }

    @TypeConverter
    fun toBigDecimal(value: String?): BigDecimal? {
        return if (value == "null") null
        else
            value?.toBigDecimal()
    }

    @TypeConverter
    fun fromSettingsNotification(data: MutableMap<String, Boolean>): String {
        return ObjectMapper().writeValueAsString(data)
    }

    @TypeConverter
    fun toSettingsNotification(data: String): MutableMap<String, Boolean> {
        val typeRef: TypeReference<MutableMap<String, Boolean>> = object : TypeReference<MutableMap<String,Boolean>>() {}
        return ObjectMapper().readValue(data, typeRef)
    }

    @TypeConverter
    fun fromLanguages(data: Languages): String {
        return ObjectMapper().writeValueAsString(data)
    }

    @TypeConverter
    fun toLanguages(data: String): Languages {
        val typeRef: TypeReference<Languages> = object : TypeReference<Languages>() {}
        return ObjectMapper().readValue(data, typeRef)
    }




    @TypeConverter
    fun fromTimestamp(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date): Long {
        return date.time
    }
}

