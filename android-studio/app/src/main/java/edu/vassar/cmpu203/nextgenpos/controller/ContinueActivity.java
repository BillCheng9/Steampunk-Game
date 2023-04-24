package edu.vassar.cmpu203.nextgenpos.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.view.IMainMenu;
import edu.vassar.cmpu203.nextgenpos.view.MainMenu;

public class ContinueActivity extends AppCompatActivity implements IMainMenu.Listener {

    MainMenu menu;

    Player p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p = (Player) getIntent().getParcelableExtra("curPlayer");

        getSupportActionBar().hide();
        menu = new MainMenu(this, this, p);

        this.setContentView(menu.getRootView());
    }

    @Override
    public void continueClick() {
        switchActivitiesContinue();
    }

    /**
     * Opens up workshop activity
     */
    @Override
    public void workshopClick() {
        switchActivitiesWorkshop();
    }

    private void switchActivitiesContinue() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }

    //Fix
    private void switchActivitiesWorkshop() {
        Intent switchActivityIntent = new Intent(this, InventoryActivity.class);
        startActivity(switchActivityIntent);
    }
}
