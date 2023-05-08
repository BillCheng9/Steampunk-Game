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

!theme spacelab
participant "User" as user
participant "View" as view
participant "Controller" as control
participant "Enemy" as enemy
participant "Player" as player
participant "Item" as item

group #gray Start Activity
control -> view : setContentView(startScreen)
view -> user : Display Start Menu
user -> view : Click help button
view -> control : helpClick()
end

group #gray Help Activity
control -> view : setContentView(helpScreen)
view -> user : Display Help Menu
user -> view : Click back button
view -> control : backClick()
end

group #gray Start Activity
control -> view : setContentView(startScreen)
view -> user : Display Start Menu
user -> view : Click start button
view -> control : startClick()
end

group #gray Main Activity
control -> view : setContentView(combatScreen)
control -> enemy : enemyRecon()
view -> user : Display Combat Menu

group #gray Player Attack
user -> view : Click attack
view -> control : lightAttackClick()
control -> player : p.attack1()

group #gray Hit
control -> enemy : e.attacked()
control -> view : displayPlayerAttack()
control -> view : renewEHealth()
end

group #gray Miss
control -> view : displayPlayerAttack()
end

control -> enemy : e.healthCheck()
control -> player : p.healthCheck()
end

view -> user : Show attack results
user -> view : Click dialogue
view -> control : continueClick()

group #gray Enemy Attack
control -> enemy : e.pickAttack()

group #gray Hit
control -> enemy : p.attacked()
control -> view : displayEnemyAttack()
control -> view : renewHealth(p)
end

group #gray Miss
control -> view : displayEnemyAttack()
end

control -> enemy : e.healthCheck()
control -> player : p.healthCheck()

end
view -> user : Show attack results

user -> view : Click inventory button
view -> control : switchActivitiesInventory()
end

group #gray Inventory Activity
control -> view : setContentView(inventory)
view -> user : Display inventory
user -> view : Click steel plates button
view -> control : plates1Click()
control -> player : p.steel
control -> item : plate1.displayStats()
control -> view : displayPlate1(p)
view -> user : Display plate stats
user -> view : Click back button
view -> control : backClick()
end

group #gray Main Activity
control -> view : setContentView(combatScreen)
view -> user : Display combat menu
user -> view : Click flee button
view -> control : fleeClick()

group #gray Flee
control -> player : p.flee()
control -> view : DisplayFlee(boolean)
view -> user : Displays Flee Result
end

user -> view : Click dialogue
view -> control : switchActivitiesContinue()

end

group #gray Continue Activity
control -> view : setContentView(menu)
view -> user : Display Continue Menu
user -> view : Click workshop button
view -> control : switchActivitiesWorkshop()
end

group #gray Workshop Activity
control -> view : setContentView(workshop)
view -> user : Display Workshop Menu
user -> view : Click tungsten plates
view -> control : plates2Click()
control -> view : displayPlate2()
view -> user : Displays Tungsten Plate Information
user -> view : Click buy button
view -> control : buyClick()

group #gray Can't Afford
control -> view : displayBroke()
view -> user : Can't afford message
end

group #gray Can Afford
control -> item : getCost()
control -> item : getDefenseChange()
control -> view : displayBuyDEF()
view -> user : Displays success
end

user -> view : Click back button
view -> control : backClick()
end

group #gray Continue Activity
control -> view : setContentView(menu)
view -> user : Display Continue Menu
user -> view : Click continue button
view -> control : switchActivitiesContinue()
end
```
