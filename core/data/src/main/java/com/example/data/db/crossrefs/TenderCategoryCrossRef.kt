package com.example.data.db.crossrefs

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.data.db.entity.CategoryEntity
import com.example.data.db.entity.TenderEntity

@Entity(
    tableName = "tender_categories",
    primaryKeys = ["tenderId", "categoryId"],
    foreignKeys = [
        ForeignKey(
            entity = TenderEntity::class,
            parentColumns = ["tenderId"],
            childColumns = ["tenderId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["categoryId"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("tenderId"), Index("categoryId")]
)
data class TenderCategoryCrossRef(
    val tenderId: Long,
    val categoryId: Long
)