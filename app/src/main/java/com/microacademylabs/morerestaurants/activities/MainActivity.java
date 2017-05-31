package com.microacademylabs.morerestaurants.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.microacademylabs.morerestaurants.R;

public class MainActivity extends AppCompatActivity {
  public static final String TAG = MainActivity.class.getSimpleName();
  private Button btnFind;
  private EditText editLocation;
  private EditText editTerm;
  private TextView titleTV;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    editLocation = (EditText)findViewById(R.id.etLocation);
    editTerm = (EditText)findViewById(R.id.etTerm);

    titleTV = (TextView)findViewById(R.id.tvTitle);
    Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/ExpletusSans-SemiBoldItalic.ttf");
    titleTV.setTypeface(myFont);

    btnFind = (Button)findViewById(R.id.btnFind);
    btnFind.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
         String location = editLocation.getText().toString();
         String term = editTerm.getText().toString();

         Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
         intent.putExtra("location", location);
         intent.putExtra("term", term);
         startActivity(intent);
       }
    });
  }
}
