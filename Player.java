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
        System.out.println("YOU DECIDE TO DO A LIGHT ATTACK.\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 89) {
            System.out.println("THE ENEMY DODGES YOUR LIGHT ATTACK\n");
            return 0;
        }
        else {
            System.out.println("YOU LANDED A LIGHT ATTACK!\n");
            return damage;
        }
    }

    public int attack2() throws InterruptedException {
        System.out.println("YOU DECIDE TO DO A HEAVY ATTACK.\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value > 73) {
            System.out.println("THE ENEMY DODGES YOUR HEAVY ATTACK!\n");
            return 0;
        }
        else {
            System.out.println("YOU LANDED A HEAVY ATTACK!\n");
            return (int)(damage * 1.5);
        }
    }

    public void accessInv() {
        System.out.println("YOU DECIDE TO OPEN YOUR INVENTORY.\n");
    }

    public void triggerPet() {
        System.out.println("YOU DECIDE TO USE YOUR PET'S ABILITY.\n");
    }

    public boolean flee() throws InterruptedException {
        System.out.println("YOU DECIDE TO RUN AWAY.\n");
        TimeUnit.SECONDS.sleep(1);
        int value = (int)(Math.random() * 100);
        if (value >= 69) {
            System.out.println("YOU SUCCESSFULLY RUN AWAY!\n");
            return true;
        }
        else {
            System.out.println("THE ENEMY CATCHES UP TO YOU!\n");
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
