package com.example.mirissabeachresort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void cusBuffetBooking(View view) {
        startActivity(new Intent(getApplicationContext(),CusBuffetBooking.class));
    }

    public void profile(View view) {
        startActivity(new Intent(getApplicationContext(),Profile.class));
    }


    public void cusEventGregoryBooking(View view) {
        startActivity(new Intent(getApplicationContext(),CusEventGregoryBooking.class));

    public void CusWhaleBooking(View view) {
        startActivity(new Intent(getApplicationContext(),CusWhaleBooking.class));

    }
}