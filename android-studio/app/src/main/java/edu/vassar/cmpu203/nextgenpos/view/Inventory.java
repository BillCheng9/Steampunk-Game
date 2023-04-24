package edu.vassar.cmpu203.nextgenpos.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import edu.vassar.cmpu203.nextgenpos.databinding.InventoryBinding;

public class Inventory implements IInventory {

    InventoryBinding binding;
    Listener listener;

    public Inventory(Context context, Listener listener){
        this.listener = listener;
        this.binding = InventoryBinding.inflate(LayoutInflater.from(context));

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
        this.binding.mechaGauntlets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.gauntlets1Click();
            }
        });
        this.binding.cbaImplants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.implants1CLick();
            }
        });
        this.binding.ice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.illegal1Click();
            }
        });

    }

    public void buttonClickable(boolean clickable) {
        Inventory.this.binding.steelPlates.setClickable(clickable);
        Inventory.this.binding.tungstenPlates.setClickable(clickable);
        Inventory.this.binding.chromiumPlates.setClickable(clickable);
        Inventory.this.binding.xt1Nanites.setClickable(clickable);
        Inventory.this.binding.xt3Nanites.setClickable(clickable);
        Inventory.this.binding.xtpNanites.setClickable(clickable);
        Inventory.this.binding.mechaGauntlets.setClickable(clickable);
        Inventory.this.binding.cbaImplants.setClickable(clickable);
        Inventory.this.binding.ice.setClickable(clickable);
    }

    public View getRootView() {
        return this.binding.getRoot();
    }

}
