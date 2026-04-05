package com.example.data.db.crossrefs

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.data.db.DatabaseConstants
import com.example.data.db.entity.CategoryEntity
import com.example.data.db.entity.OrganizationEntity

@Entity(
    tableName = DatabaseConstants.TABLE_ORGANIZATION_CATEGORIES,
    primaryKeys = [DatabaseConstants.COLUMN_ORGANIZATION_ID, DatabaseConstants.COLUMN_CATEGORY_ID],
    foreignKeys = [
        ForeignKey(
            entity = OrganizationEntity::class,
            parentColumns = [DatabaseConstants.COLUMN_ORGANIZATION_ID],
            childColumns = [DatabaseConstants.COLUMN_ORGANIZATION_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = [ DatabaseConstants.COLUMN_CATEGORY_ID],
            childColumns = [ DatabaseConstants.COLUMN_CATEGORY_ID],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(DatabaseConstants.COLUMN_ORGANIZATION_ID), Index( DatabaseConstants.COLUMN_CATEGORY_ID)]
)
data class OrganizationCategoryCrossRef(
    val organizationId: Long,
    val categoryId: Long
)