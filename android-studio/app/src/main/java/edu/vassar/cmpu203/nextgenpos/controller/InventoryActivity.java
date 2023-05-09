package edu.vassar.cmpu203.nextgenpos.controller;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.view.IInventory;
import edu.vassar.cmpu203.nextgenpos.view.Inventory;

public class InventoryActivity extends AppCompatActivity implements IInventory.Listener {
    Inventory inventory;

    Player p;

    /**
     * onCreate method that dictates the rootview and all functions to be started on start
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p = getIntent().getParcelableExtra("curPlayer");

        getSupportActionBar().hide();
        inventory = new Inventory(this, this, p);

        this.setContentView(inventory.getRootView());
    }

    /**
     * Creates intent of switching activities
     */
    private void switchActivities() {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("curPlayer", p);
        startActivity(i);
    }

    /**
     * Go back to combat menu
     */
    @Override
    public void backClick() {
        switchActivities();
    }

    /**
     * Brings up steel armor plates details
     */
    @Override
    public void plates1Click() {
        inventory.displayPlate1(p);
    }

    /**
     * Brings up tungsten-steel armor plates details
     */
    @Override
    public void plates2Click() {
        inventory.displayPlate2(p);
    }

    /**
     * Brings up Chromium-Titanium armor plates details
     */
    @Override
    public void plates3Click() {
        inventory.displayPlate3(p);
    }

    /**
     * Brings up XT-1 Nanites details
     */
    @Override
    public void nanites1Click() {
        inventory.displayNanites1(p);
    }

    /**
     * Brings up XT-3 Nanites details
     */
    @Override
    public void nanites2Click() {
        inventory.displayNanites2(p);
    }

    /**
     * Brings up XT-PROTO Nanites details
     */
    @Override
    public void nanites3Click() {
        inventory.displayNanites3(p);
    }

    /**
     * Brings up Mecha-Gauntlets details
     */
    @Override
    public void gauntlets1Click() {
        inventory.displayGauntlets(p);
    }

    /**
     * Brings up CBA Implants details
     */
    @Override
    public void implants1CLick() {
        inventory.displayImplants(p);
    }

    /**
     * Brings up Illegal Cybernetic Enhancements details
     */
    @Override
    public void illegal1Click() {
        inventory.displayIllegal(p);
    }
}
