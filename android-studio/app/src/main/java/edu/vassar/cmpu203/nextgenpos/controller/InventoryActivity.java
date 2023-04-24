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
     * Brings up steel armor plates details
     */
    @Override
    public void plates1Click() {

    }

    /**
     *
     */
    @Override
    public void plates2Click() {

    }

    /**
     *
     */
    @Override
    public void plates3Click() {

    }

    /**
     *
     */
    @Override
    public void nanites1Click() {

    }

    /**
     *
     */
    @Override
    public void nanites2Click() {

    }

    /**
     *
     */
    @Override
    public void nanites3Click() {

    }

    /**
     *
     */
    @Override
    public void gauntlets1Click() {

    }

    /**
     *
     */
    @Override
    public void implants1CLick() {

    }

    /**
     *
     */
    @Override
    public void illegal1Click() {

    }
}
