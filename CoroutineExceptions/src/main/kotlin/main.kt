import kotlinx.coroutines.*

fun main(args: Array<String>) {
    System.setProperty("kotlinx.coroutines.debug", "on" )
//    example1() // simple coroutine
//    example2() // simple job
//    example3() // parent cancelled
//    example4() // child cancelled
//    example5() // dispatchers
    example6() // combined context

}

fun example1() =
    runBlocking {
        println("runBlocking ${Thread.currentThread()}")
        launch {
            println("launch ${Thread.currentThread()}")
        }
        println("runBlocking2 ${Thread.currentThread()}")
    }

fun example2() =
    runBlocking {
        val job = launch {
            try {
                println("launch job")
                delay(1000)
                println("finish job")
            } catch (e: CancellationException) {
                println("cancel job")
            }
        }
        yield() // immediately executes launch
        job.cancel()
    }

fun example3() = runBlocking {
    val parentJob = launch {
        try {
            println("launch parent job")
            val childJob = launch {
                try {
                    println("launch child job")
                    delay(1000)
                    println("finish child job")
                } catch (e: CancellationException) {
                    println("cancel child job")
                }
            }
            delay(1000)
            println("finish parent job")
        } catch (e: CancellationException) {
            println("cancel parent job")
        }
    }
    delay(500)
    parentJob.cancel()
}

fun example4() = runBlocking {
    val parentJob = launch {
        try {
            println("launch parent job")
            val childJob = launch {
                try {
                    println("launch child job")
                    delay(1000)
                    println("finish child job")
                } catch (e: CancellationException) {
                    println("cancel child job")
                }
            }
            delay(500)
            childJob.cancel()
            delay(500)
            println("finish parent job")
        } catch (e: CancellationException) {
            println("cancel parent job")
        }
    }
}

fun example5() = runBlocking(Dispatchers.IO) {
    println("runBlocking ${Thread.currentThread()}")
    launch(Dispatchers.Main) {
        println("launch 1 ${Thread.currentThread()}")
    }
    launch() {
        println("launch 2 ${Thread.currentThread()}")
    }
    yield()
    println("runBlocking pos-yield ${Thread.currentThread()}")
}

fun example6() = runBlocking(Dispatchers.IO + CoroutineName("TestCoroutine")) {
    println("runBlocking ${Thread.currentThread()}")
}