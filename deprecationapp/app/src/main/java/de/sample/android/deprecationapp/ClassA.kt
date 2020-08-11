package de.sample.android.deprecationapp

class ClassA {
    private val a = "Android is"
    private val b = "better than the others"

    @Deprecated(
        level = DeprecationLevel.WARNING,
        message = "this functions tells the truth no matter what, so it is not wise to use! Please use ClassB.getMessage!",
        replaceWith = ReplaceWith(
            "ClassB.getTheMessage(isThereAnIOSDeveloperAround)",
            "com.example.myanimation.ClassB"
        )
    )
    fun getTheMessage(isThereAnIOSDeveloperAround: Boolean): String {
        return a + " " + b
    }
}