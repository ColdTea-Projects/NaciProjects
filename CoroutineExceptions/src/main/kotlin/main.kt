import kotlinx.coroutines.*

fun main(args: Array<String>) {
    System.setProperty("kotlinx.coroutines.debug", "on" )
//    example1() // simple coroutine
//    example2() // simple job
//    example3() // parent cancelled
//    example4() // child cancelled
//    example5() // dispatchers
//    example6() // combined context

//    tryCatch()
//    coroutineExceptionHandler()
//    launchVsAsync()
//    propagatedExceptionThroughCoroutineScope()
    exceptionHandlingPropertiesOfSupervisorScope()
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

fun tryCatch() {
    val topLevelScope = CoroutineScope(Job())
    topLevelScope.launch {
        try {
//            launch {
            throw RuntimeException("RuntimeException in nested coroutine")
//            }
        } catch (exception: Exception) {
            println("Handle $exception")
        }
    }
    Thread.sleep(100)
}

fun coroutineExceptionHandler(){
    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, exception ->
        println("Handle $exception in CoroutineExceptionHandler")
    }

    val topLevelScope = CoroutineScope(Job()) //+ coroutineExceptionHandler

    topLevelScope.launch { //(coroutineExceptionHandler)
        launch(coroutineExceptionHandler) {
            throw RuntimeException("RuntimeException in nested coroutine")
        }
    }

    Thread.sleep(100)
}

fun launchVsAsync(){
    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, exception ->
        println("Handle $exception in CoroutineExceptionHandler")
    }

    val topLevelScope = CoroutineScope(Job() + coroutineExceptionHandler)

    topLevelScope.async { //val defferedResult =
        throw RuntimeException("RuntimeException in async coroutine")
    }

//    topLevelScope.launch {
//        defferedResult.await()
//    }

    Thread.sleep(100)
}

fun propagatedExceptionThroughCoroutineScope(){
    CoroutineScope(Job()).launch {
        try {
            coroutineScope {
                launch { //coroutineScope around this
                        throw RuntimeException("RuntimeException in nested coroutine")
                    }
            }
        } catch (exception: Exception) {
            println("Handle $exception")
        }
    }

    Thread.sleep(100)
}

fun exceptionHandlingPropertiesOfSupervisorScope(){
    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, exception ->
        println("Handle $exception in CoroutineExceptionHandler")
    }

    val topLevelScope = CoroutineScope(Job())

    topLevelScope.launch {
        val job1 = launch {
            println("starting Coroutine 1")
        }

        supervisorScope {
            val job2 = launch(coroutineExceptionHandler) {
                println("starting Coroutine 2")
                throw RuntimeException("Exception in Coroutine 2")
            }

            val job3 = launch {
                println("starting Coroutine 3")
            }
        }
    }

    Thread.sleep(100)
}

