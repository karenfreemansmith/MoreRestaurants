package com.microacademylabs.morerestaurants;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by Karen Freeman-Smith on 5/23/2017.
 */

public class RestaurantsActivityInstrumentationTest {
  @Rule
  public ActivityTestRule<RestaurantsActivity> activityTestRule = new ActivityTestRule<>(RestaurantsActivity.class);

  @Test
  public void listItemClickDisplaysToastWithCorrectRestaurant() {
    View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
    String restaurantName = "Sweet Hereafter \nServes great: Vegan Food";
    onData(anything())
      .inAdapterView(withId(R.id.restaurantListView))
        .atPosition(0)
        .perform(click());
    onView(withText(restaurantName)).inRoot(withDecorView(not(activityDecorView)))
        .check(matches(withText(restaurantName)));
  }
}
