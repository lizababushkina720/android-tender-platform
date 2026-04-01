package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.db.entity.CategoryEntity

@Dao
interface CategoryDao {
    @Query("SELECT * FROM categories") suspend fun getAll(): List<CategoryEntity>
    @Query("SELECT * FROM categories WHERE categoryId = :id") suspend fun getById(id: Long): CategoryEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insert(category: CategoryEntity): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertAll(categories: List<CategoryEntity>)
    @Update
    suspend fun update(category: CategoryEntity)
    @Delete
    suspend fun delete(category: CategoryEntity)
    @Query("DELETE FROM categories") suspend fun deleteAll()
}