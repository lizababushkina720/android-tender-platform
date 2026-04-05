package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.db.DatabaseConstants
import com.example.data.db.entity.CategoryEntity

@Dao
interface CategoryDao {
    companion object {
        private const val TABLE_CATEGORIES = DatabaseConstants.TABLE_CATEGORIES
        private const val COLUMN_CATEGORY_ID = DatabaseConstants.COLUMN_CATEGORY_ID
    }

    @Query("SELECT * FROM $TABLE_CATEGORIES")
    suspend fun getAll(): List<CategoryEntity>

    @Query("SELECT * FROM $TABLE_CATEGORIES WHERE $COLUMN_CATEGORY_ID = :id")
    suspend fun getById(id: Long): CategoryEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: CategoryEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(categories: List<CategoryEntity>)

    @Update
    suspend fun update(category: CategoryEntity)

    @Delete
    suspend fun delete(category: CategoryEntity)

    @Query("DELETE FROM $TABLE_CATEGORIES")
    suspend fun deleteAll()
}