package edu.vassar.cmpu203.nextgenpos.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.nextgenpos.model.ItemTypes.Gauntlets1;
import edu.vassar.cmpu203.nextgenpos.model.ItemTypes.Illegal1;
import edu.vassar.cmpu203.nextgenpos.model.ItemTypes.Implants1;
import edu.vassar.cmpu203.nextgenpos.model.ItemTypes.Nanites1;
import edu.vassar.cmpu203.nextgenpos.model.ItemTypes.Nanites2;
import edu.vassar.cmpu203.nextgenpos.model.ItemTypes.Nanites3;
import edu.vassar.cmpu203.nextgenpos.model.ItemTypes.Plate1;
import edu.vassar.cmpu203.nextgenpos.model.ItemTypes.Plate2;
import edu.vassar.cmpu203.nextgenpos.model.ItemTypes.Plate3;
import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.view.IWorkshop;
import edu.vassar.cmpu203.nextgenpos.view.Workshop;

public class WorkshopActivity extends AppCompatActivity implements IWorkshop.Listener {

    Workshop workshop;
    Player p;
    Plate1 steelPlate = new Plate1();
    Plate2 tungPlate = new Plate2();
    Plate3 chromPlate = new Plate3();
    Nanites1 xt1 = new Nanites1();
    Nanites2 xt3 = new Nanites2();
    Nanites3 xtp = new Nanites3();
    Gauntlets1 gauntlet = new Gauntlets1();
    Implants1 implants = new Implants1();
    Illegal1 illegal = new Illegal1();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        p = getIntent().getParcelableExtra("curPlayer");

        getSupportActionBar().hide();

        workshop = new Workshop(this, this, p);
        workshop.onStartBTN();
        workshop.displayWelcome();

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
        workshop.btnVisibility(true, "PLATES1");
        workshop.displayPlate1();
    }

    @Override
    public void plates2Click() {
        workshop.btnVisibility(true, "PLATES2");
        workshop.displayPlate2();
    }

    @Override
    public void plates3Click() {
        workshop.btnVisibility(true, "PLATES3");
        workshop.displayPlate3();
    }

    @Override
    public void nanites1Click() {
        workshop.btnVisibility(true, "NANITES1");
        workshop.displayNanite1();
    }

    @Override
    public void nanites2Click() {
        workshop.btnVisibility(true, "NANITES2");
        workshop.displayNanite2();
    }

    @Override
    public void nanites3Click() {
        workshop.btnVisibility(true, "NANITES3");
        workshop.displayNanite3();
    }

    @Override
    public void gauntlets1Click() {
        workshop.btnVisibility(true, "GAUNTLETS");
        workshop.displayGauntlet();
    }

    @Override
    public void implants1CLick() {
        workshop.btnVisibility(true, "IMPLANTS");
        workshop.displayImplant();
    }

    @Override
    public void illegal1Click() {
        workshop.btnVisibility(true, "ILLEGAL");
        workshop.displayIllegal();
    }

    /**
     * Heals player
     */
    @Override
    public void healClick() {
        workshop.btnVisibility(true, "HEAL");
    }

    /**
     * Finalizes buying action
     */
    @Override
    public void buyClick(String type) {
        switch(type) {
            case "HEAL":
                if (p.gears < 2) {
                    workshop.displayBroke();
                }
                else if (p.health == p.maxHealth) {
                    workshop.displayCantHeal();
                }
                else if (p.gears >= 2) {
                    workshop.displayHeal();
                    p.health = p.maxHealth;
                    p.gears -= 2;
                }
                break;
            case "PLATES2":
                if (!p.tung) {
                    if (p.gears < tungPlate.getCost()) {
                        workshop.displayBroke();
                    } else if (p.gears >= tungPlate.getCost()) {
                        workshop.displayBuyDEF();
                        p.gears -= tungPlate.getCost();
                        p.defense += tungPlate.getDefenseChange();
                        p.tung = true;
                    }
                }
                else {
                    workshop.displayCantBuy();
                }
                break;
            case "PLATES3":
                if (!p.chrom) {
                    if (p.gears < chromPlate.getCost()) {
                        workshop.displayBroke();
                    } else if (p.gears >= chromPlate.getCost()) {
                        workshop.displayBuyDEF();
                        p.gears -= chromPlate.getCost();
                        p.defense += chromPlate.getDefenseChange();
                        p.chrom = true;
                    }
                }
                else {
                    workshop.displayCantBuy();
                }
                break;
            case "NANITES1":
                if (!p.xt1) {
                    if (p.gears < xt1.getCost()) {
                        workshop.displayBroke();
                    } else if (p.gears >= xt1.getCost()) {
                        workshop.displayBuyHP();
                        p.gears -= xt1.getCost();
                        p.maxHealth += xt1.getHealthChange();
                        p.health += xt1.getHealthChange();
                        p.xt1 = true;
                    }
                }
                else {
                    workshop.displayCantBuy();
                }
                break;
            case "NANITES2":
                if (!p.xt3) {
                    if (p.gears < xt3.getCost()) {
                        workshop.displayBroke();
                    } else if (p.gears >= xt3.getCost()) {
                        workshop.displayBuyHP();
                        p.gears -= xt3.getCost();
                        p.maxHealth += xt3.getHealthChange();
                        p.health += xt3.getHealthChange();
                        p.xt3 = true;
                    }
                }
                else {
                    workshop.displayCantBuy();
                }
                break;
            case "NANITES3":
                if (!p.xtp) {
                    if (p.gears < xtp.getCost()) {
                        workshop.displayBroke();
                    } else if (p.gears >= xtp.getCost()) {
                        workshop.displayBuyHP();
                        p.gears -= xtp.getCost();
                        p.maxHealth += xtp.getHealthChange();
                        p.health += xtp.getHealthChange();
                        p.xtp = true;
                    }
                }
                else {
                    workshop.displayCantBuy();
                }
                break;
            case "GAUNTLETS":
                if (!p.gaunt1) {
                    if (p.gears < gauntlet.getCost()) {
                        workshop.displayBroke();
                    } else if (p.gears >= gauntlet.getCost()) {
                        workshop.displayBuyATK();
                        p.gears -= gauntlet.getCost();
                        p.damage += gauntlet.getDamageChange();
                        p.gaunt1 = true;
                    }
                }
                else {
                    workshop.displayCantBuy();
                }
                break;
            case "IMPLANTS":
                if (!p.gaunt2) {
                    if (p.gears < implants.getCost()) {
                        workshop.displayBroke();
                    } else if (p.gears >= implants.getCost()) {
                        workshop.displayBuyATK();
                        p.gears -= implants.getCost();
                        p.damage += implants.getDamageChange();
                        p.gaunt2 = true;
                    }
                }
                else {
                    workshop.displayCantBuy();
                }
                break;
            case "ILLEGAL":
                if (!p.illegal) {
                    if (p.gears < illegal.getCost()) {
                        workshop.displayBroke();
                    } else if (p.gears >= illegal.getCost()) {
                        workshop.displayBuyILLEGAL();
                        p.gears -= illegal.getCost();
                        p.gearMult = illegal.getGearChange();
                        p.illegal = true;
                    }
                }
                else {
                    workshop.displayCantBuy();
                }
                break;
            default:
                if (!p.steel) {
                    if (p.gears < steelPlate.getCost()) {
                        workshop.displayBroke();
                    } else if (p.gears >= steelPlate.getCost()) {
                        workshop.displayBuyDEF();
                        p.gears -= steelPlate.getCost();
                        p.defense += steelPlate.getDefenseChange();
                        p.steel = true;
                    }
                }
                else {
                    workshop.displayCantBuy();
                }
        }
    }
}
