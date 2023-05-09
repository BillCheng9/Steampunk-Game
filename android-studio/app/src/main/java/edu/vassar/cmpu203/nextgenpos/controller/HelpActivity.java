package edu.vassar.cmpu203.nextgenpos.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.nextgenpos.view.HelpScreen;
import edu.vassar.cmpu203.nextgenpos.view.IHelpScreen;

public class HelpActivity extends AppCompatActivity implements IHelpScreen.Listener {

    HelpScreen helpScreen;
    /**
     * onCreate method that dictates the rootview and all functions to be started on start
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        helpScreen = new HelpScreen(this, this);

        this.setContentView(helpScreen.getRootView());
    }

    /**
     * Returns back to Start Menu
     */
    @Override
    public void backClick() {
        switchActivities();
    }

    /**
     * Creates intent of switching activities
     */
    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, StartMenuActivity.class);
        startActivity(switchActivityIntent);
    }
}
