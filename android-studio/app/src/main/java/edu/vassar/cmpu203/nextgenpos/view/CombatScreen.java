package edu.vassar.cmpu203.nextgenpos.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import edu.vassar.cmpu203.nextgenpos.databinding.ActivityMainBinding;
import edu.vassar.cmpu203.nextgenpos.model.Enemy;
import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.ArmorStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.GearStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.HealthStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.eArmorStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.eHealthStat;

public class CombatScreen implements ICombatScreen {

    ActivityMainBinding binding;
    Listener listener;
    PlayerDialogue dialogue;
    HealthStat healthBar;
    ArmorStat armorBar;
    GearStat gearBar;
    eHealthStat eHealthBar;
    eArmorStat eArmorBar;
    CombatDialogue combatDialogue;
    PlayerDialogue playerDialogue;
    CombatDialogue combatEnemyDialogue;
    CombatDialogue damageDialogue;
    String gameText, contText;
    boolean dialClick, buttonClick;

    /**
     * Constructor for CombatScreen
     * @param listener listener for onClick
     * @param p Player
     * @param e Enemy
     */
    public CombatScreen(Context context, Listener listener, Player p, Enemy e) {

        // instantiate
        this.listener = listener;
        this.binding = ActivityMainBinding.inflate(LayoutInflater.from(context));

        dialogue = new PlayerDialogue();
        healthBar = new HealthStat(p.health, p.maxHealth);
        armorBar = new ArmorStat(p.defense);
        gearBar = new GearStat(p.gears);
        eHealthBar = new eHealthStat(e.getName() + " HEALTH", e.getHealth());
        eArmorBar = new eArmorStat(e.getName() + " ARMOR", e.getDefense());
        combatDialogue = new CombatDialogue();
        combatEnemyDialogue = new CombatDialogue(e);
        playerDialogue = new PlayerDialogue();

        // initiate stat bar
        this.binding.healthText.setText(healthBar.toString());
        this.binding.armorText.setText(armorBar.toString());
        this.binding.gearText.setText(gearBar.toString());
        this.binding.enemyHealthText.setText(eHealthBar.toString());
        this.binding.enemyArmorText.setText(eArmorBar.toString());

        // dialogue onclick
        this.binding.dialogueArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

    }

    /**
     * Sets dialogueText to start text
     */
    public void displayStart() {
        String text = combatEnemyDialogue.displayStart() + " " + combatDialogue.displayPrompt();
        this.binding.dialogueText.setText(text);
        gameText = text;
    }

    /**
     * Sets dialogueContinue to continue text
     */
    public void displayContinueText() {
        String text = "CLICK TO CONTINUE!";
        this.binding.dialogueContinue.setText(text);
        contText = text;
    }

    /**
     * Sets dialogueContinue to empty
     */
    public void removeContinueText() {
        this.binding.dialogueContinue.setText("");
        contText = "";
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
                text += playerDialogue.displayPHH() + " ";
                damageDialogue = new CombatDialogue(dmg);
                text += damageDialogue.displayDamage();
            }
        }
        this.binding.dialogueText.setText(text);
        gameText = text;
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
        gameText = text;
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
                else if (name.equals("STEEL SENTRY")) {
                    text += combatEnemyDialogue.displaySentry_S();
                }
                else if (name.equals("XT-D PROTECTRON")) {
                    text += combatEnemyDialogue.displayProtectron_S();
                }
                else if (name.equals("LURKING_WATCHER")) {
                    text += combatEnemyDialogue.displayWatcher_S();
                }
                else if (name.equals("MECHA-BOT")) {
                    text += combatEnemyDialogue.displayBot_S();
                }
                else if (name.equals("TITANIUM GOLEM")) {
                    text += combatEnemyDialogue.displayTGolem_S();
                }
            }
        }
        text += " " + combatDialogue.displayPrompt();
        this.binding.dialogueText.setText(text);
        gameText = text;
    }

    /**
     * Sets dialogueText to Lose
     */
    public void displayEndLose() {
        String text = combatDialogue.displayLose();
        this.binding.dialogueText.setText(combatDialogue.displayLose());
        gameText = text;
    }

    /**
     * Sets dialogueText to Win
     */
    public void displayEndWin(int gear) {
        String text = combatDialogue.displayWin() + " YOU GAIN " + gear + " GEARS!";
        this.binding.dialogueText.setText(text);
        gameText = text;
    }

    /**
     * Helper method to display texts when called
     * @param text previous text
     * @param contText previous continue text
     */
    public void displayText(String text, String contText) {
        this.binding.dialogueText.setText(text);
        this.binding.dialogueContinue.setText(contText);
    }

    /**
     * Sets dialogueClickable clickability
     * @param clickable boolean
     */
    public void dialogueClickable(boolean clickable) {
        CombatScreen.this.binding.dialogueArea.setClickable(clickable);
        dialClick = clickable;
    }

    /**
     * Sets buttons clickability
     * @param clickable boolean
     */
    public void buttonClickable(boolean clickable) {
        CombatScreen.this.binding.lightAttackBTN.setClickable(clickable);
        CombatScreen.this.binding.heavyAttackBTN.setClickable(clickable);
        CombatScreen.this.binding.fleeBTN.setClickable(clickable);
        CombatScreen.this.binding.invBTN.setClickable(clickable);
        buttonClick = clickable;
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
        gearBar = new GearStat(p.gears);
        this.binding.gearText.setText(gearBar.toString());
    }

    /**
     * getter method for gameText
     * @return gameText
     */
    public String getText() {
        return gameText;
    }

    /**
     * getter method for buttonClick
     * @return buttonClick
     */
    public boolean getButtonClick() {
        return buttonClick;
    }

    /**
     * getter method for dialClick
     * @return dialClick
     */
    public boolean getDialClick() {
        return dialClick;
    }

    /**
     * getter method for contText
     * @return contText
     */
    public String getContText() {
        return contText;
    }

    /**
     * get root view
     * @return root view
     */
    public View getRootView() {
        return this.binding.getRoot();
    }

}
