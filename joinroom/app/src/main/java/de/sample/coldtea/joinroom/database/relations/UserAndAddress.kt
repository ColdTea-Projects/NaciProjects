package de.sample.coldtea.joinroom.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import de.sample.coldtea.joinroom.database.entities.AddressEntity
import de.sample.coldtea.joinroom.database.entities.UserEntity
//SELECT * FROM UserEntity as U LEFT JOIN AddressEntity as A ON (U.user_id = A.fk_user_id)

data class UserAndAddress(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "fk_user_id"
    )
    val address: AddressEntity?
)