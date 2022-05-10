package com.example.mirissabeachresort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EventBooking_GregoryBallroom_Dis2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_booking_gregory_ballroom_dis2);
    }

    public void EventGregoryBooking(View view) {
        startActivity(new Intent(getApplicationContext(),Event_Gregory_Booking_Form.class));
    }

}