package de.sample.coldtea.joinroom.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Profis")
data class ProfisEntity(
    @PrimaryKey
    @ColumnInfo(name = "profis_id")
    val profisId: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "surname")
    val surname: String?,
    @ColumnInfo(name = "service")
    val service: String?
)