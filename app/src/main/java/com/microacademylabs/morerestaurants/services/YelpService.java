package com.microacademylabs.morerestaurants.services;

import android.util.Log;

import com.microacademylabs.morerestaurants.Constants;
import com.microacademylabs.morerestaurants.models.Place;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by Karen Freeman-Smith on 5/30/2017.
 */

public class YelpService {
  public static void findStuff(String term, String location, Callback cb) {
    OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.YELP_CONSUMER_KEY, Constants.YELP_CONSUMER_SECRET);
    consumer.setTokenWithSecret(Constants.YELP_TOKEN, Constants.YELP_TOKEN_SECRET);

    OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(new SigningInterceptor(consumer))
        .build();

    HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YELP_BASE_URL).newBuilder();
    urlBuilder.addQueryParameter(Constants.YELP_TERM_QUERY_PARAMETER, term);
    urlBuilder.addQueryParameter(Constants.YELP_LOCATION_QUERY_PARAMETER, location);
    String url = urlBuilder.build().toString();

    Request request = new Request.Builder()
        .url(url)
        .build();

    Call call = client.newCall(request);
    call.enqueue(cb);
  }

  public ArrayList<Place> processResults(String jsonData) {
    ArrayList<Place> places = new ArrayList<>();
    try {
      //String jsonData = response.body().string();
      //if(response.isSuccessful()) {
        JSONObject yelpJSON = new JSONObject(jsonData);
        JSONArray businessJSON = yelpJSON.getJSONArray("businesses");
        for(int i=0; i<businessJSON.length(); i++) {
          JSONObject placeJSON = businessJSON.getJSONObject(i);
          String name = placeJSON.getString("name");
          Place place = new Place(name);
          places.add(place);
        }
      //}
    } catch(JSONException e) {
      e.printStackTrace();
    }
    return places;
  }
}
