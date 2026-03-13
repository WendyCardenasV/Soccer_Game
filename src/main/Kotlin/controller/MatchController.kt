package controller

import models.*

class MatchController (val team1: Team,val team2: Team) {

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
        println("the final score is ${team1.name}: ${Match.score1} - ${team2.name}: $score2")
    }
}

fun createPlayer(number: Int, rolAsignado: Int): Player {

    return when (rolAsignado) {
        1 -> Defender(number.toString())
        2 -> Midfielder(number.toString())
        else -> Forward(number.toString())
    }
}

fun createTeam(name: String, numberPlayers: Int): Team {

    val bolsaDeRoles = mutableListOf(1, 2, 3)
    val papelesFaltantes = numberPlayers - 3

    for (i in 1..papelesFaltantes) {
        val rolAlAzar = (1..3).random()
        bolsaDeRoles.add(rolAlAzar)
    }

    bolsaDeRoles.shuffle()

    val players = mutableListOf<Player>()

    for (i in 0 until numberPlayers) {
        val numeroDeJugador = i + 1
        val papelQueLeToco = bolsaDeRoles[i]

        players.add(createPlayer(numeroDeJugador, papelQueLeToco))
    }

    return Team(name, players)
}
