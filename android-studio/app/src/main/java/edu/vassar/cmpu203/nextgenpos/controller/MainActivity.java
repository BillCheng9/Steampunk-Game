package edu.vassar.cmpu203.nextgenpos.controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.nextgenpos.model.Enemy;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Bug;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Golem;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Rock;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Worker;
import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.model.UI.CombatButton;
import edu.vassar.cmpu203.nextgenpos.model.UI.DialogueBar;
import edu.vassar.cmpu203.nextgenpos.view.CombatDialogue;
import edu.vassar.cmpu203.nextgenpos.view.CombatScreen;
import edu.vassar.cmpu203.nextgenpos.view.ICombatScreen;
import edu.vassar.cmpu203.nextgenpos.view.PlayerDialogue;

public class MainActivity extends AppCompatActivity implements ICombatScreen.Listener {

    CombatButton lightButton;
    CombatButton heavyButton;
    CombatButton fleeButton;
    CombatButton invButton;
    CombatButton petButton;
    DialogueBar dialogueBar;
    Player p;
    CombatDialogue combatDialogue;
    PlayerDialogue playerDialogue;
    Enemy e;
    ICombatScreen combatScreen;
    CombatScreen cScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // instantiate player: maxHealth, trueDefense, damage, experience, gears, pet
        this.p = new Player(10, 5, 3, 0, 25, "None");
        // instantiate combat and player dialogue
        this.combatDialogue = new CombatDialogue();
        this.playerDialogue = new PlayerDialogue();

        // instantiate buttons
        this.lightButton = new CombatButton("LIGHT");
        this.heavyButton = new CombatButton("HEAVY");
        this.fleeButton = new CombatButton("RUN AWAY");
        this.invButton = new CombatButton("OPEN BAG");
        this.petButton = new CombatButton("USE PET");

        // instantiate dialogue bar
        this.dialogueBar = new DialogueBar();

        // picks enemy
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
        cScreen = new CombatScreen(this, this, p, e);
        this.combatScreen = new CombatScreen(this, this, p, e);
        cScreen.dialogueClickable(false);
        cScreen.DisplayStart();
        this.setContentView(cScreen.getRootView());
    }

    private void HealthChecker() {
        // check for health
        if ( !e.healthCheck()) {
            cScreen.DisplayEndWin();
            cScreen.buttonClickable(false);
        }
        else if ( !p.healthCheck() ) {
            cScreen.DisplayEndLose();
            cScreen.buttonClickable(false);
        }
    }

    private void EnemyTurn() {
        cScreen.dialogueClickable(false);
        cScreen.RemoveContinueText();
        int eAtkChoice = e.pickAttack();
        if (eAtkChoice == 0) {
            int hit = e.short_attack();
            if (hit > 0) {
                int dmg = p.attacked(hit);
                cScreen.DisplayEnemyAttack("LIGHT", dmg, hit, e);
                cScreen.renewHealth(p);
            }
            else if (hit == 0) {
                cScreen.DisplayEnemyAttack("LIGHT", 0, 0, e);
            }
        }
        else if (eAtkChoice == 1) {
            int hit = e.charge_attack();
            if (hit > 0) {
                int dmg = p.attacked(hit);
                cScreen.DisplayEnemyAttack("HEAVY", dmg, hit, e);
                cScreen.renewHealth(p);
            }
            else if (hit == 0) {
                cScreen.DisplayEnemyAttack("HEAVY", 0, 0, e);
            }
        }
        else if (eAtkChoice == -1) {
            cScreen.DisplayEnemyAttack("CHARGE", 0, 0, e);
            cScreen.renewEHealth(e);
            cScreen.renewEArmor(e);
        }
        cScreen.buttonClickable(true);
        HealthChecker();
    }

    @Override
    public void lightClick() {
        int val = p.attack1();
        if (val > 0) {
            int dmg = e.attacked(val);
            cScreen.DisplayPlayerAttack("LIGHT", dmg, val);
            cScreen.renewEHealth(e);
        }
        else {
            cScreen.DisplayPlayerAttack("LIGHT", 0, 0);
        }
        cScreen.buttonClickable(false);
        HealthChecker();
        continueClick();
    }

    @Override
    public void heavyClick() {
        int val = p.attack2();
        if (val > 0) {
            int dmg = e.attacked(val);
            cScreen.DisplayPlayerAttack("HEAVY", dmg, val);
            cScreen.renewEHealth(e);
        }
        else {
            cScreen.DisplayPlayerAttack("HEAVY", 0, 0);
        }
        cScreen.buttonClickable(false);
        HealthChecker();
        continueClick();
    }

    @Override
    public void petClick() {
        cScreen.DisplayPet("NONE", -1);
    }

    @Override
    public void invClick() {
        cScreen.DisplayInv();

    }

    @Override
    public void fleeClick() {
        boolean check = p.flee();
        if (check) {
            cScreen.buttonClickable(false);
        }
        cScreen.DisplayFlee(check);
        cScreen.buttonClickable(false);
        continueClick();
    }
    public void continueClick() {
        cScreen.dialogueClickable(true);
        cScreen.DisplayContinueText();
    }

    @Override
    public void dialogueClick() {
        EnemyTurn();
    }

}