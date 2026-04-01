package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.db.entity.AttachmentEntity

@Dao
interface AttachmentDao {
    @Query("SELECT * FROM attachments WHERE tenderId = :tenderId") suspend fun getByTender(tenderId: Long): List<AttachmentEntity>
    @Query("SELECT * FROM attachments WHERE bidId = :bidId") suspend fun getByBid(bidId: Long): List<AttachmentEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insert(attachment: AttachmentEntity): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertAll(attachments: List<AttachmentEntity>)
    @Delete
    suspend fun delete(attachment: AttachmentEntity)
    @Query("DELETE FROM attachments WHERE tenderId = :tenderId") suspend fun deleteByTender(tenderId: Long)
    @Query("DELETE FROM attachments WHERE bidId = :bidId") suspend fun deleteByBid(bidId: Long)
}