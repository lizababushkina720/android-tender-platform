package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.db.DatabaseConstants
import com.example.data.db.crossrefs.TenderCategoryCrossRef
import com.example.data.db.entity.TenderEntity
import com.example.data.db.enums.TenderStatus

@Dao
interface TenderDao {
    companion object {
        private const val TABLE_TENDERS = DatabaseConstants.TABLE_TENDERS
        private const val TABLE_TENDER_CATEGORIES = DatabaseConstants.TABLE_TENDER_CATEGORIES
        private const val COLUMN_TENDER_ID = DatabaseConstants.COLUMN_TENDER_ID
        private const val COLUMN_CUSTOMER_ID = DatabaseConstants.COLUMN_CUSTOMER_ID
        private const val COLUMN_STATUS = DatabaseConstants.COLUMN_STATUS
    }

    @Query("SELECT * FROM $TABLE_TENDERS")
    suspend fun getAll(): List<TenderEntity>

    @Query("SELECT * FROM $TABLE_TENDERS WHERE $COLUMN_TENDER_ID = :id")
    suspend fun getById(id: Long): TenderEntity?

    @Query("SELECT * FROM $TABLE_TENDERS WHERE $COLUMN_CUSTOMER_ID = :customerId")
    suspend fun getByCustomer(customerId: Long): List<TenderEntity>

    @Query("SELECT * FROM $TABLE_TENDERS WHERE $COLUMN_STATUS = :status")
    suspend fun getByStatus(status: TenderStatus): List<TenderEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tender: TenderEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tenders: List<TenderEntity>)

    @Update
    suspend fun update(tender: TenderEntity)

    @Delete
    suspend fun delete(tender: TenderEntity)

    @Query("DELETE FROM $TABLE_TENDERS")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategoryCrossRef(ref: TenderCategoryCrossRef)

    @Delete
    suspend fun deleteCategoryCrossRef(ref: TenderCategoryCrossRef)

    @Query("SELECT * FROM $TABLE_TENDER_CATEGORIES WHERE $COLUMN_TENDER_ID = :tenderId")
    suspend fun getCategoryRefs(tenderId: Long): List<TenderCategoryCrossRef>

    @Query("SELECT * FROM $TABLE_TENDERS WHERE $COLUMN_CUSTOMER_ID = :customerId AND $COLUMN_STATUS = :status")
    suspend fun getByCustomerAndStatus(customerId: Long, status: TenderStatus): List<TenderEntity>
}