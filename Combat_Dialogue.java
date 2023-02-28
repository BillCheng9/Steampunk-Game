import java.util.*;
import java.util.concurrent.TimeUnit;

public class Combat_Dialogue {

    public Player p;
    public Enemy e;
    Map<String, String> dialogue = new HashMap<>();
    public Combat_Dialogue (Player p, Enemy e){
        this.p = p;
        this.e = e;
        dialogue.put("lose", "Your mechanic body can't handle the stress of the fight anymore. Your cores start to fail...GAME OVER!");
        dialogue.put("win", "You defeated your enemy!");
        dialogue.put("prompt", "What do you want to do? (LIGHT, HEAVY, PET, INVENTORY, FLEE)");
        dialogue.put("invalid", "Please pick a valid input. (LIGHT, HEAVY, PET, INVENTORY, FLEE)");
        dialogue.put("start", "You engaged a fight against " + e.getName());
        dialogue.put("damage", "You hit the enemy for ");
        dialogue.put("enemy", "Enemy hit you for ");
    }

    public void print(String s) {
        System.out.println(dialogue.get(s));
    }
    public void health(String s, int h) {
        System.out.println(s + " Stability: " + h);
    }

    public static void main(String args[]) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);

        Player hero = new Player();
        Worker bad = new Worker();
        Combat_Dialogue output = new Combat_Dialogue(hero, bad);
        Combat current = new Combat(output);
        boolean fled = false;

        output.print("start");
        TimeUnit.SECONDS.sleep(1);

        output.health("Player", hero.health);
        output.health(bad.name, bad.health);
        TimeUnit.SECONDS.sleep(1);

        while ( (hero.healthCheck()) && (bad.healthCheck()) ) {

            // player input
            output.print("prompt");
            String action = scanner.nextLine().toUpperCase();

            //invalid input case
            while ((!action.equals("LIGHT")) && (!action.equals("HEAVY")) && (!action.equals("PET")) && (!action.equals("INVENTORY")) && (!action.equals("FLEE"))) {
                output.print("invalid");
                action = scanner.nextLine().toUpperCase();
            }

            Input executeAction;

            if (action.equals("LIGHT")) executeAction = Input.LIGHT;
            else if (action.equals("HEAVY")) executeAction = Input.HEAVY;
            else if (action.equals("PET")) executeAction = Input.PET;
            else if (action.equals("INVENTORY")) executeAction = Input.INVENTORY;
            else executeAction = Input.FLEE;

            switch (executeAction){
                case LIGHT:
                    System.out.println(output.dialogue.get("damage") + current.Light_Attack(hero, bad));
                    break;
                case HEAVY:
                    System.out.println(output.dialogue.get("damage") + current.Heavy_Attack(hero, bad));
                    break;
                case PET:
                    hero.triggerPet();
                    break;
                case INVENTORY:
                    hero.accessInv();
                    break;
                case FLEE:
                    hero.flee();
                    fled = true;
                    break;
            }
            if (fled) break;

            TimeUnit.SECONDS.sleep(1);
            output.health("Player", hero.health);
            output.health(bad.name, bad.health);
            TimeUnit.SECONDS.sleep(1);
        }

    }

}