import static java.lang.System.exit;

public class Combat{

    public Combat() {

    }

    public String getInput() throws InterruptedException {
        Combat_Dialogue inputD = new Combat_Dialogue();
        inputD.print("prompt");
        String action = inputD.grabInput();
        while ( (!action.equals("LIGHT")) && (!action.equals("HEAVY")) && (!action.equals("FLEE")) && (!action.equals("PET")) && (!action.equals("INVENTORY")) ){
            inputD.print("invalid");
            action = inputD.grabInput();
        }
        return action;
    }

    public int combatTurn(Player p, Enemy e) throws InterruptedException {
        Combat_Dialogue inputD = new Combat_Dialogue(e);
        Combat_Dialogue inputD2 = new Combat_Dialogue();
        inputD.print("start");
        Input executeAction;
        int retval = -1;
        int val;

        // loop
        boolean fled = false;
        while ( (p.healthCheck()) && (e.healthCheck()) ) {
            // show health
            inputD.pHealth(p.health);
            inputD.eHealth(e.getName(), e.getHealth());

            // player turn
            String input = getInput();
            switch (input) {
                case "LIGHT":
                    executeAction = Input.LIGHT;
                    break;
                case "HEAVY":
                    executeAction = Input.HEAVY;
                    break;
                case "PET":
                    executeAction = Input.PET;
                    break;
                case "INVENTORY":
                    executeAction = Input.INVENTORY;
                    break;
                default:
                    executeAction = Input.FLEE;
                    break;
            }
            switch(executeAction) {
                case LIGHT:
                    val = p.attack1();
                    if (val > 0) {
                        int res = e.attacked(val);
                        Combat_Dialogue dmg = new Combat_Dialogue(p, e, res);
                        dmg.print("damage");
                    }
                    break;
                case HEAVY:
                    val = p.attack2();
                    if (val > 0) {
                        int res = e.attacked(val);
                        Combat_Dialogue dmg = new Combat_Dialogue(p, e, res);
                        dmg.print("damage");
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
                        inputD2.print("flee_t");
                        retval = 2;
                        break;
                    }
                    else {
                        inputD2.print("flee_f");
                    }
                    break;
            }

            // stops loop if flee
            if (fled) break;

            // if enemy is dead
            if (!e.healthCheck()) {
                retval = 1;
                return retval;
            }

            inputD.pHealth(p.health);
            inputD.eHealth(e.getName(), e.getHealth());

            // enemy turn
            int eVal = (int) (Math.random() * 10);
            if (eVal <= 44) {
                val = e.short_attack();
                if (val > 0) {
                    int res = p.attacked(val);
                    Combat_Dialogue dmg = new Combat_Dialogue(p, e, res);
                    dmg.print("enemy");
                }
            } else if (eVal <= 74) {
                val = e.charge_attack();
                if (val > 0) {
                    int res = p.attacked(val);
                    Combat_Dialogue dmg = new Combat_Dialogue(p, e, res);
                    dmg.print("enemy");
                }
            } else {
                e.increase_stat();
            }
        }

        // if player is dead
        if (!p.healthCheck()) {
            retval = 0;
            return retval;
        }
        return retval;
    }

    public static void main(String[] args) throws InterruptedException {

        // initializes objects
        Player p = new Player();
        Combat combat = new Combat();
        Enemy e;
        Combat_Dialogue textD = new Combat_Dialogue();
        int val = -1;

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

            // golem
            case 3:
                e = new Golem();
                break;

            // default-worker bot
            default:
                e = new Worker();
        }

        if (val == -1) {
            val = combat.combatTurn(p, e);
            if (val == 0) {
                textD.print("lose");
                exit(0);
            } else if (val == 1) {
                textD.print("win");
            } else if (val == 2) {
                textD.print("finish");
            }
        }

    }

}
