package edu.vassar.cmpu203.nextgenpos.model.StatTypes;

public class ExpStat {
    String name;
    int cur;
    int max;

    public ExpStat(int max) {
        this.name = "EXPERIENCE";
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
