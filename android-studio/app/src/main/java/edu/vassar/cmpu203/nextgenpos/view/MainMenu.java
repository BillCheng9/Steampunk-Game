package edu.vassar.cmpu203.nextgenpos.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.nextgenpos.R;
import edu.vassar.cmpu203.nextgenpos.databinding.FragmentMainMenuBinding;
import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.ArmorStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.ExpStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.GearStat;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.HealthStat;

public class MainMenu extends Fragment implements IMainMenu{

    FragmentMainMenuBinding binding;
    Listener listener;
    HealthStat healthBar;
    ArmorStat armorBar;
    ExpStat expBar;
    GearStat gearBar;


    public MainMenu() {
        // Required empty public constructor
    }

    public MainMenu(Context context, Listener listener, Player p) {

        // instantiate
        this.listener = listener;
        this.binding = FragmentMainMenuBinding.inflate(LayoutInflater.from(context));
        healthBar = new HealthStat(p.health, p.maxHealth);
        armorBar = new ArmorStat(p.defense, p.trueDefense);
        expBar = new ExpStat(p.experience);
        gearBar = new GearStat(p.gears);

        // initiate stat bar
        this.binding.healthText2.setText(healthBar.toString());
        this.binding.armorText2.setText(armorBar.toString());
        this.binding.expText2.setText(expBar.toString());
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }

    /**
     * @return 
     */
    @Override
    public View getRootView() {
        return binding.getRoot();
    }
}