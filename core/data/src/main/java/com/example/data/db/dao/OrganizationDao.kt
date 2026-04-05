package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.db.DatabaseConstants
import com.example.data.db.crossrefs.OrganizationCategoryCrossRef
import com.example.data.db.entity.OrganizationEntity

@Dao
interface OrganizationDao {
    companion object {
        private const val TABLE_ORGANIZATIONS = DatabaseConstants.TABLE_ORGANIZATIONS
        private const val COLUMN_ORGANIZATION_ID = DatabaseConstants.COLUMN_ORGANIZATION_ID
        private const val COLUMN_EMAIL = DatabaseConstants.COLUMN_EMAIL
    }

    @Query("SELECT * FROM $TABLE_ORGANIZATIONS")
    suspend fun getAll(): List<OrganizationEntity>

    @Query("SELECT * FROM $TABLE_ORGANIZATIONS WHERE $COLUMN_ORGANIZATION_ID = :id")
    suspend fun getById(id: Long): OrganizationEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(org: OrganizationEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(orgs: List<OrganizationEntity>)

    @Update
    suspend fun update(org: OrganizationEntity)

    @Delete
    suspend fun delete(org: OrganizationEntity)

    @Query("DELETE FROM organizations")
    suspend fun deleteAll()

    @Query("SELECT * FROM $TABLE_ORGANIZATIONS WHERE $COLUMN_EMAIL = :email LIMIT 1")
    suspend fun getByEmail(email: String): OrganizationEntity?
}
