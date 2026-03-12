package models
class Midfielder(name: String): Player(
    name,
    attack = (50..80).random(),
    defense = (50..80).random()
)