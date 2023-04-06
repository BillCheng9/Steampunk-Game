package com.example.steampunkgame.model.UI;

public class CombatButton {

    private String name;

    public CombatButton(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        name = name.toUpperCase();
        return name;
    }
}
