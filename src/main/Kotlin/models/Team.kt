package models

data class Team(
    val name: String,
    val players: MutableList<Player>
)