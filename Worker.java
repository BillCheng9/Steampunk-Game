public class Worker implements Enemy{
    String name = "WORKER BOT";
    int defense = 5;
    int health = 5;
    int damage = 5;
    Combat_Dialogue d = new Combat_Dialogue(this);

    public int short_attack() throws InterruptedException {
        int value = (int)(Math.random() * 100);
        d.print("e_attack_L");
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
        int value = (int)(Math.random() * 100);
        d.print("e_attack_H");
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
        d.print("worker_special");
        damage++;
        health++;
    }

    public boolean healthCheck() {
        if (health <= 0) {
            return false;
        }
        return true;
    }

    public int getHealth() { return health; }

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

    public String getName() {
        return name;
    }
}
