package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.db.crossrefs.OrganizationCategoryCrossRef
import com.example.data.db.entity.OrganizationEntity

@Dao
interface OrganizationDao {
    @Query("SELECT * FROM organizations") suspend fun getAll(): List<OrganizationEntity>
    @Query("SELECT * FROM organizations WHERE organizationId = :id") suspend fun getById(id: Long): OrganizationEntity?
    @Query("SELECT * FROM organizations WHERE ownerId = :ownerId") suspend fun getByOwner(ownerId: Long): List<OrganizationEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insert(org: OrganizationEntity): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertAll(orgs: List<OrganizationEntity>)
    @Update
    suspend fun update(org: OrganizationEntity)
    @Delete suspend fun delete(org: OrganizationEntity)
    @Query("DELETE FROM organizations") suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertCategoryCrossRef(ref: OrganizationCategoryCrossRef)
    @Delete
    suspend fun deleteCategoryCrossRef(ref: OrganizationCategoryCrossRef)
    @Query("SELECT * FROM organization_categories WHERE organizationId = :orgId")
    suspend fun getCategoryRefs(orgId: Long): List<OrganizationCategoryCrossRef>
}
