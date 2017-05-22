package com.microacademylabs.morerestaurants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  private Button btnFind;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnFind = (Button)findViewById(R.id.btnFind);
    btnFind.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
         Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG).show();
       }
    });
  }
}
