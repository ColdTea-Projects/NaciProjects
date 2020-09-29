package de.sample.coldtea.joinroom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import de.sample.coldtea.joinroom.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var mJob: Job
    private val repository by lazy {
        Repository(this)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mJob = Job()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonOneToOne.setOnClickListener {
            launch {
                val pairs = repository.database.userDao.getUserAndAddressPairs()
                var text = ""
                for (pair in pairs){
                    text += "\n ${pair.user.name} ${pair.user.surname}from ${pair.address.street} ${pair.address.city}"
                }
                binding.textView.text = text
            }
        }

        binding.buttonOneToMany.setOnClickListener {
            launch {
                val pairs = repository.database.userDao.getUserAndPayments(2)
                var text = "${pairs.first().user.name} ${pairs.first().user.surname}"
                for (payment in pairs.first().payments){
                    text += "\n ${payment.type} ${payment.bank} ${payment.number}"
                }
                binding.textView.text = text
            }
        }

        binding.buttonManyToMany.setOnClickListener {
            launch {
                val pairs = repository.database.userDao.getUserAndProfiPairs()
                var text = ""
                for (pair in pairs){
                    text += "user: ${pair.users.name} ${pair.users.surname}"
                    for (profi in pair.profis){
                        text += "profi: ${profi.name} ${profi.surname} - ${profi.service} "
                    }
                }
                binding.textView.text = text
            }
        }


        launch {
            repository.insertOrUpdate()
        }

    }

    override val coroutineContext: CoroutineContext
        get() = mJob + Dispatchers.Main
}