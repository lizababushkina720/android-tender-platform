package com.example.data.db.typeconverter

import androidx.room.TypeConverter
import com.example.data.db.enums.BidStatus
import com.example.data.db.enums.ContractStatus
import com.example.data.db.enums.DocumentType
import com.example.data.db.enums.Role
import com.example.data.db.enums.TenderStatus
import java.math.BigDecimal
import java.util.Date

class AppConverters {

    @TypeConverter fun fromBigDecimal(value: BigDecimal?): String? = value?.toPlainString()
    @TypeConverter fun toBigDecimal(value: String?): BigDecimal? = value?.let { BigDecimal(it) }

    @TypeConverter fun fromBidStatus(value: BidStatus?): String? = value?.name
    @TypeConverter fun toBidStatus(value: String?): BidStatus? = value?.let { BidStatus.valueOf(it) }

    @TypeConverter fun fromContractStatus(value: ContractStatus?): String? = value?.name
    @TypeConverter fun toContractStatus(value: String?): ContractStatus? = value?.let { ContractStatus.valueOf(it) }

    @TypeConverter fun fromDocumentType(value: DocumentType?): String? = value?.name
    @TypeConverter fun toDocumentType(value: String?): DocumentType? = value?.let { DocumentType.valueOf(it) }

    @TypeConverter fun fromRole(value: Role?): String? = value?.name
    @TypeConverter fun toRole(value: String?): Role? = value?.let { Role.valueOf(it) }

    @TypeConverter fun fromTenderStatus(value: TenderStatus?): String? = value?.name
    @TypeConverter fun toTenderStatus(value: String?): TenderStatus? = value?.let { TenderStatus.valueOf(it) }

    @TypeConverter fun fromDate(value: Date?): Long? = value?.time
    @TypeConverter fun toDate(value: Long?): Date? = value?.let { Date(it) }
}