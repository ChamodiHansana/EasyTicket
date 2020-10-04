package com.example.easyticket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CustomerProfile extends AppCompatActivity {

    EditText txt1,txt2,txt3,txt4,txt5,txt6;
    Button Edit_btn,Signout;
    String txt1_name, txt2_phone,txt3_email,txt4_username,txt5_password;
    DatabaseReference reff;
    //Customer Cusp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        txt1 = findViewById(R.id.rName);
        txt2 = findViewById(R.id.rPhone);
        txt3 = findViewById(R.id.rUsername);
        txt4 = findViewById(R.id.rEmail);
        txt5=  findViewById(R.id.rPassword);
        txt6 = findViewById(R.id.textView4);

        Edit_btn = findViewById(R.id.Edit_btn);
        Signout = findViewById(R.id.Signout_btn);

        //old one
        DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("Theater-Management").child("Cup2").child("Cusp2").child("-MIiAZXXqyhxvb-ayehA");
        reff.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    txt1.setText(dataSnapshot.child("name").getValue().toString());
                    txt2.setText(dataSnapshot.child("mobilenumber").getValue().toString());
                    txt3.setText(dataSnapshot.child("username").getValue().toString());
                    txt4.setText(dataSnapshot.child("email").getValue().toString());
                    txt5.setText(dataSnapshot.child("password").getValue().toString());
                    txt6.setText(dataSnapshot.child("username").getValue().toString());
                }
                else{
                    Toast.makeText(getApplicationContext(), "No Source to display", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
        Edit_btn = (Button)findViewById(R.id.Edit_btn);
        Edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {

                Intent intent1 = new Intent(CustomerProfile.this, Update.class );
                txt1_name = txt1.getText().toString();
                txt2_phone = txt2.getText().toString();
                txt4_username = txt3.getText().toString();
                txt3_email = txt4.getText().toString();
                txt5_password = txt1.getText().toString();

                intent1.putExtra("name",txt1_name);
                intent1.putExtra("mobilenumber",txt2_phone);
                intent1.putExtra("username",txt4_username);
                intent1.putExtra("email",txt3_email);
                intent1.putExtra("password",txt5_password);
                startActivity(intent1);

            }
        });

    }
}