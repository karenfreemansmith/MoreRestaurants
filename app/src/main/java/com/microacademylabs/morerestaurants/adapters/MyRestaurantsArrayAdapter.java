package com.microacademylabs.morerestaurants.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.microacademylabs.morerestaurants.models.Place;

import java.util.ArrayList;

/**
 * Created by Karen Freeman-Smith on 5/26/2017.
 */

public class MyRestaurantsArrayAdapter extends ArrayAdapter {
  private Context mContext;
  private ArrayList<Place> mPlaces;

  public MyRestaurantsArrayAdapter(Context mContext, int resource, ArrayList<Place> places) {
    super(mContext, resource);
    this.mContext = mContext;
    this.mPlaces = places;
  }

  @Override
  public Object getItem(int position) {
    String restaurant = mPlaces.get(position).getName();
    return String.format("%s", restaurant);
  }

  @Override
  public int getCount() {
    return mPlaces.size();
  }

}
