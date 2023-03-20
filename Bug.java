public class Bug implements Enemy{
    String name = "IRON ANT";
    int defense = 1;
    int health = 3;
    int damage = 2;
    Combat_Dialogue d = new Combat_Dialogue(this);
    public int short_attack() throws InterruptedException {
        d.print("e_attack_L");
        int value = (int)(Math.random() * 100);
        if (value > 79) {
            d.print("e_miss_L");
            return 0;
        }
        else {
            d.print("e_hit_L");
            return (int)(damage / 2);
        }
    }

    public int charge_attack() throws InterruptedException {
        d.print("e_attack_H");
        int value = (int)(Math.random() * 100);
        if (value > 59) {
            d.print("e_miss_H");
            return 0;
        }
        else {
            d.print("e_hit_H");
            return (int)(damage * 1.3);
        }
    }

    public void increase_stat() throws InterruptedException {
        d.print("bug_special");
        damage += 3;
    }

    public boolean healthCheck() {
        if (health <= 0) {
            return false;
        }
        return true;
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
