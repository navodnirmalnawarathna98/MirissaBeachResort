package com.example.mirissabeachresort;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class WhaleForm extends AppCompatActivity {

   EditText mDateFormat;
   //date picker dialog
   DatePickerDialog.OnDateSetListener onDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whale_form);

        final Calendar calender  = Calendar.getInstance();
        int year = calender.get(Calendar.YEAR);
        int month = calender.get(Calendar.MONTH);
        int day = calender.get(Calendar.DAY_OF_MONTH);
        mDateFormat = findViewById(R.id.arrivaldate);
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
}