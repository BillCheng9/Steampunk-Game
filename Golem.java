import java.util.concurrent.TimeUnit;

public class Golem implements Enemy{
    String name = "STEAM GOLEM";
    int defense = 10;
    int health = 20;
    int damage = 10;
    public int short_attack() throws InterruptedException {
        System.out.println("STEAM GOLEM SWINGS WILDLY AT YOU!\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 70) {
            System.out.println("YOU DODGE THE STEAM GOLEM'S FIST!\n");
            return 0;
        }
        else {
            System.out.println("YOU GET PUNCHED HARD BY THE STEAM GOLEM!\n");
            return damage;
        }
    }

    public int charge_attack() throws InterruptedException {
        System.out.println("STEAM GOLEM BEGINS SWINGING HIS ARMS!\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 49) {
            System.out.println("YOU DODGE THE STEAM GOLEM'S WINDMILL ATTACK!\n");
            return 0;
        }
        else {
            System.out.println("YOU GOT SLAMMED BY THE STEAM GOLEM'S WINDMILL ATTACK!\n");
            return (int)(damage * 2);
        }
    }

    public void increase_stat(){
        System.out.println("STEAM GOLEM SHIFTS ITS PROTECTIVE ARMOR TO ITS FISTS!\n");
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

    @Override
    public int attacked(int value) {
        if (value > 0) {
            int dmgValue = value - defense;
            if (dmgValue < 1) {
                health--;
                return 1;
            } else {
                return health -= dmgValue;
            }
        }
        else {
            return 0;
        }
    }
}
