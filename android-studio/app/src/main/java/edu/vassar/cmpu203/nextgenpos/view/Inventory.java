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
                listener.item1Click();
            }
        });
        this.binding.tunstenPlates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.item1Click();
            }
        });
        this.binding.chromiumPlates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.item1Click();
            }
        });
        this.binding.xt1Nanites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.item1Click();
            }
        });
        this.binding.xt3Nanites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.item1Click();
            }
        });
        this.binding.xtpNanites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.item1Click();
            }
        });
        this.binding.mechaGauntlets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.item1Click();
            }
        });
        this.binding.cbaImplants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.item1Click();
            }
        });
        this.binding.ice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.item1Click();
            }
        });

    }

    public void buttonClickable(boolean clickable) {
        Inventory.this.binding.steelPlates.setClickable(clickable);
    }

    public View getRootView() {
        return this.binding.getRoot();
    }

}
