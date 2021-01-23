package bloaters

class PrimitiveObsessionExample{
    //Don't
    val serviceProviderName = "Naci"
    val serviceProviderAge = 32
    val serviceProviderAddress = "Alexanderstr. 3 10178 Berlin"

    val serviceProvider = ServiceProvider("Naci", 32, "Alexanderstr. 3 10178 Berlin")

    fun runTheFunction(){
        theFunctionWeWantToCall(serviceProviderName, serviceProviderAge, serviceProviderAddress)

        theBetterWayToDo(serviceProvider)
    }

    fun theFunctionWeWantToCall(serviceProviderName: String, serviceProviderAge: Int, serviceProviderAddress: String){
        println("$serviceProviderName - $serviceProviderAge - $serviceProviderAddress")
    }

    fun theBetterWayToDo(serviceProvider: ServiceProvider){
        println("${serviceProvider.name} - ${serviceProvider.age} - ${serviceProvider.address}")
    }


}

data class ServiceProvider(var name: String, var age: Int, var address: String)