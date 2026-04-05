package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.data.db.DatabaseConstants
import com.example.data.db.enums.TenderStatus
import java.math.BigDecimal

@Entity(
    tableName = DatabaseConstants.TABLE_TENDERS,
    foreignKeys = [
        ForeignKey(
            entity = OrganizationEntity::class,
            parentColumns = [DatabaseConstants.COLUMN_ORGANIZATION_ID],
            childColumns = [DatabaseConstants.COLUMN_CUSTOMER_ID],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(DatabaseConstants.COLUMN_CUSTOMER_ID)]
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
    val status: TenderStatus = TenderStatus.OPEN,
    val customerId: Long,
    val categoryId: Long? = null,
    val region: String? = null,
)