package com.example.cognizantrever;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    String TAG = HomeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        Log.i(TAG,"created --egg-- memory is being allocated");
        //get intent which started this activity gets data from the key --mykey
        String dataRecieved = getIntent().getExtras().getString("mykey");

        //from the intent i get extras --mykey
        //set it on a textview
        TextView homeView = findViewById(R.id.tvHome);
        homeView.setText(dataRecieved);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.w(TAG,"started --egg hatched -- ui is visible");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"wake up -- resume -foreground");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"nap -- onpause-- background");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"hibernate-- onstop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "purged-- vanished-destroyed");
    }
}