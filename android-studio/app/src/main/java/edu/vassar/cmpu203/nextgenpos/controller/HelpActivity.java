package edu.vassar.cmpu203.nextgenpos.controller;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.nextgenpos.R;
import edu.vassar.cmpu203.nextgenpos.view.HelpScreen;
import edu.vassar.cmpu203.nextgenpos.view.IHelpScreen;

public class HelpActivity extends AppCompatActivity implements IHelpScreen.Listener {

    HelpScreen helpScreen;
    MediaPlayer mp;

    /**
     * onCreate method that dictates the rootview and all functions to be started on start
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        helpScreen = new HelpScreen(this, this);

        this.mp = MediaPlayer.create(this, R.raw.button_onclick);
        this.mp.start();

        this.setContentView(helpScreen.getRootView());
    }

    public void onDestroy() {
        super.onDestroy();
        mp.release();
    }

    /**
     * Returns back to Start Menu
     */
    @Override
    public void backClick() {
        /*if (this.mp.isPlaying()) {
            this.mp.seekTo(0);
        }
        else {
            this.mp.start();
        }*/
        switchActivities();
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, StartMenuActivity.class);
        startActivity(switchActivityIntent);
    }
}
