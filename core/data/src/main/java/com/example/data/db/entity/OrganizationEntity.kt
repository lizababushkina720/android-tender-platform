package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "organizations",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["userId"],
            childColumns = ["ownerId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [Index("ownerId")]
)
data class OrganizationEntity(
    @PrimaryKey(autoGenerate = true)
    val organizationId: Long = 0,
    val fullName: String,
    val inn: String,
    val kpp: String? = null,
    val legalAddress: String,
    val canBeCustomer: Boolean,
    val canBeSupplier: Boolean = true,
    val ownerId: Long? = null
)
