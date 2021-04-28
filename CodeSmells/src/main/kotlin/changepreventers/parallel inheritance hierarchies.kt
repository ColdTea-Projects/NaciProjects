package changeoreventers

interface SmartPhone{
    fun ring()
}

open class Android():SmartPhone{
    override fun ring() {
        TODO("Not yet implemented")
    }
}

class IPhone():SmartPhone{
    override fun ring() {
        TODO("Not yet implemented")
    }

}


/////////////

interface ScreenProtector{
    var size:Int
    fun stick()
}

open class AndroidScreenProtector(override var size: Int = 10) : ScreenProtector{
    override fun stick() {
        TODO("Not yet implemented")
    }
}

open class IPhoneScreenProtector(override var size: Int = 11) : ScreenProtector{
    override fun stick() {
        TODO("Not yet implemented")
    }
}


/////////Other Androids come in//////

class LG: Android(){}
class HTC : Android(){}

class LGScreenProtector: AndroidScreenProtector() {
    init {
        size = 13
    }
}
class HTCScreenProtector: AndroidScreenProtector(){
    init {
        size = 15
    }}

// Better would be//////

open class BetterAndroid():SmartPhone{
    protected var screenProtector = AndroidScreenProtector()

    override fun ring() {
        TODO("Not yet implemented")
    }
}

class BetterLG(): BetterAndroid(){
    init {
        lgscreenProtector = AndroidScreenProtector(13)
    }
}

class BetterHTC: BetterAndroid(){
    init {
        screenProtector = AndroidScreenProtector(15)
    }
}


