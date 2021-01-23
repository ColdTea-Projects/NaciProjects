class BadDataClass(){
    var a:Int = 0
    var b:Int = 0
    var c:Int = 0
}

fun doIt(){
    val badData = BadDataClass()
    badData.a = 3
    badData.b = 4
    badData.c = 5


    val result = badData.a  + badData.b * 2 + badData.c * 3
}

class GoodDataClass(){
    var single:Int = 0
    var  double:Int = 0
        get() = field * 2
    var triple:Int = 0
        get() = field * 3
}

fun alsoDoIt(){
    val goodData = GoodDataClass()
    goodData.single = 3
    goodData.double = 4
    goodData.triple = 5

    val result = goodData.single + goodData.double + goodData.triple
}

