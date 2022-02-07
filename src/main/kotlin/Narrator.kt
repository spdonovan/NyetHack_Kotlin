
    val narrationModifier: (String) -> String = {
        val numExclamationPoints = 3
        it.uppercase() + "!".repeat(numExclamationPoints)
    }

    fun narrate(
        message: String
    ) {
    println(narrationModifier(message))
}