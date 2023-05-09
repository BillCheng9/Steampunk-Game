package edu.vassar.cmpu203.nextgenpos.model.EnemyTypes;
import edu.vassar.cmpu203.nextgenpos.model.Enemy;

public class Rock implements Enemy{
    String name = "LITERAL ROCK";
    int damage = 0;
    int defense = (int)(Math.random() * 1) + 1;
    int health = (int)(Math.random() * 10) + 9;
    int gear = (int)(Math.random() * 1) + 1;

    /**
     * Constructor with pre-determined stats
     * @param health health
     * @param damage damage
     * @param defense defense
     */
    public Rock(int health, int damage, int defense) {
        this.health = health;
        this.damage = damage;
        this.defense = defense;
    }

    /**
     * Constructor that scales
     * @param gearScore player gear score that affects enemy stats
     */
    public Rock(int gearScore) {
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
     * Returns 0
     * @return 0
     */
    public int short_attack() {
        return 0;
    }

    /**
     * Returns short_attack()
     * @return 0
     */
    public int charge_attack() {
        return short_attack();
    }

    /**
     * Increase Enemy's health by 4
     */
    public void increase_stat() {
        health += 4;
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
     * Calculate damage done to Enemy by Player's attack
     * @param value Player's attack value
     * @return the damage done to Enemy
     */
    public int attacked(int value){
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
        else return 0;
    }

    /**
     * Picks a random Attack
     * @return Integer indicating which move Enemy will take: 0 for light attack, 1 for heavy attack, -1 for charge
     */
    public int pickAttack() {
        int eVal = (int) (Math.random() * 100);
        if (eVal <= 74) {
            return 0;
        } else {
            this.increase_stat();
            return -1;
        }
    }

    /**
     * Returns Enemy's name
     * @return Enemy's name
     */
    public String getName() {
        return name;
    }
}
