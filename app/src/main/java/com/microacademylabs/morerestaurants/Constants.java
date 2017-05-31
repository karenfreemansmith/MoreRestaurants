package com.microacademylabs.morerestaurants;

/**
 * Created by Karen Freeman-Smith on 5/30/2017.
 */

public class Constants {
  public static final String YELP_CONSUMER_KEY = BuildConfig.YELP_CONSUMER_KEY;
  public static final String YELP_CONSUMER_SECRET = BuildConfig.YELP_CONSUMER_SECRET;
  public static final String YELP_TOKEN = BuildConfig.YELP_TOKEN;
  public static final String YELP_TOKEN_SECRET = BuildConfig.YELP_TOKEN_SECRET;
  public static final String YELP_BASE_URL = "https://api.yelp.com/v2/search?";
  //term=food, category_filter=nudist, All, category_filter=parasailing, All
  public static final String YELP_TERM_QUERY_PARAMETER = "term";
  public static final String YELP_LOCATION_QUERY_PARAMETER = "location";
}
