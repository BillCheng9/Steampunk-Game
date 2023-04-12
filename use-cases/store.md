## Store

Store allows the player to buy items to increase stats

Items purchased will be removed from the Store object if non-consumable

Consumables will be added to player inventory

### Color Code

    Player: Lavender
    CPU: Pink
    
```plantuml
<style>
diamond {
  BackgroundColor lavender
}
</style>

title Store

start
#pink:Display store options;
switch (Selects purchase)
case (Item)
#pink:Applies effects;
#pink:Removes from store;
case (Consumable)
#pink:Adds to inventory;
endswitch

stop
```
