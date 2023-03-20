public class Bug implements Enemy{
    String name = "IRON ANT";
    int defense = 1;
    int health = 3;
    int damage = 2;
    Combat_Dialogue d = new Combat_Dialogue(this);
    public int short_attack() throws InterruptedException {
        d.displayEAL();
        int value = (int)(Math.random() * 100);
        if (value > 79) {
            d.displayEML();
            return 0;
        }
        else {
            d.displayEHL();
            return damage / 2;
        }
    }

    public int charge_attack() throws InterruptedException {
        d.displayEAH();
        int value = (int)(Math.random() * 100);
        if (value > 59) {
            d.displayEMH();
            return 0;
        }
        else {
            d.displayEHH();
            return (int)(damage * 1.3);
        }
    }

    public void increase_stat() throws InterruptedException {
        d.displayBug_S();
        damage += 3;
    }

    public boolean healthCheck() {
        return health > 0;
    }

    public int attacked(int value){
        if (value > 0) {
            int dmgValue = value - defense;
            if (dmgValue <= 1) {
                health--;
                return 1;
            } else {
                health -= dmgValue;
                return dmgValue;
            }
        }
        else return 0;
    }

    public int getHealth() { return health; }

    public String getName() {
        return name;
    }
}
