package com.example.steampunkgame.model;

public class Rock implements Enemy{
    String name = "LITERAL ROCK";
    int defense = 1;
    int health = 23;
    int damage = 0;

    public int short_attack() {
        return 0;
    }

    public int charge_attack() {
        return short_attack();
    }

    public void increase_stat() {
        health += 5;
    }

    public int getHealth() { return health; }

    public boolean healthCheck() {
        return health > 0;
    }

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
        if (eVal <= 74) {
            return 0;
        } else {
            this.increase_stat();
            return -1;
        }
    }

    public String getName() {
        return name;
    }
}
