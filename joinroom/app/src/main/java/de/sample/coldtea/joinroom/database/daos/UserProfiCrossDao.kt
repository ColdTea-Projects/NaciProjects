package de.sample.coldtea.joinroom.database.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import de.sample.coldtea.joinroom.database.BaseDao
import de.sample.coldtea.joinroom.database.entities.UserEntity
import de.sample.coldtea.joinroom.database.entities.UserProfiCrossRef
import de.sample.coldtea.joinroom.database.relations.UserAndAddress
import de.sample.coldtea.joinroom.database.relations.UserAndPayments
import de.sample.coldtea.joinroom.database.relations.UserAndProfis

@Dao
interface UserProfiCrossDao : BaseDao<UserProfiCrossRef>