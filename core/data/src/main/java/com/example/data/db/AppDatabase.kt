package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.db.dao.AttachmentDao
import com.example.data.db.dao.BidDao
import com.example.data.db.dao.CategoryDao
import com.example.data.db.dao.ContractDao
import com.example.data.db.dao.LotDao
import com.example.data.db.dao.OrganizationDao
import com.example.data.db.dao.TenderDao
import com.example.data.db.dao.TenderStatusHistoryDao
import com.example.data.db.dao.UserDao
import com.example.data.db.entity.AttachmentEntity
import com.example.data.db.entity.BidEntity
import com.example.data.db.entity.CategoryEntity
import com.example.data.db.entity.ContractEntity
import com.example.data.db.entity.LotEntity
import com.example.data.db.entity.OrganizationEntity
import com.example.data.db.entity.TenderEntity
import com.example.data.db.entity.TenderStatusHistoryEntity
import com.example.data.db.entity.UserEntity
import com.example.data.db.typeconverter.AppConverters
import com.example.data.db.crossrefs.OrganizationCategoryCrossRef
import com.example.data.db.crossrefs.TenderCategoryCrossRef

@Database(
    entities = [
        UserEntity::class,
        OrganizationEntity::class,
        CategoryEntity::class,
        TenderEntity::class,
        LotEntity::class,
        BidEntity::class,
        ContractEntity::class,
        AttachmentEntity::class,
        TenderStatusHistoryEntity::class,
        TenderCategoryCrossRef::class,
        OrganizationCategoryCrossRef::class
    ],
    version = 1,
)
@TypeConverters(AppConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun organizationDao(): OrganizationDao
    abstract fun categoryDao(): CategoryDao
    abstract fun tenderDao(): TenderDao
    abstract fun lotDao(): LotDao
    abstract fun bidDao(): BidDao
    abstract fun contractDao(): ContractDao
    abstract fun attachmentDao(): AttachmentDao
    abstract fun tenderStatusHistoryDao(): TenderStatusHistoryDao

}