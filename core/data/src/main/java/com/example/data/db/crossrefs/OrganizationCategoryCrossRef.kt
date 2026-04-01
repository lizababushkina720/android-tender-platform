package com.example.data.db.crossrefs

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.data.db.entity.CategoryEntity
import com.example.data.db.entity.OrganizationEntity

@Entity(
    tableName = "organization_categories",
    primaryKeys = ["organizationId", "categoryId"],
    foreignKeys = [
        ForeignKey(
            entity = OrganizationEntity::class,
            parentColumns = ["organizationId"],
            childColumns = ["organizationId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["categoryId"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("organizationId"), Index("categoryId")]
)
data class OrganizationCategoryCrossRef(
    val organizationId: Long,
    val categoryId: Long
)