package models
class Forward(name: String):Player(
    name,
    attack = (70..100).random(),
    defense = (30..60).random()
)