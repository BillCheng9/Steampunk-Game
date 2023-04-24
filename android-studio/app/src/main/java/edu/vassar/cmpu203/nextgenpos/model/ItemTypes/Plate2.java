package edu.vassar.cmpu203.nextgenpos.model.ItemTypes;

import edu.vassar.cmpu203.nextgenpos.model.Item;

public class Plate2 implements Item {

    String name = "TUNGSTEN-STEEL PLATES";
    String desc = "ADVANCED ARMOR PLATING MADE FROM STRONG TUNGSTEN-STEEL ALLOY";
    int numberItems;
    int defenseChange = 2;

    public Plate2(int numberItems) {
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
        return getNumberItems() * defenseChange;
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
        return 0;
    }
}
