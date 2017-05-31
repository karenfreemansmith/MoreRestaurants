package com.microacademylabs.morerestaurants;

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

import com.microacademylabs.morerestaurants.adapters.MyRestaurantsArrayAdapter;
import com.microacademylabs.morerestaurants.services.YelpService;

import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RestaurantsActivity extends AppCompatActivity {
  public static final String TAG = RestaurantsActivity.class.getSimpleName();
  private TextView locationText;

  private ListView mRestaurantList;
  private String[] restaurants = new String[] {
      "Sweet Hereafter", "Cricket", "Hawthorne Fish House", "Viking Soul Food", "Red Square", "Horse Brass", "Dick's Kitchen", "Taco Bell", "Me Kha Noodle Bar", "La Bonita Taqueria", "Smokehouse Tavern", "Pembiche", "Kay's Bar", "Gnarly Grey", "Slappy Cakes", "Mi Mero Mole"
  };
  private String[] cuisines = new String[] {
      "Vegan Food", "Breakfast", "Fishs Dishs", "Scandinavian", "Coffee", "English Food", "Burgers", "Fast Food", "Noodle Soups", "Mexican", "BBQ", "Cuban", "Bar Food", "Sports Bar", "Breakfast", "Mexican"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_restaurants);

    locationText = (TextView)findViewById(R.id.tvLocation);

    mRestaurantList = (ListView)findViewById(R.id.restaurantListView);
    MyRestaurantsArrayAdapter adapter = new MyRestaurantsArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines);
    mRestaurantList.setAdapter(adapter);
    mRestaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String restaurant = ((TextView)view).getText().toString();
        Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
      }
    });

    Intent intent = getIntent();
    String location = intent.getStringExtra("location");
    String term = intent.getStringExtra("term");
    getRestaurants(location, term);
    locationText.setText("Here are all the " + term + " near " + location);
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

        try {
          String jsonData = response.body().string();
          Log.v(TAG, jsonData);
        } catch (IOException e) {

        }
      }
    });
  }
}
