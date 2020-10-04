package com.example.easyticket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class offers extends AppCompatActivity {

    TextView txt_offer;
    Button SeeOffers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);


        txt_offer = findViewById(R.id.txt_offer);
        //SeeOffers = findViewById(R.id.SeeOffers);

        DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("Theater-Management").child("offers/offer2");
        reff.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()){
                    txt_offer.setText(dataSnapshot.child("offerDecription").getValue().toString());
                }else{
                    Toast.makeText(getApplicationContext(), "No Source to display", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}