package com.example.easyticket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class booking extends AppCompatActivity {

    EditText editTextname, editTextphone, editTextemail;
    TextView textViewmv,textViewth,textViewdt,textViewtm,textViewcost,textViewfull,textViewhalf;
    Button btnnext1,btnupdate;
    DatabaseReference dbRef;
    Customer cus;
    TicketDetails tkte;

    private void clearControls() {
        editTextname.setText("");
        editTextphone.setText("");
        editTextemail.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        editTextname = findViewById(R.id.editTextname);
        editTextphone = findViewById(R.id.editTextphone);
        editTextemail = findViewById(R.id.editTextemail);
        textViewmv=findViewById(R.id.textViewmv);
        textViewth=findViewById(R.id.textViewth);
        textViewdt=findViewById(R.id.textViewdt);
        textViewtm=findViewById(R.id.textViewtm);
        textViewcost=findViewById(R.id.textViewcost);
        textViewfull=findViewById(R.id.textViewfull);
        textViewhalf=findViewById(R.id.textViewhalf);

        final CheckBox simpleCheckBox = (CheckBox) findViewById(R.id.simpleCheckBox);



        btnnext1 = findViewById(R.id.btnnext1);
        btnupdate = findViewById(R.id.btnupdate);

        cus = new Customer();

        tkte = new TicketDetails();







        btnnext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Customer");
                try {
                    if (TextUtils.isEmpty(editTextname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Your Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextphone.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Your phone", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextemail.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Your email", Toast.LENGTH_SHORT).show();

                    else {

                        cus.setName(editTextname.getText().toString().trim());
                        cus.setPhone(editTextphone.getText().toString().trim());
                        cus.setEmail(editTextemail.getText().toString().trim());


                        //dbRef.push().setValue(std);
                        dbRef.child("cus1").setValue(cus);


                        Intent i = new Intent(new Intent(booking.this, payment.class));
                        startActivity(i);


                        clearControls();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });






                DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("TicketDetails").child("tkt1");
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChildren()) {
                            textViewfull.setText(dataSnapshot.child("full").getValue().toString());
                            textViewhalf.setText(dataSnapshot.child("half").getValue().toString());
                            textViewcost.setText(dataSnapshot.child("cost").getValue().toString());

                        } else
                            Toast.makeText(getApplicationContext(), "No Sourse to display", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });







        DatabaseReference readRef2 = FirebaseDatabase.getInstance().getReference().child("MovieDetails").child("mv1");
        readRef2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.hasChildren()) {

                    textViewmv.setText(dataSnapshot.child("moviename").getValue().toString());
                    textViewth.setText(dataSnapshot.child("theater").getValue().toString());
                    textViewdt.setText(dataSnapshot.child("date").getValue().toString());
                    textViewtm.setText(dataSnapshot.child("time").getValue().toString());

                } else
                    Toast.makeText(getApplicationContext(), "No Sourse to display", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });







        DatabaseReference readRef3 = FirebaseDatabase.getInstance().getReference().child("Theater-Management").child("Cusp1");
        readRef3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.hasChildren()) {
                    editTextname.setText(dataSnapshot.child("name").getValue().toString());
                    editTextphone.setText(dataSnapshot.child("phone").getValue().toString());
                    editTextemail.setText(dataSnapshot.child("email").getValue().toString());
                    simpleCheckBox.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            if(simpleCheckBox.isChecked())
                            {
                                Toast.makeText(booking.this,"", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(booking.this,"Please confirm details", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                } else
                    Toast.makeText(getApplicationContext(), "No Sourse to display", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });






        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Theater-Management");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("Cusp1")) {
                            try {
                                cus.setName(editTextname.getText().toString().trim());
                                cus.setPhone(editTextphone.getText().toString().trim());
                                cus.setEmail(editTextemail.getText().toString().trim());



                                dbRef = FirebaseDatabase.getInstance().getReference().child("Theater-Management").child("Cusp1");
                                dbRef.setValue(cus);
                                simpleCheckBox.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        if(simpleCheckBox.isChecked())
                                        {
                                            Toast.makeText(booking.this,"", Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            Toast.makeText(booking.this,"Please confirm details", Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });

                                Toast.makeText(getApplicationContext(), "Check emails and confirm your payment", Toast.LENGTH_SHORT).show();

                            } catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(), "Please try again", Toast.LENGTH_SHORT).show();
                            }
                        } else
                            Toast.makeText(getApplicationContext(), "No Source to update", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
            }
        });





    }






    }


