package com.example.steampunkgame.model.PetTypes;
import com.example.steampunkgame.model.Pet;

public class Marlow implements Pet{

    String name = "Marlow";
    int cost = 10;
    String info = "Marlow, a cybernetic dog, created by Robotic Animals Inc., are some of the most popular cybernetic dog breeds currently! These objectively " +
            "adorable and trustworthy dogs are useful for maintaining protection and fighting robotic monsters. Marlow buffs the user's damage by 2 and their defense by 1.";

    /**
     * Return Marlow
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns 10
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
     * @return MarlowBuff
     */
    @Override
    public String petAbility() {
        return "MarlowBuff";
    }
}
