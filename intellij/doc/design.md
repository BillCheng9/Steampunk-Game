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


participant "User" as user
participant "View" as view
participant "Controller" as control
participant "Enemy" as enemy
participant "Player" as player

control -> enemy : getName()
control -> view : displayStart()
view -> user : Display Start Info

loop p.healthCheck() && e.healthCheck()
activate view
activate control
activate player
activate enemy
activate user

control -> view : pHealth(int)
view -> user : Display Player Health
control -> view : eHealth(int)
view -> user : Display Enemy Health

control -> view : Input : grabInput()
view -> user : Display Prompt
user -> view : Return Action String
view -> control : Input executeAction

control -> view : pHealth(int)
view -> user : Display Player Health
control -> view : eHealth(int)
view -> user : Display Enemy Health

control -> enemy : pickAttack()
end

deactivate view
deactivate control
deactivate enemy
deactivate user
deactivate player

control -> view : combatResult(combat)
view -> user : Display Combat Results
control -> player : Update Stats
```
