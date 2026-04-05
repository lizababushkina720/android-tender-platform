package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.db.DatabaseConstants
import com.example.data.db.entity.AttachmentEntity

@Dao
interface AttachmentDao {
    companion object {
        private const val TABLE_ATTACHMENTS = DatabaseConstants.TABLE_ATTACHMENTS
        private const val COLUMN_BID_ID = DatabaseConstants.COLUMN_BID_ID
        private const val COLUMN_TENDER_ID = DatabaseConstants.COLUMN_TENDER_ID
    }

    @Query("SELECT * FROM $TABLE_ATTACHMENTS WHERE $COLUMN_TENDER_ID = :tenderId")
    suspend fun getByTender(tenderId: Long): List<AttachmentEntity>

    @Query("SELECT * FROM $TABLE_ATTACHMENTS WHERE $COLUMN_BID_ID = :bidId")
    suspend fun getByBid(bidId: Long): List<AttachmentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(attachment: AttachmentEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(attachments: List<AttachmentEntity>)

    @Delete
    suspend fun delete(attachment: AttachmentEntity)

    @Query("DELETE FROM $TABLE_ATTACHMENTS WHERE $COLUMN_TENDER_ID = :tenderId")
    suspend fun deleteByTender(tenderId: Long)


    @Query("DELETE FROM attachments WHERE bidId = :bidId")
    suspend fun deleteByBid(bidId: Long)
}