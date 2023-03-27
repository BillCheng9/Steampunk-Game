#Read Dialogue

Brief description:
1) System outputs dialogue
2) Player continues by pressing the return key if no response is prompted
3) If response is needed, System outputs 3 dialogue choices and asks for player input
4) Player inputs response choice
5) System outputs dialogue corresponding with the player's choice
6) System will adjust plot and character statistic variables in response to player input
7) System outputs any change in character statistics
8) If end of dialogue is reached, line break will be printed, checkpoint saved
9) Next line of dialogue is run if end has not been reached

```plantuml
<style>
diamond {
  BackgroundColor White
}
</style>

title Read Dialogue

start
while (More Dialogue?) is (yes)
#pink:Output dialogue;
if (Input Needed) then (Player Response)
#pink:Output response options;
#lavender:Select response;
#pink:Plot & character variables adjusted;
#pink:Dialogue response to input;
#pink:Outputs change in character variables;
else (None)
#lavender:Player taps/returns to continue;
endif
endwhile (no)
#pink:Print line break;
#pink:Save checkpoint;

stop
```
