package com.example.steampunkgame.model;

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
        int value = (int)(Math.random() * 100);
        if (value > 84) {
            return 0;
        }
        else {
            return damage;
        }
    }

    public int attack2() {
        int value = (int)(Math.random() * 100);
        if (value > 74) {
            return 0;
        }
        else {
            return (int)(damage * 1.5);
        }
    }

    public void accessInv() {
    }

    public void triggerPet() {
    }

    public boolean flee() {
        int value = (int)(Math.random() * 100);
        return value >= 69;
    }

    public boolean healthCheck() {
        return health > 0;
    }

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
}
