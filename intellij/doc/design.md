## CLASS DIAGRAM
```plantuml
hide Menu
hide empty methods

' classes
class MainActivity{
...
--
onCreate(Bundle)
+healthChecker()
+enemyTurn()
+lightClick()
+heavyClick()
+petClick()
+invClick()
+fleeClick()
+continueClick()
+dialogueClick()
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

Enemy <|.. Bug
Enemy <|.. Golem
Enemy <|.. Rock
Enemy <|.. Worker

class CombatScreen{
Binding
Listener
Dialogue
Stat Bar
Dialogue Bar
Combat Dialogue
Player Dialogue
Combat Enemy Dialogue
Damage Dialogue
--
CombatScreen(Context, Listener, Player, Enemy)
}
interface StatBar{
Name
Max
--
getName() : String
getCur() : Int
getmax() : Int
toString() : String
}

StatBar <|.. ArmorStat
StatBar <|.. ExpStat
StatBar <|.. GearStat
StatBar <|.. HealthStat
StatBar <|.. eArmorStat
StatBar <|.. eHealthStat

CombatDialogue -> Enemy
MainActivity "0" -up- "1" Player : Contains
MainActivity "0" -down- "1" Enemy : Contains
MainActivity "0" .left-> "1" CombatDialogue : Input From
MainActivity "0" -up- "1" PlayerDialogue : Outputs
CombatScreen "0" -down- "1" StatBar : Contains
MainActivity "0" -right- "1" CombatScreen : Displays
```

## SEQUENCE DIAGRAM
```plantuml

participant "User" as user
participant "View" as view
participant "Controller" as control
participant "Enemy" as enemy
participant "Player" as player

control -> view : dialogueClickable(false)
control -> view : displayStart()
view -> user : Display Combat Menu
user -> view : Clicks Action Button

group Light Attack
view -> control : lightAttackBTN
control -> player : p.attack1()
group Hit
control -> enemy : e.attacked()
control -> view : displayPlayerAttack()
control -> view : renewEHealth()
end
group Miss
control -> view : displayPlayerAttack()
end
control -> enemy : e.healthCheck()
control -> player : p.healthCheck()
end

group Heavy Attack
view -> control : heavyAttackBTN
control -> player : p.attack2()
group Hit
control -> enemy : e.attacked()
control -> view : displayPlayerAttack()
control -> view : renewEHealth()
end
group Miss
control -> view : displayPlayerAttack()
end
control -> enemy : e.healthCheck()
control -> player : p.healthCheck()
end

group Flee
view -> control : fleeBTN
control -> player : p.flee(0
control -> view : DisplayFlee(boolean)
view -> user : Displays Flee Result
end

control -> view : displayEndWin()
view -> user : Displays End Screen
```
