import java.util.*;
public class Combat_Dialogue {

    public Player p;
    public Enemy e;
    public Combat_Dialogue (Player p, Enemy e){
        this.p = p;
        this.e = e;
    }
    final Map<String, String> Diamap = new HashMap<>();
    Diamap.put("lose", "Your mechanic body can't handle the stress of the fight anymore. Your cores start to fail...GAME OVER!");
    Diamap.put("win", "You defeated your enemy!");
    Diamap.put("start", "You engaged a fight against " + e.name);

    public void print(String s) {
        System.out.print(Diamp.get(s));
    }
}