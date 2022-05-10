package com.example.mirissabeachresort;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Event_Gregory_Booking_Form extends AppCompatActivity {
    EditText name, nic, phone, email, bookingDate, time, guest;
    Button btnAdd, btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_gregory_booking_form);


        name = (EditText) findViewById(R.id.txtName);
        nic = (EditText) findViewById(R.id.txtNic);
        phone = (EditText) findViewById(R.id.txtPhone);
        email = (EditText) findViewById(R.id.txtEmail);
        bookingDate = (EditText) findViewById(R.id.txtBookingDate);
        time = (EditText) findViewById(R.id.txtTime);
        guest = (EditText) findViewById(R.id.txtGuest);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                clearAll();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



    private void insertData() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("nic", nic.getText().toString());
        map.put("phone", phone.getText().toString());
        map.put("email", email.getText().toString());
        map.put("bookingDate", bookingDate.getText().toString());
        map.put("time", time.getText().toString());
        map.put("guest", guest.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Event").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Event_Gregory_Booking_Form.this, "Successfully Done", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Event_Gregory_Booking_Form.this, "Error while Accepting Your Booking", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void clearAll() {
        name.setText("");
        nic.setText("");
        phone.setText("");
        email.setText("");
        bookingDate.setText("");
        time.setText("");
        guest.setText("");

    }

    public void profile(View view) {
        startActivity(new Intent(getApplicationContext(),Profile.class));
    }
}