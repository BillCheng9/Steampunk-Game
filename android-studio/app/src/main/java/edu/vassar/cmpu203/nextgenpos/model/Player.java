package edu.vassar.cmpu203.nextgenpos.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Player implements Parcelable {
    public int gears, health, defense, damage, maxHealth;
    public Item[] inventory = new Item[9];

    /**
     * Creates a Player entity with initial stats
     */
    public Player(int health, int maxHealth, int defense, int damage, int gears, Item[] inventory){
        // numerical stats
        this.health = health;
        this.maxHealth = maxHealth;
        this.gears = gears;
        this.defense = defense;
        this.damage = damage;

        // inventory
        this.inventory = inventory;
        // 0 = steel plates, DEF + 1
        // 1 = tungsten-steel plates, DEF + 2
        // 2 = chromium-titanium plates, DEF + 3
        // 3 = xt-1 nanites, HP + 2
        // 4 = xt-3 nanites, HP + 5
        // 5 = xt-proto nanites, HP + 9
        // 6 = mecha-gauntlets, ATK + 1
        // 7 = cba implants, ATK + 2
        // 8 = illegal cybernetic enhancements, gearBoost + 10%
    }


    protected Player(Parcel in) {
        gears = in.readInt();
        health = in.readInt();
        defense = in.readInt();
        damage = in.readInt();
        maxHealth = in.readInt();
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
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

    public void onEnd(int gear) {
        gears += gear;
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
