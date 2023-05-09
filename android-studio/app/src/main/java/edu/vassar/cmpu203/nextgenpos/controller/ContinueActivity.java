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

    /**
     * on create method
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p = getIntent().getParcelableExtra("curPlayer");

        p.enemyFight = "NONE";

        getSupportActionBar().hide();
        menu = new MainMenu(this, this, p);

        this.setContentView(menu.getRootView());
    }

    /**
     * Starts a new MainActivity
     */
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

    /**
     * Creates intent of switching activities
     */
    private void switchActivitiesContinue() {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("curPlayer", p);
        startActivity(i);
    }

    /**
     * Creates intent of switching activities
     */
    private void switchActivitiesWorkshop() {
        Intent i = new Intent(this, WorkshopActivity.class);
        i.putExtra("curPlayer", p);
        startActivity(i);
    }
}
