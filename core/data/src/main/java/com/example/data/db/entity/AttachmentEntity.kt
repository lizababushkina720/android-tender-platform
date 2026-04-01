package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.data.db.enums.DocumentType

@Entity(
    tableName = "attachments",
    foreignKeys = [
        ForeignKey(
            entity = TenderEntity::class,
            parentColumns = ["tenderId"],
            childColumns = ["tenderId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = BidEntity::class,
            parentColumns = ["bidId"],
            childColumns = ["bidId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("tenderId"), Index("bidId")]
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
