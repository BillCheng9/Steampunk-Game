package edu.vassar.cmpu203.nextgenpos.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.nextgenpos.model.Enemy;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Bug;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Golem;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Rock;
import edu.vassar.cmpu203.nextgenpos.model.EnemyTypes.Worker;
import edu.vassar.cmpu203.nextgenpos.model.UI.CombatButton;
import edu.vassar.cmpu203.nextgenpos.view.CombatDialogue;
import edu.vassar.cmpu203.nextgenpos.view.CombatScreen;
import edu.vassar.cmpu203.nextgenpos.model.UI.DialogueBar;
import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.view.ICombatScreen;
import edu.vassar.cmpu203.nextgenpos.view.PlayerDialogue;

public class MainActivity extends AppCompatActivity {

    CombatButton lightButton;
    CombatButton heavyButton;
    CombatButton fleeButton;
    CombatButton invButton;
    CombatButton petButton;
    DialogueBar dialogueBar;
    Player p;
    CombatDialogue combatDialogue;
    PlayerDialogue playerDialogue;
    Combat combat;
    Enemy e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // instantiate player: maxHealth, trueDefense, damage, experience, gears, pet
        this.p = new Player(10, 5, 3, 0, 25, "None");
        //instantiate combat and player dialogue
        this.combatDialogue = new CombatDialogue();
        this.playerDialogue = new PlayerDialogue();
        this.combat = new Combat();

        // instantiate buttons
        this.lightButton = new CombatButton("LIGHT");
        this.heavyButton = new CombatButton("HEAVY");
        this.fleeButton = new CombatButton("RUN AWAY");
        this.invButton = new CombatButton("OPEN BAG");
        this.petButton = new CombatButton("USE PET");

        // instantiate dialogue bar
        this.dialogueBar = new DialogueBar();

        // picks enemy
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

        CombatScreen combatScreen = new CombatScreen(this, new ICombatScreen.Listener() {
            @Override
            public void onBTNClick(String name) {
            }
        }, p, e);

        // combat turn
        // 1. display start
        combatScreen.DisplayStart();
        while (combat.CombatTurn(p, e, combatScreen)) {
            // 2. player goes first
            combatScreen.DisplayPlayerAttack("LIGHT", 5, 1);
            e.attacked(5);
            // 3. renew stats
            combatScreen.renewStat(p, e);
            // 4. enemy goes next
            // 5. renew stats
        }

        setContentView(combatScreen.getRootView());
    }
}