package edu.vassar.cmpu203.nextgenpos.view;

import android.view.View;

public interface IMainMenu {

    interface Listener {
        void continueClick();
        void workshopClick();
    }

    View getRootView();
}
