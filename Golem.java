import java.util.concurrent.TimeUnit;

public class Golem implements Enemy{
    String name = "Steam Golem";
    int defense = 10;
    int health = 20;
    int damage = 10;
    public int short_attack() throws InterruptedException {
        System.out.println("Steam Golem swings wildly at you!\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 70) {
            System.out.println("You dodge the Steam Golem's fist!\n");
            return 0;
        }
        else {
            System.out.println("You got punched hard by the Steam Golem!!\n");
            return damage;
        }
    }

    public int charge_attack() throws InterruptedException {
        System.out.println("Steam Golem begins spinning his arms!\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 49) {
            System.out.println("You dodge the Steam Golem's windmill attack!\n");
            return 0;
        }
        else {
            System.out.println("You got slammed by the Steam Golem's windmill attack!\n");
            return (int)(damage * 2);
        }
    }

    public void increase_stat(){
        System.out.println("Steam Golem moves its bulky armor to its arms!\n");
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
}
