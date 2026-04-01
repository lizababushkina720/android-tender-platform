package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.data.db.enums.ContractStatus
import java.math.BigDecimal

@Entity(
    tableName = "contracts",
    foreignKeys = [
        ForeignKey(
            entity = TenderEntity::class,
            parentColumns = ["tenderId"],
            childColumns = ["tenderId"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = BidEntity::class,
            parentColumns = ["bidId"],
            childColumns = ["winningBidId"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = OrganizationEntity::class,
            parentColumns = ["organizationId"],
            childColumns = ["supplierId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index("tenderId"),
        Index(value = ["winningBidId"], unique = true),
        Index("supplierId")
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
