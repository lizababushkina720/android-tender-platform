package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.db.entity.LotEntity

@Dao
interface LotDao {
    @Query("SELECT * FROM lots") suspend fun getAll(): List<LotEntity>
    @Query("SELECT * FROM lots WHERE lotId = :id") suspend fun getById(id: Long): LotEntity?
    @Query("SELECT * FROM lots WHERE tenderId = :tenderId") suspend fun getByTender(tenderId: Long): List<LotEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insert(lot: LotEntity): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertAll(lots: List<LotEntity>)
    @Update
    suspend fun update(lot: LotEntity)
    @Delete
    suspend fun delete(lot: LotEntity)
    @Query("DELETE FROM lots WHERE tenderId = :tenderId") suspend fun deleteByTender(tenderId: Long)
}
