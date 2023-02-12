## Player Combat System: Attack #1, Attack #2, Open Inventory, Flee, Activate Pet
Attack #1: Inflicts damage/effect on opponent based on slotted attack
Attack #2: Inflicts damage/effect on opponent based on slotted attack
Open Inventory: Choose from all available consumables
Flee: Rolls a random chance to escape: Succeed - flee, Fail - skip turn
Activate Pet: Activates pet's special ability, puts it on cooldown
## Computer Combat System: Random short attacks, Charges long attack, Stat increase
Random short attacks: Quantity and exact effect of attacks vary based on enemy
Charges long attack: Strong enemies and bosses may be able to contribute charge towards a large attack that will be more powerful
Stat increase: Enemies may increase a specific stat for the rest of combat
## Combat End: Victory, Defeat
Victory: If the enemy's armor reaches 0, victory dialogue and gears gain
Defeat: If player's armor reaches 0, defeat dialogue and gears loss. Possible screen blackout.

<!-->
@startuml
<style>
diamond {
  BackgroundColor White
}
</style>

title Combat

start
while (Both Alive?) is (yes)
if (Whose Turn?) then (Player)
#pink:Print combat options;
switch (Player Input)
case (Attack #1 and #2)
#pink:Damage/effects dealt to enemy;
case (Inventory)
#pink:Displays inventory;
case (Flee)
#pink:Generates random chance to flee;
if (Successful?) then (Yes)
#pink:Combat End;
else (No)
endif
case (Pet)
#pink:Activates pet effect;
endswitch
else (Computer)
#lavender:Player taps/returns to continue;
endif
endwhile (no)
if (Result) then (Victory)
#pink:Victory dialogue output, gain gears;
else (Defeat)
#pink:Defeat dialogue, gears loss, screen fade;

stop
@enduml
