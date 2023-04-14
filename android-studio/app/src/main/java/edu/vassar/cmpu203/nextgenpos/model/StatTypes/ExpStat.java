package edu.vassar.cmpu203.nextgenpos.model.StatTypes;

import edu.vassar.cmpu203.nextgenpos.model.StatBar;

public class ExpStat implements StatBar {
    String name;
    int cur;
    int max;

    /**
     * constructor for ExpStat
     * @param max the max number
     */
    public ExpStat(int max) {
        this.name = "EXPERIENCE";
        this.max = max;
    }

    /**
     * getter method for name
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
     * getter method for name
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
