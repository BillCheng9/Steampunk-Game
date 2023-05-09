package edu.vassar.cmpu203.nextgenpos.model.ItemTypes;

import edu.vassar.cmpu203.nextgenpos.model.Item;

public class Gauntlets1 implements Item {

    String name = "MECHA-GAUNTLETS";
    String desc = "GAUNTLETS MADE WITH SHARPENED STEEL TO ENHANCE FIGHTING CAPABILITIES";
    int damageChange = 1;
    int cost = 3;

    /**
     * Constructor
     */
    public Gauntlets1() {
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
     * Getter method for item cost
     *
     * @return cost
     */
    @Override
    public int getCost() {
        return cost;
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
        return damageChange;
    }

    /**
     * Display stats boost
     * @return String representation of stats boosts
     */
    public String displayStats() {
        String x = "DAMAGE +" + getDamageChange();
        return x;
    }
}
