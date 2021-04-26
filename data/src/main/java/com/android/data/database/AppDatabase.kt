package com.android.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(
//    entities = [AuthDataEntity::class, UserEntity::class, OrderEntity::class, ProductEntity::class],
//    version = 1,
//    exportSchema = false
//)
//@TypeConverters(OrderConverter::class)
abstract class AppDatabase : RoomDatabase() {

//    abstract val userDao: UserDao


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
