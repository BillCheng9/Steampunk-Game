package edu.vassar.cmpu203.nextgenpos.view;

public interface IWorkshop {
    interface Listener{
        /**
         * Go back to continue menu
         */
        void backClick();

        /**
         * Buys item 1
         */
        void plates1Click();

        /**
         * Buys item 2
         */
        void plates2Click();

        /**
         * Buys item 3
         */
        void plates3Click();

        /**
         * Buys item 4
         */
        void nanites1Click();

        /**
         * Buys item 5
         */
        void nanites2Click();

        /**
         * Buys item 6
         */
        void nanites3Click();

        /**
         * Buys item 7
         */
        void gauntlets1Click();

        /**
         * Buys item 8
         */
        void implants1CLick();

        /**
         * Buys item 9
         */
        void illegal1Click();

        /**
         * Heals player
         */
        void healClick();

        /**
         * Finalizes buying action
         */
        void buyClick(String type);
    }
}
