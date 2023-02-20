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
