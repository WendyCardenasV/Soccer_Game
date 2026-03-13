import controller.Match
import controller.createTeam



fun main() {
    var numberPlayers = 0
    println("-------Welcome to the soccer game!---------")
    while (true) {
        println("Please select a number between 5-10. This is going to be the number of players for the teams:")
        numberPlayers = readln().toInt()
        if (numberPlayers in 5..10) {
            break
        } else {
            println("Error: Invalid number. Let's try again!!!.\n")
        }
    }
    println("Please write the name for the first team")
    var name = readln()
    val teamA=createTeam(name,numberPlayers)
    println("----------------------------------------")
    println("Please write the name for the second team")
    name = readln()
    println("Now the players for the team $name:")
    val teamB = createTeam(name,numberPlayers)
    val match = Match(teamA, teamB)
    match.playMatch()
}