package com.example.mirissabeachresort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class CusEventGregoryBooking extends AppCompatActivity {
    RecyclerView recyclerView;
    CusEventGregoryBooking_Adapter cusEventGregoryBooking_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_event_gregory_booking);

        recyclerView = (RecyclerView)findViewById(R.id.rvEvent);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<CusEventGregoryBooking_Model> options =
                new FirebaseRecyclerOptions.Builder<CusEventGregoryBooking_Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Event"), CusEventGregoryBooking_Model.class)
                        .build();

        cusEventGregoryBooking_adapter = new CusEventGregoryBooking_Adapter(options);
        recyclerView.setAdapter(cusEventGregoryBooking_adapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        cusEventGregoryBooking_adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cusEventGregoryBooking_adapter.stopListening();
    }
}