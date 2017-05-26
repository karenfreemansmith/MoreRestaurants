package com.microacademylabs.morerestaurants.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by Karen Freeman-Smith on 5/26/2017.
 */

public class MyRestaurantsArrayAdapter extends ArrayAdapter {
  private Context mContext;
  private String[] mRestaurants;
  private String[] mCuisines;

  public MyRestaurantsArrayAdapter(Context mContext, int resource, String[] mRestaurants, String[] mCuisines) {
    super(mContext, resource);
    this.mContext = mContext;
    this.mRestaurants = mRestaurants;
    this.mCuisines = mCuisines;
  }

  @Override
  public Object getItem(int position) {
    String restaurant = mRestaurants[position];
    String cuisine = mCuisines[position];
    return String.format("%s \nServes great: %s", restaurant, cuisine);
  }

  @Override
  public int getCount() {
    return mRestaurants.length;
  }

}
