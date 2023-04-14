package edu.vassar.cmpu203.nextgenpos.model;

public interface StatBar {
    String name = null;
    int max = 0;

    /**
     * Getter method for name
     * @return name
     */
    public String getName();

    /**
     * Getter method for cur
     * @return cur
     */
    public int getCur();

    /**
     * Getter method for max
     * @return max
     */
    public int getMax();

    /**
     * toString method
     * @return toString
     */
    @Override
    public String toString();

}
