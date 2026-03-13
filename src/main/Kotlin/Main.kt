import controller.MatchController
import models.Match



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

    val matchController = MatchController()
    println("Please write the name for the first team")
    var name = readln()


    val teamA = matchController.createTeam(name, numberPlayers)

    println("----------------------------------------")
    println("Please write the name for the second team")
    name = readln()
    println("Now the players for the team $name:")

    // Usamos la misma instancia para el segundo equipo
    val teamB = matchController.createTeam(name, numberPlayers)

    // 3. SEGUNDO PASO CLAVE: Creamos el modelo Match con los equipos, NO el controlador
    val match = Match(teamA, teamB)

    // 4. Le pedimos al controlador que juegue el partido que acabamos de crear
    matchController.playMatch(match)
}