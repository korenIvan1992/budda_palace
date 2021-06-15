package com.android.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.data.database.converter.ConverterDb
import com.android.data.database.dao.quotes.QuotesDao
import com.android.data.database.dao.quotes.SettingsNotificationDao
import com.android.data.database.entity.quotes.Quotes
import com.android.data.database.entity.settings.SettingsNotification

@Database(
    entities = [Quotes::class, SettingsNotification::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(ConverterDb::class)
abstract class AppDatabase : RoomDatabase() {

    abstract val quotesDao: QuotesDao
    abstract val settingsNotificationDao: SettingsNotificationDao

    companion object {

        private var instance: AppDatabase? = null
        private const val DATABASE_NAME = "QUOTES_BP_DB"

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room
                .databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
