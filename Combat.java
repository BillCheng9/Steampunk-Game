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
            System.out.println("Player Stability: " + hero.health);
            System.out.println("Enemy Health: " + bad.health);

            // player inputs
            
        }

        if (!hero.healthCheck()) {
            fight.endCombat(0);
        }
        else if (!bad.healthCheck()) {
            fight.endCombat(1);
        }

    }
}
