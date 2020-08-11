package de.sample.android.deprecationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cA = ClassA()
        val a = true
        button_nested_layout.setOnClickListener {
            textview_main.text = ClassB.getTheMessage(a)
        }
    }
}