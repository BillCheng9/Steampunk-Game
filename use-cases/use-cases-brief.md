### Color Code

    Player: Lavender
    CPU: Pink

## Player
1) Execute Combat
```plantuml
<style>
diamond {
  BackgroundColor White
}
</style>

title Combat Brief

start

while (Combat)
#lavender:Player input;
#pink:CPU response;
endwhile (Combat End)

stop
```

2) Read Dialogue
```plantuml
<style>
diamond {
  BackgroundColor White
}
</style>

title Dialogue

start

while (More Dialogue)
#pink:Dialogue;
#lavender:Player input;
#pink:CPU Response;
endwhile (Dialogue End)

stop
```

3) Choose Pet
```plantuml
<style>
diamond {
  BackgroundColor White
}
</style>

title Choose Pet

start

#pink:Open pet inventory;
#lavender:Select active pet;
#pink:Dialogue output, stat changes;

stop
```

4) Select Button
```plantuml
<style>
diamond {
  BackgroundColor White
}
</style>

title Select Button

start

#pink:Displays valid inputs;
#lavender:Select button;
#pink:Translates selection to integer;
#pink:Feed to Game System;

stop
```

5) Store
```plantuml
title Store

start
#pink:Display store options;
#lavender:Selects purchase;
#pink:Applies effects;
#pink:Removes from store;
stop
```


## System/Program

1) Leveling
```plantuml
<style>
diamond {
  BackgroundColor White
}
</style>

title Leveling

start

#pink:Congratulatory message, base increase to all stats;
#pink:Modify category stat, increase exp threshold;

stop
```
