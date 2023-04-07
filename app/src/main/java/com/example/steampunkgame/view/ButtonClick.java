package com.example.steampunkgame.view;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.example.steampunkgame.databinding.ActivityMainBinding;

public class ButtonClick implements ICombatView {

    ActivityMainBinding binding;

    public ButtonClick(Context context) {
        this.binding = ActivityMainBinding.inflate(LayoutInflater.from(context));
    }

    public View getRootView() {
        return binding.getRoot();
    }

}
