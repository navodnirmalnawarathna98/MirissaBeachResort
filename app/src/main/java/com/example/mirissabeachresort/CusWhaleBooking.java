package com.example.mirissabeachresort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;




public class CusWhaleBooking extends AppCompatActivity {

    RecyclerView recyclerView;
    CusWhaleBooking_Adapter cusWhaleBooking_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_whale_booking);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<CusWhaleBooking_Model> options =
                new FirebaseRecyclerOptions.Builder<CusWhaleBooking_Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("WhaleFishing"), CusWhaleBooking_Model.class)
                        .build();

        cusWhaleBooking_adapter = new CusWhaleBooking_Adapter(options);
        recyclerView.setAdapter(cusWhaleBooking_adapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        cusWhaleBooking_adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cusWhaleBooking_adapter.stopListening();
    }



}