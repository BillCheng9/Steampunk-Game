package edu.vassar.cmpu203.nextgenpos.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.view.IWorkshop;
import edu.vassar.cmpu203.nextgenpos.view.Workshop;

public class WorkshopActivity extends AppCompatActivity implements IWorkshop.Listener {

    Workshop workshop;
    Player p;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        p = getIntent().getParcelableExtra("curPlayer");

        getSupportActionBar().hide();

        workshop = new Workshop(this, this, p);

        this.setContentView(workshop.getRootView());
    }

    @Override
    public void backClick() {
        switchActivities();
    }

    private void switchActivities() {
        Intent i = new Intent(this, ContinueActivity.class);
        i.putExtra("curPlayer", p);
        startActivity(i);
    }

    @Override
    public void plates1Click() {

    }

    @Override
    public void plates2Click() {

    }

    @Override
    public void plates3Click() {

    }

    @Override
    public void nanites1Click() {

    }

    @Override
    public void nanites2Click() {

    }

    @Override
    public void nanites3Click() {

    }

    @Override
    public void gauntlets1Click() {

    }

    @Override
    public void implants1CLick() {

    }

    @Override
    public void illegal1Click() {

    }
}
