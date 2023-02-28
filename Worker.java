import java.util.concurrent.TimeUnit;

public class Worker implements Enemy{
    String name = "Worker Bot";
    int defense = 5;
    int health = 5;
    int damage = 5;
    public int short_attack() throws InterruptedException {
        System.out.println("Worker Bot decides to attack you!\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 70) {
            System.out.println("You dodge the Worker Bot's attack!\n");
            return 0;
        }
        else {
            System.out.println("You get hit by the Worker Bot!\n");
            return damage;
        }
    }

    public int charge_attack() throws InterruptedException {
        System.out.println("Worker Bot decides to charge up a powerful attack!\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 49) {
            System.out.println("You dodge the Worker Bot's powerful attack!!\n");
            return 0;
        }
        else {
            System.out.println("You get slammed by the Worker Bot!\n");
            return (int)(damage * 2);
        }
    }

    public void increase_stat(){
        System.out.println("Worker Bot decides to power up!\n");
        damage++;
        health++;
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
            if (dmgValue < 1) {
                health--;
                return 1;
            } else {
                return health -= dmgValue;
            }
        }
        else return 0;
    }

    public String getName() {
        return name;
    }
}
