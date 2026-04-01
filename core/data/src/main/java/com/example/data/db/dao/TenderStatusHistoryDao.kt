package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.db.entity.TenderStatusHistoryEntity

@Dao
interface TenderStatusHistoryDao {
    @Query("SELECT * FROM tender_status_histories WHERE tenderId = :tenderId ORDER BY changedAt DESC")
    suspend fun getByTender(tenderId: Long): List<TenderStatusHistoryEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insert(entry: TenderStatusHistoryEntity): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertAll(entries: List<TenderStatusHistoryEntity>)
    @Delete
    suspend fun delete(entry: TenderStatusHistoryEntity)
    @Query("DELETE FROM tender_status_histories WHERE tenderId = :tenderId") suspend fun deleteByTender(tenderId: Long)
}