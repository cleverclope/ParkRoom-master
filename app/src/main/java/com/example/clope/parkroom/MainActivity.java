package com.example.clope.parkroom;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="mytag";
    private static final String TA=MainActivity.class.getSimpleName();

    ListView list;
    String[]parkNow={"Nearest Parking","Cheapest Parking","Most Popular Parking",
            "Street Parking","VIP PARK","Most Common Parkyard"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        list =(ListView) findViewById(R.id.room1);
        ArrayAdapter <String>arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,parkNow);
        list.setAdapter(arrayAdapter );


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view, int position, long id){
                Toast.makeText(getApplicationContext(),parkNow[position],
                        Toast.LENGTH_SHORT).show();
            }});
        Handler handler= new Handler ();
        handler.postDelayed (new Runnable () {
            @Override
            public void run() {
                Intent intent= new Intent (MainActivity.this, NearestParking.class);
                startActivity (intent);
                finish ();
            }
        },3000);
    }
    protected void onStart(){
        super.onStart();
    }
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"RESUME");
    }
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"PAUSE");
    }
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"STOP");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"DESTROY");
    }
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"RESTART");
    }

  /*  public void toNextActivity(){
        Intent intent= new Intent(this,NearestParking.class);
        startActivity(intent);
    }*/

    public void fun(View V){
        Intent intent= new Intent(this,NearestParking.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_nearest_parking,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.parking:
                Log.d(TAG, "parking IS CLICKED");
                return true;
            case R.id.motor:
                Log.d(TAG, "motor IS CLICKED");
                return true;
            case R.id.trairers:
                Log.d(TAG, "trairers IS CLICKED");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }}
