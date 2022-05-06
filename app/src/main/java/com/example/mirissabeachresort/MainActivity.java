package com.example.mirissabeachresort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

    public void roomBooking(View view) {
        startActivity(new Intent(getApplicationContext(),RoomBooking.class));
    }

    public void eventBooking(View view) {
        startActivity(new Intent(getApplicationContext(),EventBooking.class));
    }

    public void foodBuffet(View view) {
        startActivity(new Intent(getApplicationContext(),FoodBuffet.class));
    }

    public void whaleFishing(View view) {
        startActivity(new Intent(getApplicationContext(),WhaleFishing.class));
    }

}