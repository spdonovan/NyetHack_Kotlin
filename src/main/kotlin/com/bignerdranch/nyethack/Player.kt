package com.bignerdranch.nyethack

class Player(initialName: String, val homeTown: String, var healthPoints: Int, val isImmortal: Boolean)
{
    var name = initialName
    get() = field.replaceFirstChar { it.uppercase() }
    private set(value) { field = value.trim() }


    val title: String
    get() = when {
            name.all { it.isDigit() } -> "The Identifiable"
            name.none { it.isLetter() } -> " The Witness Protection Member"
            name.count { it.lowercase() in "aeiou" } > 4 -> "The Master of Vowels"
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

    fun castFireBall(numFireBalls: Int = 2) {
        narrate("A glass of Fireball springs into existence (x$numFireBalls)")
    }

    fun changeName(newName: String) {
        narrate("$name legally changes their name to $newName")
        name = newName
    }
}