package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.data.db.DatabaseConstants
import com.example.data.db.enums.ContractStatus
import java.math.BigDecimal

@Entity(
    tableName = DatabaseConstants.TABLE_CONTRACTS,
    foreignKeys = [
        ForeignKey(
            entity = TenderEntity::class,
            parentColumns = [DatabaseConstants.COLUMN_TENDER_ID],
            childColumns = [DatabaseConstants.COLUMN_TENDER_ID],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = BidEntity::class,
            parentColumns = [DatabaseConstants.COLUMN_BID_ID],
            childColumns = [DatabaseConstants.COLUMN_WINNING_BID_ID],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = OrganizationEntity::class,
            parentColumns = [DatabaseConstants.COLUMN_ORGANIZATION_ID],
            childColumns = [DatabaseConstants.COLUMN_SUPPLIER_ID],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index(DatabaseConstants.COLUMN_TENDER_ID),
        Index(value = [DatabaseConstants.COLUMN_WINNING_BID_ID], unique = true),
        Index(DatabaseConstants.COLUMN_SUPPLIER_ID)
    ]
)
data class ContractEntity(
    @PrimaryKey(autoGenerate = true)
    val contractId: Long = 0,
    val contractNumber: String? = null,
    val signDate: Long? = null,
    val totalAmount: BigDecimal? = null,
    val status: ContractStatus = ContractStatus.DRAFT,
    val endDate: Long? = null,
    val tenderId: Long? = null,
    val winningBidId: Long? = null,
    val supplierId: Long? = null
)
