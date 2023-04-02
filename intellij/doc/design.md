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
