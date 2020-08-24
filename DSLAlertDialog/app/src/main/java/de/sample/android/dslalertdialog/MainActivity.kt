package de.sample.android.dslalertdialog

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("Meeeh Dialog")
//        builder.setMessage("The body of meeeh alert")
//        builder.setPositiveButton("OK") {dialog, which ->
//            Toast.makeText(applicationContext, "Yes", Toast.LENGTH_SHORT).show()
//        }
//        builder.setNegativeButton("No") { dialog, which ->
//            Toast.makeText(applicationContext, "No", Toast.LENGTH_SHORT).show()
//        }
//
//        btnAlert.setOnClickListener {
//            builder.show()
//        }

        val dialog = myDialogBuilder {
            with{ this@MainActivity}

            this titleText "Cooler Dialog"

            message{ "The body of my cooler dialog" }
            positiveButton("Yes") { dialog, which ->
                Toast.makeText(applicationContext, "Yes", Toast.LENGTH_SHORT).show()
            }
            negativeButton {
                text = "No"
                onClickAction = { dialog, which ->
                    Toast.makeText(applicationContext, "No", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnAlert.setOnClickListener {
//            builder.show()
            dialog.show()
        }
    }
}