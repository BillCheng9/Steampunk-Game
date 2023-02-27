import java.util.concurrent.TimeUnit;

public class Golem implements Enemy{
    String name = "Steam Golem";
    int defense = 10;
    int health = 20;
    int damage = 10;
    public int short_attack() throws InterruptedException {
        System.out.println("Golem swings wildly at you\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 70) {
            System.out.println("You dodge the golem's fist\n");
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
}
