## DOMAIN MODEL
```plantuml
hide Menu
hide empty methods

' classes
class Combat{
}
class Player{
Gears
Experience
}
interface Enemy{
}
class CurrentEnemy{
}
class Statistics{
Defense
Damage
Health
}

' associations
Combat "1" - "1" Player : \tUpdates\t\t
CurrentEnemy "1" -up- "1" Enemy : Implements\t
Combat "1" -left- "1" CurrentEnemy : \tUpdated-by\t\t
Player "1" -down- "1" Statistics : Describes\t\t
CurrentEnemy "1" -down- "1" Statistics : Described-by\t\t
Player "1" -up- "1" Inventory : Contained-in\t
Player "1" -down- "1" Result : Updated-by\t
```

## SEQUENCE DIAGRAM
```plantuml

participant ": Player" as player
participant ": System" as system
participant ": Enemy" as enemy

player -> system : inputValues(Player.Stats)
enemy -> system : inputValues(Enemy.Stats)

activate player
activate system
activate enemy

system -> player : updateUI(Player.Moves)
player -> system : doInput(Player.Moves)

system -> system : checkStats(Player.Stats, Enemy.Stats)

system -> enemy : pickMove(Enemy.Moves)
enemy -> system : doInput(Enemy.Moves)

system -> system : checkStats(Player.Stats, Enemy.Stats)

player <-> system : repeat
system <-> enemy : repeat

deactivate player
deactivate system
deactivate enemy

system -> player : updateUI(Combat.Results)
system -> player : updateStats(Combat.Results)
```
