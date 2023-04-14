package edu.vassar.cmpu203.nextgenpos.model.StatTypes;

import edu.vassar.cmpu203.nextgenpos.model.StatBar;

public class ArmorStat implements StatBar {
    String name;
    int cur;
    int max;

    /**
     * Constructor for ArmorStat
     * @param cur the current number
     * @param max the max number
     */
    public ArmorStat(int cur, int max) {
        this.name = "DEFENSE";
        this.cur = cur;
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
     * @return cur
     */
    public int getCur() {
        return cur;
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
