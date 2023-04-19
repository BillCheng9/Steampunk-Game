package edu.vassar.cmpu203.nextgenpos.view;

import android.view.View;

public interface IStartScreen {

    interface Listener{

        /**
         * Continues on to the main menu
         */
        void startClick();

        /**
         * Continues to the help menu
         */
        void helpClick();

        /**
         * starts the game
         */
        void startGame();
    }

    View getRootView();
}
