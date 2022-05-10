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

public class CusEventGregoryBooking_Adapter extends FirebaseRecyclerAdapter<CusEventGregoryBooking_Model, CusEventGregoryBooking_Adapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CusEventGregoryBooking_Adapter(@NonNull FirebaseRecyclerOptions<CusEventGregoryBooking_Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, final int position, @NonNull CusEventGregoryBooking_Model model) {

        holder.name.setText(model.getName());
        holder.nic.setText(model.getNic());
        holder.phone.setText(model.getPhone());
        holder.email.setText(model.getEmail());
        holder.bookingDate.setText(model.getBookingDate());
        holder.time.setText(model.getTime());
        holder.guest.setText(model.getGuest());



        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.name.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup_event))
                        .setExpanded(true, 1600)
                        .create();

                View view1 = dialogPlus.getHolderView();

                EditText name = view1.findViewById(R.id.txtName);
                EditText nic = view1.findViewById(R.id.txtNic);
                EditText phone = view1.findViewById(R.id.txtPhone);
                EditText email = view1.findViewById(R.id.txtEmail);
                EditText bookingDate = view1.findViewById(R.id.txtBookingDate);
                EditText time = view1.findViewById(R.id.txtTime);
                EditText guest = view1.findViewById(R.id.txtGuest);

                Button btnUpdate = view1.findViewById(R.id.btnUpdate);

                name.setText(model.getName());
                nic.setText(model.getNic());
                phone.setText(model.getPhone());
                email.setText(model.getEmail());
                bookingDate.setText(model.getBookingDate());
                time.setText(model.getTime());
                guest.setText(model.getGuest());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("name", name.getText().toString());
                        map.put("nic", nic.getText().toString());
                        map.put("phone", phone.getText().toString());
                        map.put("email", email.getText().toString());
                        map.put("bookingDate", bookingDate.getText().toString());
                        map.put("time", time.getText().toString());
                        map.put("guest", guest.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Event")
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

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("Deleted Buffet Booking can't Undo");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Event")
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cus_event_gregory_booking_item,parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView name, nic, phone, email ,bookingDate, time, guest;

        Button btnEdit, btnDelete;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.nametext);
            nic = (TextView)itemView.findViewById(R.id.nictext);
            phone = (TextView)itemView.findViewById(R.id.phonetext);
            email = (TextView)itemView.findViewById(R.id.emailtext);
            bookingDate = (TextView)itemView.findViewById(R.id.bookingDatetext);
            time = (TextView)itemView.findViewById(R.id.timetext);
            guest = (TextView)itemView.findViewById(R.id.guesttext);



            btnEdit = (Button)itemView.findViewById(R.id.btnEdit);
            btnDelete = (Button)itemView.findViewById(R.id.btnDelete);
        }
    }
}
