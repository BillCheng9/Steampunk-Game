package edu.vassar.cmpu203.nextgenpos.model;

public interface Enemy {

    String name = null;
    int health = 0;
    int damage = 0;
    int defense = 0;

    /**
     * Getter method for Enemy's name
     * @return Enemy's name
     */
    String getName();

    /**
     * Getter method for Enemy's health
     * @return Enemy's health
     */
    int getHealth();

    /**
     * Getter method for Enemy's armor
     * @return Enemy's armor
     */
    int getDefense();


    /**
     * Calculate damage done to Enemy by Player's attack
     * @param value Player's attack value
     * @return the damage done to Enemy
     */
    int attacked(int value);

    /**
     * Calculates chance of hitting Player with an Enemy's light attack and the damage it does
     * @return 0 if missed, any number >0 if hit for damage
     * @throws InterruptedException
     */
    int short_attack() throws InterruptedException;

    /**
     * Calculates chance of hitting Player with an Enemy's heavy attack and the damage it does
     * @return 0 if missed, any number >0 if hit for damage
     * @throws InterruptedException
     */
    int charge_attack() throws InterruptedException;

    /**
     * Increase Enemy's stats based on specific rules of each Enemy type
     * @throws InterruptedException
     */
    void increase_stat() throws InterruptedException;

    /**
     * Picks a random Attack
     * @return Integer indicating which move Enemy will take: 0 for light attack, 1 for heavy attack, -1 for charge
     * @throws InterruptedException
     */
    int pickAttack() throws InterruptedException;

    /**
     * Checks Enemy's health
     * @return True if health>0, False if not
     */
    boolean healthCheck();
}
