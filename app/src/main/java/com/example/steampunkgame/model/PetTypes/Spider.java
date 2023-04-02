package com.example.steampunkgame.model.PetTypes;
import com.example.steampunkgame.model.Pet;

public class Spider implements Pet{

    String name = "spyDER.exe";
    int cost = 20;
    String info = "spyDER.exe is the newest technology created by the robots. It is capable of carrying quadruple its bodyweight and can assist its " +
            "owner in combat. No one knows what companies make these or what they're made of, but they're reliable and objectively cute. spyDER.exe never misses and deal 80% " +
            "damage based on its user's damage capabilities.";

    /**
     * Return spyDER.exe
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns 20
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
     * @return spiderATK
     */
    @Override
    public String petAbility() {
        return "spiderATK";
    }
}
