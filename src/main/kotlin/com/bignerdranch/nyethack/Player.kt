package com.bignerdranch.nyethack


class Player(initialName: String, val homeTown: String, override var healthPoints: Int, val isImmortal: Boolean)
    :Fightable {

    override var name = initialName
    get() = field.replaceFirstChar { it.uppercase() }
    private set(value) { field = value.trim() }
    override val diceCount = 3
    override val diceSides = 4

    override fun takeDamage(damage: Int) {
        if (!isImmortal) {
            healthPoints -= damage
        }
    }


    val title: String
    get() = when {
            name.all { it.isDigit() } -> "The Identifiable"
            name.none { it.isLetter() } -> " The Witness Protection Member"
            name.numVowels > 4 -> "The Master of Vowels"
            else -> "The Renowned Hero"
        }

    init {
        require(healthPoints > 0) { "healthpoints must be greater than zero" }
        require(name.isNotBlank()) { "Player must have a name" }
    }

    constructor(name: String) : this(
        initialName = name,
        homeTown = "Neversummer",
        healthPoints = 100,
        isImmortal = false
    ) {
        if (name.equals("Jason", ignoreCase = true)) {
            healthPoints = 500
        }
    }

    val prophecy by lazy {
        narrate("$name embarks on an arduous quest to locate the fortune teller")
        Thread.sleep(3000)
        narrate("The fortune teller bestows a prophecy upon $name")

        "An intrepid hero from $homeTown shall one day " + listOf(
            "form an unlikely bond between two warring factions",
            "take possession of an otherworldly blade",
            "bring the gift of creation back to the world",
            "best the world-eater"
        ).random()
    }
val inventory = mutableListOf<Loot>()
    var gold = 0

    fun castFireBall(numFireBalls: Int = 2) {
        narrate("A glass of Fireball springs into existence (x$numFireBalls)")
    }

    fun changeName(newName: String) {
        narrate("$name legally changes their name to $newName")
        name = newName
    }

    fun prophesize() {
        narrate("$name thinks about their future")
        narrate("A fortune teller told Madrigal, \"$prophecy\"")
    }
}