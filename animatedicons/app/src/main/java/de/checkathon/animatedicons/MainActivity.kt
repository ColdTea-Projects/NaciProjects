package de.checkathon.animatedicons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.checkathon.animatedicons.customviews.listeners.OnStateChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //lotti animations
        logo_github.setOnClickListener {
            logo_github.playAnimation()
        }

        lottie_switch.mOnStateChangedListener = object: OnStateChangedListener{
            override fun onStateChanged(state: Boolean) {
                check_text_view.text = if (state) "checked" else "unchecked"
            }
        }
    }
}
