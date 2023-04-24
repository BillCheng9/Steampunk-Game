package edu.vassar.cmpu203.nextgenpos.view;

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
    }
}
