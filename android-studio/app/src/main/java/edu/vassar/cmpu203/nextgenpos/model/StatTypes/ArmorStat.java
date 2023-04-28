package edu.vassar.cmpu203.nextgenpos.model.StatTypes;

import edu.vassar.cmpu203.nextgenpos.model.StatBar;

public class ArmorStat implements StatBar {
    String name;
    int max;

    /**
     * Constructor for ArmorStat
     * @param max the max number
     */
    public ArmorStat(int max) {
        this.name = "DEFENSE";
        this.max = max;
    }

    /**
     * Getter method for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for cur
     *
     * @return cur
     */
    @Override
    public int getCur() {
        return 0;
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
