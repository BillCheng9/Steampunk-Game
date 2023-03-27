package com.example.steampunkgame;

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

    Player_Dialogue d = new Player_Dialogue();

    public int attack1() throws InterruptedException {
        d.displayPAL();
        int value = (int)(Math.random() * 100);
        if (value > 84) {
            d.displayPML();
            return 0;
        }
        else {
            d.displayPHL();
            return damage;
        }
    }

    public int attack2() throws InterruptedException {
        d.displayPAH();
        int value = (int)(Math.random() * 100);
        if (value > 74) {
            d.displayPMH();
            return 0;
        }
        else {
            d.displayPHH();
            return (int)(damage * 1.5);
        }
    }

    public void accessInv() throws InterruptedException {
        d.displayInv();
    }

    public void triggerPet() throws InterruptedException {
        d.displayPet();
    }

    public boolean flee() throws InterruptedException {
        d.displayFlee();
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
