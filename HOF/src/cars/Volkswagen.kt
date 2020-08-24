package cars

class Volkswagen {
    private val name = "VOLKSWAGEN"

    fun drive(carObserver: (String) -> Unit){
        //functions drives the car

        carObserver.invoke(name)
    }
}