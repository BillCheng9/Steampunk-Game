import java.util.*;
import java.util.concurrent.TimeUnit;

public class Combat_Dialogue {

    public Player p;
    public Enemy e;
    Map<String, String> dialogue = new HashMap<>();
    public Combat_Dialogue (Enemy e){
        this.e = e;
        dialogue.put("start", "YOU ENGAGED A FIGHT AGAINST " + e.getName() + "!");
        dialogue.put("e_attack_L", e.getName() + " DECIDES TO ATTACK YOU!");
        dialogue.put("e_miss_L", "YOU DODGE THE " + e.getName() + "'S LIGHT ATTACK!");
        dialogue.put("e_hit_L", "YOU GET HIT BY THE " + e.getName() + "'S LIGHT ATTACK!");
        dialogue.put("e_attack_H", e.getName() + " DECIDES TO CHARGE UP A POWERFUL ATTACK!");
        dialogue.put("e_miss_H", "YOU DODGE THE " + e.getName() + "'S HEAVY ATTACK!");
        dialogue.put("e_hit_H", "YOU GET HIT BY THE " + e.getName() + "'S HEAVY ATTACK!");
        dialogue.put("bug_special", "IRON ANT SHARPENS ITS METALLIC MANDIBLES!");
        dialogue.put("worker_special", "WORKER BOT POWERS UP!");
        dialogue.put("golem_special", "STEAM GOLEM SHIFTS ITS METALLIC ARMOR TO ITS FISTS!");
        dialogue.put("rock_special", "THE ROCK SOMEHOW GROWS LARGER?!");
        dialogue.put("rock_start", "A ROCK STANDS IN YOUR WAY");
        dialogue.put("rock_move", "IT'S A LITERAL ROCK. IT CAN'T HURT YOU!");
    }

    public Combat_Dialogue () {
        dialogue.put("prompt", "WHAT DO YOU WANT TO DO? (LIGHT, HEAVY, PET, INVENTORY, FLEE)");
        dialogue.put("invalid", "PLEASE PICK A VALID INPUT. (LIGHT, HEAVY, PET, INVENTORY, FLEE)");
        dialogue.put("lose", "YOUR MECHANIC BODY CAN'T HANDLE THE STRESS OF THE FIGHT ANYMORE. YOUR CORES START TO FAIL. GAME OVER!");
        dialogue.put("win", "YOU DEFEATED YOUR ENEMY!");
        dialogue.put("flee_f", "THE ENEMY CATCHES UP TO YOU!");
        dialogue.put("flee_t", "YOU SUCCESSFULLY RUN AWAY!");
        dialogue.put("finish", "YOU LIVE TO FIGHT ANOTHER DAY!");

    }

    public Combat_Dialogue (Player p, Enemy e, int dmg) {
        dialogue.put("enemy", "ENEMY HIT YOU FOR " + dmg);
        dialogue.put("damage", "YOU HIT THE ENEMY FOR " + dmg);
    }

    public String grabInput() {
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine().toUpperCase();
        return action;
    }

    public void print(String s) throws InterruptedException {
        System.out.println(dialogue.get(s) + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    public void displayLoss() throws InterruptedException {
        System.out.println(dialogue.get("lose") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    public void pHealth(int h) {
        System.out.println("PLAYER STABILITY: " + h);
    }
    public void eHealth(String s, int h) {
        System.out.println(e.getName() + "'S STABILITY: " + h);
    }

}