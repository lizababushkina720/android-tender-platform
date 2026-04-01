package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.db.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM users") suspend fun getAll(): List<UserEntity>
    @Query("SELECT * FROM users WHERE userId = :id") suspend fun getById(id: Long): UserEntity?
    @Query("SELECT * FROM users WHERE email = :email LIMIT 1") suspend fun getByEmail(email: String): UserEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insert(user: UserEntity): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertAll(users: List<UserEntity>)
    @Update
    suspend fun update(user: UserEntity)
    @Delete
    suspend fun delete(user: UserEntity)
    @Query("DELETE FROM users") suspend fun deleteAll()
}