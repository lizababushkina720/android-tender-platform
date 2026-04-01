package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.data.db.enums.TenderStatus

@Entity(
    tableName = "tender_status_histories",
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
data class TenderStatusHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val tenderStatusHistoryId: Long = 0,
    val status: TenderStatus? = null,
    val changedAt: Long? = null,
    val changedBy: String? = null,
    val comment: String? = null,
    val tenderId: Long
)
