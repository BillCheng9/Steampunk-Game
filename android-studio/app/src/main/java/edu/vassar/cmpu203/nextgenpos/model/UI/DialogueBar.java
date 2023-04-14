package edu.vassar.cmpu203.nextgenpos.model.UI;

public class DialogueBar {

    String actor;
    String text;

    /**
     * Getter method for actor
     * @return actor
     */
    public String getActor() {
        return actor;
    }

    /**
     * Getter method for text
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * toString method
     * @return (actor): text
     */
    @Override
    public String toString() {
        return actor + ": " + text;
    }
}
