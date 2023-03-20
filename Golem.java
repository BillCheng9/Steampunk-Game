public class Golem implements Enemy{
    String name = "STEAM GOLEM";
    int defense = 10;
    int health = 20;
    int damage = 10;
    Combat_Dialogue d = new Combat_Dialogue(this);
    public int short_attack() throws InterruptedException {
        d.print("e_attack_L");
        int value = (int)(Math.random() * 100);
        if (value > 70) {
            d.print("e_miss_L");
            return 0;
        }
        else {
            d.print("e_hit_L");
            return damage;
        }
    }

    public int charge_attack() throws InterruptedException {
        d.print("e_attack_H");
        int value = (int)(Math.random() * 100);
        if (value > 49) {
            d.print("e_miss_H");
            return 0;
        }
        else {
            d.print("e_hit_H");
            return (int)(damage * 2);
        }
    }

    public void increase_stat() throws InterruptedException {
        d.print("golem_special");
        damage += 5;
        defense -= 5;
        if (defense < 0) {
            defense = 0;
        }
    }

    public boolean healthCheck() {
        if (health <= 0) {
            return false;
        }
        return true;
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
