package edu.vassar.cmpu203.nextgenpos.controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import edu.vassar.cmpu203.nextgenpos.R;
import edu.vassar.cmpu203.nextgenpos.model.Enemy;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Bug;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Golem;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Rock;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Worker;
import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.model.UI.DialogueBar;
import edu.vassar.cmpu203.nextgenpos.view.CombatDialogue;
import edu.vassar.cmpu203.nextgenpos.view.CombatScreenFragment;
import edu.vassar.cmpu203.nextgenpos.view.FragFactory;
import edu.vassar.cmpu203.nextgenpos.view.ICombatScreen;
import edu.vassar.cmpu203.nextgenpos.view.IMainMenu;
import edu.vassar.cmpu203.nextgenpos.view.IMainView;
import edu.vassar.cmpu203.nextgenpos.view.IStartScreen;
import edu.vassar.cmpu203.nextgenpos.view.MainView;
import edu.vassar.cmpu203.nextgenpos.view.PlayerDialogue;
import edu.vassar.cmpu203.nextgenpos.view.StartScreenFragment;

public class MainActivity extends AppCompatActivity implements ICombatScreen.Listener, IMainMenu.Listener, IStartScreen.Listener {
    DialogueBar dialogueBar;
    Player p;
    CombatDialogue combatDialogue;
    PlayerDialogue playerDialogue;
    Enemy e;
    ICombatScreen combatScreen;
    CombatScreenFragment cScreen;
    StartScreenFragment sScreen;
    IMainView mainView;

    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

    /**
     * onCreate method that dictates the rootview and all functions to be started on start
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // set the fragment factory
        getSupportFragmentManager().setFragmentFactory(new FragFactory(this));

        // recreate any fragments that was there before
        super.onCreate(savedInstanceState);

        // instantiate player: maxHealth, trueDefense, damage, experience, gears, pet
        this.p = new Player(10, 5, 3, 0, 25, "None");
        // instantiate combat and player dialogue
        this.combatDialogue = new CombatDialogue();
        this.playerDialogue = new PlayerDialogue();

        // instantiate dialogue bar
        this.dialogueBar = new DialogueBar();
        cScreen = new CombatScreenFragment(this, this, p, enemyPicker());
        cScreen.dialogueClickable(false);
        cScreen.displayStart();

        sScreen = new StartScreenFragment(this, this);

        this.mainView = new MainView(this);
        this.setContentView(mainView.getRootView());

        // first time launching app should open start screen
        if (savedInstanceState == null) {
            this.mainView.displayFragment(new StartScreenFragment(this, this), false, "start");
            this.mainView.displayFragment(new CombatScreenFragment(this, this, p, e), false, "combat");
        }

    }

    /**
     * Picks a random enemy
     * @return Enemy type
     */
    private Enemy enemyPicker() {
        int eVal = (int) (Math.random() * 4);
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
            int exp = e.getExp();
            p.onEnd(e.getGear(), e.getExp());
            cScreen.renewExpGear(p);
            cScreen.displayEndWin(gear, exp);
            cScreen.buttonClickable(false);
        }
        else if ( !p.healthCheck() ) {
            cScreen.displayEndLose();
            cScreen.buttonClickable(false);
        }
    }

    /**
     * Logic for Enemy turn, and sets buttonClickable to true
     */
    private void enemyTurn() {
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
        int val = p.attack1();
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
        int val = p.attack2();
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
     * petClick method that calls Player's pet ability
     */
    @Override
    public void petClick() {
        cScreen.displayPet("NONE", -1);
    }

    /**
     * invClick method that calls Player's inventory
     */
    @Override
    public void invClick() {
        cScreen.displayInv();

    }

    /**
     * fleeClick method that calls Player's flee move and sets buttonClickable to false
     */
    @Override
    public void fleeClick() {
        boolean check = p.flee();
        if (check) {
            cScreen.buttonClickable(false);
        }
        cScreen.displayFlee(check);
        cScreen.buttonClickable(false);
        continueClick();
    }

    /**
     * makes dialogueCLickable true and displays the continue text
     */
    public void continueClick() {
        cScreen.dialogueClickable(true);
        cScreen.displayContinueText();
    }

    /**
     *
     */
    @Override
    public void workshopClick() {
    }

    /**
     * dialogueClick method that calls EnemyTurn
     */
    @Override
    public void dialogueClick() {
        enemyTurn();
    }

    public void startClick(){
        transaction.replace(R.id.fragmentContainerView, cScreen);
        transaction.addToBackStack(null);
    }

    public void helpClick(){}

    /**
     * starts the game
     */
    @Override
    public void startGame() {
        this.mainView.displayFragment(new CombatScreenFragment(this, this, p, e), true, "combat");
    }
}