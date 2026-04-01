package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.db.crossrefs.TenderCategoryCrossRef
import com.example.data.db.entity.TenderEntity
import com.example.data.db.enums.TenderStatus

@Dao
interface TenderDao {
    @Query("SELECT * FROM tenders") suspend fun getAll(): List<TenderEntity>
    @Query("SELECT * FROM tenders WHERE tenderId = :id") suspend fun getById(id: Long): TenderEntity?
    @Query("SELECT * FROM tenders WHERE customerId = :customerId") suspend fun getByCustomer(customerId: Long): List<TenderEntity>
    @Query("SELECT * FROM tenders WHERE status = :status") suspend fun getByStatus(status: TenderStatus): List<TenderEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insert(tender: TenderEntity): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertAll(tenders: List<TenderEntity>)
    @Update
    suspend fun update(tender: TenderEntity)
    @Delete
    suspend fun delete(tender: TenderEntity)
    @Query("DELETE FROM tenders") suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertCategoryCrossRef(ref: TenderCategoryCrossRef)
    @Delete suspend fun deleteCategoryCrossRef(ref: TenderCategoryCrossRef)
    @Query("SELECT * FROM tender_categories WHERE tenderId = :tenderId")
    suspend fun getCategoryRefs(tenderId: Long): List<TenderCategoryCrossRef>
}