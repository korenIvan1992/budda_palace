package com.android.data.database.entity.quotes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(
        @PrimaryKey
        val id: Long,
        val languages: Languages,
        val date: String,
        var like : Boolean = false
)
