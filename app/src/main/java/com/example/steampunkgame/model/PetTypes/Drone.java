package com.example.steampunkgame.model.PetTypes;
import com.example.steampunkgame.model.Pet;

public class Drone implements Pet{

    String name = "F.A.S. Drone";
    int cost = 25;
    String info = "F.A.S. (Friendly Aerial Support) Drone is skilled in aerial reconnaissance and target-acquisition. Created by humans to assist with war efforts, they are now " +
            "a remnant of an ancient civilization. A few of them could still be seen patrolling the wastelands, as per their protocol. It sends geographical data to its user and allows the user to " +
            "have a location on the enemy targets. Its ability lets the user get a lock-on to the enemy and the next attack will always hit and do 150% damage.";

    /**
     * Return F.A.S. Drone
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns 25
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
     * @return nMissingATK
     */
    @Override
    public String petAbility() {
        return "nMissingATK";
    }
}
