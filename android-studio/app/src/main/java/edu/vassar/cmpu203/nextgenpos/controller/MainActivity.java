package edu.vassar.cmpu203.nextgenpos.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.nextgenpos.model.Enemy;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Bug;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Golem;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Rock;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Worker;
import edu.vassar.cmpu203.nextgenpos.model.Item;
import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.model.UI.DialogueBar;
import edu.vassar.cmpu203.nextgenpos.view.CombatDialogue;
import edu.vassar.cmpu203.nextgenpos.view.CombatScreen;
import edu.vassar.cmpu203.nextgenpos.view.ICombatScreen;
import edu.vassar.cmpu203.nextgenpos.view.PlayerDialogue;

public class MainActivity extends AppCompatActivity implements ICombatScreen.Listener{
    DialogueBar dialogueBar;
    Player p;
    CombatDialogue combatDialogue;
    PlayerDialogue playerDialogue;
    Enemy e;
    CombatScreen cScreen;

    boolean end = false;

    /**
     * onCreate method that dictates the rootview and all functions to be started on start
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        // instantiate player: maxHealth, trueDefense, damage, experience, gears, pet
        p = (Player) getIntent().getParcelableExtra("curPlayer");

        // instantiate combat and player dialogue
        this.combatDialogue = new CombatDialogue();
        this.playerDialogue = new PlayerDialogue();

        // instantiate dialogue bar
        this.dialogueBar = new DialogueBar();
        cScreen = new CombatScreen(this, this, p, enemyPicker());

        this.setContentView(cScreen.getRootView());
        }

    /**
     * Picks a random enemy
     * @return Enemy type
     */
    private Enemy enemyPicker() {
        int eVal = (int)(Math.random() * 4);
        switch (eVal) {
            // iron ant
            case 1:
                e = new Bug();
                break;
            // rock
            case 2:
                e = new Rock();
                break;
            // golem
            case 3:
                e = new Golem();
                break;
            // default-worker bot
            default:
                e = new Worker();
        }
        return e;
    }

    /**
     * Checks Player and Enemy health, sets buttonClickable if any are dead and displays correct end message
     */
    private void healthChecker() {
        // check for health
        if ( !e.healthCheck()) {
            cScreen.removeContinueText();
            int gear = e.getGear();
            p.onEnd(25);
            cScreen.renewExpGear(p);
            cScreen.buttonClickable(false);
            cScreen.displayEndWin(gear);
            winCombat();
        }
        else if ( !p.healthCheck() ) {
            cScreen.buttonClickable(false);
            endCombat();
        }
    }

    /**
     * Logic for Enemy turn, and sets buttonClickable to true
     */
    private void enemyTurn() {
        if (end) {
            switchActivitiesContinue();
        }
        cScreen.dialogueClickable(false);
        cScreen.removeContinueText();
        int eAtkChoice = e.pickAttack();
        if (eAtkChoice == 0) {
            int hit = e.short_attack();
            if (hit > 0) {
                int dmg = p.attacked(hit);
                cScreen.displayEnemyAttack("LIGHT", dmg, hit, e);
                cScreen.renewHealth(p);
            }
            else if (hit == 0) {
                cScreen.displayEnemyAttack("LIGHT", 0, 0, e);
            }
        }
        else if (eAtkChoice == 1) {
            int hit = e.charge_attack();
            if (hit > 0) {
                int dmg = p.attacked(hit);
                cScreen.displayEnemyAttack("HEAVY", dmg, hit, e);
                cScreen.renewHealth(p);
            }
            else if (hit == 0) {
                cScreen.displayEnemyAttack("HEAVY", 0, 0, e);
            }
        }
        else if (eAtkChoice == -1) {
            cScreen.displayEnemyAttack("CHARGE", 0, 0, e);
            cScreen.renewEHealth(e);
            cScreen.renewEArmor(e);
        }
        cScreen.buttonClickable(true);
        healthChecker();
    }

    /**
     * lightClick method that calls Player's light attack and sets buttonClickable to false
     */
    @Override
    public void lightClick() {
        int val = p.lightAttack();
        if (val > 0) {
            int dmg = e.attacked(val);
            cScreen.displayPlayerAttack("LIGHT", dmg, val);
            cScreen.renewEHealth(e);
        }
        else {
            cScreen.displayPlayerAttack("LIGHT", 0, 0);
        }
        cScreen.buttonClickable(false);
        healthChecker();
        continueClick("false");
    }

    /**
     * heavyClick method that calls Player's light attack and sets buttonClickable to false
     */
    @Override
    public void heavyClick() {
        int val = p.heavyAttack();
        if (val > 0) {
            int dmg = e.attacked(val);
            cScreen.displayPlayerAttack("HEAVY", dmg, val);
            cScreen.renewEHealth(e);
        }
        else {
            cScreen.displayPlayerAttack("HEAVY", 0, 0);
        }
        cScreen.buttonClickable(false);
        healthChecker();
        continueClick("false");
    }

    /**
     * invClick method that calls Player's inventory
     */
    @Override
    public void invClick() {
        switchActivitiesInventory();
    }

    /**
     * fleeClick method that calls Player's flee move and sets buttonClickable to false
     */
    @Override
    public void fleeClick() {
        boolean check = p.flee();
        cScreen.buttonClickable(false);
        if (check) {
            //cScreen.displayFlee(true);
            continueClick("flee");
        }
        else {
            cScreen.displayFlee(false);
            continueClick("false");
        }
    }

    /**
     * makes dialogueCLickable true and displays the continue text
     */
    public void continueClick(String state) {
        cScreen.dialogueClickable(true);
        cScreen.displayContinueText();
        if (state.equals("flee")) {
            switchActivitiesContinue();
        }
        else if (state.equals("lost")) {
            switchActivitiesMenu();
        }
    }

    public void endCombat(){
        cScreen.dialogueClickable(true);
        cScreen.displayEndLose();
        continueClick("lost");
    }

    public void winCombat(){
        cScreen.dialogueClickable(true);
        end = true;
    }

    /**
     * dialogueClick method that calls EnemyTurn
     */
    @Override
    public void dialogueClick() {
        enemyTurn();
    }

    private void switchActivitiesInventory() {
        Intent i = new Intent(this, InventoryActivity.class);
        i.putExtra("curPlayer", p);
        startActivity(i);
    }

    private void switchActivitiesContinue() {
        Intent i = new Intent(this, ContinueActivity.class);
        i.putExtra("curPlayer", p);
        startActivity(i);
    }
    private void switchActivitiesMenu() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}