package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.data.db.DatabaseConstants
import com.example.data.db.enums.BidStatus
import java.math.BigDecimal

@Entity(
    tableName = DatabaseConstants.TABLE_BIDS,
    foreignKeys = [
        ForeignKey(
            entity = TenderEntity::class,
            parentColumns = [DatabaseConstants.COLUMN_TENDER_ID],
            childColumns = [DatabaseConstants.COLUMN_TENDER_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = OrganizationEntity::class,
            parentColumns = [DatabaseConstants.COLUMN_ORGANIZATION_ID],
            childColumns = [DatabaseConstants.COLUMN_EXECUTOR_ID],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(DatabaseConstants.COLUMN_TENDER_ID),
        Index(DatabaseConstants.COLUMN_EXECUTOR_ID)
    ]
)
data class BidEntity(
    @PrimaryKey(autoGenerate = true)
    val bidId: Long = 0,

    val offeredPrice: BigDecimal,
    val deliveryDays: Int? = null,
    val comment: String? = null,
    val status: BidStatus = BidStatus.PENDING,
    val submittedAt: Long? = null,
    val tenderId: Long,
    val executorId: Long,                   // id организации исполнителя
)