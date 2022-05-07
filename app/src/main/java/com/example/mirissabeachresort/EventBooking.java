package com.example.mirissabeachresort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EventBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_booking);
    }

    public void gregoryBallroom(View view) {
        startActivity(new Intent(getApplicationContext(),EventBooking_GregoryBallroom_Dis1.class));
    }
    public void grandBallroom(View view) {
        startActivity(new Intent(getApplicationContext(),EventBooking_GrandBallroom_Dis1.class));
    }
    public void beach(View view) {
        startActivity(new Intent(getApplicationContext(),EventBooking_Beach_Dis1.class));
    }
    public void dining(View view) {
        startActivity(new Intent(getApplicationContext(),EventBooking_Dining_Dis1.class));
    }

}