package models
class Defender(name: String) : Player(
    name,
    attack = (30..60).random(),
    defense = (70..100).random()
)