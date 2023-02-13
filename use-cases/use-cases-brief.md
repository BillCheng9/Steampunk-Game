##Color Code
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

2) Move Character
```plantuml
<style>
diamond {
  BackgroundColor White
}
</style>

title Movement

start

while (Movement)
#pink:Computer outputs map;
#lavender:Player input;
#pink:Map update;
#pink:Checks for random event/encounter;
endwhile (Event)

stop
```

3) Read Dialogue
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

4) Choose Pet
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

5) Select Button
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

6) Leveling
```plantuml
<style>
diamond {
  BackgroundColor White
}
</style>

title Leveling

start

#pink:Congratulatory message, base increase to all stats;
#pink:Display categories to add level point to;
#lavender:Select category;
#pink:Modify category stat, increase exp threshold;

stop
```

7) Interface with Menu

## System/Program

1) Respond to Changes
```plantuml
<style>
diamond {
  BackgroundColor White
}
</style>

title Responsive Changes

start

#lavender:Some input;
#pink:Reads input, calls and modifies related object;


stop
@enduml
```

2) Play Random Event
```plantuml
<style>
diamond {
  BackgroundColor White
}
</style>

title Random Events

start

if (Random Number) then (Event)
#pink:Calls event method (Considers environment);
#lavender:Player response to event;
#pink:Applies effects of event;
else (No corresponding)
endif

stop
```

