package de.sample.coldtea.joinroom

import android.content.Context
import androidx.annotation.WorkerThread
import de.sample.coldtea.joinroom.database.ExampleDatabase
import de.sample.coldtea.joinroom.database.entities.AddressEntity
import de.sample.coldtea.joinroom.database.entities.PaymentEntity
import de.sample.coldtea.joinroom.database.entities.ProfisEntity
import de.sample.coldtea.joinroom.database.entities.UserEntity
import de.sample.coldtea.joinroom.database.entities.UserProfiCrossRef
import de.sample.coldtea.joinroom.database.insertOrUpdate

class Repository(context: Context) {

    val database by lazy { ExampleDatabase.create(context, "exampleDB") }

    @WorkerThread
    suspend fun insertOrUpdate(){
        database.addressDao.insertOrUpdate(AddressEntity(0, 0, "Dirschauerstraße", "Berlin"))
        database.addressDao.insertOrUpdate(AddressEntity(1, 1, "Asbachstraße", "Weimar"))
        database.addressDao.insertOrUpdate(AddressEntity(2, 2, "Nordernfeldstraße", "Berlin"))

        database.paymentDao.insertOrUpdate(PaymentEntity(0, 0, "Credit Card", "14932848234812841238", "Deutsche Bank"))
        database.paymentDao.insertOrUpdate(PaymentEntity(1, 0, "Paypal", "14932841238", "Paypal GmbH"))

        database.paymentDao.insertOrUpdate(PaymentEntity(2, 1, "Direct Payment", "14932848234812841238", "Deutsche Bank"))
        database.paymentDao.insertOrUpdate(PaymentEntity(3, 1, "Credit Card", "14932848234812841238", "Deutsche Bank"))
        database.paymentDao.insertOrUpdate(PaymentEntity(4, 1, "Paypal", "14932841238", "Paypal GmbH"))

        database.paymentDao.insertOrUpdate(PaymentEntity(5, 2, "Direct Payment", "14932848234812841238", "Sparkasse"))
        database.paymentDao.insertOrUpdate(PaymentEntity(6, 2, "Direct Payment", "14932848234812841238", "C24Bank"))

        database.userDao.insertOrUpdate(UserEntity(0, "Joachim", "Müller"))
        database.userDao.insertOrUpdate(UserEntity(1, "Hans", "Bauer"))
        database.userDao.insertOrUpdate(UserEntity(2, "Lisa", "Schweinsteiger"))

        database.profisDao.insertOrUpdate(ProfisEntity(0, "Helmut", "Becker", "Baker"))
        database.profisDao.insertOrUpdate(ProfisEntity(1, "Konrad", "Klingemann", "Weapon Smith"))
        database.profisDao.insertOrUpdate(ProfisEntity(2, "Wolfgang", "Schneider", "Tailor"))

        database.crossDao.insertOrUpdate(UserProfiCrossRef(2,1))

    }


}