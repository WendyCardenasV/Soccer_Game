package game

import models.Player
import models.Team

class Match (val team1: Team,val team2: Team) {
 var score1 = 0
 var score2 = 0
        fun selectRol(player1: Player, player2: Player, i: Int) {
        println("los equipos son attack $player1 Vs Defender $player2")
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
                selectRol(attacker, defender, i)
            }else{
                val attacker = team2.players[i]
                val defender = team1.players[i]
               selectRol(attacker, defender, i)
            }
        }
        println("the final score is ${team1.name}: $score1 - ${team2.name}: $score2")
    }
}
