package edu.vassar.cmpu203.nextgenpos.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import edu.vassar.cmpu203.nextgenpos.databinding.InventoryBinding;
import edu.vassar.cmpu203.nextgenpos.databinding.WorkshopBinding;
import edu.vassar.cmpu203.nextgenpos.model.Player;

public class Workshop implements IWorkshop{

    WorkshopBinding binding;

    Listener listener;

    Player p;

    public Workshop(Context context, Listener listener, Player p){
        this.listener = listener;
        this.binding = WorkshopBinding.inflate(LayoutInflater.from(context));

        this.binding.goBackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.backClick();
            }
        });

        this.binding.steelPlates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.plates1Click();
            }
        });

        this.binding.tungstenPlates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.plates2Click();
            }
        });

        this.binding.chromiumPlates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.plates3Click();
            }
        });

        this.binding.xt1Nanites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.nanites1Click();
            }
        });

        this.binding.xt3Nanites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.nanites2Click();
            }
        });

        this.binding.xtpNanites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.nanites3Click();
            }
        });

        this.binding.gauntlets1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.gauntlets1Click();
            }
        });

        this.binding.gauntlets2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.implants1CLick();
            }
        });

        this.binding.illegal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.illegal1Click();
            }
        });
    }

    public void buttonClickable(boolean clickable) {
        Workshop.this.binding.steelPlates.setClickable(clickable);
        Workshop.this.binding.tungstenPlates.setClickable(clickable);
        Workshop.this.binding.chromiumPlates.setClickable(clickable);
        Workshop.this.binding.xt1Nanites.setClickable(clickable);
        Workshop.this.binding.xt3Nanites.setClickable(clickable);
        Workshop.this.binding.xtpNanites.setClickable(clickable);
        Workshop.this.binding.gauntlets1.setClickable(clickable);
        Workshop.this.binding.gauntlets2.setClickable(clickable);
        Workshop.this.binding.illegal1.setClickable(clickable);
    }

    public View getRootView() {
        return this.binding.getRoot();
    }
}
