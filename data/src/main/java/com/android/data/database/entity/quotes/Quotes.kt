package com.android.data.database.entity.quotes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quotes(
        @PrimaryKey
        val id: Long,
        val name: String,
        val text: String
)
