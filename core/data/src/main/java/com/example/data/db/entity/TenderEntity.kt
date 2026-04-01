package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.data.db.enums.TenderStatus
import java.math.BigDecimal

@Entity(
    tableName = "tenders",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["userId"],
            childColumns = ["customerId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("customerId")]
)
data class TenderEntity(
    @PrimaryKey(autoGenerate = true)
    val tenderId: Long = 0,
    val title: String,
    val description: String? = null,
    val startPrice: BigDecimal? = null,
    val currency: String = "RUB",
    val publicationDate: Long? = null,
    val endDate: Long? = null,
    val status: TenderStatus = TenderStatus.DRAFT,
    val customerId: Long
)
