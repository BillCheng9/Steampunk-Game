package edu.vassar.cmpu203.nextgenpos.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import edu.vassar.cmpu203.nextgenpos.databinding.StartScreenBinding;

public class StartScreen implements IStartScreen{

    StartScreenBinding binding;
    Listener listener;

    public StartScreen(Context context, Listener listener){
        this.listener = listener;
        this.binding = StartScreenBinding.inflate(LayoutInflater.from(context));

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


    public View getRootView() {
        return this.binding.getRoot();
    }

}
