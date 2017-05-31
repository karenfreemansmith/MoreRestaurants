package com.microacademylabs.morerestaurants;

import android.content.Intent;
import android.widget.TextView;

import com.microacademylabs.morerestaurants.activities.MainActivity;
import com.microacademylabs.morerestaurants.activities.RestaurantsActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Karen Freeman-Smith on 5/23/2017.
 * Tests won't run/pass because the required files are not getting
 * saved when robolectric is downloaded.
 * This has to do with my user account having an illegal character
 * and cannot be fixed without reinstalling windows (which I cannot
 * do because it was presinstalled and I don't have disks to install
 * it. NEXT TIME I get a new computer, try to remember not to have
 * spaces in my name...
 */

@Config(constants = BuildConfig.class, manifest=Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
  private MainActivity activity;

  @Before
  public void setup() {
    activity = Robolectric.setupActivity(MainActivity.class);
  }

  @Test
  public void validateTextViewContent() {
    TextView titleTextView = (TextView)activity.findViewById(R.id.tvTitle);
    assertTrue("More Restaurants".equals(titleTextView.getText().toString()));
  }

  @Test
  public void secondActivityStarted() {
    activity.findViewById(R.id.btnFind).performClick();
    Intent expectedIntent = new Intent(activity, RestaurantsActivity.class);
    ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
    Intent actualIntent = shadowActivity.getNextStartedActivity();
    assertTrue(actualIntent.filterEquals(expectedIntent));
  }
}
