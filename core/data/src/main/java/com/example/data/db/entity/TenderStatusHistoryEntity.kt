package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.data.db.DatabaseConstants
import com.example.data.db.enums.TenderStatus

@Entity(
    tableName = DatabaseConstants.TABLE_TENDER_STATUS_HISTORIES,
    foreignKeys = [
        ForeignKey(
            entity = TenderEntity::class,
            parentColumns = [DatabaseConstants.COLUMN_TENDER_ID],
            childColumns = [DatabaseConstants.COLUMN_TENDER_ID],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(DatabaseConstants.COLUMN_TENDER_ID)]
)
data class TenderStatusHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val tenderStatusHistoryId: Long = 0,
    val status: TenderStatus? = null,
    val changedAt: Long? = null,
    val changedBy: String? = null,
    val comment: String? = null,
    val tenderId: Long
)
