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

3) Dialogue Input\

4) Pets System\

5) Button Selection\

6) Leveling System/Character Creation\


## System/Program
1) Maintenance of Stats and Game Values\

2) Responsive Changes\

3) Random Events\

