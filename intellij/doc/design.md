## CLASS DIAGRAM
```plantuml
!theme spacelab
hide Menu
hide empty methods

' classes
class MainActivity #PowderBlue{
...
--
onCreate(Bundle)
+enemyRecon() : Enemy
+enemyPicker() : Enemy
+healthChecker()
+enemyTurn()
+lightClick()
+heavyClick()
+invClick()
+fleeClick()
+continueClick()
+dialogueClick()
+endCombat()
+winCombat()
+switchActivitiesInventory()
+switchActivitiesContinue()
+switchActivitiesMenu()
}
class StartMenuActivity #PowderBlue{
...
--
onCreate(Bundle)
+onDestroy()
+startClick()
+helpClick()
+switchActivities()
}
class HelpActivity #PowderBlue{
...
--
onCreate(Bundle)
+onDestroy()
+backClick()
+switchActivities()
}
class ContinueActivity #PowderBlue{
...
--
onCreate(Bundle)
+continueClick()
+workshopClick()
+switchActivitiesContinue()
+switchActivitiesWorkshop()
}
class InventoryActivity #PowderBlue{
...
--
onCreate(Bundle)
+backClick()
+switchActivities()
+plates1Click()
+plates2Click()
+plates3Click()
+nanites1Click()
+nanites2Click()
+nanites3Click()
+gauntlets1Click()
+implants1Click()
+illegal1Click()
}
class WorkshopActivity #PowderBlue{
steelPlate
tungPlate
chromPlate
xt1
xt3
xtp
gauntlet
implants
illegal
--
onCreate(Bundle)
+backClick()
+switchActivities()
+plates1Click()
+plates2Click()
+plates3Click()
+nanites1Click()
+nanites2Click()
+nanites3Click()
+gauntlets1Click()
+implants1Click()
+illegal1Click()
+healClick()
+buyClick()
}
class CombatDialogue #DodgerBlue{
Enemy
Dialogue
--
CombatDialogue(Enemy)
CombatDialogue()
CombatDialogue(int)
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
+displaySentry_S()
+displayProtectron_S()
+displayWatcher_S()
+displayBot_S()
+displayTGolem_S()
+displayPrompt()
+displayFlee_F()
+displayFlee_T()
+displayLose()
+displayWin()
+displayDamage()
+displayEnemyDamage()
}
class Player #MediumSlateBlue{
Health
Defense
Damage
Gears
Experience
MaxHealth
GearMult
GearScore
--
+lightAttack() : int
+heavyAttack() : int
+flee() : bool
+healthCheck() : bool
+attacked(int) : int
+onEnd(int)
+describeContents() : int
}
class PlayerDialogue #DodgerBlue{
dialogue
--
PlayerDialogue()
+displayPAL()
+displayPML()
+displayPHL()
+displayPAH()
+displayPMH()
+displayPHH()
+displayFlee()
}
interface Enemy #MediumSlateBlue{
Name
Defense
Health
Damage
Gear
--
getName() : String
getHealth() : String
attacked(int) : int
short_attack(int) : int
charge_attack(int) : int
increase_stat()
pickAttack() : int
healthCheck() : bool
getGear() : int
getDamage() : int
}
class Bug{}
class Golem{}
class Rock{}
class Worker{}

Enemy <|..down Bug
Enemy <|..down Golem
Enemy <|..down Rock
Enemy <|..down Worker
Enemy <|..down Bot
Enemy <|..down Drone
Enemy <|..down Protectron
Enemy <|..down Sentry
Enemy <|..down TGolem
Enemy <|..down Watcher

class CombatScreen #LightSkyBlue{
...
--
+displayStart()
+displayContinueText()
+removeContinueText()
+displayPlayerAttack(String, int, int)
+displayFlee(boolean)
+displayEnemyAttack(String, int, int, Enemy)
+displayEndLose()
+displayEndWin()
+dialogueClickable()
+buttonClickable()
+renewEHealth(Enemy)
+renewEArmor(Enemy)
+renewHealth(Player)
+renewExpGear(Player)
}
class HelpScreen #LightSkyBlue{
backBTN
--
}
class StartScreen #LightSkyBlue{
startBTN
helpBTN
--
}
class Inventory #LightSkyBlue{
goBackBTN
steelPlates
tungstenPlates
chromiumPlates
xt1Nanites
xt3Nanites
xtpNanites
mechaGauntlets
cbaImplants
ice
--
+displayPlate1(Player)
+displayPlate2(Player)
+displayPlate3(Player)
+displayNanites1(Player)
+displayNanites2(Player)
+displayNanites3(Player)
+displayGauntlets(Player)
+displayImplants(Player)
+displayIllegal(Player)
}
class MainMenu #LightSkyBlue{
continueBTN
storeBTN
--
}
class Workshop #LightSkyBlue{
goBackBTN
steelPlates
tungstenPlates
chromiumPlates
xt1Nanites
xt3Nanites
xtpNanites
gauntlets1
gauntlets2
illegal1
healBTN
buyBTN
--
+displayPlate1()
+displayPlate2()
+displayPlate3()
+displayNanite1()
+displayNanite2()
+displayNanites3()
+displayGauntlet()
+displayImplant()
+displayIllegal()
+displayWelcome()
+displayBuyATK()
+displayBuyDEF()
+displayBuyHP()
+displayBuyILLEGAL()
+displayBroke()
+displayHeal()
+displayCantHeal()
+displayGears(Player)
+displayHealBuy()
+btnVisibility()
}
interface StatBar #MediumSlateBlue{
Name
Max
--
getName() : String
getCur() : Int
getmax() : Int
toString() : String
}

StatBar <|..right ArmorStat
StatBar <|..right GearStat
StatBar <|..right HealthStat
StatBar <|..right eArmorStat
StatBar <|..right eHealthStat

interface Item #MediumSlateBlue{
Name
Description
Cost
Health Change
Defense Change
Gear Change
Damage Change
--
getName() : String
getCost() : Int
getDesc() : String
getHealthChange() : int
getDefenseChange() : int
getGearChange() : int
getDamageChange() : int
}


Item <|..up Plate1 
Item <|..up Plate2
Item <|..up Plate3
Item <|..up Nanites1
Item <|..up Nanites2
Item <|..up Nanites3
Item <|..up Gauntlets1
Item <|..up Implants1
Item <|..up Illegal1

StartMenuActivity "0" -right- "1" MainActivity : Continues to
StartMenuActivity "0" -left- "1" HelpActivity : Switches to
MainActivity "0" -right- "1" ContinueActivity : Continues to
MainActivity "0" -up- "1" InventoryActivity : Switches to
MainActivity "0" -down- "1" PlayerDialogue : Outputs
MainActivity "0" -down- "1" CombatScreen : Displays
MainActivity "0" .down-> "1" CombatDialogue : Input From
ContinueActivity "0" -right- "1" WorkshopActivity : Switches to
HelpActivity "0" -left- "1" HelpScreen : Displays
StartMenuActivity "0" -up- "1" StartScreen : Displays
InventoryActivity "0" -up- "1" Inventory : Displays
ContinueActivity "0" -right- "1" MainMenu : Displays
WorkshopActivity "0" -right- "1" Workshop : Displays
MainActivity "0" -down- "1" Enemy : Contains
CombatScreen "0" -right- "1" StatBar : Uses
MainMenu "0" -right- "1" StatBar : Uses
MainActivity "0" -up- "1" Player : Contains
InventoryActivity "0" -right- "1" Player : Contains
ContinueActivity "0" -up- "1" Player : Contains
WorkshopActivity "0" -up- "1" Player : Contains
InventoryActivity "0" -up- "1" Item : Contains
WorkshopActivity "0" -up- "1" Item : Contains
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
