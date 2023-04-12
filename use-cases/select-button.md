## Combat Button System: Heavy Attack, Light Attack, Use Pet, Open Bag, Run Away
Heavy Attack: Sends heavy_attack instruction to controller

Light Attack: Sends light_attack instruction to controller

Use Pet: Sends pet instruction to controller

Open Bag: Sends inventory instruction to controller

Run Away: Sends flee instruction to controller

## Main Menu Button System: ##
Continue: Creates a new combat
Quit: Exits app

## Start Menu Button System: ##
Start: Creates new Player character, opens up main menu
Help: Opens up the help menu

## Help Menu Button System: ##
Exit: Returns to start menu

### Color Code

    Player: Lavender
    CPU: Pink

```plantuml
<style>
diamond {
  BackgroundColor lavender
}
</style>

title Button Menu

start
while (Start Menu) is (Help)
#pink:Help Menu;
endwhile (Start)
while (Main Menu) is (Continue)
while (Combat Menu) is (Combat)
#pink:Controller executes;
endwhile
endwhile (Quit)

stop
```
