package edu.vassar.cmpu203.nextgenpos.model;

import edu.vassar.cmpu203.nextgenpos.model.PetTypes.Drone;

public class Player {
    public int experience, gears, health, defense, damage, maxHealth, trueDefense;

    /**
     * Creates a Player entity with (temporary) numbers for stats
     */
    public Player(int maxHealth, int trueDefense, int damage, int experience, int gears){
        //Placeholder values for first iteration
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.gears = gears;
        this.defense = trueDefense;
        this.trueDefense = trueDefense;
        this.damage = damage;
        this.experience = experience;
    }

    Pet p = new Drone();

    /**
     * Calculates whether or not the Player hits a light attack
     *
     * @return A 0 if the attack misses or any number > 0 indicating a hit and the hit damage
     */
    public int attack1() {
        int value = (int)(Math.random() * 100);
        if (value > 84) {
            return 0;
        }
        else {
            return damage;
        }
    }

    /**
     * Calculates whether or not the Player hits a heavy attack
     *
     * @return A 0 if the attack misses or any number > 0 indicating a hit and the hit damage
     */
    public int attack2() {
        int value = (int)(Math.random() * 100);
        if (value > 74) {
            return 0;
        }
        else {
            return (int)(damage * 1.5);
        }
    }

    /**
     * Opens up the Player inventory and allows the User to equip/unequip different items and pets
     */
    public void accessInv() {
    }

    /**
     * Calculates whether or not the Player successfully flees
     *
     * @return True if the player successfully flees, False if not
     */
    public boolean flee() {
        int value = (int)(Math.random() * 100);
        return value >= 69;
    }

    /**
     * Checks to see if the Player has no health left
     *
     * @return True if player still has >0 health, False if not
     */
    public boolean healthCheck() {
        return health > 0;
    }

    /**
     * Calculates how much damage is done to the Player after an Enemy attack
     *
     * @param e_dmg The damage value taken from the Enemy's attack
     * @return A number indicating how much damage the Player taken from the Enemy attack
     */
    public int attacked(int e_dmg) {
        if (e_dmg > 0) {
            int dmgValue = e_dmg - defense;
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

    public void onEnd(int gear, int exp) {
        gears += gear;
        experience += exp;
    }
}
