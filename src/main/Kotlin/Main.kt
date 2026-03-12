package main

import game.Match
import models.Team
import models.Defender
import models.Midfielder
import models.Forward
import models.Player

fun main() {
    lateinit var teamA :Team
    lateinit  var teamB : Team

    fun createPlayer(number: Int): Player {
        println("Name of the player $number :")
        val name = readln()

        println("Select a type of the player:")
        println("1 - Defender")
        println("2 - Midfielder")
        println("3 - Forward")

        val type = readln().toInt()

        return when (type) {
            1 -> Defender(name)
            2 -> Midfielder(name)
            else -> Forward(name)
        }
    }
    println("-------Welcome to the soccer game!---------")
    println("Please select a number between 5-10 this going to be the number of players for the Team A:")
    val numberPlayersA =readln().toInt()

    if (numberPlayersA !in 5..10) {
        println("Number of players needs to be between 5 and 10")
        return
    }else {
        val playersA = mutableListOf<Player>()
        for (i in 1..numberPlayersA) {
            playersA.add(createPlayer(i))
        }
        teamA = Team("TeamA", playersA)
    }
    println("----------------------------------------")
    println("Now select a number between 5-10 this going to the number of players for the Team B:")

    val numberPlayersB =readln().toInt()
    if (numberPlayersB !in 5..10)  {
        println("Number of players needs to be between 5 and 10")
       return
    }else {
        val playersB = mutableListOf<Player>()
        for (i in 1..numberPlayersB) {
            playersB.add(createPlayer(i))
        }

        teamB = Team("TeamB", playersB)
    }

    val match = Match(teamA, teamB)
    match.playMatch()
}