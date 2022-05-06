package com.example.eventsdemo

import Event
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.eventsdemo.response.Image
import com.example.eventsdemo.ui.EventActivity
import com.example.eventsdemo.ui.EventAdapter
import com.example.eventsdemo.ui.EventDetailsActivity
import com.example.eventsdemo.utils.IConstants
import org.junit.Before
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
class EventDetailsActivityInstrumentedTest {
    lateinit var scenario: ActivityScenario<EventDetailsActivity>


    @Before
    fun start() {
        val intent =
            Intent(ApplicationProvider.getApplicationContext(), EventDetailsActivity::class.java)
        val event = Event(
            "1",
            listOf<Image>(
                Image(
                    false,
                    100,
                    "",
                    "https://s1.ticketm.net/dam/a/ac1/3bc6b045-e04f-4520-b1de-b552e2b1cac1_1645021_RETINA_PORTRAIT_3_2.jpg",
                    300
                )
            ),
            "",
            "Test",
            true,
            "Event",
            "https://s1.ticketm.net/dam/a/ac1/3bc6b045-e04f-4520-b1de-b552e2b1cac1_1645021_RETINA_PORTRAIT_3_2.jpg"
        )
        intent.putExtra(IConstants.EVENT, event)
        scenario = ActivityScenario.launch(intent)

    }

    @Test
    fun isTitleVisible() {
        onView(withId(R.id.tvTitle)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

    }

    @Test
    fun isTitleCorrect() {
        onView(withId(R.id.tvTitle)).check(matches(withText("Test")));
    }

    @Test
    fun isEventImageVisible() {
        onView(withId(R.id.ivEvent)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }


}