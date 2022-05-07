package com.example.mirissabeachresort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WhaleWatching_Details2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whale_watching_details2);
    }

    public void whalebooking(View view) {
        startActivity(new Intent(getApplicationContext(),WhaleForm.class));
    }
}