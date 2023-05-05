package edu.vassar.cmpu203.nextgenpos.view;

import edu.vassar.cmpu203.nextgenpos.model.Enemy;

import java.util.HashMap;
import java.util.Map;

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
        dialogue.put("sentry_special", "THE STEEL SENTRY PREPARES ITSELF FOR COMBAT!");
        dialogue.put("protectron_special", "THE XT-D PROTECTRON STARTS PUMPING NANITES IN!");
        dialogue.put("watcher_special", "THE LURKING WATCHER COATS ITSELF IN HEALING ALGAE");
        dialogue.put("bot_special", "THE MECHA-BOT STRIPS ITS ARMOR TO STRENGTHEN ITS FISTS!");
        dialogue.put("tgolem_special", "THE TITANIUM GOLEM LETS OUT A METALLIC SCREECH AND ITS INFERNAL CORES GROW BRIGHTER");
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
     * Start dialogue
     *
     * @return dialogue corresponding to start
     */
    public String displayStart(){
        return dialogue.get("start");
    }

    /**
     * Enemy tries to use light attack dialogue
     *
     * @return dialogue corresponding to enemy attack light
     */
    public String displayEAL() {
        return dialogue.get("e_attack_l");
    }

    /**
     * Enemy miss light attack dialogue
     *
     * @return dialogue corresponding to enemy miss light
     */
    public String displayEML() {
        return dialogue.get("e_miss_l");
    }

    /**
     * Enemy hit light attack dialogue
     *
     * @return dialogue corresponding to enemy hit light
     */
    public String displayEHL(){
        return dialogue.get("e_hit_l");
    }

    /**
     * Enemy tries a heavy attack dialogue
     *
     * @return dialogue corresponding to enemy attack heavy
     */
    public String displayEAH() {
        return dialogue.get("e_attack_h");
    }

    /**
     * Enemy miss heavy attack dialogue
     *
     * @return dialogue corresponding to enemy miss heavy
     */
    public String displayEMH() {
        return dialogue.get("e_miss_h");
    }

    /**
     * Enemy hits heavy attack dialogue
     *
     * @return dialogue corresponding to enemy hit heavy
     */
    public String displayEHH()  {
        return dialogue.get("e_hit_h");
    }

    /**
     * Iron Ant's charge move dialogue
     *
     * @return dialogue corresponding to bug special
     */
    public String displayBug_S() {
        return dialogue.get("bug_special");
    }

    /**
     * Worker Bot's charge move dialogue
     *
     * @return dialogue corresponding to worker special
     */
    public String displayWorker_S(){
        return dialogue.get("worker_special");
    }

    /**
     * Literal Rock's charge move dialogue
     *
     * @return dialogue corresponding to rock special
     */
    public String displayRock_S() {
        return dialogue.get("rock_special");
    }

    /**
     * Literal Rock's attack dialogue
     *
     * @return dialogue corresponding to rock miss
     */
    public String displayRock_M() {
        return dialogue.get("rock_move");
    }

    /**
     * Steam Golem's charge move dialogue
     *
     * @return dialogue corresponding to golem special
     */
    public String displayGolem_S() {
        return dialogue.get("golem_special");
    }

    /**
     * Steel Sentry's charge move dialogue
     * @return dialogue corresponding to sentry special
     */
    public String displaySentry_S() {
        return dialogue.get("sentry_special");
    }

    /**
     * XT-D Protectron's charge move dialogue
     * @return dialogue corresponding to protectron special
     */
    public String displayProtectron_S() {
        return dialogue.get("protectron_special");
    }

    /**
     * Lurking Watcher's charge move dialogue
     * @return dialogue corresponding to watcher special
     */
    public String displayWatcher_S() {
        return dialogue.get("watcher_special");
    }

    /**
     * Mecha-Bot's charge move dialogue
     * @return dialogue corresponding to bot special
     */
    public String displayBot_S() {
        return dialogue.get("bot_special");
    }

    /**
     * Titanium Golem's charge move dialogue
     * @return dialogue corresponding to titanium golem special
     */
    public String displayTGolem_S() {
        return dialogue.get("tgolem_special");
    }

    /**
     * Ask for input dialogue
     *
     * @return dialogue corresponding to prompt
     */
    public String displayPrompt() {
        return dialogue.get("prompt");
    }

    /**
     * Flee is not successful dialogue
     *
     * @returndialogue corresponding to flee fail
     */
    public String displayFlee_F() {
        return dialogue.get("flee_f");
    }

    /**
     * Flee is successful dialogue
     *
     * @return dialogue corresponding to flee success
     */
    public String displayFlee_T(){
        return dialogue.get("flee_t");
    }

    /**
     * Player loses the fight
     * @return dialogue corresponding to lose
     */
    public String displayLose() {
        return dialogue.get("lose");
    }

    /**
     * Player wins the fight
     * @return dialogue corresponding to win
     */
    public String displayWin() {
        return dialogue.get("win");
    }

    /**
     * Show Player and Enemy hit damage dialogue
     *
     * @return dialogue corresponding to damage
     */
    public String displayDamage() {
        return dialogue.get("damage");
    }

    /**
     * Show Player and Enemy hit damage dialogue
     *
     * @return dialogue corresponding to damage
     */
    public String displayEnemyDamage() {
        return dialogue.get("enemy");
    }

}