import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Combat {

/*    public void endCombat(int value) {
        Combat_Dialogue dialogue = new Combat_Dialogue(hero, bad);
        if (value == 0) {
            dialogue.print("lose");
        } else {
            dialogue.print("win");
        }
    }*/

    public static void main(String args[]) throws InterruptedException {

        Player hero = new Player();
        Combat fight = new Combat();
        Worker bad = new Worker();
        Combat_Dialogue dialogue = new Combat_Dialogue(hero, bad);

        dialogue.print("start");
        TimeUnit.SECONDS.sleep(1);

        dialogue.health("Player", hero.health);
        dialogue.health(bad.name, bad.health);
        TimeUnit.SECONDS.sleep(1);

        while ( (hero.healthCheck()) && (bad.healthCheck()) ) {

            // player inputs
            Scanner scanner = new Scanner(System.in);
            dialogue.print("prompt");
            String action = scanner.nextLine().toUpperCase();

            while( (!action.equals("LIGHT")) && (!action.equals("HEAVY")) && (!action.equals("PET")) && (!action.equals("INVENTORY")) && (!action.equals("FLEE")) ) {
                dialogue.print("invalid");
                action = scanner.nextLine().toUpperCase();
            }

//            Strength actionStrenght = Strength.LIGHT;
//
//            if (actionStrenght == Strength.HEAVY){
//
//            }
//
//            if (action.equals("LIGHT")) actionStrenght = Strength.LIGHT;


            if ( (action.equals("LIGHT")) || (action.equals("HEAVY")) ) {
                if (action.equals("LIGHT")) {
                    int value = hero.attack1();
                    if (value > 0) {
                        int dmgValue = value - bad.defense;
                        if (dmgValue < 1) {
                            bad.health--;
                            System.out.println("You dealt 1 light damage to the enemy!\n");
                        }
                        else {
                            bad.health -= dmgValue;
                            System.out.println("You dealt " + dmgValue + " light damage to the enemy!\n");
                        }
                    }
                }
                else {
                    int value = hero.attack2();
                    if (value > 0) {
                        int dmgValue = value - bad.defense;
                        if (dmgValue < 1) {
                            bad.health--;
                            System.out.println("You dealt 1 heavy damage to the enemy!\n");
                        }
                        else {
                            bad.health -= dmgValue;
                            System.out.println("You dealt " + dmgValue + " heavy damage to the enemy!\n");
                        }
                    }
                }
            }

            else if (action.equals("PET")) {
                hero.triggerPet();
            }
            else if (action.equals("INVENTORY")) {
                hero.accessInv();
            }
            else if (action.equals("FLEE")) {
                hero.flee();
                break;
            }

            TimeUnit.SECONDS.sleep(1);
            dialogue.health("Player", hero.health);
            dialogue.health(bad.name, bad.health);
            TimeUnit.SECONDS.sleep(1);

            // enemy inputs
            int enemyRNG = (int)(Math.random() * 100);
            if (enemyRNG > 79) {
                bad.increase_stat();
            }
            else if (enemyRNG > 60) {
                int value = bad.charge_attack();
                if (value > 0) {
                    int dmgValue = value - hero.defense;
                    if (dmgValue < 1) {
                        hero.health--;
                        System.out.println(bad.name + " dealt 1 heavy damage to you!\n");
                    }
                    else {
                        hero.health -= dmgValue;
                        System.out.println(bad.name + " dealt " + dmgValue + " heavy damage to you!\n");
                    }
                }
            }
            else {
                int value = bad.short_attack();
                if (value > 0) {
                    int dmgValue = value - hero.defense;
                    if (dmgValue < 1) {
                        hero.health--;
                        System.out.println(bad.name + " dealt 1 damage to you!\n");
                    }
                    else {
                        hero.health -= dmgValue;
                        System.out.println(bad.name + "dealt " + dmgValue + " damage to you!\n");
                    }
                }
            }

            TimeUnit.SECONDS.sleep(1);
            dialogue.health("Player", hero.health);
            dialogue.health(bad.name, bad.health);
            TimeUnit.SECONDS.sleep(1);

        }

//        if (!hero.healthCheck()) {
//            fight.endCombat(0);
//        }
//        else if (!bad.healthCheck()) {
//            fight.endCombat(1);
//        }

    }
}
