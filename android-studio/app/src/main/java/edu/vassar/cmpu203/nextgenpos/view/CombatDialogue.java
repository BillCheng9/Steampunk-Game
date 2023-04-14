package edu.vassar.cmpu203.nextgenpos.view;


import edu.vassar.cmpu203.nextgenpos.Input;
import edu.vassar.cmpu203.nextgenpos.model.Enemy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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
        dialogue.put("e_attack_l", "THE " + e.getName() + " DECIDES TO ATTACK YOU!");
        dialogue.put("e_miss_l", "YOU DODGE THE " + e.getName() + "'S LIGHT ATTACK!");
        dialogue.put("e_hit_l", "YOU GET HIT BY THE " + e.getName() + "'S LIGHT ATTACK!");
        dialogue.put("e_attack_h", "THE " + e.getName() + " DECIDES TO CHARGE UP A POWERFUL ATTACK!");
        dialogue.put("e_miss_h", "YOU DODGE THE " + e.getName() + "'S HEAVY ATTACK!");
        dialogue.put("e_hit_h", "YOU GET HIT BY THE " + e.getName() + "'S HEAVY ATTACK!");
        dialogue.put("bug_special", "IRON ANT SHARPENS ITS METALLIC MANDIBLES!");
        dialogue.put("worker_special", "WORKER BOT POWERS UP!");
        dialogue.put("golem_special", "STEAM GOLEM SHIFTS ITS METALLIC ARMOR TO ITS FISTS!");
        dialogue.put("rock_special", "THE ROCK SOMEHOW GROWS LARGER?!");
        dialogue.put("rock_move", "IT'S A LITERAL ROCK. IT CAN'T HURT YOU...");
    }

    /**
     * HashMap for General Combat dialogue
     */
    public CombatDialogue () {
        dialogue.put("prompt", "WHAT DO YOU WANT TO DO?");
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
     *
     * @return
     */
    public String displayStart(){
        return dialogue.get("start");
    }

    /**
     * Enemy tries to use light attack dialogue
     *
     * @return
     */
    public String displayEAL() {
        return dialogue.get("e_attack_l");
    }

    /**
     * Enemy miss light attack dialogue
     *
     * @return
     */
    public String displayEML() {
        return dialogue.get("e_miss_l");
    }

    /**
     * Enemy hit light attack dialogue
     *
     * @return
     */
    public String displayEHL(){
        return dialogue.get("e_hit_l");
    }

    /**
     * Enemy tries a heavy attack dialogue
     *
     * @return
     */
    public String displayEAH() {
        return dialogue.get("e_attack_h");
    }

    /**
     * Enemy miss heavy attack dialogue
     *
     * @return
     */
    public String displayEMH() {
        return dialogue.get("e_miss_h");
    }

    /**
     * Enemy hits heavy attack dialogue
     *
     * @return
     */
    public String displayEHH()  {
        return dialogue.get("e_hit_h");
    }

    /**
     * Iron Ant's charge move dialogue
     *
     * @return
     */
    public String displayBug_S() {
        return dialogue.get("bug_special");
    }

    /**
     * Worker Bot's charge move dialogue
     *
     * @return
     */
    public String displayWorker_S(){
        return dialogue.get("worker_special");
    }

    /**
     * Literal Rock's charge move dialogue
     *
     * @return
     */
    public String displayRock_S() {
        return dialogue.get("rock_special");
    }

    /**
     * Literal Rock's attack dialogue
     *
     * @return
     */
    public String displayRock_M() {
        return dialogue.get("rock_move");
    }

    /**
     * Steam Golem's charge move dialogue
     *
     * @return
     */
    public String displayGolem_S() {
        return dialogue.get("golem_special");
    }

    /**
     * Ask for input dialogue
     *
     * @return
     */
    public String displayPrompt() {
        return dialogue.get("prompt");
    }

    /**
     * Input is invalid dialogue
     *
     * @return
     */
    public String displayInvalid() {
        return dialogue.get("invalid");
    }

    /**
     * Flee is not successful dialogue
     *
     * @return
     */
    public String displayFlee_F() {
        return dialogue.get("flee_f");
    }

    /**
     * Flee is successful dialogue
     *
     * @return
     */
    public String displayFlee_T(){
        return dialogue.get("flee_t");
    }

    public String displayLose() {
        return dialogue.get("lose");
    }
    public String displayWin() {
        return dialogue.get("win");
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
     *
     * @return
     */
    public String displayEnemy() {
        return dialogue.get("enemy");
    }

    /**
     * Show Player and Enemy hit damage dialogue
     *
     * @return
     */
    public String displayDamage() {
        return dialogue.get("damage");
    }

}