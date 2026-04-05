package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.data.db.DatabaseConstants

@Entity(
    tableName =DatabaseConstants.TABLE_CATEGORIES,
    indices = [Index(value = [DatabaseConstants.COLUMN_CODE], unique = true)]
)
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val categoryId: Long = 0,
    val code: String,
    val name: String,
    val description: String? = null
)
