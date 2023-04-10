package com.example.steampunkgame.view;

import android.view.View;

public interface IButtonClick {

    interface Listener {
        void onBTNClick(String name);
    }

    View getRootView();
}
