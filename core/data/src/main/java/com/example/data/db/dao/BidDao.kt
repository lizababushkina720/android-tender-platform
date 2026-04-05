package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.db.DatabaseConstants
import com.example.data.db.entity.BidEntity
import com.example.data.db.enums.BidStatus

@Dao
interface BidDao {
    companion object {
        private const val TABLE_BIDS = DatabaseConstants.TABLE_BIDS
        private const val COLUMN_BID_ID = DatabaseConstants.COLUMN_BID_ID
        private const val COLUMN_STATUS = DatabaseConstants.COLUMN_STATUS
        private const val COLUMN_TENDER_ID = DatabaseConstants.COLUMN_TENDER_ID
        private const val COLUMN_EXECUTOR_ID = DatabaseConstants.COLUMN_EXECUTOR_ID
    }

    @Query("SELECT * FROM $TABLE_BIDS")
    suspend fun getAll(): List<BidEntity>

    @Query("SELECT * FROM $TABLE_BIDS WHERE $COLUMN_BID_ID = :id")
    suspend fun getById(id: Long): BidEntity?

    @Query("SELECT * FROM $TABLE_BIDS WHERE $COLUMN_STATUS = :status")
    suspend fun getByStatus(status: BidStatus): List<BidEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bid: BidEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(bids: List<BidEntity>)

    @Update
    suspend fun update(bid: BidEntity)

    @Delete
    suspend fun delete(bid: BidEntity)

    @Query("SELECT * FROM $TABLE_BIDS WHERE $COLUMN_TENDER_ID = :tenderId")
    suspend fun getByTender(tenderId: Long): List<BidEntity>

    @Query("SELECT * FROM $TABLE_BIDS WHERE $COLUMN_EXECUTOR_ID = :executorId")
    suspend fun getByExecutor(executorId: Long): List<BidEntity>

    @Query("SELECT * FROM $TABLE_BIDS WHERE $COLUMN_TENDER_ID = :tenderId AND $COLUMN_STATUS = :status")
    suspend fun getByTenderAndStatus(tenderId: Long, status: BidStatus): List<BidEntity>
}