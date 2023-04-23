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

        this.binding.sword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.item1Click();
            }
        });
    }

    public void buttonClickable(boolean clickable) {
        Inventory.this.binding.sword.setClickable(clickable);
    }

    public View getRootView() {
        return this.binding.getRoot();
    }

}
