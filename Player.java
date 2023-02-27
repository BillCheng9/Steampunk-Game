import java.util.concurrent.TimeUnit;

public class Player {
    public int experience, gears, health, defense, damage;
    public Player(){
        //Placeholder values for first iteration
        health = 5;
        defense = 5;
        damage = 5;
        experience = 5;
        gears = 5;
    }

    public int attack1() throws InterruptedException {
        System.out.println("You decide to do a light attack.\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 89) {
            System.out.println("The enemy dodges your light attack!\n");
            return 0;
        }
        else {
            System.out.println("You landed a light attack!\n");
            return damage;
        }
    }

    public int attack2() throws InterruptedException {
        System.out.println("You decide to do a heavy attack.\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 73) {
            System.out.println("The enemy dodges your heavy attack!\n");
            return 0;
        }
        else {
            System.out.println("You landed a heavy attack!\n");
            return (int)(damage * 1.5);
        }
    }

    public void accessInv() {
        System.out.println("You decide to open your inventory.\n");
    }

    public void triggerPet() {
        System.out.println("You decide to use your pet's ability.\n");
    }

    public boolean flee() throws InterruptedException {
        System.out.println("You decide to run away.\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value >= 69) {
            System.out.println("You successfully ran away from the enemy!\n");
            return true;
        }
        else {
            System.out.println("The enemy catches up to you!\n");
        }
        return false;
    }

    public boolean healthCheck() {
        if (health <= 0) {
            return false;
        }
        return true;
    }
}
