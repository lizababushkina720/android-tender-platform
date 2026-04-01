package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.db.entity.ContractEntity

@Dao
interface ContractDao {
    @Query("SELECT * FROM contracts") suspend fun getAll(): List<ContractEntity>
    @Query("SELECT * FROM contracts WHERE contractId = :id") suspend fun getById(id: Long): ContractEntity?
    @Query("SELECT * FROM contracts WHERE tenderId = :tenderId") suspend fun getByTender(tenderId: Long): List<ContractEntity>
    @Query("SELECT * FROM contracts WHERE supplierId = :supplierId") suspend fun getBySupplier(supplierId: Long): List<ContractEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insert(contract: ContractEntity): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertAll(contracts: List<ContractEntity>)
    @Update
    suspend fun update(contract: ContractEntity)
    @Delete
    suspend fun delete(contract: ContractEntity)
    @Query("DELETE FROM contracts") suspend fun deleteAll()
}