package edu.vassar.cmpu203.nextgenpos.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.vassar.cmpu203.nextgenpos.databinding.ActivityMainBinding;
import edu.vassar.cmpu203.nextgenpos.databinding.MainBinding;
import edu.vassar.cmpu203.nextgenpos.model.Enemy;
import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.ArmorStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.ExpStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.GearStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.HealthStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.eArmorStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.eHealthStat;
import edu.vassar.cmpu203.nextgenpos.model.UI.DialogueBar;

public class CombatScreenFragment extends Fragment implements ICombatScreen {

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

    /**
     * Constructor for CombatScreen
     * @param context context from UI screen
     * @param listener listener for onClick
     * @param p Player
     * @param e Enemy
     */
    public CombatScreenFragment(Context context, Listener listener, Player p, Enemy e) {

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

    }

    /**
     * Sets dialogueText to start text
     */
    public void displayStart() {
        String text = combatEnemyDialogue.displayStart() + " " + combatDialogue.displayPrompt();
        this.binding.dialogueText.setText(text);
    }

    /**
     * Sets dialogueContinue to continue text
     */
    public void displayContinueText() {
        this.binding.dialogueContinue.setText("CLICK TO CONTINUE!");
    }

    /**
     * Sets dialogueContinue to empty
     */
    public void removeContinueText() {
        this.binding.dialogueContinue.setText("");
    }

    /**
     * Sets dialogueText to Player attack
     * @param type attack type
     * @param dmg damage value
     * @param hit hit chance
     */
    public void displayPlayerAttack(String type, int dmg, int hit) {
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

    /**
     * Sets dialogueText to Pet (not implemented)
     * @param type Pet type
     * @param dmg damage
     */
    public void displayPet(String type, int dmg) {
        String text ="";
        text += "NOT IMPLEMENTED YET. TOO BAD TOO SAD!";
        this.binding.dialogueText.setText(text);
    }

    /**
     * Sets dialogueText to Inventory (not implemented)
     */
    public void displayInv() {
        String text ="";
        text += "NOT IMPLEMENTED YET. TOO BAD TOO SAD!";
        this.binding.dialogueText.setText(text);
    }

    /**
     * Sets dialogueText to Flee
     * @param check flee chance
     */
    public void displayFlee(boolean check) {
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

    /**
     * Sets dialogueText to Enemy attack
     * @param type attack type
     * @param dmg damage value
     * @param hit hit chance
     * @param e Enemy type
     */
    public void displayEnemyAttack(String type, int dmg, int hit, Enemy e) {
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
                    text += damageDialogue.displayEnemyDamage();
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
                    text += damageDialogue.displayEnemyDamage();
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

    /**
     * Sets dialogueText to Lose
     */
    public void displayEndLose() {
        this.binding.dialogueText.setText(combatDialogue.displayLose());
    }

    /**
     * Sets dialogueText to Win
     */
    public void displayEndWin(int gear, int exp) {
        CombatDialogue endDialogue = new CombatDialogue(gear, exp);
        String text = combatDialogue.displayWin() + " " + endDialogue.displayOnEnd();
        this.binding.dialogueText.setText(text);
    }

    /**
     * Sets dialogueClickable clickability
     * @param clickable boolean
     */
    public void dialogueClickable(boolean clickable) {
        CombatScreenFragment.this.binding.dialogueArea.setClickable(clickable);
    }

    /**
     * Sets buttons clickability
     * @param clickable boolean
     */
    public void buttonClickable(boolean clickable) {
        CombatScreenFragment.this.binding.lightAttackBTN.setClickable(clickable);
        CombatScreenFragment.this.binding.heavyAttackBTN.setClickable(clickable);
        CombatScreenFragment.this.binding.fleeBTN.setClickable(clickable);
        CombatScreenFragment.this.binding.petBTN.setClickable(clickable);
        CombatScreenFragment.this.binding.invBTN.setClickable(clickable);
    }

    /**
     * Refreshes Enemy Health stats
     * @param e Enemy type
     */
    public void renewEHealth(Enemy e) {
        eHealthBar = new eHealthStat(e.getName() + " HEALTH", e.getHealth());
        this.binding.enemyHealthText.setText(eHealthBar.toString());
    }

    /**
     * Refreshes Enemy Armor stats
     * @param e Enemy type
     */
    public void renewEArmor(Enemy e) {
        eArmorBar = new eArmorStat(e.getName() + " ARMOR", e.getDefense());
        this.binding.enemyArmorText.setText(eArmorBar.toString());
    }

    /**
     * Refreshes Player Health stats
     * @param p Player
     */
    public void renewHealth(Player p) {
        healthBar = new HealthStat(p.health, p.maxHealth);
        this.binding.healthText.setText(healthBar.toString());
    }

    /**
     * Refreshes Player Exp and Gear stats
     * @param p Player
     */
    public void renewExpGear(Player p) {
        expBar = new ExpStat(p.experience);
        gearBar = new GearStat(p.gears);
        this.binding.gearText.setText(gearBar.toString());
        this.binding.expText.setText(expBar.toString());
    }

    /**
     * OnCreateView() overrides method of the same name from superclass. It's purpose is to
     * inflate the xml layout associated with the fragment.
     * @param inflater object to use to inflate the xml layout (create actual graphical widgets out of the xml declarations)
     * @param container where the graphical widgets will be placed
     * @param savedInstanceState any saved state information to be restored (null if none exists)
     * @return the root of the layout that has just been inflated
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = ActivityMainBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // initiate stat bar
        this.binding.healthText.setText(healthBar.toString());
        this.binding.armorText.setText(armorBar.toString());
        this.binding.expText.setText(expBar.toString());
        this.binding.gearText.setText(gearBar.toString());
        this.binding.enemyHealthText.setText(eHealthBar.toString());
        this.binding.enemyArmorText.setText(eArmorBar.toString());
        // dialogue onclick
        this.binding.dialogueArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dmg;
                listener.dialogueClick();}
        });

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
                CombatScreenFragment.this.listener.heavyClick();
            }
        });
        this.binding.fleeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CombatScreenFragment.this.listener.fleeClick();
            }
        });
        this.binding.invBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CombatScreenFragment.this.listener.invClick();
            }
        });
        this.binding.petBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CombatScreenFragment.this.listener.petClick();
            }
        });
    }

}
