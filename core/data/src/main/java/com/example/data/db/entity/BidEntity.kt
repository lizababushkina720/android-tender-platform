package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.data.db.enums.BidStatus
import java.math.BigDecimal

@Entity(
    tableName = "bids",
    foreignKeys = [
        ForeignKey(
            entity = LotEntity::class,
            parentColumns = ["lotId"],
            childColumns = ["lotId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = OrganizationEntity::class,
            parentColumns = ["organizationId"],
            childColumns = ["supplierId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["userId"],
            childColumns = ["submittedByUserId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [Index("lotId"), Index("supplierId"), Index("submittedByUserId")]
)
data class BidEntity(
    @PrimaryKey(autoGenerate = true)
    val bidId: Long = 0,
    val offeredPrice: BigDecimal? = null,
    val deliveryDays: Int? = null,
    val comment: String? = null,
    val status: BidStatus = BidStatus.DRAFT,
    val submittedAt: Long? = null,
    val lotId: Long,
    val supplierId: Long,
    val submittedByUserId: Long? = null
)
