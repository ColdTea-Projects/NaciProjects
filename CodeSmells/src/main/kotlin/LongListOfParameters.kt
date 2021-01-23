
class LongListOfParameters{
    //Don't
    val serviceProviderName = "Naci"
    val serviceProviderAge = 32
    val serviceProviderAddress = "Alexanderstr. 3 10178 Berlin"

    val serviceProvider = ServiceProvider("Naci", 32, "Alexanderstr. 3 10178 Berlin")

    fun runTheFunction(){
        val five = giveMeFive()
        val doubleFive = giveMeDoubleFive()
        theFunctionWeWantToCall(serviceProviderName, serviceProviderAge, serviceProviderAddress, five, doubleFive)

        theBetterWayToDo(serviceProvider)
    }

    fun theFunctionWeWantToCall(serviceProviderName: String, serviceProviderAge: Int, serviceProviderAddress: String,five: Int, doubleFive: Double){
        println("$serviceProviderName - $serviceProviderAge - $serviceProviderAddress - $five - $doubleFive")
    }

    fun theBetterWayToDo(serviceProvider: ServiceProvider){
        println("${serviceProvider.name} - ${serviceProvider.age} - ${serviceProvider.address} - ${giveMeFive()} - ${giveMeDoubleFive()}")
    }

    fun giveMeFive() = 5
    fun giveMeDoubleFive() = 5.0

}