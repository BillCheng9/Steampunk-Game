package com.example.steampunkgame.model;

public class Golem implements Enemy{
    String name = "STEAM GOLEM";
    int defense = 10;
    int health = 20;
    int damage = 10;
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
        damage += 5;
        defense -= 5;
        if (defense < 0) {
            defense = 0;
        }
    }

    public boolean healthCheck() {
        return health > 0;
    }

    public String getName(){
        return name;
    }
    public int getHealth() { return health; }

    @Override
    public int attacked(int value) {
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
        else {
            return 0;
        }
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
}
