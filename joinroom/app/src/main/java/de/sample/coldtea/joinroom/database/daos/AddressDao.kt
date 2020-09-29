package de.sample.coldtea.joinroom.database.daos

import androidx.room.Dao
import de.sample.coldtea.joinroom.database.BaseDao
import de.sample.coldtea.joinroom.database.entities.AddressEntity

@Dao
interface AddressDao : BaseDao<AddressEntity>