import java.util.Scanner;
public class Combat {

    public void endCombat(int value) {
        if (value == 0) {
            System.out.print("Your mechanic body can't handle the stress of the fight anymore. Your cores start to fail...GAME OVER!\n");
        } else {
            System.out.print("You defeated your enemy!\n");
        }
    }

    public static void main(String args[]) {

        Player hero = new Player();
        Combat fight = new Combat();
        Worker bad = new Worker();

        System.out.println("You engaged a fight against " + bad.name + "!\n");

        while ( (hero.healthCheck()) && (bad.healthCheck()) ) {
            System.out.println("Player Stability: " + hero.health + "\n");
            System.out.println("Enemy Health: " + bad.health + "\n");

            // player inputs
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to do? (LIGHT, HEAVY, PET, INVENTORY, FLEE)\n");
            String action = scanner.nextLine().toUpperCase();

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

            // enemy inputs

        }

        if (!hero.healthCheck()) {
            fight.endCombat(0);
        }
        else if (!bad.healthCheck()) {
            fight.endCombat(1);
        }

    }
}
