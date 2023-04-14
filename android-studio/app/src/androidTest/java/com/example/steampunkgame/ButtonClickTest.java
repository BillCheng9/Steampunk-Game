package com.example.steampunkgame;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import edu.vassar.cmpu203.nextgenpos.R;
import edu.vassar.cmpu203.nextgenpos.controller.MainActivity;

/**
 * Button test for the combat menu
 */
public class ButtonClickTest {
    @Rule public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    ViewInteraction dialogueScreen = Espresso.onView(ViewMatchers.withId(R.id.dialogueText));

    /**
     * Tests light attack button
     */
    @Test
    public void testLightAttack(){
        onView(withId(R.id.lightAttackBTN)).perform(click());
        dialogueScreen.check(matches(ViewMatchers.withSubstring("YOU DECIDE TO DO A LIGHT ATTACK")));
    }

    /**
     * Tests heavy attack button
     */
    @Test
    public void testHeavyAttack(){
        Espresso.onView(ViewMatchers.withId(R.id.heavyAttackBTN)).perform(ViewActions.click());
        dialogueScreen.check(matches(ViewMatchers.withSubstring("YOU DECIDE TO DO A HEAVY ATTACK")));
    }

    /**
     * Tests flee button
     */
    @Test
    public void testFlee(){
        Espresso.onView(ViewMatchers.withId(R.id.fleeBTN)).perform(ViewActions.click());
        dialogueScreen.check(matches(ViewMatchers.withSubstring("YOU DECIDE TO RUN AWAY")));
    }

    /*@Test
    public void testInventory(){
        Espresso.onView(ViewMatchers.withId(R.id.invBTN)).perform(ViewActions.click());
        dialogueScreen.check(matches(ViewMatchers.withSubstring("")));
    }

    @Test
    public void testPet(){
        Espresso.onView(ViewMatchers.withId(R.id.petBTN)).perform(ViewActions.click());
        dialogueScreen.check(matches(ViewMatchers.withSubstring("")));
    }*/

    /**
     * Tests enemy attack response and player ability to click on dialogue box to motivate combat
     */
    @Test
    public void enemyAttack(){
        Espresso.onView(ViewMatchers.withId(R.id.lightAttackBTN)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.dialogueArea)).perform(ViewActions.click());
        dialogueScreen.check(matches(ViewMatchers.withSubstring("WHAT DO YOU WANT TO DO?")));
    }
}
