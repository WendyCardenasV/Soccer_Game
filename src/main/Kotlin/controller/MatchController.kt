package controller

import models.*

class MatchController {

    fun createTeam(name: String, numberPlayers: Int): Team {
        val roles = mutableListOf(1, 2, 3)
        val missingRoles = numberPlayers - 3

        for (i in 1..missingRoles) {
            roles.add((1..3).random())
        }
        roles.shuffle()

        val players = mutableListOf<Player>()
        for (i in 0 until numberPlayers) {
            players.add(createPlayer(i + 1, roles[i]))
            if(roles[i]==1){
                println("player ${i+1} Defender")
            }else if(roles[i]==2){
                println("player ${i+1} Midfielder")
            }else{
                println("player ${i+1} Forward")
            }
        }

        return Team(name, players)
    }

    private fun createPlayer(number: Int, roleNumber: Int): Player {
        return when (roleNumber) {
            1 -> Defender(number.toString())
            2 -> Midfielder(number.toString())
            else -> Forward(number.toString())
        }
    }


    fun playMatch(match: Match) {
        val rounds = minOf(match.team1.players.size, match.team2.players.size)

        for (i in 0 until rounds) {
            if (i % 2 == 0) {

                val attacker = match.team1.players[i]
                val defender = match.team2.players[i]
                resolveRound(attacker, defender, match.team1.name, match.team2.name, i, match, isTeam1Attacking = true)
            } else {

                val attacker = match.team2.players[i]
                val defender = match.team1.players[i]
                resolveRound(attacker, defender, match.team2.name, match.team1.name, i, match, isTeam1Attacking = false)
            }
        }
        println("The final score is ${match.team1.name}: ${match.score1} - ${match.team2.name}: ${match.score2}")
    }

    private fun resolveRound(
        attacker: Player,
        defender: Player,
        attackerName: String,
        defenderName: String,
        roundIndex: Int,
        match: Match,
        isTeam1Attacking: Boolean
    ) {
        println("The teams are attack $attackerName Vs Defender $defenderName")
        println("Round# ${roundIndex + 1} the players attack: ${attacker.name} Vs Defender ${defender.name}")

        if (attacker.attack > defender.defense) {

            if (isTeam1Attacking) match.score1 += 1 else match.score2 += 1
            println("For Team $attackerName The player ${attacker.name} Scored!!\n")

        } else if (attacker.attack == defender.defense) {
            println("Nice!! This is a Draw\n")

        } else {
            println("For the team $defenderName the player ${defender.name} is a genius")

            if (isTeam1Attacking) match.score2 += 1 else match.score1 += 1
            println("\n")
        }
    }
}