package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.db.DatabaseConstants
import com.example.data.db.entity.TenderStatusHistoryEntity

@Dao
interface TenderStatusHistoryDao {
    companion object {
        private const val TABLE_TENDER_STATUS_HISTORIES = DatabaseConstants.TABLE_TENDER_STATUS_HISTORIES
        private const val COLUMN_TENDER_ID = DatabaseConstants.COLUMN_TENDER_ID
    }

    @Query("SELECT * FROM $TABLE_TENDER_STATUS_HISTORIES WHERE $COLUMN_TENDER_ID = :tenderId ORDER BY changedAt DESC")
    suspend fun getByTender(tenderId: Long): List<TenderStatusHistoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: TenderStatusHistoryEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entries: List<TenderStatusHistoryEntity>)

    @Delete
    suspend fun delete(entry: TenderStatusHistoryEntity)

    @Query("DELETE FROM $TABLE_TENDER_STATUS_HISTORIES WHERE $COLUMN_TENDER_ID = :tenderId")
    suspend fun deleteByTender(tenderId: Long)
}