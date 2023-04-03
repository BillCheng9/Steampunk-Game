package com.example.steampunkgame.model;

public interface Pet {

    /**
     * Getter method for Pet's name
     * @return Pet's name
     */
    String getName();

    /**
     * Getter method for Pet's cost
     * @return Pet's cost
     */
    int getCost();

    /**
     * Getter method for Pet's ability information
     * @return Pet's ability
     */
    String getInfo();

    /**
     * Activates Pet's ability and either increases Player's stats or does damage to Enemy or does a special effect
     * @return a one-worded string representation of the ability
     */
    String petAbility();
}
