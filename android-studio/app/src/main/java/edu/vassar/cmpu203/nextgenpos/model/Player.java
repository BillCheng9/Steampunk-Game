package edu.vassar.cmpu203.nextgenpos.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Player implements Parcelable {
    public int experience, gears, health, defense, damage, maxHealth;
    public Item[] inventory = new Item[9];

    /**
     * Creates a Player entity with initial stats
     */
    public Player(int health, int maxHealth, int defense, int damage, int experience, int gears, Item[] inventory){
        // numerical stats
        this.health = health;
        this.maxHealth = maxHealth;
        this.gears = gears;
        this.defense = defense;
        this.damage = damage;
        this.experience = experience;

        // inventory
        this.inventory = inventory;
        // 0 = steel plates, DEF + 1
        // 1 = tungsten-steel plates, DEF + 2
        // 2 = chromium-titanium plates, DEF + 3
        // 3 = xt-1 nanites, HP + 1
        // 4 = xt-3 nanites, HP + 3
        // 5 = xt-proto nanites, HP + 5
        // 6 = mecha-gauntlets, ATK + 1
        // 7 = cba implants, ATK + 2
        // 8 = illegal cybernetic enhancements, gearBoost + 10%
    }


    protected Player(Parcel in) {
        experience = in.readInt();
        gears = in.readInt();
        health = in.readInt();
        defense = in.readInt();
        damage = in.readInt();
        maxHealth = in.readInt();
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(experience);
        parcel.writeInt(gears);
        parcel.writeInt(health);
        parcel.writeInt(defense);
        parcel.writeInt(damage);
        parcel.writeInt(maxHealth);
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
     * Changes total amount of gears
     */
    public void renewGear(int newGear){
        double mult = .10 * inventory[8].getNumberItems();
        gears = (int) (gears + (newGear * mult));
    }

    /**
     * Changes total maxHealth
     */
    public void renewHealth() {
        maxHealth = maxHealth + (inventory[3].getNumberItems()) + (3 * inventory[4].getNumberItems()) + (5 * inventory[5].getNumberItems());
    }

    /**
     * Changes total defense
     */
    public void renewDefense() {
        maxHealth = defense + (inventory[0].getNumberItems()) + (2 * inventory[1].getNumberItems()) + (3 * inventory[2].getNumberItems());
    }

    /**
     * Changes total attack
     */
    public void renewAttack() {
        maxHealth = maxHealth + (inventory[6].getNumberItems()) + (2 * inventory[7].getNumberItems());
    }

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
