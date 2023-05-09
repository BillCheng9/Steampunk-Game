package edu.vassar.cmpu203.nextgenpos.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Player implements Parcelable {
    public int gears, health, defense, damage, maxHealth, gearMult, gearScore;
    public int steel, tung, chrom, xt1, xt3, xtp, gaunt1, gaunt2, illegal;
    public String enemyFight;
    public int enemyHealth, enemyDefense, enemyDamage;
    public boolean gameClick, gameContinue;
    public String gameText, contText;

    /**
     * Creates a Player entity with (temporary) numbers for stats
     */
    public Player(int health, int maxHealth, int defense, int damage, int gears, int gearMult){
        //Placeholder values for first iteration
        this.health = health;
        this.maxHealth = maxHealth;
        this.gears = gears;
        this.defense = defense;
        this.damage = damage;
        this.gearMult = gearMult;
        this.gearScore = 0;
        this.steel = 0;
        this.tung = 0;
        this.chrom = 0;
        this.xt1 = 0;
        this.xt3 = 0;
        this.xtp = 0;
        this.gaunt1 = 0;
        this.gaunt2 = 0;
        this.illegal = 0;
        this.enemyFight = "NONE";
        this.enemyHealth = 0;
        this.enemyDamage = 0;
        this.enemyDefense = 0;
        this.gameClick = gameClick;
        this.gameContinue = gameContinue;
        this.gameText = gameText;
        this.contText = contText;
    }

    /**
     * Player parcel
     * @param in
     */
    protected Player(Parcel in) {
        gears = in.readInt();
        health = in.readInt();
        defense = in.readInt();
        damage = in.readInt();
        maxHealth = in.readInt();
        gearMult = in.readInt();
        gearScore = in.readInt();
        enemyFight = in.readString();
        enemyHealth = in.readInt();
        enemyDamage = in.readInt();
        enemyDefense = in.readInt();
        steel = in.readInt();
        tung = in.readInt();
        chrom = in.readInt();
        xt1 = in.readInt();
        xt3 = in.readInt();
        xtp = in.readInt();
        gaunt1 = in.readInt();
        gaunt2 = in.readInt();
        illegal = in.readInt();
        gameClick = in.readBoolean();
        gameContinue = in.readBoolean();
        gameText = in.readString();
        contText = in.readString();
    }

    /**
     * writes to parcel
     * @param parcel
     * @param i
     */
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(gears);
        parcel.writeInt(health);
        parcel.writeInt(defense);
        parcel.writeInt(damage);
        parcel.writeInt(maxHealth);
        parcel.writeInt(gearMult);
        parcel.writeInt(gearScore);
        parcel.writeString(enemyFight);
        parcel.writeInt(enemyHealth);
        parcel.writeInt(enemyDamage);
        parcel.writeInt(enemyDefense);
        parcel.writeInt(steel);
        parcel.writeInt(chrom);
        parcel.writeInt(tung);
        parcel.writeInt(xt1);
        parcel.writeInt(xt3);
        parcel.writeInt(xtp);
        parcel.writeInt(gaunt1);
        parcel.writeInt(gaunt2);
        parcel.writeInt(illegal);
        parcel.writeBoolean(gameClick);
        parcel.writeBoolean(gameContinue);
        parcel.writeString(gameText);
        parcel.writeString(contText);
    }

    /**
     * creates player
     */
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

    /**
     * changes player gears on end
     * @param gear
     */
    public void onEnd(int gear) {
        this.gears = gears + (gear * gearMult);
    }

    /**
     * describes contents
     * @return 0
     */
    @Override
    public int describeContents() {
        return 0;
    }

}
