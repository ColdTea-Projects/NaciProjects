package de.sample.coldtea.joinroom.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "surname")
    val surname: String?
)