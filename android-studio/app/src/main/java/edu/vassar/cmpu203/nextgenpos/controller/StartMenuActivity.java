package edu.vassar.cmpu203.nextgenpos.controller;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.nextgenpos.R;
import edu.vassar.cmpu203.nextgenpos.view.IStartScreen;
import edu.vassar.cmpu203.nextgenpos.view.StartScreen;


public class StartMenuActivity extends AppCompatActivity implements IStartScreen.Listener {

    StartScreen startScreen;
    //MediaPlayer mp;

    /**
     * onCreate method that dictates the rootview and all functions to be started on start
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        startScreen = new StartScreen(this, this);
        //mp = MediaPlayer.create(this, R.raw.start_menu_music);

        this.setContentView(startScreen.getRootView());
    }

    /*@Override
    protected void onResume() {
        super.onResume();
        mp.start();
    }*/

    /**
     * Continues on to the combat screen
     */
    @Override
    public void startClick() {
        switchActivities();
    }

    /**
     * Continues to the help menu
     */
    @Override
    public void helpClick() {

    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
}
