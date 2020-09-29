package de.sample.coldtea.joinroom.database.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import de.sample.coldtea.joinroom.database.entities.ProfisEntity
import de.sample.coldtea.joinroom.database.entities.UserEntity
import de.sample.coldtea.joinroom.database.entities.UserProfiCrossRef


//SELECT
//UserEntity.userId AS userId,
//ProfisEntity.profisId AS profisId,
//_junction.userId
//FROM
//UserProfiCrossRef AS _junction
//INNER JOIN Profi ON (_junction.profisId = Profis.profisId)
//WHERE _junction.userId In (userId1, userId2, …)

data class UserAndProfis(
    @Embedded val users: UserEntity,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "profis_id",
        associateBy = Junction(UserProfiCrossRef::class)
    )
    val profis: List<ProfisEntity>
)