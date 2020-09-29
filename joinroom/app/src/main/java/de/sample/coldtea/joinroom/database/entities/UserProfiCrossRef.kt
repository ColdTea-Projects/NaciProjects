package de.sample.coldtea.joinroom.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["user_id", "profis_id"])
data class UserProfiCrossRef(
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @ColumnInfo(name = "profis_id")
    val profisId: Int
)