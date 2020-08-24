package de.sample.android.dslalertdialog

data class Example(var isExample: Boolean = false, var exampleNumber: Int = 0)

//fun example(exampleLambda: (Example) -> Unit): Example{
//    val example = Example()
//    exampleLambda(example)
//    return example
//}

fun example(exampleLambda: Example.() -> Unit): Example{
    val example = Example()
    example.exampleLambda()
    return example
}

fun run(){
//    val ex = Example(true, 0)
//        example{
//            it.isExample = true
//            it.exampleNumber = 0
//        }
    example {
        isExample = true
        exampleNumber = 0
    }
}

fun myDialogBuilder(lambda: MyDialogBuilder.() -> Unit) =
    MyDialogBuilder().apply(lambda).build()

