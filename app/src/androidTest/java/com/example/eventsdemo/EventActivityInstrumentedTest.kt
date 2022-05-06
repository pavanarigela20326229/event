package com.example.eventsdemo

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.eventsdemo.ui.EventActivity
import com.example.eventsdemo.ui.EventAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class EventActivityInstrumentedTest {


    @get : Rule
    public var activityScenarioRule: ActivityScenarioRule<EventActivity> =
        ActivityScenarioRule(
            EventActivity::class.java
        )


    @Test
    fun isRecyclerViewVisibleAndRedirectToDetails() {
        Thread.sleep(6000)
        onView(withId(R.id.rvEvents)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.rvEvents)).perform(
            RecyclerViewActions.actionOnItemAtPosition<EventAdapter.ViewHolder>(
                0,
                click()
            )
        )
    }






}