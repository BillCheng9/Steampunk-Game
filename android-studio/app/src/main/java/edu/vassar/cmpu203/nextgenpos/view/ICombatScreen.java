package edu.vassar.cmpu203.nextgenpos.view;

public interface ICombatScreen {

    interface Listener {
        /**
         * light attack button onClick method
         */
        void lightClick();

        /**
         * heavy attack button onClick method
         */
        void heavyClick();

        /**
         * inventory button onClick method
         */
        void invClick();

        /**
         * flee button onClick method
         */
        void fleeClick();

        /**
         * dialogueArea onClick method
         */
        void dialogueClick();
    }

}
