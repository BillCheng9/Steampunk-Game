package edu.vassar.cmpu203.nextgenpos.model.StatTypes;

public class GearStat {
    String name;
    int cur;
    int max;

    public GearStat(int max) {
        this.name = "GEARS";
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
        return name + ": " + max;
    }

}
