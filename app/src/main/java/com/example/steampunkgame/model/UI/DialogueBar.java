package com.example.steampunkgame.model.UI;

public class DialogueBar {

    String actor;
    String text;

    public String getActor() {
        return actor;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return actor + ": " + text;
    }
}
