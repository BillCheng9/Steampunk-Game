package edu.vassar.cmpu203.nextgenpos.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import edu.vassar.cmpu203.nextgenpos.databinding.HelpScreenBinding;

public class HelpScreen implements IHelpScreen {
    HelpScreenBinding binding;
    Listener listener;

    public HelpScreen(Context context, Listener listener) {
        this.listener = listener;
        this.binding = HelpScreenBinding.inflate(LayoutInflater.from(context));

        this.binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.backClick();
            }
        });
    }

    public View getRootView() {
        return this.binding.getRoot();
    }
}
