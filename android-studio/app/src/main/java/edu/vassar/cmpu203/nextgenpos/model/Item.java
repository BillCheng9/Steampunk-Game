package edu.vassar.cmpu203.nextgenpos.model;

public interface Item {

    String name = null;
    String desc = null;
    int cost = 0;
    int healthChange = 0;
    int defenseChange = 0;
    int gearChange = 0;
    int damageChange = 0;

    /**
     * Getter method for item name
     * @return name
     */
    String getName();

    /**
     * Getter method for item cost
     * @return cost
     */
    int getCost();

    /**
     * Getter method for item desc
     * @return desc
     */
    String getDesc();

    /**
     * Getter method for health change
     * @return healthChange
     */
    int getHealthChange();

    /**
     * Getter method for defense change
     * @return defenseChange
     */
    int getDefenseChange();

    /**
     * Getter method for gear change
     * @return gearChange
     */
    int getGearChange();

    /**
     * Getter method for damage change
     * @return damageChange
     */
    int getDamageChange();

}
