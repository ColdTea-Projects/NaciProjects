package de.sample.coldtea.joinroom.database.daos

import androidx.room.Dao
import de.sample.coldtea.joinroom.database.BaseDao
import de.sample.coldtea.joinroom.database.entities.PaymentEntity

@Dao
interface PaymentDao : BaseDao<PaymentEntity>