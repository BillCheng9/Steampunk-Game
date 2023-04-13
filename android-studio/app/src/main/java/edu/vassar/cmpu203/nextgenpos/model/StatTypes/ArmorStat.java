package edu.vassar.cmpu203.nextgenpos.model.StatTypes;

public class ArmorStat {
    String name;
    int cur;
    int max;

    public ArmorStat(int cur, int max) {
        this.name = "DEFENSE";
        this.cur = cur;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public int getCur() {
        return cur;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        return name + ": " + max;
    }

}
