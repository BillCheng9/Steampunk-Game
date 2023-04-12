package edu.vassar.cmpu203.nextgenpos.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

import edu.vassar.cmpu203.nextgenpos.databinding.ActivityMainBinding;
import edu.vassar.cmpu203.nextgenpos.model.Enemy;
import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.model.UI.DialogueBar;
import edu.vassar.cmpu203.nextgenpos.model.UI.StatBar;

public class CombatScreen implements ICombatScreen {

    ActivityMainBinding binding;
    Listener listener;
    PlayerDialogue dialogue;
    StatBar healthBar;
    StatBar armorBar;
    StatBar expBar;
    StatBar gearBar;
    StatBar eHealthBar;
    StatBar eArmorBar;
    DialogueBar dialogueBar;
    CombatDialogue combatDialogue;
    PlayerDialogue playerDialogue;
    CombatDialogue combatEnemyDialogue;
    String attType = "NONE";

    public CombatScreen(Context context, @NonNull Listener listener, Player p, Enemy e) {

        // instantiate
        this.binding = ActivityMainBinding.inflate(LayoutInflater.from(context));
        this.listener = listener;

        dialogue = new PlayerDialogue();
        healthBar = new StatBar("HEALTH", p.health, p.maxHealth);
        armorBar = new StatBar("ARMOR", -1, p.defense);
        expBar = new StatBar("EXPERIENCE", -1, p.experience);
        gearBar = new StatBar("GEARS", -1, p.gears);
        eHealthBar = new StatBar(e.getName() + " HEALTH", -1, e.getHealth());
        eArmorBar = new StatBar(e.getName() + " ARMOR", -1, e.getDefense());
        dialogueBar = new DialogueBar();
        combatDialogue = new CombatDialogue();
        combatEnemyDialogue = new CombatDialogue(e);
        playerDialogue = new PlayerDialogue();

        // initiate stat bar
        this.binding.healthText.setText(healthBar.toString());
        this.binding.armorText.setText(armorBar.toString());
        this.binding.expText.setText(expBar.toString());
        this.binding.gearText.setText(gearBar.toString());
        this.binding.enemyHealthText.setText(eHealthBar.toString());
        this.binding.enemyArmorText.setText(eArmorBar.toString());

        // button onclick
        this.binding.lightAttackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CombatScreen.this.listener.lightClick();
                CombatScreen.this.binding.dialogueText.setText(playerDialogue.displayPAL());
            }
        });
        this.binding.heavyAttackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CombatScreen.this.listener.heavyClick();
                CombatScreen.this.binding.dialogueText.setText(playerDialogue.displayPAH());
            }
        });
        this.binding.fleeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CombatScreen.this.listener.fleeClick();
                CombatScreen.this.binding.dialogueText.setText(playerDialogue.displayFlee());
            }
        });
        this.binding.invBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CombatScreen.this.listener.invClick();
                CombatScreen.this.binding.dialogueText.setText(playerDialogue.displayInv());;
            }
        });
        this.binding.petBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CombatScreen.this.listener.petClick();
                CombatScreen.this.binding.dialogueText.setText(playerDialogue.displayPet());
            }
        });
    }

    public void DisplayStart() {
        String text = combatEnemyDialogue.displayStart() + " " + combatDialogue.displayPrompt();
        this.binding.dialogueText.setText(text);
    }

    public void DisplayPlayerAttack(String type, int dmg, int success) {
        String text = "";
        CombatDialogue damageDialogue = new CombatDialogue(dmg);
        if (type.equals("LIGHT")) {
            if (success > 0) {
                text += playerDialogue.displayPHL();
                text += damageDialogue.displayDamage();
            }
            else if (success < 1) {
                text += playerDialogue.displayPML();
            }
        }
        if (type.equals("HEAVY")) {
            if (success > 0) {
                text += playerDialogue.displayPHH() + " ";
                text += damageDialogue.displayDamage();
            }
            else if (success < 1) {
                text += playerDialogue.displayPMH();
            }
        }
        this.binding.dialogueText.setText(text);
    }
    public void Clickable(boolean clickable) {
        CombatScreen.this.binding.dialogueArea.setClickable(clickable);
        CombatScreen.this.binding.lightAttackBTN.setClickable(clickable);
        CombatScreen.this.binding.heavyAttackBTN.setClickable(clickable);
        CombatScreen.this.binding.fleeBTN.setClickable(clickable);
        CombatScreen.this.binding.petBTN.setClickable(clickable);
        CombatScreen.this.binding.invBTN.setClickable(clickable);
    }
    public void buttonClickable(boolean clickable) {
        CombatScreen.this.binding.lightAttackBTN.setClickable(clickable);
        CombatScreen.this.binding.heavyAttackBTN.setClickable(clickable);
        CombatScreen.this.binding.fleeBTN.setClickable(clickable);
        CombatScreen.this.binding.petBTN.setClickable(clickable);
        CombatScreen.this.binding.invBTN.setClickable(clickable);
    }

    public void renewStats(Player p, Enemy e) {
        healthBar = new StatBar("HEALTH", p.health, p.maxHealth);
        armorBar = new StatBar("ARMOR", -1, p.defense);
        expBar = new StatBar("EXPERIENCE", -1, p.experience);
        gearBar = new StatBar("GEARS", -1, p.gears);
        eHealthBar = new StatBar(e.getName() + " HEALTH", -1, e.getHealth());
        eArmorBar = new StatBar(e.getName() + " ARMOR", -1, e.getDefense());
        this.binding.healthText.setText(healthBar.toString());
        this.binding.armorText.setText(armorBar.toString());
        this.binding.expText.setText(expBar.toString());
        this.binding.gearText.setText(gearBar.toString());
        this.binding.enemyHealthText.setText(eHealthBar.toString());
        this.binding.enemyArmorText.setText(eArmorBar.toString());
    }

    public View getRootView() {
        return binding.getRoot();
    }


}
