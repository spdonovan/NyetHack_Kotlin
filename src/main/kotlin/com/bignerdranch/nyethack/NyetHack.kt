package com.bignerdranch.nyethack
var player = Player("Jason", "Jacksonville", 100, false)

fun main() {
    //changeNarratorMood()
    val mortality = if (player.isImmortal) "an immortal" else "a mortal"
    narrate("${player.name} of ${player.homeTown} ${player.title}, heads to the town square")
    narrate("${player.name}, $mortality, has ${player.healthPoints} health points")
    visitTavern()
    player.castFireBall()
}

private fun promptHeroName(): String {
    narrate("A hero enters the town of Kronstadt. What is their name?")
    { message -> "\u001b[33;1m$message\u001b[0m" }

    /*val input = readLine()
    require(input != null && input.isNotEmpty()) {
    "The hero must have a name."
    }
    return input*/
    println("Madrigal")
    return "Madrigal"
}


