package edu.vassar.cmpu203.nextgenpos.model.EnemyTypes;
import edu.vassar.cmpu203.nextgenpos.model.Enemy;

public class Golem implements Enemy{
    String name = "STEAM GOLEM";
    int defense = (int)(Math.random() * 8) + 2;
    int health = (int)(Math.random() * 13) + 5;
    int damage = (int)(Math.random() * 3) + 2;
    int gear = (int)(Math.random() * 6) + 4;

    /**
     * Constructor with pre-determined stats
     * @param health health
     * @param damage damage
     * @param defense defense
     */
    public Golem(int health, int damage, int defense) {
        this.health = health;
        this.damage = damage;
        this.defense = defense;
    }

    /**
     * Constructor that scales
     * @param gearScore player gear score that affects enemy stats
     */
    public Golem(int gearScore) {
        if (gearScore > 16) {
            defense = defense * (gearScore / 3);
            health = (int) (health * (gearScore/2.7));
            damage = (int) (damage * (gearScore / 2.9));
            gear = gear * (gearScore / 3);
        }
        else if (gearScore > 10) {
            defense = defense * 2;
            health = (int) (health * 2.5);
            damage = damage * 2;
            gear = gearScore * 2;
        }
        else if (gearScore > 5) {
            defense = (int)(defense * 1.5);
            health = health * 2;
            damage = (int)(damage * 1.75);
            gear = (int)(gearScore * 1.5);
        }
    }

    /**
     * Calculates chance of hitting Player with an Enemy's light attack and the damage it does
     * @return 0 if missed, any number >0 if hit for damage
     */
    public int short_attack() {
        int value = (int)(Math.random() * 100);
        if (value > 70) {
            return 0;
        }
        else {
            return damage;
        }
    }

    /**
     * Calculates chance of hitting Player with an Enemy's heavy attack and the damage it does
     * @return 0 if missed, any number >0 if hit for damage
     */
    public int charge_attack() {
        int value = (int)(Math.random() * 100);
        if (value > 49) {
            return 0;
        }
        else {
            return (int) (damage * 1.5);
        }
    }

    /**
     * Increase Enemy's damage by 2, defense by -3 with a minimum defense of 0
     */
    public void increase_stat() {
        damage += 2;
        defense -= 3;
        if (defense < 0) {
            defense = 0;
        }
    }

    /**
     * Checks Enemy's health
     * @return True if health>0, False if not
     */
    public boolean healthCheck() {
        return health > 0;
    }

    /**
     * Getter method for gear
     *
     * @return gear
     */
    @Override
    public int getGear() {
        return gear;
    }

    /**
     * Getter method for damage
     *
     * @return damage
     */
    @Override
    public int getDamage() {
        return damage;
    }

    /**
     * Returns Enemy's name
     * @return Enemy's name
     */
    public String getName(){
        return name;
    }

    /**
     * Get Enemy's health
     * @return Enemy's health
     */
    public int getHealth() {
        if (health < 0) {
            health = 0;
        }
        return health;
    }

    /**
     * Getter method for Enemy's armor
     *
     * @return Enemy's armor
     */
    @Override
    public int getDefense() {
        return defense;
    }

    /**
     * Calculate damage done to Enemy by Player's attack
     * @param value Player's attack value
     * @return the damage done to Enemy
     */
    @Override
    public int attacked(int value) {
        if (value > 0) {
            int dmgValue = value - defense;
            if (dmgValue <= 1) {
                health--;
                return 1;
            } else {
                health -= dmgValue;
                return dmgValue;
            }
        }
        else {
            return 0;
        }
    }

    /**
     * Picks a random Attack
     * @return Integer indicating which move Enemy will take: 0 for light attack, 1 for heavy attack, -1 for charge
     */
    public int pickAttack() {
        int eVal = (int) (Math.random() * 100);
        if (eVal <= 44) {
            return 0;
        } else if (eVal <= 74) {
            return 1;
        } else {
            this.increase_stat();
            return -1;
        }
    }
}
