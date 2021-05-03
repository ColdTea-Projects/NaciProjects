fun main(args: Array<String>) {


    ///interface segregation
    connection(Line())
    connection(SecureLine())

}

fun connection(network: Network){
    network.connect()
}