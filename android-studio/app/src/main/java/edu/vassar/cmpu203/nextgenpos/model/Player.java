package edu.vassar.cmpu203.nextgenpos.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Player implements Parcelable {
    public int experience, gears, health, defense, damage, maxHealth, trueDefense;
    public Item[] inventory;

    /**
     * Creates a Player entity with (temporary) numbers for stats
     */
    public Player(int maxHealth, int trueDefense, int damage, int experience, int gears, Item[] inventory){
        //Placeholder values for first iteration
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.gears = gears;
        this.defense = trueDefense;
        this.trueDefense = trueDefense;
        this.damage = damage;
        this.experience = experience;
        this.inventory = inventory;
    }


    protected Player(Parcel in) {
        experience = in.readInt();
        gears = in.readInt();
        health = in.readInt();
        defense = in.readInt();
        damage = in.readInt();
        maxHealth = in.readInt();
        trueDefense = in.readInt();
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(experience);
        parcel.writeInt(gears);
        parcel.writeInt(health);
        parcel.writeInt(defense);
        parcel.writeInt(damage);
        parcel.writeInt(maxHealth);
        parcel.writeInt(trueDefense);
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    /**
     * Calculates whether or not the Player hits a light attack
     *
     * @return A 0 if the attack misses or any number > 0 indicating a hit and the hit damage
     */
    public int lightAttack() {
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
    public int heavyAttack() {
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

    @Override
    public int describeContents() {
        return 0;
    }

}
