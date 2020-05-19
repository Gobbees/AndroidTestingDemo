package com.giovannigobbi.androidtestingexample;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.test.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstrumentedUnitTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class) {
        @Override
        protected void beforeActivityLaunched() {
            SharedPreferences sp = InstrumentationRegistry.getTargetContext().getSharedPreferences("MainActivity", Context.MODE_PRIVATE);
            sp.edit().putString("lastResult", "1").commit();
            super.beforeActivityLaunched();
        }
    };

    @Test
    public void testSP() {
        MainActivity activity = mainActivityTestRule.getActivity();
        assertEquals("Last Result: 1", activity.txtLastResult.getText().toString());
    }
}
