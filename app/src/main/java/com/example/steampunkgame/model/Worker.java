package com.example.steampunkgame.model;

public class Worker implements Enemy {
    String name = "WORKER BOT";
    int defense = 5;
    int health = 5;
    int damage = 5;

    public int short_attack() {
        int value = (int)(Math.random() * 100);
        if (value > 70) {
            return 0;
        }
        else {
            return damage;
        }
    }

    public int charge_attack() {
        int value = (int)(Math.random() * 100);
        if (value > 49) {
            return 0;
        }
        else {
            return damage * 2;
        }
    }

    public void increase_stat() {
        damage++;
        health++;
    }

    public boolean healthCheck() {
        return health > 0;
    }

    public int getHealth() { return health; }

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

    public String getName() {
        return name;
    }
}
