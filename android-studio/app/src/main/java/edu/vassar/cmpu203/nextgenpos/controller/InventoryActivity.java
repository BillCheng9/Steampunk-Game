package edu.vassar.cmpu203.nextgenpos.controller;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.nextgenpos.R;
import edu.vassar.cmpu203.nextgenpos.view.IInventory;
import edu.vassar.cmpu203.nextgenpos.view.Inventory;

public class InventoryActivity extends AppCompatActivity implements IInventory.Listener {
    Inventory inventory;

    /**
     * onCreate method that dictates the rootview and all functions to be started on start
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        inventory = new Inventory(this, this);

        this.setContentView(inventory.getRootView());
    }

    /**
     * Displays item 1 details
     */
    @Override
    public void item1Click() {

    }

    @Override
    public void item2Click() {

    }

    @Override
    public void item3Click() {

    }

    @Override
    public void item4Click() {

    }

    @Override
    public void item5Click() {

    }

    @Override
    public void item6Click() {

    }

    @Override
    public void item7Click() {

    }

    @Override
    public void item8Click() {

    }

    @Override
    public void item9Click() {

    }

}