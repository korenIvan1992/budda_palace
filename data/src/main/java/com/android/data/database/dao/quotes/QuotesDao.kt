package com.android.data.database.dao.quotes

import androidx.room.*
import com.android.data.database.entity.quotes.Quote

@Dao
interface QuotesDao {
    @Query("SELECT * FROM quote")
    suspend fun allQuotes(): List<Quote>

    @Insert
    suspend fun insert(catalog: Quote)

    @Insert
    fun insertList(list: List<Quote>)

    @Update
    suspend fun update(catalog: Quote)

    @Update
    suspend fun updateList(listCatalog: List<Quote>)

    @Delete
    suspend fun delete(catalog: Quote)

    @Query("DELETE FROM Quote")
    suspend fun deleteAll()
}