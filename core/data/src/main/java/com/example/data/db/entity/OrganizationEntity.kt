package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.data.db.DatabaseConstants
import com.example.data.db.enums.Role

@Entity(
    tableName = DatabaseConstants.TABLE_ORGANIZATIONS,
    indices = [
        Index(value = [DatabaseConstants.COLUMN_EMAIL], unique = true),
        Index(value = [DatabaseConstants.COLUMN_INN], unique = true)
    ]
)

data class OrganizationEntity(
    @PrimaryKey(autoGenerate = true)
    val organizationId: Long = 0,

    // авторизация
    val email: String,
    val passwordHash: String,

    // данные представителя организации
    val firstName: String,
    val lastName: String,
    val fatherName: String? = null,
    val contactPhone: String? = null,
    val role: Role,

    // данные организации
    val organizationName: String,
    val inn: String,
    val ogrn: String? = null,
    val kpp: String? = null,
    val legalAddress: String? = null,

    // доп на будущее
//    val avatarUrl: String? = null,
//    val avgRating: Float = 0f,
//    val reviewCount: Int = 0,

)
