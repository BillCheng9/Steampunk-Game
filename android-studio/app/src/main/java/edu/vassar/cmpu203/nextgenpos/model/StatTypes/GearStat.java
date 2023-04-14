package edu.vassar.cmpu203.nextgenpos.model.StatTypes;

import edu.vassar.cmpu203.nextgenpos.model.StatBar;

public class GearStat implements StatBar {
    String name;
    int cur;
    int max;

    /**
     * Constructor for GearStat
     * @param max the max number
     */
    public GearStat(int max) {
        this.name = "GEARS";
        this.max = max;
    }

    /**
     * Getter method for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /** Getter method for cur
     *
     * @return -1
     */
    @Override
    public int getCur() {
        return -1;
    }

    /**
     * Getter method for max
     * @return max
     */
    public int getMax() {
        return max;
    }

    /**
     * toString method
     * @return (name): max
     */
    @Override
    public String toString() {
        return name + ": " + max;
    }

}
