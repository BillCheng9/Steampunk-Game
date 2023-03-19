import java.util.concurrent.TimeUnit;

public class Bug implements Enemy{
    String name = "IRON ANT";
    int defense = 1;
    int health = 3;
    int damage = 2;

    public int short_attack() throws InterruptedException {
        System.out.println("IRON ANT DECIDES TO ATTACK YOU!\n");

        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 79) {
            System.out.println("YOU DODGE THE IRON ANT'S BITE!\n");
            return 0;
        }
        else {
            System.out.println("YOU GET BIT BY THE IRON ANT!\n");
            return (int)(damage / 2);
        }
    }

    public int charge_attack() throws InterruptedException {
        System.out.println("IRON ANT DECIDES TO CHARGE AT YOU!\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 59) {
            System.out.println("YOU DODGE THE IRON ANT'S CHARGE!\n");
            return 0;
        }
        else {
            System.out.println("YOU GET PUSHED BACK BY THE IRON ANT'S CHARGE!\n");
            return (int)(damage * 1.3);
        }
    }

    public void increase_stat(){
        System.out.println("IRON ANT DECIDES TO SHARPEN ITS METALLIC MANDIBLES!\n");
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
