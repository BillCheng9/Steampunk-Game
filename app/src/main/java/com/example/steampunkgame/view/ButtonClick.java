package com.example.steampunkgame.view;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.example.steampunkgame.databinding.ActivityMainBinding;

public class ButtonClick implements IButtonClick, View.OnClickListener {

    ActivityMainBinding binding;

    public ButtonClick(Context context) {
        this.binding = ActivityMainBinding.inflate(LayoutInflater.from(context));
        this.binding.lightAttackBTN.setOnClickListener(this);
    }

    public View getRootView() {
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        this.binding.dialogueText.setText("TEST");
    }
}
