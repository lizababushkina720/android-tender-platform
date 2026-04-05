package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.data.db.DatabaseConstants
import com.example.data.db.enums.DocumentType

@Entity(
    tableName = DatabaseConstants.TABLE_ATTACHMENTS,
    foreignKeys = [
        ForeignKey(
            entity = TenderEntity::class,
            parentColumns = [DatabaseConstants.COLUMN_TENDER_ID],
            childColumns = [DatabaseConstants.COLUMN_TENDER_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = BidEntity::class,
            parentColumns = [DatabaseConstants.COLUMN_BID_ID],
            childColumns = [DatabaseConstants.COLUMN_BID_ID],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(DatabaseConstants.COLUMN_TENDER_ID), Index(DatabaseConstants.COLUMN_BID_ID)]
)
data class AttachmentEntity(
    @PrimaryKey(autoGenerate = true)
    val attachmentId: Long = 0,
    val fileName: String,
    val filePath: String,
    val fileSize: Long? = null,
    val contentType: String? = null,
    val documentType: DocumentType? = null,
    val tenderId: Long? = null,
    val bidId: Long? = null
)
