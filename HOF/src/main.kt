import cars.Porsche
import cars.StringToUnit
import cars.Volkswagen

//Lambda expressions
val filterA = { x : Int -> x < 2 }
val filterB: (Int) -> Boolean = { it < 3 }
val printMe: (String) -> Unit = { println(it) }

// Anonymous functions
val filterC = fun(x : Int) : Boolean = x < 4
// Member functions
val filterD = Sample::filterD


fun main(args: Array<String>) {

    if(filterA(0)) println("Hello, A!")
    if(filterB(0)) printMe("Hello, B!")
    if(filterC(0)) printMe("Hello, C!")
    if(filterD.invoke(Sample(), 0)) printMe("Hello, D!")

    val list = listOf(1,2,3,4,5,6,7,8,9,10)

    //region predicate
    list.filter(filterC).map{
        printMe(it.toString())
    }



//    list.filter(filterC).map {
//        printMe(it.toString())
//    }
    // endregion

    val car1 = Volkswagen()
    val car2 = Porsche()

    val carObserver: StringToUnit = {
        printMe("I drive a $it")
    }

    car1.drive(carObserver)
    car2.drive(carObserver)

    //region observer

//    val car1 = Volkswagen()
//    val car2 = Porsche()
//
//    val carObserver: (String) -> Unit = {
//        printMe("I drive a $it")
//    }
//
//    car1.drive(carObserver)
//    car2.drive(carObserver)

    //endregion
}












