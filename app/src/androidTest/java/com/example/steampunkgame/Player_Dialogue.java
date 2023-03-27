package com.example.steampunkgame;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Player_Dialogue {

    Map<String, String> dialogue = new HashMap<>();

    public Player_Dialogue() {
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

    public void displayPAL() throws InterruptedException {
        System.out.println(dialogue.get("p_attack_l") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    public void displayPML() throws InterruptedException {
        System.out.println(dialogue.get("p_miss_l") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    public void displayPHL() throws InterruptedException {
        System.out.println(dialogue.get("p_hit_l") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    public void displayPAH() throws InterruptedException {
        System.out.println(dialogue.get("p_attack_h") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    public void displayPMH() throws InterruptedException {
        System.out.println(dialogue.get("p_miss_h") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    public void displayPHH() throws InterruptedException {
        System.out.println(dialogue.get("p_hit_h") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    public void displayInv() throws InterruptedException {
        System.out.println(dialogue.get("inventory") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    public void displayPet() throws InterruptedException {
        System.out.println(dialogue.get("pet") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    public void displayFlee() throws InterruptedException {
        System.out.println(dialogue.get("flee") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }
}
