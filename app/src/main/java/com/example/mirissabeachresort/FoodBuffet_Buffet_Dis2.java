package com.example.mirissabeachresort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FoodBuffet_Buffet_Dis2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_buffet_buffet_dis2);
    }

    public void buffetBooking(View view) {
        startActivity(new Intent(getApplicationContext(),FoodBuffet_Booking_Form.class));
    }

    public void profile(View view) {
        startActivity(new Intent(getApplicationContext(),FoodBuffet_Buffet_Dis1.class));
    }
}