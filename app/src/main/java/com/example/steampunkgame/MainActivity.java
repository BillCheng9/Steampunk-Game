package com.example.steampunkgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.steampunkgame.model.UI.CombatButton;
import com.example.steampunkgame.model.UI.DialogueBar;
import com.example.steampunkgame.model.UI.StatBar;
import com.example.steampunkgame.view.ButtonClick;
import com.example.steampunkgame.view.IButtonClick;

public class MainActivity extends AppCompatActivity {

    CombatButton lightButton;
    CombatButton heavyButton;
    CombatButton fleeButton;
    CombatButton invButton;
    CombatButton petButton;
    DialogueBar dialogueBar;
    StatBar healthBar;
    StatBar armorBar;
    StatBar expBar;
    StatBar gearBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.lightButton = new CombatButton("LIGHT");
        this.heavyButton = new CombatButton("HEAVY");
        this.fleeButton = new CombatButton("RUN AWAY");
        this.invButton = new CombatButton("OPEN BAG");
        this.petButton = new CombatButton("USE PET");

        this.dialogueBar = new DialogueBar();

        this.healthBar = new StatBar("HEALTH", 0, 0);
        this.armorBar = new StatBar("ARMOR", -1, 0);
        this.expBar = new StatBar("EXPERIENCE", 0, 0);
        this.gearBar = new StatBar("GEARS", -1, 0);

        IButtonClick buttonClick = new ButtonClick(this, new IButtonClick.Listener() {
            @Override
            public void onBTNClick(String name) {

            }
        });
        setContentView(buttonClick.getRootView());
    }
}