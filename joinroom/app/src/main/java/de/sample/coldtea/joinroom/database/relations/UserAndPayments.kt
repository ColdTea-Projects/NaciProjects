package de.sample.coldtea.joinroom.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import de.sample.coldtea.joinroom.database.entities.AddressEntity
import de.sample.coldtea.joinroom.database.entities.PaymentEntity
import de.sample.coldtea.joinroom.database.entities.UserEntity
//SELECT * FROM UserEntity as U LEFT JOIN PaymentEntity as P ON (U.user_id = P.fk_user_id)
data class UserAndPayments(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "fk_user_id"
    )
    val payments: List<PaymentEntity>
)