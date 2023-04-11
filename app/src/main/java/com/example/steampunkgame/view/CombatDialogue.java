package com.example.steampunkgame.view;

import com.example.steampunkgame.model.Enemy;
import com.example.steampunkgame.Input;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * User interface for the entire game. Contains dialogue maps for both enemy and system messages. Current iteration
 * contains a combat prompt method. Contains many display methods that withdraw and print strings from the dialogue
 * map.
 */
public class CombatDialogue {

    public Enemy e;
    Map<String, String> dialogue = new HashMap<>();

    /**
     * HashMap for Enemy dialogue
     * @param e Enemy
     */
    public CombatDialogue (Enemy e){
        this.e = e;
        dialogue.put("start", "YOU ENGAGED A FIGHT AGAINST " + e.getName() + "!");
        dialogue.put("e_attack_l", e.getName() + " DECIDES TO ATTACK YOU!");
        dialogue.put("e_miss_l", "YOU DODGE THE " + e.getName() + "'S LIGHT ATTACK!");
        dialogue.put("e_hit_l", "YOU GET HIT BY THE " + e.getName() + "'S LIGHT ATTACK!");
        dialogue.put("e_attack_h", e.getName() + " DECIDES TO CHARGE UP A POWERFUL ATTACK!");
        dialogue.put("e_miss_h", "YOU DODGE THE " + e.getName() + "'S HEAVY ATTACK!");
        dialogue.put("e_hit_h", "YOU GET HIT BY THE " + e.getName() + "'S HEAVY ATTACK!");
        dialogue.put("bug_special", "IRON ANT SHARPENS ITS METALLIC MANDIBLES!");
        dialogue.put("worker_special", "WORKER BOT POWERS UP!");
        dialogue.put("golem_special", "STEAM GOLEM SHIFTS ITS METALLIC ARMOR TO ITS FISTS!");
        dialogue.put("rock_special", "THE ROCK SOMEHOW GROWS LARGER?!");
        dialogue.put("rock_move", "IT'S A LITERAL ROCK. IT CAN'T HURT YOU!");
    }

    /**
     * HashMap for General Combat dialogue
     */
    public CombatDialogue () {
        dialogue.put("prompt", "WHAT DO YOU WANT TO DO? (LIGHT, HEAVY, PET, INVENTORY, FLEE)");
        dialogue.put("invalid", "PLEASE PICK A VALID INPUT. (LIGHT, HEAVY, PET, INVENTORY, FLEE)");
        dialogue.put("lose", "YOUR MECHANIC BODY CAN'T HANDLE THE STRESS OF THE FIGHT ANYMORE. YOUR CORES START TO FAIL. GAME OVER!");
        dialogue.put("win", "YOU DEFEATED YOUR ENEMY!");
        dialogue.put("flee_f", "THE ENEMY CATCHES UP TO YOU!");
        dialogue.put("flee_t", "YOU SUCCESSFULLY RUN AWAY!");
        dialogue.put("finish", "YOU LIVE TO FIGHT ANOTHER DAY!");

    }

    /**
     * HashMap for Damage dialogue
     * @param dmg damage value
     */
    public CombatDialogue (int dmg) {
        dialogue.put("enemy", "ENEMY HIT YOU FOR " + dmg + " DAMAGE!");
        dialogue.put("damage", "YOU HIT THE ENEMY FOR " + dmg + " DAMAGE!");
    }


    /**
     * Asks User for input and checks if it is a valid input or not
     * @return a valid Enum Input
     * @throws InterruptedException
     */
    public Input grabInput() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        displayPrompt();
        String action = scanner.nextLine().toUpperCase();
        while ( (!action.equals("LIGHT")) && (!action.equals("HEAVY")) && (!action.equals("FLEE")) && (!action.equals("PET")) && (!action.equals("INVENTORY")) ){
            displayInvalid();
            action = scanner.nextLine().toUpperCase();
        }
        Input executeAction;

        switch (action) {
            case "LIGHT":
                executeAction = Input.LIGHT;
                break;
            case "HEAVY":
                executeAction = Input.HEAVY;
                break;
            case "PET":
                executeAction = Input.PET;
                break;
            case "INVENTORY":
                executeAction = Input.INVENTORY;
                break;
            default:
                executeAction = Input.FLEE;
                break;
        }

        return executeAction;
    }

    /**
     * Start dialogue
     * @throws InterruptedException
     */
    public void displayStart() throws InterruptedException {
        System.out.println(dialogue.get("start") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Enemy tries to use light attack dialogue
     * @throws InterruptedException
     */
    public void displayEAL() throws InterruptedException {
        System.out.println(dialogue.get("e_attack_l") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Enemy miss light attack dialogue
     * @throws InterruptedException
     */
    public void displayEML() throws InterruptedException {
        System.out.println(dialogue.get("e_miss_l") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Enemy hit light attack dialogue
     * @throws InterruptedException
     */
    public void displayEHL() throws InterruptedException {
        System.out.println(dialogue.get("e_hit_l") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Enemy tries a heavy attack dialogue
     * @throws InterruptedException
     */
    public void displayEAH() throws InterruptedException {
        System.out.println(dialogue.get("e_attack_h") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Enemy miss heavy attack dialogue
     * @throws InterruptedException
     */
    public void displayEMH() throws InterruptedException {
        System.out.println(dialogue.get("e_miss_h") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Enemy hits heavy attack dialogue
     * @throws InterruptedException
     */
    public void displayEHH() throws InterruptedException {
        System.out.println(dialogue.get("e_hit_h") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Iron Ant's charge move dialogue
     * @throws InterruptedException
     */
    public void displayBug_S() throws InterruptedException {
        System.out.println(dialogue.get("bug_special") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Worker Bot's charge move dialogue
     * @throws InterruptedException
     */
    public void displayWorker_S() throws InterruptedException {
        System.out.println(dialogue.get("worker_special") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Literal Rock's charge move dialogue
     * @throws InterruptedException
     */
    public void displayRock_S() throws InterruptedException {
        System.out.println(dialogue.get("rock_special") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Literal Rock's attack dialogue
     * @throws InterruptedException
     */
    public void displayRock_M() throws InterruptedException {
        System.out.println(dialogue.get("rock_move") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Steam Golem's charge move dialogue
     * @throws InterruptedException
     */
    public void displayGolem_S() throws InterruptedException {
        System.out.println(dialogue.get("golem_special") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Ask for input dialogue
     * @throws InterruptedException
     */
    public void displayPrompt() throws InterruptedException {
        System.out.println(dialogue.get("prompt") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Input is invalid dialogue
     * @throws InterruptedException
     */
    public void displayInvalid() throws InterruptedException {
        System.out.println(dialogue.get("invalid") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Flee is not successful dialogue
     * @throws InterruptedException
     */
    public void displayFlee_F() throws InterruptedException {
        System.out.println(dialogue.get("flee_f") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Flee is successful dialogue
     * @throws InterruptedException
     */
    public void displayFlee_T() throws InterruptedException {
        System.out.println(dialogue.get("flee_t") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Finished combat dialogue
     * @throws InterruptedException
     */
    public void combatResult(String s) throws InterruptedException {
        if (s.equals("LOSE")) System.out.println(dialogue.get("lose") + "\n");
        else if (s.equals("WIN")) System.out.println(dialogue.get("win") + "\n");
        else System.out.println(dialogue.get("finish") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Show Enemy encounter dialogue
     * @throws InterruptedException
     */
    public void displayEnemy() throws InterruptedException {
        System.out.println(dialogue.get("enemy") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Show Player and Enemy hit damage dialogue
     * @throws InterruptedException
     */
    public void displayDamage() throws InterruptedException {
        System.out.println(dialogue.get("damage") + "\n");
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Show Player's health dialogue
     * @throws InterruptedException
     */
    public void pHealth(int h) {
        System.out.println("PLAYER STABILITY: " + h);
    }
    /**
     * Show Enemy's health dialogue
     * @throws InterruptedException
     */
    public void eHealth(int h) {
        System.out.println(e.getName() + "'S STABILITY: " + h);
    }

}