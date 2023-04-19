package edu.vassar.cmpu203.nextgenpos.view;

import android.view.View;

import edu.vassar.cmpu203.nextgenpos.model.Enemy;
import edu.vassar.cmpu203.nextgenpos.model.Player;

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
         * pet button onClick method
         */
        void petClick();

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

    /**
     * Gets rootView
     * @return root view
     */
    View getRootView();

}
