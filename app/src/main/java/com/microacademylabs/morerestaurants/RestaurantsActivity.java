package com.microacademylabs.morerestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RestaurantsActivity extends AppCompatActivity {
  private TextView locationText;
  private ListView mRestaurantList;
  private String[] restaurants = new String[] {
      "Mi Mero Mole", "Mother's Bistro",
      "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
      "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
      "Lardo", "Portland City Grill", "Fat Head's Brewery",
      "Chipotle", "Subway"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_restaurants);

    locationText = (TextView)findViewById(R.id.tvLocation);
    mRestaurantList = (ListView)findViewById(R.id.restaurantListView);
    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants);
    mRestaurantList.setAdapter(adapter);

    Intent intent = getIntent();
    String location = intent.getStringExtra("location");
    locationText.setText("Here are all the restaurants near " + location);
  }
}
