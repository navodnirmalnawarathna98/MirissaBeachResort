package com.example.mirissabeachresort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class CusBuffetBooking extends AppCompatActivity {

    RecyclerView recyclerView;
    CusBuffetBooking_Adapter cusBuffetBooking_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_buffet_booking);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<CusBuffetBooking_Model> options =
                new FirebaseRecyclerOptions.Builder<CusBuffetBooking_Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Buffet"), CusBuffetBooking_Model.class)
                        .build();

        cusBuffetBooking_adapter = new CusBuffetBooking_Adapter(options);
        recyclerView.setAdapter(cusBuffetBooking_adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        cusBuffetBooking_adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cusBuffetBooking_adapter.stopListening();
    }

}