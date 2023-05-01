package edu.vassar.cmpu203.nextgenpos.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import edu.vassar.cmpu203.nextgenpos.databinding.InventoryBinding;
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

public class Inventory implements IInventory {

    InventoryBinding binding;
    Listener listener;
    Plate1 plate1 = new Plate1();
    Plate2 plate2 = new Plate2();
    Plate3 plate3 = new Plate3();
    Nanites1 nanites1 = new Nanites1();
    Nanites2 nanites2 = new Nanites2();
    Nanites3 nanites3 = new Nanites3();
    Gauntlets1 gauntlets1 = new Gauntlets1();
    Implants1 implants1 = new Implants1();
    Illegal1 illegal1 = new Illegal1();

    public Inventory(Context context, Listener listener, Player p){
        this.listener = listener;
        this.binding = InventoryBinding.inflate(LayoutInflater.from(context));

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

        this.binding.mechaGauntlets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.gauntlets1Click();
            }
        });

        this.binding.cbaImplants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.implants1CLick();
            }
        });

        this.binding.ice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.illegal1Click();
            }
        });

    }

    public void displayPlate1(Player p) {
        Inventory.this.binding.nameText.setText(plate1.getName());
        Inventory.this.binding.descText.setText(plate1.getDesc());
        Inventory.this.binding.statText.setText(plate1.displayStats());
        if (p.steel) {
            Inventory.this.binding.numberText.setText("YOU HAVE THIS ITEM.");
        }
        else {
            Inventory.this.binding.numberText.setText("YOU DON'T HAVE THIS YET, BUY IT AT THE WORKSHOP!");
        }
    }
    public void displayPlate2(Player p) {
        Inventory.this.binding.nameText.setText(plate2.getName());
        Inventory.this.binding.descText.setText(plate2.getDesc());
        Inventory.this.binding.statText.setText(plate2.displayStats());
        if (p.tung) {
            Inventory.this.binding.numberText.setText("YOU HAVE THIS ITEM.");
        }
        else {
            Inventory.this.binding.numberText.setText("YOU DON'T HAVE THIS YET, BUY IT AT THE WORKSHOP!");
        }
    }
    public void displayPlate3(Player p) {
        Inventory.this.binding.nameText.setText(plate3.getName());
        Inventory.this.binding.descText.setText(plate3.getDesc());
        Inventory.this.binding.statText.setText(plate3.displayStats());
        if (p.chrom) {
            Inventory.this.binding.numberText.setText("YOU HAVE THIS ITEM.");
        }
        else {
            Inventory.this.binding.numberText.setText("YOU DON'T HAVE THIS YET, BUY IT AT THE WORKSHOP!");
        }
    }
    public void displayNanites1(Player p) {
        Inventory.this.binding.nameText.setText(nanites1.getName());
        Inventory.this.binding.descText.setText(nanites1.getDesc());
        Inventory.this.binding.statText.setText(nanites1.displayStats());
        if (p.xt1) {
            Inventory.this.binding.numberText.setText("YOU HAVE THIS ITEM.");
        }
        else {
            Inventory.this.binding.numberText.setText("YOU DON'T HAVE THIS YET, BUY IT AT THE WORKSHOP!");
        }
    }
    public void displayNanites2(Player p) {
        Inventory.this.binding.nameText.setText(nanites2.getName());
        Inventory.this.binding.descText.setText(nanites2.getDesc());
        Inventory.this.binding.statText.setText(nanites2.displayStats());
        if (p.xt3) {
            Inventory.this.binding.numberText.setText("YOU HAVE THIS ITEM.");
        }
        else {
            Inventory.this.binding.numberText.setText("YOU DON'T HAVE THIS YET, BUY IT AT THE WORKSHOP!");
        }
    }
    public void displayNanites3(Player p) {
        Inventory.this.binding.nameText.setText(nanites3.getName());
        Inventory.this.binding.descText.setText(nanites3.getDesc());
        Inventory.this.binding.statText.setText(nanites3.displayStats());
        if (p.xtp) {
            Inventory.this.binding.numberText.setText("YOU HAVE THIS ITEM.");
        }
        else {
            Inventory.this.binding.numberText.setText("YOU DON'T HAVE THIS YET, BUY IT AT THE WORKSHOP!");
        }
    }
    public void displayGauntlets(Player p) {
        Inventory.this.binding.nameText.setText(gauntlets1.getName());
        Inventory.this.binding.descText.setText(gauntlets1.getDesc());
        Inventory.this.binding.statText.setText(gauntlets1.displayStats());
        if (p.gaunt1) {
            Inventory.this.binding.numberText.setText("YOU HAVE THIS ITEM.");
        }
        else {
            Inventory.this.binding.numberText.setText("YOU DON'T HAVE THIS YET, BUY IT AT THE WORKSHOP!");
        }
    }
    public void displayImplants(Player p) {
        Inventory.this.binding.nameText.setText(implants1.getName());
        Inventory.this.binding.descText.setText(implants1.getDesc());
        Inventory.this.binding.statText.setText(implants1.displayStats());
        if (p.gaunt2) {
            Inventory.this.binding.numberText.setText("YOU HAVE THIS ITEM.");
        }
        else {
            Inventory.this.binding.numberText.setText("YOU DON'T HAVE THIS YET, BUY IT AT THE WORKSHOP!");
        }
    }
    public void displayIllegal(Player p) {
        Inventory.this.binding.nameText.setText(illegal1.getName());
        Inventory.this.binding.descText.setText(illegal1.getDesc());
        Inventory.this.binding.statText.setText(illegal1.displayStats());
        if (p.illegal) {
            Inventory.this.binding.numberText.setText("YOU HAVE THIS ITEM.");
        }
        else {
            Inventory.this.binding.numberText.setText("YOU DON'T HAVE THIS YET, BUY IT AT THE WORKSHOP!");
        }
    }


    public void buttonClickable(boolean clickable) {
        Inventory.this.binding.steelPlates.setClickable(clickable);
        Inventory.this.binding.tungstenPlates.setClickable(clickable);
        Inventory.this.binding.chromiumPlates.setClickable(clickable);
        Inventory.this.binding.xt1Nanites.setClickable(clickable);
        Inventory.this.binding.xt3Nanites.setClickable(clickable);
        Inventory.this.binding.xtpNanites.setClickable(clickable);
        Inventory.this.binding.mechaGauntlets.setClickable(clickable);
        Inventory.this.binding.cbaImplants.setClickable(clickable);
        Inventory.this.binding.ice.setClickable(clickable);
    }

    public View getRootView() {
        return this.binding.getRoot();
    }

}
