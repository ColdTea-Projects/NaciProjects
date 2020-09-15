fun main(args: Array<String>) {
    println("Hello World where superheroes exist!")

    call(SuperHero.Aquaman)

    //call(SuperHero.Batman("Black", "Na Na Na Na Na", listOf("batmobil", "battranqualizer")))
}


fun call(superHero: SuperHero)
//as expression
{
    // Nope: SuperHero("Tony Stark")
    when (superHero) {
        is SuperHero.Batman -> println("the ${superHero.capeColor} caped crusader says: ${superHero.says} and uses ${superHero.gadgetsAsString}. BECAUSE HE IS ${superHero.name}")
        is SuperHero.Superman -> println("the ${superHero.capeColor} caped crusader says: ${superHero.says}")
        is SuperHero.Wonderwoman -> println("she says: ${superHero.says} and uses ${superHero.gadgets.map { it }}")
        SuperHero.Aquaman -> println("I mean....who cares...it's aquaman")
    }
}

//assingment
////    =
////    when(superHero){
////        is SuperHero.Aquaman -> "Swim"
////        is SuperHero.Batman -> "Being awsome"
////    }
//}

// Finite-state Machine
//{
//    when (superHero) {
//        is SuperHero.Aquaman -> {
//            println("${superHero.name} swims around and ruins it then passes on ")
//            call(SuperHero.Wonderwoman("Black", listOf("some sort of whip", "horse I guess, idk")))
//        }
//        is SuperHero.Batman -> println("And caped crusader saves the day, because he is ${superHero.name} ;)")
//        else -> {
//            println("${superHero.name} flies around and ruins it then passes on ")
//            call(SuperHero.Batman("Black", "Na Na Na Na Na", listOf("batmobil", "battranqualizer")))
//        }
//    }
//}