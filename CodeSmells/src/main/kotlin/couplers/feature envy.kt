package couplers

class SomeClass{
    var multiplier = 3
    val someOtherClass = SomeOtherClass()

    fun featureEnviousMethod(): Int =
        (someOtherClass.data1 + someOtherClass.data2 + someOtherClass.data3) * multiplier

//    fun noSoMuchFeatureEnviousMethod(): Int =
//        someOtherClass.getTotalData() * multiplier
}

class SomeOtherClass{
    var data1 = 10
    var data2 = 12
    var data3 = 15
//    fun getTotalData() = data1 + data2 + data3
}