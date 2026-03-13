# Soccer Match
This is a Kottlin console aplication that simulates a soccer match, in this project the user its allow to custom the name of the teams, the program assigns automatically a tactical role to players and finally  resolves
the game round based on individual atributes: attak and defense.

### Prerequisites
To run this proyect:
- Java JDK
- Kotlin Compiler or IntelliJ 

### Instalation and Execution

1. Clone this repository to your machine
2. Open the proyect in your IDE
3. Locate and run the 'main.kt' file

### How to play 
 Once the program is runing, the console will guide you step by step
 1. You going to see in console the message:
```
-------Welcome to the soccer game!---------
Please select a number between 5-10. This is going to be the number of players for the teams:
```
Please write a number that meets the condition, for example: *5*

2. The console going to ask you what is the name to your first Team, please write a name, for example: *Team A*
3. In this step the console show you the number of players and the role assined before, remember always we need one player in each role, for example
```
player 1 Midfielder
player 2 Defender
player 3 Forward
player 4 Defender
player 5 Defender
```
4. The game simulates the match round-by-round, displaying the attacker vs. defender matchups and updating the score in real-time, for Example:

```
The teams are attack A Vs Defender B
Round# 1 the players attack: 1 Vs Defender 1
For the team B the player 1 is a genius

The teams are attack B Vs Defender A
Round# 2 the players attack: 2 Vs Defender 2
For the team A the player 2 is a genius

The teams are attack A Vs Defender B
Round# 3 the players attack: 3 Vs Defender 3
For Team A The player 3 Scored!!

The teams are attack B Vs Defender A
Round# 4 the players attack: 4 Vs Defender 4
For the team A the player 4 is a genius

The teams are attack A Vs Defender B
Round# 5 the players attack: 5 Vs Defender 5
For the team B the player 5 is a genius
-------------------------------------------
The final score is A: 3 - B: 2
```
### Architecture
The project strictly follows the **Model-View-Controller (MVC)** architectural pattern to separate business logic from data entities.

##  Estructura del Proyecto

```text
soccer-simulator/
├── controller/
│   └── GameController.kt
├── models/
│   ├── Defender.kt
│   ├── Forward.kt
│   ├── Match.kt
│   ├── Midfielder.kt
│   ├── Player.kt
│   └── Team.kt
├── main.kt
└── README.md
```
##  Models (`/models`)
Data classes and entities that represent the core components of the game.

* **`Player`** (Abstract): The base class for all players, defining `name`, `attack`, and `defense` stats.
  * **Inheritance:** Implemented by `Defender`, `Midfielder`, and `Forward`, each initializing with different stat weights.
* **`Team`**: Represents a playing side, containing a `name` and a list of `Player` objects.
* **`Match`**: Holds the current state of the game, including the two competing teams and the ongoing `score1` and `score2`.

##  Controller (`/controller`)
The `MatchController` acts as the brain of the simulator, encapsulating all game rules and entity creation.

##  Methods:
* **`createTeam(name: String, numberPlayers: Int): Team`**
  Generates a team using a randomized "role pool" system. It guarantees the inclusion of core roles before filling the remaining spots randomly and shuffling the final lineup.
* **`playMatch(match: Match)`**
  Handles the turn-based loop. It calculates the total rounds based on team size and alternates the attacking team (Team 1 attacks on even rounds, Team 2 on odd rounds).
* **`resolveRound(...)`** *(Private)*
  The core calculation engine. It compares the attacker's `attack` stat against the defender's `defense` stat to determine if a goal is scored or blocked.
