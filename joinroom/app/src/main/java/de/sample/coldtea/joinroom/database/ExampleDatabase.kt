package de.sample.coldtea.joinroom.database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.sample.coldtea.joinroom.database.daos.AddressDao
import de.sample.coldtea.joinroom.database.daos.PaymentDao
import de.sample.coldtea.joinroom.database.daos.ProfisDao
import de.sample.coldtea.joinroom.database.daos.UserDao
import de.sample.coldtea.joinroom.database.daos.UserProfiCrossDao
import de.sample.coldtea.joinroom.database.entities.AddressEntity
import de.sample.coldtea.joinroom.database.entities.PaymentEntity
import de.sample.coldtea.joinroom.database.entities.ProfisEntity
import de.sample.coldtea.joinroom.database.entities.UserEntity
import de.sample.coldtea.joinroom.database.entities.UserProfiCrossRef

@Database(
    entities = [
        AddressEntity::class,
        PaymentEntity::class,
        ProfisEntity::class,
        UserEntity::class,
        UserProfiCrossRef::class
    ],
    version = 1,
    exportSchema = true
)

abstract class ExampleDatabase : RoomDatabase() {
    abstract val addressDao: AddressDao
    abstract val paymentDao: PaymentDao
    abstract val profisDao: ProfisDao
    abstract val userDao: UserDao
    abstract val crossDao: UserProfiCrossDao

    companion object {
        fun create(context: Context, name: String) = synchronized(this) {
            Room.databaseBuilder(context.applicationContext, ExampleDatabase::class.java, name)
                .fallbackToDestructiveMigration() // todo proper migration
                .build()
        }
    }
}


