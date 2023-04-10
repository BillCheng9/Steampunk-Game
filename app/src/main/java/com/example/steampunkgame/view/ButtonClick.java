package com.example.steampunkgame.view;
import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.steampunkgame.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class ButtonClick implements IButtonClick {

    ActivityMainBinding binding;
    Listener listener;

    public ButtonClick(Context context, @NonNull Listener listener) {
        this.binding = ActivityMainBinding.inflate(LayoutInflater.from(context));
        this.listener = listener;
        this.binding.lightAttackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonClick.this.binding.dialogueText.setText("LIGHT");
                listener.onBTNClick("LIGHT");
            }
        });
        this.binding.heavyAttackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonClick.this.binding.dialogueText.setText("HEAVY");
            }
        });
        this.binding.fleeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonClick.this.binding.dialogueText.setText("FLEE");
            }
        });
        this.binding.invBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonClick.this.binding.dialogueText.setText("INVENTORY");
            }
        });
        this.binding.petBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonClick.this.binding.dialogueText.setText("PET");
            }
        });
    }

    public View getRootView() {
        return binding.getRoot();
    }


}
