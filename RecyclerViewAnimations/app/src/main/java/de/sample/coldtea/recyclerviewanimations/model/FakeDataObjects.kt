package de.sample.coldtea.recyclerviewanimations.model

import kotlin.random.Random

data class TextData(
    val text: String,
    val timestamp: Long
){
    companion object{
        val fakeListOfText : List<String> = listOf(
            "At length he gathered from Sam that",
            "Sam plainly was ",
            "beginning to have doubts",
            "but Strider knelt down swiftly at his side.",
            "'I am not a Black Rider, Sam,'",
            "he said gently, 'nor in league",
            " with them. I have been trying " ,
            "to discover something of their ",
            "movements; but I have found nothing.",
            " I cannot think why they have gone and",
            "movements; but I have found nothing."
        )

    }
}

fun List<String>.getRandomItem(): String{
    return this[Random.nextInt(this.size)]
}