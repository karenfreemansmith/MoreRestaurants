package com.microacademylabs.morerestaurants;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.microacademylabs.morerestaurants.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Karen Freeman-Smith on 5/23/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentationTest {
  @Rule
  public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

  @Test
  public void validateEditText() {
    onView(withId(R.id.etLocation)).perform(typeText("Portland"))
        .check(matches(withText("Portland")));
  }

  @Test
  public void locationIsSentToRestaurantsActivity() {
    String location = "Portland";
    onView(withId(R.id.etLocation)).perform(typeText(location), closeSoftKeyboard());
    onView(withId(R.id.btnFind)).perform(click());
    onView(withId(R.id.tvLocation)).check(matches(withText("Here are all the restaurants near " + location)));
  }
}
