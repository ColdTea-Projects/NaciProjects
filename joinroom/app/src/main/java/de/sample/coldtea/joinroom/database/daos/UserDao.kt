package de.sample.coldtea.joinroom.database.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import de.sample.coldtea.joinroom.database.BaseDao
import de.sample.coldtea.joinroom.database.entities.UserEntity
import de.sample.coldtea.joinroom.database.relations.UserAndAddress
import de.sample.coldtea.joinroom.database.relations.UserAndPayments
import de.sample.coldtea.joinroom.database.relations.UserAndProfis

@Dao
interface UserDao : BaseDao<UserEntity>{
    @Transaction
    @Query("SELECT * FROM Users")
    suspend fun getUserAndAddressPairs(): List<UserAndAddress>

    @Transaction
    @Query("SELECT * FROM Users WHERE user_id = :userId")
    suspend fun getUserAndPayments(userId: Int): List<UserAndPayments>

    @Transaction
    @Query("SELECT * FROM Users")
    suspend fun getUserAndProfiPairs(): List<UserAndProfis>
}