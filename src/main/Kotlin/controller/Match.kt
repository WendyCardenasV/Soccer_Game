package controller

import models.Defender
import models.Forward
import models.Midfielder
import models.Player
import models.Team



class Match (val team1: Team,val team2: Team) {
 var score1 = 0
 var score2 = 0

    fun selectRol(player1: Player, player2: Player, name1: String, name2: String, i: Int) {
        println("The teams are attack $name1 Vs Defender $name2")
        println("Round# ${i + 1} the players attack: ${player1.name} Vs Defender ${player2.name}")
        if (player1.attack > player2.defense) {
            score1 += 1
            println("${player1.name} Scored!!")
        } else if (player1.attack == player2.defense) {
            println("Nice!! This is a Draw")
        } else {
            println("${player2.name} it's a genius")
            score2 += 1
        }
    }

    fun playMatch(){
        val rounds = minOf(team1.players.size, team2.players.size)
        for (i in 0 until rounds){
            if(i%2 == 0) {
                val attacker = team1.players[i]
                val defender = team2.players[i]
                selectRol(attacker, defender,team1.name,team2.name, i)
            }else{
                val attacker = team2.players[i]
                val defender = team1.players[i]
               selectRol(attacker, defender,team2.name,team1.name, i)
            }
        }
        println("the final score is ${team1.name}: $score1 - ${team2.name}: $score2")
    }
}
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

fun createTeam(name: String, number: Int): Team {
    val players = mutableListOf<Player>()

    for (i in 1..number) {
        players.add(createPlayer(i))
    }

    return Team(name, players)
}


