

/**
 * Combat is the controller class we will be using for this game. Current iteration interacts with the view model
 * CombatDialogue to retrieve player inputs. Combat will run until Player dies, enemy dies, or Player flees
 */
public class Combat{

    public Combat() {

    }

    /**
     *  Returns an enum Input that is used in the combatTurn method. Calls the grabInput method in the CombatDialogue
     *  class and returns the corresponding Input.
     * @return an enum Input that represents a player action
     */
    public Input getInput() throws InterruptedException {
        CombatDialogue inputD = new CombatDialogue();
        return inputD.grabInput();
    }

    /**
     * Returns a String corresponding to the result of combat. Uses the getInput method to loop combat until
     * an exit condition is reached.
     * @param p a Player object
     * @param e a randomly generated Enemy object
     * @return result of combat: Win, lose, flee
     */
    public String combatTurn(Player p, Enemy e) throws InterruptedException {
        CombatDialogue inputD = new CombatDialogue(e);
        CombatDialogue inputD2 = new CombatDialogue();
        inputD.displayStart();
        Input executeAction;
        int val;

        // loop
        boolean fled = false;
        while ( (p.healthCheck()) && (e.healthCheck()) ) {
            // show health
            inputD.pHealth(p.health);
            inputD.eHealth(e.getHealth());

            // player turn
            executeAction = getInput();

            switch(executeAction) {
                case LIGHT:
                    val = p.attack1();
                    if (val > 0) {
                        int res = e.attacked(val);
                        CombatDialogue dmg = new CombatDialogue(res);
                        dmg.displayDamage();
                    }
                    break;
                case HEAVY:
                    val = p.attack2();
                    if (val > 0) {
                        int res = e.attacked(val);
                        CombatDialogue dmg = new CombatDialogue(res);
                        dmg.displayDamage();
                    }
                    break;
                case PET:
                    p.triggerPet();
                    break;
                case INVENTORY:
                    p.accessInv();
                    break;
                case FLEE:
                    fled = p.flee();
                    if (fled) {
                        inputD2.displayFlee_T();
                        break;
                    }
                    else {
                        inputD2.displayFlee_F();
                    }
                    break;
            }

            // stops loop if flee
            if (fled) break;

            // if enemy is dead
            if (!e.healthCheck()) {
                return "WIN";
            }

            inputD.pHealth(p.health);
            inputD.eHealth(e.getHealth());

            // enemy turn
            int eVal = e.pickAttack();
            int dmgVal;
            if (eVal == 0) {
                dmgVal = e.short_attack();
                if (dmgVal != 0) {
                    int res = p.attacked(dmgVal);
                    CombatDialogue dmg = new CombatDialogue(res);
                    dmg.displayEnemy();
                }
            }
            else if (eVal == 1) {
                dmgVal = e.charge_attack();
                if (dmgVal != 0) {
                    int res = p.attacked(dmgVal);
                    CombatDialogue dmg = new CombatDialogue(res);
                    dmg.displayEnemy();
                }
            }
        }

        // if player is dead
        if (!p.healthCheck()) {
            return "LOSS";
        }
        return "FINISH";
    }

    /**
     * Main method for the controller class. Randomly generates an enemy for combat, then calls the combatTurn method
     * to return combat until conclusion is reached. Calls the view class to print an output based on the result of
     * combatTurn.
     */
    public static void main(String[] args) throws InterruptedException {

        // initializes objects
        Player p = new Player();
        Combat combat = new Combat();
        Enemy e;
        CombatDialogue textD = new CombatDialogue();

        // picks random enemy to fight
        int eVal = (int)(Math.random() * 4);

        switch (eVal) {
            // iron ant
            case 1:
                e = new Bug();
                break;

            // rock
            case 2:
                e = new Rock();
                break;

            // Golem
            case 3:
                e = new Golem();
                break;

            // default-worker bot
            default:
                e = new Worker();
        }

        textD.combatResult(combat.combatTurn(p, e));
    }

}
