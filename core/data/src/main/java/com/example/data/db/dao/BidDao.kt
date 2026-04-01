package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.db.entity.BidEntity
import com.example.data.db.enums.BidStatus

@Dao
interface BidDao {

    @Query("SELECT * FROM bids")
    suspend fun getAll(): List<BidEntity>

    @Query("SELECT * FROM bids WHERE bidId = :id") suspend fun getById(id: Long): BidEntity?
    @Query("SELECT * FROM bids WHERE lotId = :lotId") suspend fun getByLot(lotId: Long): List<BidEntity>
    @Query("SELECT * FROM bids WHERE supplierId = :supplierId") suspend fun getBySupplier(supplierId: Long): List<BidEntity>
    @Query("SELECT * FROM bids WHERE status = :status") suspend fun getByStatus(status: BidStatus): List<BidEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insert(bid: BidEntity): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertAll(bids: List<BidEntity>)
    @Update
    suspend fun update(bid: BidEntity)
    @Delete
    suspend fun delete(bid: BidEntity)
}