package de.sample.android.deprecationapp

class ClassB {
    companion object{
        private val a = "Android is"
        private val b = "better than the others \uD83D\uDE08"

        private val fallbackMessage = "All good guys, nothing interesting to see \uD83D\uDE17 \uD83C\uDFB6"
        fun getTheMessage(isThereAnIOSDeveloperAround: Boolean) : String{
            return if(isThereAnIOSDeveloperAround) fallbackMessage else "$a $b"
        }
    }
}