package de.sample.coldtea.recyclerviewanimations.extensions

import kotlin.random.Random

fun List<String>.getRandomString(): String{
    return this[Random.nextInt(this.size)]
}