## Player Combat System: Attack \#1, Attack \#2, Open Inventory, Flee, Activate Pet
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
Victory: If the enemy's health reaches 0, victory dialogue and gain gears 

Defeat: If player's health reaches 0, defeat dialogue and lose gears. Possible screen blackout.  

### Color Code

    Player: Lavender
    CPU: Pink

```plantuml
<style>
diamond {
  BackgroundColor White
}
</style>

title Execute Combat

start
while (Both Alive?) is (Yes)
if (Whose Turn?) then (Player)
#pink:Print combat options;
switch (Player Input)
case (Attack #1 and #2)
#pink:Damage/effects dealt to enemy;
case (Inventory)
#pink:Displays inventory;
#lavender:Selects inventory option;
#pink:Applies effects of selection;
case (Flee)
#pink:Generates random chance to flee;
if (Successful?) then (Yes)
stop
else (No)
endif
case (Pet)
#pink:Activates pet effect;
endswitch
else (Computer)
switch (CPU Input)
case (Short Attack)
#pink:Reduces player's armor;
case (Charge Attack)
#pink:Increment charge, attacks if charge=x;
case (Increase Stat)
#pink:Changes stat variables for enemy;
endswitch
endif
endwhile (No)
if (Result) then (Victory)
#pink:Victory dialogue output, gain gears;
else (Defeat)
#pink:Defeat dialogue, gears loss, screen fade;
endif

stop
```
