package de.checkathon.animatedicons.customviews

import android.view.LayoutInflater
import android.view.View
import com.airbnb.lottie.LottieAnimationView

fun View.layoutInflater(): LayoutInflater = LayoutInflater.from(context)
fun LottieAnimationView.setToBeginning() {
    frame = 0
}