package edu.vassar.cmpu203.nextgenpos.view;

import java.util.HashMap;
import java.util.Map;

public class PlayerDialogue {

    Map<String, String> dialogue = new HashMap<>();

    /**
     * HashMap for Player Dialogue in Combat
     */
    public PlayerDialogue() {
        dialogue.put("p_attack_l", "YOU DECIDE TO DO A LIGHT ATTACK!");
        dialogue.put("p_miss_l", "THE ENEMY DODGES YOUR LIGHT ATTACK!");
        dialogue.put("p_hit_l", "YOU LANDED A LIGHT ATTACK!");
        dialogue.put("p_attack_h", "YOU DECIDE TO DO A HEAVY ATTACK!");
        dialogue.put("p_miss_h", "THE ENEMY DODGES YOUR HEAVY ATTACK!");
        dialogue.put("p_hit_h", "YOU LANDED A HEAVY ATTACK!");
        dialogue.put("inventory", "YOU DECIDE TO OPEN YOUR INVENTORY!");
        dialogue.put("pet", "YOU DECIDE TO USE YOUR PET'S ABILITY!");
        dialogue.put("flee", "YOU DECIDE TO RUN AWAY!");
    }

    /**
     * Player uses light attack dialogue
     *
     * @return
     */
    public String displayPAL() {
        return dialogue.get("p_attack_l");
    }

    /**
     * Player misses light attack dialogue
     *
     * @return
     */
    public String displayPML() {
        return dialogue.get("p_miss_l");
    }

    /**
     * Player hits light attack dialogue
     *
     * @return
     */
    public String displayPHL(){
        return dialogue.get("p_hit_l");
    }

    /**
     * Player uses a heavy attack dialogue
     *
     * @return
     */
    public String displayPAH() {
        return dialogue.get("p_attack_h");
    }

    /**
     * Player misses heavy attack dialogue
     *
     * @return
     */
    public String displayPMH() {
        return dialogue.get("p_miss_h");
    }

    /**
     * Player hits heavy attack dialogue
     *
     * @return
     */
    public String displayPHH() {
        return dialogue.get("p_hit_h");
    }

    /**
     * Player tries to flee dialogue
     *
     * @return
     */
    public String displayFlee() {
        return dialogue.get("flee");
    }
}
