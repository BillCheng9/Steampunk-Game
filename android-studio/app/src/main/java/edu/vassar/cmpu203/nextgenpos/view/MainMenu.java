package edu.vassar.cmpu203.nextgenpos.view;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;

import edu.vassar.cmpu203.nextgenpos.databinding.MainMenuBinding;
import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.ArmorStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.GearStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.HealthStat;

public class MainMenu implements IMainMenu{

    MainMenuBinding binding;
    Listener listener;
    HealthStat healthBar;
    ArmorStat armorBar;
    GearStat gearBar;

    public MainMenu(Context context, Listener listener, Player p) {

        // instantiate
        this.listener = listener;
        this.binding = MainMenuBinding.inflate(LayoutInflater.from(context));
        healthBar = new HealthStat(p.health, p.maxHealth);
        armorBar = new ArmorStat(p.defense);
        gearBar = new GearStat(p.gears);

        // initiate stat bar
        this.binding.healthText2.setText(healthBar.toString());
        this.binding.armorText2.setText(armorBar.toString());
        this.binding.gearText2.setText(gearBar.toString());

        // button onClick
        this.binding.continueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.continueClick();
            }
        });
        this.binding.storeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.workshopClick();
            }
        });
    }

    /** Gets root view
     * @return root view
     */
    @Override
    public View getRootView() {
        return binding.getRoot();
    }
}