package com.microacademylabs.morerestaurants.models;

/**
 * Created by Karen Freeman-Smith on 5/30/2017.
 */

public class Place {
  private String mName;

  public Place(String name) {
    this.mName = name;

  }

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    mName = name;
  }
}
