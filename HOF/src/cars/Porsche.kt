package cars
typealias StringToUnit = (String) -> Unit

class Porsche {
    private val name = "PORSCHE"

    fun drive(carObserver: StringToUnit){
        //functions drives the car
        carObserver.ext()
        carObserver(name)
    }

    fun ((String) -> Unit).ext(){
        println("type aliased and extended")
    }
}