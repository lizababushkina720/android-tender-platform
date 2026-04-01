package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(
    tableName = "lots",
    foreignKeys = [
        ForeignKey(
            entity = TenderEntity::class,
            parentColumns = ["tenderId"],
            childColumns = ["tenderId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("tenderId")]
)
data class LotEntity(
    @PrimaryKey(autoGenerate = true)
    val lotId: Long = 0,
    val lotNumber: Int? = null,
    val name: String,
    val description: String? = null,
    val quantity: BigDecimal? = null,
    val unit: String? = null,
    val initialPrice: BigDecimal? = null,
    val deliveryDeadline: Long? = null,
    val tenderId: Long
)
