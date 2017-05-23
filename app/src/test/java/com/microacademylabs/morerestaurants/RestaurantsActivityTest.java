package com.microacademylabs.morerestaurants;

/**
 * Created by Karen Freeman-Smith on 5/23/2017.
 */

    import android.os.Build;
    import android.widget.ListView;

    import org.junit.Before;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.robolectric.Robolectric;
    import org.robolectric.RobolectricGradleTestRunner;
    import org.robolectric.annotation.Config;

    import static junit.framework.Assert.assertEquals;
    import static junit.framework.Assert.assertNotNull;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class RestaurantsActivityTest {
  private RestaurantsActivity activity;
  private ListView mRestaurantListView;

  @Before
  public void setup() {
    activity = Robolectric.setupActivity(RestaurantsActivity.class);
    mRestaurantListView = (ListView) activity.findViewById(R.id.restaurantListView);
  }

  @Test
  public void restaurantListViewPopulates() {
    assertNotNull(mRestaurantListView.getAdapter());
    assertEquals(mRestaurantListView.getAdapter().getCount(), 15);
  }

}
