package com.example.steampunkgame.model.PetTypes;
import com.example.steampunkgame.model.Pet;

public class Servatoid implements Pet{

    String name = "Servatoid Bot Healer";
    int cost = 5;
    String info = "Servatoid Bot are robots made for servitude for the extinct humans. Now useless and without direction, they roam the streets looking for humans to assist. " +
            "Now, rNet has hacked into their programming and reprogrammed them to act as servants for their company. This type of Servatoid Bot specializes in healing " +
            "and maintaining their user's health. Servatoid Bot Healer can heal their user by this formula: rnd(1,4)+level.";

    /**
     * Return Servatoid Bot
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns 5
     * @return cost
     */
    @Override
    public int getCost() {
        return cost;
    }

    /**
     * Returns Pet's information
     * @return info
     */
    @Override
    public String getInfo() {
        return info;
    }

    /**
     * Activates Pet's ability
     * @return servaBHeal
     */
    @Override
    public String petAbility() {
        return "servaBHeal";
    }
}
