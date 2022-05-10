package com.example.mirissabeachresort;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class WhaleForm extends AppCompatActivity {

    EditText name, nic, phone, arrivalDate, boatNo, adult , chlidren;
    Button btn_save;

   EditText mDateFormat;
   //date picker dialog
   DatePickerDialog.OnDateSetListener onDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whale_form);

        name = (EditText)findViewById(R.id.Wname);
        nic = (EditText)findViewById(R.id.Wnic);
        phone = (EditText)findViewById(R.id.Wphone);
        arrivalDate = (EditText)findViewById(R.id.Warrivaldate);
        boatNo = (EditText)findViewById(R.id.Wselectboat);
        adult = (EditText)findViewById(R.id.txtAdult);
        chlidren = (EditText)findViewById(R.id.txtChildren);

        btn_save = (Button) findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                clearAll();
            }
        });



        final Calendar calender  = Calendar.getInstance();
        int year = calender.get(Calendar.YEAR);
        int month = calender.get(Calendar.MONTH);
        int day = calender.get(Calendar.DAY_OF_MONTH);
        mDateFormat = findViewById(R.id.Warrivaldate);
        mDateFormat.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        WhaleForm.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                        onDateSetListener, year, month, day);
                        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        datePickerDialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = year+"/"+month+"/"+dayOfMonth;
                mDateFormat.setText(date);
            }
        };






    }

    private void insertData() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("age", nic.getText().toString());
        map.put("phone", phone.getText().toString());
        map.put("arrivalDate", arrivalDate.getText().toString());
        map.put("boatNo", boatNo.getText().toString());
        map.put("adult", adult.getText().toString());
        map.put("chlidren", chlidren.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("WhaleFishing").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(WhaleForm.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(WhaleForm.this, "Error while Registation", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void clearAll() {
        name.setText("");
        nic.setText("");
        phone.setText("");
        arrivalDate.setText("");
        boatNo.setText("");
        adult.setText("");
        chlidren.setText("");
    }


}