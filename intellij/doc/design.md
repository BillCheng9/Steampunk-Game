## CLASS DIAGRAM
```plantuml
hide Menu
hide empty methods

' classes
class Combat{
...
--
Combat()
+getInput() : Input
+combatTurn() : String
}
class CombatDialogue{
Enemy
Dialogue
--
CombatDialogue(Enemy)
CombatDialogue()
CombatDialogue(int)
+grabInput() : Input
+displayStart()
+displayEAL()
+displayEML()
+displayEHL()
+displayEAH()
+displayEMH()
+displayEHH()
+displayBug_S()
+displayWorker_S()
+displayRock_S()
+displayRock_M()
+displayGolem_S()
+displayPrompt()
+displayInvalid()
+displayFlee_F()
+displayFlee_T()
+combatResult(String)
+displayEnemy()
+displayDamage()
+pHealth(int)
+eHealth(int)
}
class Player{
Health
Defense
Damage
Gears
Experience
--
+attack1() : int
+attack2() : int
+accessInv()
+triggerPet()
+flee() : bool
+healthCheck() : bool
+attacked(int) : int
}
class PlayerDialogue{
dialogue
--
PlayerDialogue()
+displayPAL()
+displayPML()
+displayPHL()
+displayPAH()
+displayPMH()
+displayPHH()
+displayInv()
+displayPet()
+displayFlee()
}
interface Enemy{
Name
Defense
Health
Damage
--
getName() : String
getHealth() : String
attacked(int) : int
short_attack(int) : int
charge_attack(int) : int
increase_stat()
pickAttack() : int
healthCheck() : bool
}
class Bug{}
class Golem{}
class Rock{}
class Worker{}
enum Input{
LIGHT
HEAVY
PET
INVENTORY
FLEE
}

Enemy <|.. Bug
Enemy <|.. Golem
Enemy <|.. Rock
Enemy <|.. Worker

CombatDialogue -> Enemy
Combat "0" -down- "1" Player : Contains
Combat "0" -down- "1" Enemy : Contains
Combat "0" .down-> "1" CombatDialogue : Input From
Combat -left-> Input
CombatDialogue -left-> Input
Combat "0" -down- "1" PlayerDialogue : Outputs
```

## SEQUENCE DIAGRAM
```plantuml

participant ": View" as view
participant ": Controller" as control
participant ": Model" as model

model -> control : Import Player Stats
control -> model : Picks enemy
model -> control : Import Enemy Stats
control -> view :Send Enemy Information
view -> control : Display Enemy

activate view
activate control
activate model

loop Until Combat End
control -> view : Send Current Health Update
view -> control : Display Player and Enemy Health
control -> view : Asks for player input
view -> control : Validates and returns input
control -> model : Executes Input
model -> control : Sends Action Result

control -> control : Check For End

control -> model : Executes Random Enemy Input
model -> control : Sends Action Result

control -> control : Check For End
end

deactivate view
deactivate control
deactivate model

control -> view : Report Combat End
view -> control : Display Combat Results
control -> model : Update Stats
```
