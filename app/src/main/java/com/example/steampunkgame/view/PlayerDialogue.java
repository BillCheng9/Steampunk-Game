package com.example.steampunkgame.view;

import java.util.*;
import java.util.concurrent.TimeUnit;

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
     * @throws InterruptedException
     */
    public void displayPAL() throws InterruptedException {
        System.out.println(dialogue.get("p_attack_l") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Player misses light attack dialogue
     * @throws InterruptedException
     */
    public void displayPML() throws InterruptedException {
        System.out.println(dialogue.get("p_miss_l") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Player hits light attack dialogue
     * @throws InterruptedException
     */
    public void displayPHL() throws InterruptedException {
        System.out.println(dialogue.get("p_hit_l") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Player uses a heavy attack dialogue
     * @throws InterruptedException
     */
    public void displayPAH() throws InterruptedException {
        System.out.println(dialogue.get("p_attack_h") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Player misses heavy attack dialogue
     * @throws InterruptedException
     */
    public void displayPMH() throws InterruptedException {
        System.out.println(dialogue.get("p_miss_h") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Player hits heavy attack dialogue
     * @throws InterruptedException
     */
    public void displayPHH() throws InterruptedException {
        System.out.println(dialogue.get("p_hit_h") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Player uses inventory dialogue
     * @throws InterruptedException
     */
    public void displayInv() throws InterruptedException {
        System.out.println(dialogue.get("inventory") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Player uses Pet ability dialogue
     * @throws InterruptedException
     */
    public void displayPet() throws InterruptedException {
        System.out.println(dialogue.get("pet") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Player tries to flee dialogue
     * @throws InterruptedException
     */
    public void displayFlee() throws InterruptedException {
        System.out.println(dialogue.get("flee") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }
}
