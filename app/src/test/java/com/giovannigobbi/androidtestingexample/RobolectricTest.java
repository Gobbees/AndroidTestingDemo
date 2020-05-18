package com.giovannigobbi.androidtestingexample;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class RobolectricTest {

    @Test
    @Config(sdk = 28)
    public void setup() {
        try(ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class)) {
            activityScenario.moveToState(Lifecycle.State.CREATED);
            activityScenario.onActivity(activity -> {
                assertEquals("Result: ", activity.txtResult.getText().toString());
                assertEquals("", activity.operation.getText().toString());
            });
            activityScenario.moveToState(Lifecycle.State.RESUMED);
            activityScenario.onActivity(activity -> {
                //do something
            });
        }
    }
}
