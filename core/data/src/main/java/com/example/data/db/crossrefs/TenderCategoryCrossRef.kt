package com.example.data.db.crossrefs

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.data.db.DatabaseConstants
import com.example.data.db.entity.CategoryEntity
import com.example.data.db.entity.TenderEntity

@Entity(
    tableName = DatabaseConstants.TABLE_TENDER_CATEGORIES,
    primaryKeys = [DatabaseConstants.COLUMN_TENDER_ID, DatabaseConstants.COLUMN_CATEGORY_ID],
    foreignKeys = [
        ForeignKey(
            entity = TenderEntity::class,
            parentColumns = [DatabaseConstants.COLUMN_TENDER_ID],
            childColumns = [DatabaseConstants.COLUMN_TENDER_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = [ DatabaseConstants.COLUMN_CATEGORY_ID],
            childColumns = [ DatabaseConstants.COLUMN_CATEGORY_ID],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(DatabaseConstants.COLUMN_TENDER_ID), Index( DatabaseConstants.COLUMN_CATEGORY_ID)]
)
data class TenderCategoryCrossRef(
    val tenderId: Long,
    val categoryId: Long
)