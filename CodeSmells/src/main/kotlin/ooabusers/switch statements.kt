package ooabusers


class JuniorDev{
    fun work(salary: Int){}
}

class MidDev{
    fun work(salary: Int){}
}

class SeniorDev{
    fun work(salary: Int){}
}

fun getWorkDone(workerType: Int){
    when(workerType){
        1 -> JuniorDev().work(100)
        2 -> MidDev().work(150)
        3 -> SeniorDev().work(200)
    }
}

















////////////////////////////////////////
interface Employee{
    fun work()
}

class BetterJuniorDev: Employee{
    val requiredSalary = 100
    override fun work(){

    }
}

class BetterMidDev: Employee{
    val requiredSalary = 150
    override fun work(){

    }
}

class BetterSeniorDev: Employee{
    val requiredSalary = 200
    override fun work(){

    }
}

fun getWorkDoneBetter(employee: Employee){
    employee.work()
}
