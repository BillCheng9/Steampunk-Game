package edu.vassar.cmpu203.nextgenpos.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.Fragment;

import edu.vassar.cmpu203.nextgenpos.databinding.FragmentStartScreenBinding;

public class StartScreen implements IStartScreen{

    FragmentStartScreenBinding binding;
    Listener listener;

    public StartScreen(Context context, Listener listener){
        this.listener = listener;
        this.binding = FragmentStartScreenBinding.inflate(LayoutInflater.from(context));

        this.binding.startBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.startClick();
            }
        });

        this.binding.helpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.helpClick();
            }
        });
    }

    public void buttonClickable(boolean clickable) {
        StartScreen.this.binding.startBTN.setClickable(clickable);
        StartScreen.this.binding.helpBTN.setClickable(clickable);
    }


    public View getRootView() {
        return binding.getRoot();
    }
}
