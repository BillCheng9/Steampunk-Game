package edu.vassar.cmpu203.nextgenpos.model.EnemyTypes;
import edu.vassar.cmpu203.nextgenpos.model.Enemy;

public class Rock implements Enemy{
    String name = "LITERAL ROCK";
    int defense = 1;
    int health = 23;
    int damage = 0;

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
     * Increase Enemy's health by 5
     */
    public void increase_stat() {
        health += 5;
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
