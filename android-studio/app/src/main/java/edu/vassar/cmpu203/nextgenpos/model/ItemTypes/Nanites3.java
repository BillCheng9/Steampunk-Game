package edu.vassar.cmpu203.nextgenpos.model.ItemTypes;

import edu.vassar.cmpu203.nextgenpos.model.Item;

public class Nanites3 implements Item {

    String name = "XT-PROTO NANITES";
    String desc = "A SET OF STATE-OF-THE-ART NANITES THAT PROVIDES OVERCLOCKING CAPABILITY FOR THE STANDARD CORES";
    int healthChange = 9;
    int cost = 15;

    /**
     * Constructor
     */
    public Nanites3() {

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
        return healthChange;
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
        return 0;
    }

    /**
     * Display stats boost
     * @return String representation of stats boosts
     */
    public String displayStats() {
        String x = "HEALTH +" + getHealthChange();
        return x;
    }
}
