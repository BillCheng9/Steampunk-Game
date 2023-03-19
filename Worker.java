import java.util.concurrent.TimeUnit;

public class Worker implements Enemy{
    String name = "WORKER BOT";
    int defense = 5;
    int health = 5;
    int damage = 5;

    public int short_attack() throws InterruptedException {
        System.out.println("WORKER BOT DECIDES TO ATTACK YOU!\n");

        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 70) {
            System.out.println("YOU DODGE THE WORKER BOT'S SWING!\n");
            return 0;
        }
        else {
            System.out.println("YOU GET HIT BY THE WORKER BOT!\n");
            return damage;
        }
    }

    public int charge_attack() throws InterruptedException {
        System.out.println("WORKER BOT DECIDES TO CHARGE UP A POWERFUL ATTACK!\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 49) {
            System.out.println("YOU DODGE THE WORKER BOT'S POWERFUL ATTACK!\n");
            return 0;
        }
        else {
            System.out.println("YOU GET SLAMMED BY THE WORKER BOT!\n");
            return (int)(damage * 2);
        }
    }

    public void increase_stat(){
        System.out.println("WORKER BOT DECIDES TO POWER UP!\n");
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
