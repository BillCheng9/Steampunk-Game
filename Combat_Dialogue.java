import java.util.*;
public class Combat_Dialogue {

    public Player p;
    public Enemy e;
    Map<String, String> Diamap = new HashMap<>();
    public Combat_Dialogue (Player p, Enemy e){
        this.p = p;
        this.e = e;
        Diamap.put("lose", "Your mechanic body can't handle the stress of the fight anymore. Your cores start to fail...GAME OVER!");
        Diamap.put("win", "You defeated your enemy!");
        Diamap.put("start", "You engaged a fight against " + e.name);
    }

    public void print(String s) {
        System.out.println(Diamap.get(s));
    }
    public void health(String s, int h) {
        System.out.println(s + " Stability: " + h);
    }
}