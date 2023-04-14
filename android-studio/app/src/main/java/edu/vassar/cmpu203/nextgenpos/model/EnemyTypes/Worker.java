package edu.vassar.cmpu203.nextgenpos.model.EnemyTypes;
import edu.vassar.cmpu203.nextgenpos.model.Enemy;

public class Worker implements Enemy {
    String name = "WORKER BOT";
    int defense = 2;
    int health = 7;
    int damage = 2;
    int gear = 5;
    int exp = 8;

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
            return damage * 2;
        }
    }

    /**
     * Increase Enemy's damage and health by 1
     */
    public void increase_stat() {
        damage++;
        health++;
    }

    /**
     * Checks Enemy's health
     * @return True if health>0, False if not
     */
    public boolean healthCheck() { return health > 0; }

    /**
     * Getter method for exp
     *
     * @return exp
     */
    @Override
    public int getExp() {
        return exp;
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
        if (eVal <= 44) {
            return 0;
        } else if (eVal <= 74) {
            return 1;
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
