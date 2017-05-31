package com.microacademylabs.morerestaurants.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.microacademylabs.morerestaurants.R;
import com.microacademylabs.morerestaurants.adapters.MyRestaurantsArrayAdapter;
import com.microacademylabs.morerestaurants.models.Place;
import com.microacademylabs.morerestaurants.services.YelpService;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RestaurantsActivity extends AppCompatActivity {
  public static final String TAG = RestaurantsActivity.class.getSimpleName();
  private TextView locationText;
  private ListView mRestaurantList;

  public ArrayList<Place> mPlaces = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_restaurants);

    locationText = (TextView)findViewById(R.id.tvLocation);

    Intent intent = getIntent();
    String location = intent.getStringExtra("location");
    String term = intent.getStringExtra("term");
    getRestaurants(location, term);
    locationText.setText("Here are all the " + term + " places near " + location);
  }

  private void getRestaurants(String location, String term) {
    final YelpService yelp = new YelpService();
    yelp.findStuff(term, location, new Callback() {

      @Override
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        final String jsonData = response.body().string();
        mPlaces = yelp.processResults(jsonData);

        RestaurantsActivity.this.runOnUiThread(new Runnable() {
          @Override
          public void run() {
            //textAPI.setText(jsonData);

            mRestaurantList = (ListView)findViewById(R.id.restaurantListView);
            MyRestaurantsArrayAdapter adapter = new MyRestaurantsArrayAdapter(RestaurantsActivity.this, android.R.layout.simple_list_item_1, mPlaces);
            mRestaurantList.setAdapter(adapter);
            mRestaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
              }
            });
          }
        });

      }
    });
  }
}
