package com.example.steampunkgame.model;

public class Bug implements Enemy {
    String name = "IRON ANT";
    int defense = 1;
    int health = 3;
    int damage = 2;
    public int short_attack() {
        int value = (int)(Math.random() * 100);
        if (value > 79) {
            return 0;
        }
        else {
            return damage / 2;
        }
    }

    public int charge_attack() {
        int value = (int)(Math.random() * 100);
        if (value > 59) {
            return 0;
        }
        else {
            return (int)(damage * 1.3);
        }
    }

    public void increase_stat() {
        damage += 3;
    }

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
        if (eVal <= 44) {
            return 0;
        } else if (eVal <= 74) {
            return 1;
        } else {
            this.increase_stat();
            return -1;
        }
    }

    public int getHealth() { return health; }

    public String getName() {
        return name;
    }
}
