package edu.vassar.cmpu203.nextgenpos.view;

import android.view.View;

import edu.vassar.cmpu203.nextgenpos.model.Enemy;
import edu.vassar.cmpu203.nextgenpos.model.Player;

public interface ICombatScreen {

    interface Listener {
        void lightClick();
        void heavyClick();
        void petClick();
        void invClick();
        void fleeClick();
        void dialogueClick();
    }

    View getRootView();
}
