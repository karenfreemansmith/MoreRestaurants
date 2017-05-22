package com.microacademylabs.morerestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RestaurantsActivity extends AppCompatActivity {
  private TextView locationText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_restaurants);

    locationText = (TextView)findViewById(R.id.tvLocation);
    Intent intent = getIntent();
    String location = intent.getStringExtra("location");
    locationText.setText("Here are all the restaurants near " + location);
  }
}
