package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.db.DatabaseConstants
import com.example.data.db.entity.ContractEntity

@Dao
interface ContractDao {
    companion object {
        private const val TABLE_CONTRACTS = DatabaseConstants.TABLE_CONTRACTS
        private const val COLUMN_TENDER_ID = DatabaseConstants.COLUMN_TENDER_ID
        private const val COLUMN_CONTRACT_ID = DatabaseConstants.COLUMN_CONTRACT_ID
        private const val COLUMN_SUPPLIER_ID = DatabaseConstants.COLUMN_SUPPLIER_ID
    }

    @Query("SELECT * FROM $TABLE_CONTRACTS")
    suspend fun getAll(): List<ContractEntity>

    @Query("SELECT * FROM $TABLE_CONTRACTS WHERE $COLUMN_CONTRACT_ID = :id")
    suspend fun getById(id: Long): ContractEntity?

    @Query("SELECT * FROM $TABLE_CONTRACTS WHERE $COLUMN_TENDER_ID = :tenderId")
    suspend fun getByTender(tenderId: Long): List<ContractEntity>

    @Query("SELECT * FROM $TABLE_CONTRACTS WHERE $COLUMN_SUPPLIER_ID = :supplierId")
    suspend fun getBySupplier(supplierId: Long): List<ContractEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contract: ContractEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(contracts: List<ContractEntity>)

    @Update
    suspend fun update(contract: ContractEntity)

    @Delete
    suspend fun delete(contract: ContractEntity)

    @Query("DELETE FROM $TABLE_CONTRACTS")
    suspend fun deleteAll()
}