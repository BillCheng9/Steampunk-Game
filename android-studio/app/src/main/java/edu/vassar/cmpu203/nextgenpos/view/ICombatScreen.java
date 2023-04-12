package edu.vassar.cmpu203.nextgenpos.view;

import android.view.View;

public interface ICombatScreen {

    interface Listener {
        void onBTNClick(String name);
    }

    View getRootView();
}
