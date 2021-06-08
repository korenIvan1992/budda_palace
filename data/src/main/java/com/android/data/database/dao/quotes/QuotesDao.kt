package com.android.data.database.dao.quotes

import androidx.room.*
import com.android.data.database.entity.quotes.Quotes

@Dao
interface QuotesDao {
    @Query("SELECT * FROM quotes")
    suspend fun allQuotes(): List<Quotes>

    @Insert
    suspend fun insert(catalog: Quotes)

    @Insert
    fun insertList(list: List<Quotes>)

    @Update
    suspend fun update(catalog: Quotes)

    @Update
    suspend fun updateList(listCatalog: List<Quotes>)

    @Delete
    suspend fun delete(catalog: Quotes)

    @Query("DELETE FROM Quotes")
    suspend fun deleteAll()
}