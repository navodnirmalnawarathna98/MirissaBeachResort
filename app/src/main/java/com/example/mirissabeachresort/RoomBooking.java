package com.example.mirissabeachresort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RoomBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_booking);
    }

    public void roomBookingDis_1(View view) {
        startActivity(new Intent(getApplicationContext(),RoomBooking_Room_Dis1.class));
    }

    public void roomBookingDis_3(View view) {
        startActivity(new Intent(getApplicationContext(),RoomBooking_Room_Dis3.class));
    }
}