package com.example.mirissabeachresort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WhaleFishing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whale_fishing);
    }

    public void whaleDash(View view) {
        startActivity(new Intent(getApplicationContext(),WhaleWatching_Details.class));
    }
}