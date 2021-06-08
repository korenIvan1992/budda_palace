package com.android.data.database.converter

import androidx.room.TypeConverter
import java.math.BigDecimal

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
}