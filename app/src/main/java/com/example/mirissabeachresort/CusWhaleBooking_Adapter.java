package com.example.mirissabeachresort;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class CusWhaleBooking_Adapter extends FirebaseRecyclerAdapter< CusWhaleBooking_Model , CusWhaleBooking_Adapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CusWhaleBooking_Adapter(@NonNull FirebaseRecyclerOptions<CusWhaleBooking_Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, final int position, @NonNull CusWhaleBooking_Model model) {

        holder.name.setText(model.getName());
        holder.nic.setText(model.getNic());
        holder.phone.setText(model.getPhone());
        holder.arrivalDate.setText(model.getArrivalDate());
        holder.boatNo.setText(model.getBoatNo());
        holder.adult.setText(model.getAdult());
        holder.chlidren.setText(model.getChlidren());



        holder.btnWEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.name.getContext())
                        .setContentHolder(new ViewHolder(R.layout.wupdate_popup))
                        .setExpanded(true, 1200)
                        .create();

                View view1 = dialogPlus.getHolderView();

                //get values From form ids
                EditText name = view1.findViewById(R.id.Wname);
                EditText nic = view1.findViewById(R.id.Wnic);
                EditText phone = view1.findViewById(R.id.Wphone);
                EditText arrivalDate = view1.findViewById(R.id.Warrivaldate);
                EditText boatNo = view1.findViewById(R.id.Wselectboat);
                EditText adult = view1.findViewById(R.id.txtAdult);
                EditText children = view1.findViewById(R.id.txtChildren);

                Button btnWpdate = view1.findViewById(R.id.btnWUpdate);

                name.setText(model.getName());
                nic.setText(model.getNic());
                phone.setText(model.getPhone());
                arrivalDate.setText(model.getArrivalDate());
                boatNo.setText(model.getBoatNo());
                adult.setText(model.getAdult());
                children.setText(model.getChlidren());

                dialogPlus.show();

                btnWpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("name", name.getText().toString());
                        map.put("nic", nic.getText().toString());
                        map.put("phone", phone.getText().toString());
                        map.put("arrivalDate", arrivalDate.getText().toString());
                        map.put("boatNo", boatNo.getText().toString());
                        map.put("adult", adult.getText().toString());
                        map.put("children", children.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("WhaleFishing")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.name.getContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.name.getContext(), "Error While Updating", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });
            }
        });  // finish update

        holder.btnWDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("Deleted Whale Booking can't Undo");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("WhaleFishing")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.name.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();
            }
        }); // finish delete

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cus_whale_booking_item,parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView name,nic,phone,arrivalDate,boatNo,adult,chlidren;

        Button btnWEdit, btnWDelete;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.wnametext);
            nic = (TextView)itemView.findViewById(R.id.wnictext);
            phone = (TextView)itemView.findViewById(R.id.wphonetext);


            btnWEdit = (Button)itemView.findViewById(R.id.WbtnEdit);
            btnWDelete = (Button)itemView.findViewById(R.id.WbtnDelete);
        }
    }
}
