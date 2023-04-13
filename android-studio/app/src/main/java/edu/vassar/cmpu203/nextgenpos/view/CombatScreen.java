package edu.vassar.cmpu203.nextgenpos.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import edu.vassar.cmpu203.nextgenpos.databinding.ActivityMainBinding;
import edu.vassar.cmpu203.nextgenpos.model.Enemy;
import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.ArmorStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.ExpStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.GearStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.HealthStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.eArmorStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.eHealthStat;
import edu.vassar.cmpu203.nextgenpos.model.UI.DialogueBar;

public class CombatScreen implements ICombatScreen {

    ActivityMainBinding binding;
    Listener listener;
    PlayerDialogue dialogue;
    HealthStat healthBar;
    ArmorStat armorBar;
    ExpStat expBar;
    GearStat gearBar;
    eHealthStat eHealthBar;
    eArmorStat eArmorBar;
    DialogueBar dialogueBar;
    CombatDialogue combatDialogue;
    PlayerDialogue playerDialogue;
    CombatDialogue combatEnemyDialogue;
    CombatDialogue damageDialogue;
    public CombatScreen(Context context, Listener listener, Player p, Enemy e) {

        // instantiate
        this.listener = listener;
        this.binding = ActivityMainBinding.inflate(LayoutInflater.from(context));

        dialogue = new PlayerDialogue();
        healthBar = new HealthStat(p.health, p.maxHealth);
        armorBar = new ArmorStat(p.defense, p.trueDefense);
        expBar = new ExpStat(p.experience);
        gearBar = new GearStat(p.gears);
        eHealthBar = new eHealthStat(e.getName() + " HEALTH", e.getHealth());
        eArmorBar = new eArmorStat(e.getName() + " ARMOR", e.getDefense());
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
                listener.lightClick();
            }
        });
        this.binding.heavyAttackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CombatScreen.this.listener.heavyClick();
            }
        });
        this.binding.fleeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CombatScreen.this.listener.fleeClick();
            }
        });
        this.binding.invBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CombatScreen.this.listener.invClick();
            }
        });
        this.binding.petBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CombatScreen.this.listener.petClick();
            }
        });
    }

    public void DisplayStart() {
        String text = combatEnemyDialogue.displayStart() + " " + combatDialogue.displayPrompt();
        this.binding.dialogueText.setText(text);
    }
    public void DisplayPlayerAttack(String type, int dmg, int hit) {
        String text = "";
        if (type.equals("LIGHT")) {
            text += playerDialogue.displayPAL() + " ";
            if (hit == 0) {
                text += playerDialogue.displayPML();
            }
            else if (hit > 0) {
                text += playerDialogue.displayPHL() + " ";
                damageDialogue = new CombatDialogue(dmg);
                text += damageDialogue.displayDamage();
            }
        }
        else if (type.equals("HEAVY")) {
            text += playerDialogue.displayPAH() + " ";
            if (hit == 0) {
                text += playerDialogue.displayPMH();
            }
            else if (hit > 0) {
                text += playerDialogue.displayPHL() + " ";
                damageDialogue = new CombatDialogue(dmg);
                text += damageDialogue.displayDamage();
            }
        }
        this.binding.dialogueText.setText(text);
    }

    public void DisplayPet(String type, int dmg) {
        String text ="";
        text += "NOT IMPLEMENTED YET. TOO BAD TOO SAD!";
        this.binding.dialogueText.setText(text);
    }

    public void DisplayInv() {
        String text ="";
        text += "NOT IMPLEMENTED YET. TOO BAD TOO SAD!";
        this.binding.dialogueText.setText(text);
    }

    public void DisplayFlee(boolean check) {
        String text ="";
        text += playerDialogue.displayFlee() + " ";
        if (check) {
            text += combatDialogue.displayFlee_T();
        }
        else {
            text += combatDialogue.displayFlee_F();
        }
        this.binding.dialogueText.setText(text);
    }

    public void DisplayPrompt() {
        this.binding.dialogueText.setText(combatDialogue.displayPrompt());
    }

    public void DisplayEnemyAttack(String type, int dmg, int hit, Enemy e) {
        String text = "";
        String name = e.getName();
        if (name.equals("LITERAL ROCK")) {
            if ( (type.equals("LIGHT")) || (type.equals("HEAVY") )) {
                text += combatEnemyDialogue.displayRock_M();
            }
            else {
                text += combatEnemyDialogue.displayRock_S();
            }
        }
        else {
            if (type.equals("LIGHT")) {
                text += combatEnemyDialogue.displayEAL() + " ";
                if (hit > 0) {
                    text += combatEnemyDialogue.displayEHL() + " ";
                    damageDialogue = new CombatDialogue(dmg);
                    text += damageDialogue.displayDamage();
                }
                else if (hit == 0) {
                    text += combatEnemyDialogue.displayEML();
                }
            }
            else if (type.equals("HEAVY")) {
                text += combatEnemyDialogue.displayEAH() + " ";
                if (hit > 0) {
                    text += combatEnemyDialogue.displayEHH() + " ";
                    damageDialogue = new CombatDialogue(dmg);
                    text += damageDialogue.displayDamage();
                }
                else if (hit == 0) {
                    text += combatEnemyDialogue.displayEMH();
                }
            }
            else if (type.equals("CHARGE")) {
                if (name.equals("WORKER BOT")) {
                    text += combatEnemyDialogue.displayWorker_S();
                }
                else if (name.equals("STEAM GOLEM")) {
                    text += combatEnemyDialogue.displayGolem_S();
                }
                else if (name.equals("IRON ANT")) {
                    text += combatEnemyDialogue.displayBug_S();
                }
            }
        }
        text += " " + combatDialogue.displayPrompt();
        this.binding.dialogueText.setText(text);
    }
    public void DisplayEndLose() {
        this.binding.dialogueText.setText(combatDialogue.displayLose());
    }
    public void DisplayEndWin() {
        this.binding.dialogueText.setText(combatDialogue.displayWin());
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

    public void renewEHealth(Enemy e) {
        eHealthBar = new eHealthStat(e.getName() + " HEALTH", e.getHealth());
        this.binding.enemyHealthText.setText(eHealthBar.toString());
    }
    public void renewEArmor(Enemy e) {
        eArmorBar = new eArmorStat(e.getName() + " ARMOR", e.getDefense());
        this.binding.enemyArmorText.setText(eArmorBar.toString());
    }
    public void renewHealth(Player p) {
        healthBar = new HealthStat(p.health, p.maxHealth);
        this.binding.healthText.setText(healthBar.toString());
    }

    public View getRootView() {
        return binding.getRoot();
    }


}
