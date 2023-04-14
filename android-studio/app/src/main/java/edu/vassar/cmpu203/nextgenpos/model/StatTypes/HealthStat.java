package edu.vassar.cmpu203.nextgenpos.model.StatTypes;

import edu.vassar.cmpu203.nextgenpos.model.StatBar;

public class HealthStat implements StatBar {
    String name;
    int cur;
    int max;

    /**
     * Constructor for HealthStat
     * @param cur the current number
     * @param max the max number
     */
    public HealthStat(int cur, int max) {
        this.name = "HEALTH";
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
     * @return (name): cur / max
     */
    @Override
    public String toString() {
        return name + ": " + cur + "/" + max;
    }

}
