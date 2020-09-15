sealed class SuperHero(val name: String) {
    object Aquaman: SuperHero("Arthur")

    data class Wonderwoman(val says: String, val gadgets: List<String>): SuperHero("Diana")
    data class Superman(val capeColor: String, val says: String): SuperHero("Clark")

    class Batman(val capeColor: String, val says: String, val gadgets: List<String>): SuperHero("BATMAAAAAN")
    {
        val gadgetsAsString: String by lazy {
            gadgets.joinToString()
        }
    }
}