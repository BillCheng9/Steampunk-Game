package edu.vassar.cmpu203.nextgenpos.view;

import android.view.View;

public interface IMainMenu {

    /**
     * Listener interface
     */
    interface Listener {
        void continueClick();
        void workshopClick();
    }

    /**
     *
     * @return
     */
    View getRootView();
}
