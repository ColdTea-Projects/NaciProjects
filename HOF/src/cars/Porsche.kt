package cars

class Porsche {
    private val name = "PORSCHE"

    fun drive(carObserver: (String) -> Unit){
        //functions drives the car

        carObserver.invoke(name)
    }
}