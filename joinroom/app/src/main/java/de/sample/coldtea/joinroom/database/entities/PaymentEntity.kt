package de.sample.coldtea.joinroom.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Payment")
data class PaymentEntity(
    @PrimaryKey
    @ColumnInfo(name = "payment_id")
    val paymentId: Int,
    @ColumnInfo(name = "fk_user_id")
    var fkUserId: Int,
    @ColumnInfo(name = "type")
    var type: String,
    @ColumnInfo(name = "number")
    val number: String,
    @ColumnInfo(name = "bank")
    val bank: String
)