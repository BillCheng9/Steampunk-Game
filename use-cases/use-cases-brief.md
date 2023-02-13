## Player
1) Combat
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

2) Character Movement
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

3) Dialogue Input
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

4) Pets System
```plantuml
<style>
diamond {
  BackgroundColor White
}
</style>

title Pets

start

#pink:Open pet inventory;
#lavender:Select active pet;
#pink:Dialogue output, stat changes;

stop
```

5) Button Selection
```plantuml
<style>
diamond {
  BackgroundColor White
}
</style>

title Button Selection

start

#pink:Displays valid inputs;
#lavender:Select button;
#pink:Translates selection to integer;
#pink:Feed to Game System;

stop
```

6) Leveling System

7) Character Creation


## System/Program
1) Maintenance of Stats and Game Values\

2) Responsive Changes\

3) Random Events\

