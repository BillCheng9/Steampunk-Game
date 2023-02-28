import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Combat{

    public Combat_Dialogue d;

    public Combat(Combat_Dialogue d){
        this.d = d;
    }

    public int Light_Attack(Player hero, Enemy bad) throws InterruptedException{
        int value = hero.attack1();
        return bad.attacked(value);
    }

    public int Heavy_Attack(Player hero, Enemy bad) throws InterruptedException{
        int value = hero.attack2();
        return bad.attacked(value);
    }
/*    public void endCombat(int value) {
        Combat_Dialogue dialogue = new Combat_Dialogue(hero, bad);
        if (value == 0) {
            dialogue.print("lose");
        } else {
            dialogue.print("win");
        }
    }*/

}
