package edu.vassar.cmpu203.nextgenpos.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import edu.vassar.cmpu203.nextgenpos.databinding.WorkshopBinding;
import edu.vassar.cmpu203.nextgenpos.model.Player;
import edu.vassar.cmpu203.nextgenpos.model.StatTypes.GearStat;

public class Workshop implements IWorkshop{

    WorkshopBinding binding;
    Listener listener;
    String type;
    GearStat gearBar;

    public Workshop(Context context, Listener listener, Player p){
        this.listener = listener;
        this.binding = WorkshopBinding.inflate(LayoutInflater.from(context));
        gearBar = new GearStat(p.gears);

        this.binding.gearsText.setText(gearBar.toString());

        this.binding.goBackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.backClick();
            }
        });

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

        this.binding.gauntlets1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.gauntlets1Click();
            }
        });

        this.binding.gauntlets2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.implants1CLick();
            }
        });

        this.binding.illegal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.illegal1Click();
            }
        });

        this.binding.healBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.healClick();
            }
        });

        this.binding.buyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.buyClick(type);
            }
        });
    }

    public void displayPlate1() {
        Workshop.this.binding.shopText.setText("THESE ARE SIMPLE ARMOR PLATING MADE FROM STEEL. THEY'LL PROVIDE YOU WITH +1 DEF FOR 3 GEARS.");
    }
    public void displayPlate2() {
        Workshop.this.binding.shopText.setText("THESE ARE ADVANCED TUNGSTEN-STEEL PLATING. THEY'LL PROVIDE YOU WITH +2 DEF FOR 4 GEARS.");
    }
    public void displayPlate3() {
        Workshop.this.binding.shopText.setText("THESE ARE STRONG CHROMIUM-TITANIUM PLATING. THEY'LL PROVIDE YOU WITH +3 DEF FOR 5 GEARS.");
    }
    public void displayNanite1() {
        Workshop.this.binding.shopText.setText("THESE ARE SIMPLE CORE NANITES. THEY'LL PROVIDE YOU WITH +2 MAX HEALTH FOR 3 GEARS.");
    }
    public void displayNanite2() {
        Workshop.this.binding.shopText.setText("THESE ARE ADVANCED CORE NANITES. THEY'LL PROVIDE YOU WITH +5 MAX HEALTH FOR 7 GEARS.");
    }
    public void displayNanite3() {
        Workshop.this.binding.shopText.setText("THESE ARE STATE OF THE ART PROTOTYPE CORE NANITES. THEY'LL PROVIDE YOU WITH +9 MAX HEALTH FOR 15 GEARS.");
    }
    public void displayGauntlet() {
        Workshop.this.binding.shopText.setText("THESE ARE STEEL BOXING GAUNTLETS. THEY'LL PROVIDE YOU WITH +1 DAMAGE FOR 3 GEARS.");
    }
    public void displayImplant() {
        Workshop.this.binding.shopText.setText("THESE ARE MILITARY GRADE CQB FIGHTING IMPLANTS. THEY'LL PROVIDE YOU WITH +2 DAMAGE FOR 5 GEARS.");
    }
    public void displayIllegal() {
        Workshop.this.binding.shopText.setText("THESE ARE BLACK MARKET ENHANCEMENTS. I'LL BE HONEST, I DON'T KNOW WHAT THEY DO, SO BE CAREFUL. I'LL GIVE IT TO YOU FOR 15 GEARS?");
    }
    public void displayWelcome() {
        int textVal = (int)(Math.random() * 4);
        String text;
        switch (textVal) {
            case 1:
                text = "WELCOME FRIEND! TAKE YOUR TIME TO SHOP, OR IF YOU NEED, WE GOT A MECHANIC ON DUTY.";
                break;
            case 2:
                text = "BIG MAN WALKING IN. WHAT CAN WE DO FOR YOU, FRIEND?";
                break;
            case 3:
                text = "LOOKING TO PROTECT YOURSELF OR DEAL SOME DAMAGE?";
                break;
            default:
                text = "LET ME KNOW IF ANYTHING CATCHES YOUR EYE, I'M ON MY BREAK RIGHT NOW.";
        }
        Workshop.this.binding.shopText.setText(text);
    }
    public void displayBuyATK(){
        Workshop.this.binding.shopText.setText("THANK YOU! CRACK SOME METAL WITH THOSE FOR US!");
    }
    public void displayBuyDEF(){
        Workshop.this.binding.shopText.setText("THANKS! HOPE THAT PROTECTS YOU!");
    }
    public void displayBuyHP(){
        Workshop.this.binding.shopText.setText("THANKS LOVE! YOU BETTER NOT BREAK OUT THERE!");
    }
    public void displayBuyILLEGAL(){
        Workshop.this.binding.shopText.setText("UM, THANKS? GOOD LUCK WITH THOSE...");
    }
    public void displayBroke() {
        Workshop.this.binding.shopText.setText("AH! I'M AFRAID YOU DON'T HAVE ENOUGH GEARS FOR THIS. I WOULD GIVE YOU A DISCOUNT BUT A GIRL LIKES SHINY THINGS. SORRY!");
    }
    public void displayHeal() {
        Workshop.this.binding.shopText.setText("THERE! LOOKING LIKE A FACTORY NEW ROBOT!");
    }
    public void displayCantHeal() {
        Workshop.this.binding.shopText.setText("WE WOULD LOVE TO FIX YOU UP, BUT IT LOOKS LIKE YOU'RE ALREADY PRETTY FIXED UP.");
    }
    public void displayGears(Player p) {
        gearBar = new GearStat(p.gears);
        Workshop.this.binding.gearsText.setText(gearBar.toString());
    }
    public void displayHealBuy() {
        Workshop.this.binding.shopText.setText("IF YOU'RE LOOKING FOR A QUICK TUNE-UP, OUR MECHANIC WILL TAKE A LOOK FOR 2 GEARS.");
    }

    public void btnVisibility(boolean state, String itemType){
        if (state) {
            Workshop.this.binding.buyBTN.setVisibility(View.VISIBLE);
            type = itemType;
        }
        else {
            Workshop.this.binding.buyBTN.setVisibility(View.GONE);
        }
    }

    public void onStartBTN() {
        Workshop.this.binding.buyBTN.setVisibility(View.GONE);
    }

    public View getRootView() {
        return this.binding.getRoot();
    }

}
