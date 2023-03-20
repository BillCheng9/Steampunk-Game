public class Golem implements Enemy{
    String name = "STEAM GOLEM";
    int defense = 10;
    int health = 20;
    int damage = 10;
    Combat_Dialogue d = new Combat_Dialogue(this);
    public int short_attack() throws InterruptedException {
        d.displayEAL();
        int value = (int)(Math.random() * 100);
        if (value > 70) {
            d.displayEML();
            return 0;
        }
        else {
            d.displayEHL();
            return damage;
        }
    }

    public int charge_attack() throws InterruptedException {
        d.displayEAH();
        int value = (int)(Math.random() * 100);
        if (value > 49) {
            d.displayEMH();
            return 0;
        }
        else {
            d.displayEHH();
            return damage * 2;
        }
    }

    public void increase_stat() throws InterruptedException {
        d.displayGolem_S();
        damage += 5;
        defense -= 5;
        if (defense < 0) {
            defense = 0;
        }
    }

    public boolean healthCheck() {
        return health > 0;
    }

    public String getName(){
        return name;
    }
    public int getHealth() { return health; }

    @Override
    public int attacked(int value) {
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
        else {
            return 0;
        }
    }
}
