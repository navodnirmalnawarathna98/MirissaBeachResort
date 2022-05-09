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

public class FoodBuffet_Booking_Form extends AppCompatActivity {

    EditText name, age, phone, email;
    Button btnAdd, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_buffet_booking_form);

        name = (EditText)findViewById(R.id.txtName);
        age = (EditText)findViewById(R.id.txtAge);
        phone = (EditText)findViewById(R.id.txtPhone);
        email = (EditText)findViewById(R.id.txtEmail);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnBack = (Button)findViewById(R.id.btnBack);

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
        map.put("age", age.getText().toString());
        map.put("phone", phone.getText().toString());
        map.put("email", email.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Buffet").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(FoodBuffet_Booking_Form.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(FoodBuffet_Booking_Form.this, "Error while Registation", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void clearAll() {
        name.setText("");
        age.setText("");
        phone.setText("");
        email.setText("");
    }

    public void profile(View view) {
        startActivity(new Intent(getApplicationContext(),Profile.class));
    }

}