package com.giovannigobbi.androidtestingexample;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void espressoTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn4), withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        2),
                                0),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btnPlus), withText("+"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        3),
                                3),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btn5), withText("5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        2),
                                1),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btnEquals), withText("="),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        4),
                                3),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.txtResult), withText("Result: 9.0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("Result: 9.0")));

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btn7), withText("7"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        1),
                                0),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btnMinus), withText("-"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        2),
                                3),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btn2), withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        3),
                                1),
                        isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.btn2), withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        3),
                                1),
                        isDisplayed()));
        appCompatButton8.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.editText), withText("7-22"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        0),
                                0),
                        isDisplayed()));
        editText.check(matches(withText("7-22")));

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.btnEquals), withText("="),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        4),
                                3),
                        isDisplayed()));
        appCompatButton9.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.txtResult),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        textView3.check(matches(withText("Result: -15.0")));

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.btn2), withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        3),
                                1),
                        isDisplayed()));
        appCompatButton10.perform(click());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.btnPlus), withText("+"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        3),
                                3),
                        isDisplayed()));
        appCompatButton11.perform(click());

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.btn3), withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        3),
                                2),
                        isDisplayed()));
        appCompatButton12.perform(click());

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.btnPlus), withText("+"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        3),
                                3),
                        isDisplayed()));
        appCompatButton13.perform(click());

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(R.id.btn6), withText("6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        2),
                                2),
                        isDisplayed()));
        appCompatButton14.perform(click());

        ViewInteraction appCompatButton15 = onView(
                allOf(withId(R.id.btnEquals), withText("="),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tableLayout),
                                        4),
                                3),
                        isDisplayed()));
        appCompatButton15.perform(click());

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.txtResult), withText("Result: -15.0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        textView5.check(matches(withText("Result: -15.0")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
