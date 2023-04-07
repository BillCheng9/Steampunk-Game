package com.example.steampunkgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.steampunkgame.view.ButtonClick;
import com.example.steampunkgame.view.IButtonClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IButtonClick buttonClick = new ButtonClick(getApplicationContext());
        setContentView(buttonClick.getRootView());
    }
}