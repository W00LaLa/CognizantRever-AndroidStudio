package com.example.cognizantrever;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        //get intent which started this activity gets data from the key --mykey
        String dataRecieved = getIntent().getExtras().getString("mykey");

        //from the intent i get extras --mykey
        //set it on a textview
        TextView homeView = findViewById(R.id.tvHome);
        homeView.setText(dataRecieved);
    }


}