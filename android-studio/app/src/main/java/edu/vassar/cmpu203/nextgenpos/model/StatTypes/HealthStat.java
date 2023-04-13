package edu.vassar.cmpu203.nextgenpos.model.StatTypes;

public class HealthStat {
    String name;
    int cur;
    int max;

    public HealthStat(int cur, int max) {
        this.name = "HEALTH";
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
        return name + ": " + cur + "/" + max;
    }

}
