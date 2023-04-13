package edu.vassar.cmpu203.nextgenpos.model.StatTypes;

public class eHealthStat {
    String name;
    int max;

    public eHealthStat(String name, int max) {
        this.name = name;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        return name + ": " +  max;
    }

}
