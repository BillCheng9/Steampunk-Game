package edu.vassar.cmpu203.nextgenpos.view;

public interface IInventory {
    interface Listener{

        /**
         * Go back to combat menu
         */
        void backClick();

        /**
         * Brings up item 1 details
         */
        void plates1Click();

        /**
         * Brings up item 2 details
         */
        void plates2Click();

        /**
         * Brings up item 3 details
         */
        void plates3Click();

        /**
         * Brings up item 4 details
         */
        void nanites1Click();

        /**
         * Brings up item 5 details
         */
        void nanites2Click();

        /**
         * Brings up item 6 details
         */
        void nanites3Click();

        /**
         * Brings up item 7 details
         */
        void gauntlets1Click();

        /**
         * Brings up item 8 details
         */
        void implants1CLick();

        /**
         * Brings up item 9 details
         */
        void illegal1Click();
    }
}
