package edu.vassar.cmpu203.nextgenpos.model.StatTypes;

import edu.vassar.cmpu203.nextgenpos.model.StatBar;

public class eHealthStat implements StatBar {
    String name;
    int max;

    /**
     * Constructor for eHealthStat
     * @param name name
     * @param max max number
     */
    public eHealthStat(String name, int max) {
        this.name = name;
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
        return name + ": " +  max;
    }

}
