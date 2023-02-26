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

    public int attack1() {
        System.out.println("You decide to do a light attack.\n");
        int value = (int)(Math.random() * 100);
        if (value <= 9) {
            System.out.println("The enemy dodges your light attack!");
            return 0;
        }
        else {
            System.out.println("You landed a light attack!");
            return damage;
        }
    }

    public int attack2() {
        System.out.println("You decide to do a heavy attack.\n");
        int value = (int)(Math.random() * 100);
        if (value <= 24) {
            System.out.println("The enemy dodges your heavy attack!");
            return 0;
        }
        else {
            System.out.println("You landed a heavy attack!");
            return (int)(damage * 1.5);
        }
    }

    public void accessInv() {
        System.out.println("You decide to open your inventory.\n");
    }

    public void triggerPet() {
        System.out.println("You decide to use your pet's ability.\n");
    }

    public boolean flee() {
        System.out.println("You decide to run away.\n");
        int value = (int)(Math.random() * 100);
        if (value >= 69) {
            System.out.println("You successfully ran away from the enemy!\n");
            return true;
        }
        return false;
    }
}
