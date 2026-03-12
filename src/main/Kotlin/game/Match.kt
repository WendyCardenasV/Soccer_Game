package game

import models.Team

class Match (val team1: Team,val team2: Team) {
 var score1 = 0
 var score2 = 0

    fun playMatch(){
        val rounds = minOf(team1.players.size, team2.players.size)
        for (i in 0 until rounds){
            val attacker = team1.players[i]
            val defender = team2.players[i]
            println("Round# ${i+1} the players: ${attacker.name} Vs ${defender.name}")
            if (attacker.attack > defender.defense){
                score1 += 1
                println("${attacker.name} Scored!!")
            }else if (attacker.attack==defender.defense){
                println("Nice!! This is a Draw")
            }else{
                println("${defender.name} it's a genius")
                score2+=1
            }
        }
        println("the final score is ${team1.name}: $score1 - ${team2.name}: $score2")
    }
}
