package com.example.steampunkgame;
import android.app.Activity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


public class ButtonClickTest {
    @Rule public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testLightAttack(){
        Espresso.onView(ViewMatchers.withId(R.id.lightAttackBTN)).perform(ViewActions.click());
    }
    @Test
    public void testHeavyAttack(){
        Espresso.onView(ViewMatchers.withId(R.id.heavyAttackBTN)).perform(ViewActions.click());
    }
    @Test
    public void testFlee(){
        Espresso.onView(ViewMatchers.withId(R.id.fleeBTN)).perform(ViewActions.click());
    }
    @Test
    public void testInventory(){
        Espresso.onView(ViewMatchers.withId(R.id.invBTN)).perform(ViewActions.click());
    }
    @Test
    public void testPet(){
        Espresso.onView(ViewMatchers.withId(R.id.petBTN)).perform(ViewActions.click());
    }
}
