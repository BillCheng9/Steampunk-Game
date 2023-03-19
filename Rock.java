import java.util.concurrent.TimeUnit;

public class Rock implements Enemy{
    String name = "LITERAL ROCK";
    int defense = 1;
    int health = 23;
    int damage = 0;

    public int short_attack() throws InterruptedException {
        System.out.println("A ROCK STANDS IN YOUR WAY!\n");

        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        System.out.println("IT'S LITERALLY A ROCK. IT CAN'T HURT YOU!\n");
        return 0;
    }

    public int charge_attack() throws InterruptedException {
        return short_attack();
    }

    public void increase_stat(){
        System.out.println("THE ROCK SOMEHOW GETS MORE SMALLER ROCKS!\n");
        health += 5;
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
