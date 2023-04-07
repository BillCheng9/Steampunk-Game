package com.example.steampunkgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.steampunkgame.view.ButtonClick;
import com.example.steampunkgame.view.ICombatView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ICombatView buttonClick = new ButtonClick(getApplicationContext());
        setContentView(buttonClick.getRootView());
    }
}