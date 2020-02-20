package de.checkathon.animatedicons.customviews

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import de.checkathon.animatedicons.R
import de.checkathon.animatedicons.customviews.listeners.OnStateChangedListener
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.layout_lottie_switch.view.*

class LottieSwitch @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null
) : FrameLayout(context, attributeSet) {

    var isChecked = false
    lateinit var mOnStateChangedListener: OnStateChangedListener

    init {
        layoutInflater().inflate(R.layout.layout_lottie_switch, this, true)
        lottie_check_animated.setOnClickListener {
            if (isChecked){
                lottie_check_animated.setToBeginning()
            }else{
                lottie_check_animated.playAnimation()
            }

            isChecked = isChecked.not()
            mOnStateChangedListener.onStateChanged(isChecked)
        }

        lottie_switch.onFocusChangeListener
    }
}

