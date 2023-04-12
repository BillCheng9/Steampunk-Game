package edu.vassar.cmpu203.nextgenpos.model.UI;

public class StatBar {
    String name;
    int cur;
    int max;

    public StatBar(String name, int cur, int max) {
        this.name = name;
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
        if (cur == -1) {
            return name + ": " + max;
        }
        return name + ": " + cur + "/" + max;
    }

}
