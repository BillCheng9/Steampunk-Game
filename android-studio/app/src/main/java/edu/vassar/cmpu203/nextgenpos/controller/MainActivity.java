package edu.vassar.cmpu203.nextgenpos.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.nextgenpos.model.Enemy;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Bot;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Bug;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Drone;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Golem;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Protectron;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Rock;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Sentry;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.TGolem;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Watcher;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Worker;
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
    boolean die = false;
    boolean flee = false;

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
        if (p.enemyFight.equals("NONE")) {
            cScreen = new CombatScreen(this, this, p, enemyPicker());
        }
        else {
            cScreen = new CombatScreen(this, this, p, enemyRecon());
        }

        this.setContentView(cScreen.getRootView());
        }

    private Enemy enemyRecon() {
        String eName = p.enemyFight;
        switch (eName) {
            // iron ant
            case "IRON ANT":
                e = new Bug(p.enemyHealth, p.enemyDamage, p.enemyDefense);
                break;
            // rock
            case "LITERAL ROCK":
                e = new Rock(p.enemyHealth, p.enemyDamage, p.enemyDefense);
                break;
            // golem
            case "STEAM GOLEM":
                e = new Golem(p.enemyHealth, p.enemyDamage, p.enemyDefense);
                break;
            case "XT-D PROTECTRON":
                e = new Protectron(p.enemyHealth, p.enemyDamage, p.enemyDefense);
                break;
            case "STEEL SENTRY":
                e = new Sentry(p.enemyHealth, p.enemyDamage, p.enemyDefense);
                break;
            case "TITANIUM GOLEM":
                e = new TGolem(p.enemyHealth, p.enemyDamage, p.enemyDefense);
                break;
            case "LURKING WATCHER":
                e = new Watcher(p.enemyHealth, p.enemyDamage, p.enemyDefense);
                break;
            case "ANCIENT MILITARY STEAM DRONE":
                e = new Drone(p.enemyHealth, p.enemyDamage, p.enemyDefense);
                break;
            case "MECHA-BOT":
                e = new Bot(p.enemyHealth, p.enemyDamage, p.enemyDefense);
                break;
            // default-worker bot
            default:
                e = new Worker(p.enemyHealth, p.enemyDamage, p.enemyDefense);
        }
        return e;
    }

    /**
     * Picks a random enemy
     * @return Enemy type
     */
    private Enemy enemyPicker() {
        int eVal = (int)(Math.random() * 10);
        switch (eVal) {
            // iron ant
            case 1:
                e = new Bug(p.gearScore);
                break;
            // rock
            case 2:
                e = new Rock(p.gearScore);
                break;
            // golem
            case 3:
                e = new Golem(p.gearScore);
                break;
            case 4:
                e = new Bot(p.gearScore);
                break;
            case 5:
                e = new Drone(p.gearScore);
                break;
            case 6:
                e = new Protectron(p.gearScore);
                break;
            case 7:
                e = new Sentry(p.gearScore);
                break;
            case 8:
                e = new TGolem(p.gearScore);
                break;
            case 9:
                e = new Watcher(p.gearScore);
                break;
            // default-worker bot
            default:
                e = new Worker(p.gearScore);
        }
        return e;
    }

    /**
     * Checks Player and Enemy health, sets buttonClickable if any are dead and displays correct end message
     */
    private void healthChecker() {
        // check for health
        if ( !e.healthCheck()) {
            int gear = e.getGear();
            p.onEnd(gear);

            cScreen.renewExpGear(p);
            cScreen.removeContinueText();
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
        if (!end && !flee && !die) {
            cScreen.dialogueClickable(false);
            cScreen.removeContinueText();
            int eAtkChoice = e.pickAttack();
            if (eAtkChoice == 0) {
                int hit = e.short_attack();
                if (hit > 0) {
                    int dmg = p.attacked(hit);
                    cScreen.displayEnemyAttack("LIGHT", dmg, hit, e);
                    cScreen.renewHealth(p);
                } else if (hit == 0) {
                    cScreen.displayEnemyAttack("LIGHT", 0, 0, e);
                }
            } else if (eAtkChoice == 1) {
                int hit = e.charge_attack();
                if (hit > 0) {
                    int dmg = p.attacked(hit);
                    cScreen.displayEnemyAttack("HEAVY", dmg, hit, e);
                    cScreen.renewHealth(p);
                } else if (hit == 0) {
                    cScreen.displayEnemyAttack("HEAVY", 0, 0, e);
                }
            } else if (eAtkChoice == -1) {
                cScreen.displayEnemyAttack("CHARGE", 0, 0, e);
                cScreen.renewEHealth(e);
                cScreen.renewEArmor(e);
            }
            cScreen.buttonClickable(true);
            healthChecker();
        }
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
        continueClick();
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
        continueClick();
    }

    /**
     * invClick method that calls Player's inventory
     */
    @Override
    public void invClick() {
        p.enemyFight = e.getName();
        p.enemyHealth = e.getHealth();
        p.enemyDamage = e.getDamage();
        p.enemyDefense = e.getDefense();
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
            flee = true;
            cScreen.displayFlee(true);
            continueClick();
        }
        else {
            cScreen.displayFlee(false);
            continueClick();
        }
    }

    /**
     * makes dialogueCLickable true and displays the continue text
     */
    public void continueClick() {
        cScreen.dialogueClickable(true);
        cScreen.displayContinueText();
    }

    public void endCombat(){
        cScreen.dialogueClickable(true);
        cScreen.displayEndLose();
        die = true;
        continueClick();
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
        if (flee) {
            switchActivitiesContinue();
        }
        else if (die) {
            switchActivitiesMenu();
        }
        else if (end) {
            switchActivitiesContinue();
        }
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
        Intent i = new Intent(this, StartMenuActivity.class);
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