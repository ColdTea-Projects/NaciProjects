package de.sample.coldtea.sampleretrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.sample.coldtea.sampleretrofitapp.users.UserFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UserFragment.newInstance())
                .commitNow()
        }
    }
}