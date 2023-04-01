package com.example.steampunkgame.model;

public class Bug implements Enemy {
    String name = "IRON ANT";
    int defense = 1;
    int health = 3;
    int damage = 2;

    /**
     * Calculates chance of hitting Player with an Enemy's light attack and the damage it does
     * @return 0 if missed, any number >0 if hit for damage
     */
    public int short_attack() {
        int value = (int)(Math.random() * 100);
        if (value > 79) {
            return 0;
        }
        else {
            return damage / 2;
        }
    }

    /**
     * Calculates chance of hitting Player with an Enemy's heavy attack and the damage it does
     * @return 0 if missed, any number >0 if hit for damage
     */
    public int charge_attack() {
        int value = (int)(Math.random() * 100);
        if (value > 59) {
            return 0;
        }
        else {
            return (int)(damage * 1.3);
        }
    }

    /**
     * Increase Enemy's damage by 3
     */
    public void increase_stat() {
        damage += 3;
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
        int eVal = (int) (Math.random() * 10);
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
     * Checks Enemy's health
     * @return True if health>0, False if not
     */
    public int getHealth() { return health; }

    /**
     * Returns Enemy's name
     * @return Enemy's name
     */
    public String getName() {
        return name;
    }
}
