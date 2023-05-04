package edu.vassar.cmpu203.nextgenpos.controller;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.nextgenpos.R;
import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.view.IStartScreen;
import edu.vassar.cmpu203.nextgenpos.view.StartScreen;


public class StartMenuActivity extends AppCompatActivity implements IStartScreen.Listener {

    StartScreen startScreen;

    Player p;
    MediaPlayer mp;

    /**
     * onCreate method that dictates the rootview and all functions to be started on start
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mp = MediaPlayer.create(this, R.raw.start_menu_music);

        getSupportActionBar().hide();
        mp.start();
        startScreen = new StartScreen(this, this);

        this.p = new Player(10,10, 5, 3, 3, 1, 0);

        this.setContentView(startScreen.getRootView());
    }

    public void onDestroy() {
        super.onDestroy();
        mp.release();
    }

    /**
     * Continues on to the combat screen
     */
    @Override
    public void startClick() {
        /*if (this.mp.isPlaying()) {
            this.mp.seekTo(0);
        }
        else {
            this.mp.start();
        }*/
        switchActivities("START");
    }

    /**
     * Continues to the help menu
     */
    @Override
    public void helpClick() {
        /*if (this.mp.isPlaying()) {
            this.mp.seekTo(0);
        }
        else {
            this.mp.start();
        }*/
        switchActivities("HELP");
    }

    private void switchActivities(String activity) {
        if (activity.equals("START")) {
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("curPlayer", p);
            startActivity(i);
        }
        else if (activity.equals("HELP")) {
            Intent switchActivityIntent = new Intent(this, HelpActivity.class);
            startActivity(switchActivityIntent);
        }
    }
}
