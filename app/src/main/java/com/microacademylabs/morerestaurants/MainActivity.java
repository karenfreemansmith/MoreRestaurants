package com.microacademylabs.morerestaurants;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  public static final String TAG = MainActivity.class.getSimpleName();
  private Button btnFind;
  private EditText editLocation;
  private TextView titleTV;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    editLocation = (EditText)findViewById(R.id.etLocation);

    titleTV = (TextView)findViewById(R.id.tvTitle);
    Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/ExpletusSans-SemiBoldItalic.ttf");
    titleTV.setTypeface(myFont);

    btnFind = (Button)findViewById(R.id.btnFind);
    btnFind.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
//         Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG).show();
         String location = editLocation.getText().toString();
//         Log.d(TAG, location);
         Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
         intent.putExtra("location", location);
         startActivity(intent);
       }
    });
  }
}
