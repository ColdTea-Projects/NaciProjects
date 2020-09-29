package de.sample.coldtea.joinroom.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Address")
data class AddressEntity(
    @PrimaryKey
    @ColumnInfo(name = "address_id")
    val addressId: Int,
    @ColumnInfo(name = "fk_user_id")
    var fkUserId: Int,
    @ColumnInfo(name = "street")
    var street: String,
    @ColumnInfo(name = "city")
    val city: String
)