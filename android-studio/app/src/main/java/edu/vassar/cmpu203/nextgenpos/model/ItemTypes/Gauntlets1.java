package edu.vassar.cmpu203.nextgenpos.model.ItemTypes;

import edu.vassar.cmpu203.nextgenpos.model.Item;

public class Gauntlets1 implements Item {

    String name = "MECHA-GAUNTLETS";
    String desc = "GAUNTLETS MADE WITH SHARPENED STEEL TO ENHANCE FIGHTING CAPABILITIES";
    int numberItems;
    int damageChange = 1;

    public Gauntlets1(int numberItems) {
        this.numberItems = numberItems;
    }

    /**
     * Getter method for item name
     *
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Getter method for item desc
     *
     * @return desc
     */
    @Override
    public String getDesc() {
        return desc;
    }

    /**
     * Getter method for number of items
     *
     * @return numberItems
     */
    @Override
    public int getNumberItems() {
        return numberItems;
    }

    /**
     * Getter method for health change
     *
     * @return healthChange
     */
    @Override
    public int getHealthChange() {
        return 0;
    }

    /**
     * Getter method for defense change
     *
     * @return defenseChange
     */
    @Override
    public int getDefenseChange() {
        return 0;
    }

    /**
     * Getter method for gear change
     *
     * @return gearChange
     */
    @Override
    public int getGearChange() {
        return 0;
    }

    /**
     * Getter method for damage change
     *
     * @return damageChange
     */
    @Override
    public int getDamageChange() {
        return getDamageChange() * damageChange;
    }
}