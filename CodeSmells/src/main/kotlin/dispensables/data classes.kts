class BadDataClass(){
    var a:Int
    var b:Int
    var c:Int
}

fun doIt(){
    val badData = BadDataClass(3,4,5)

    val result = badData.a  + badData.b * 2 + badData.c * 3
}

class GoodDataClass(){
    private var single:Int
        get() = field
        set(value) {
            field = value
        }
    private var  double:Int
        get() = field
        set(value) {
            field = value * 2
        }
    private var triple:Int
        get() = field
        set(value) {
            field = value * 3
        }
}

fun alsoDoIt(){
    val goodData = GoodDataClass(3,4,5)

    val result = goodData.single + goodData.double + goodData.triple
}

