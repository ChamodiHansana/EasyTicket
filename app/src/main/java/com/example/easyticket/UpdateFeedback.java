package com.example.easyticket;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateFeedback extends AppCompatActivity {
    EditText txt1, txt2, txt3, txt4;
    Button btn1;
    DatabaseReference updatereff;
    AddFeedback feedback;
    String txt1_namein,txt2_phonein,txt3_emailin,txt4_messagein;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_feedback);

        txt1 = findViewById(R.id.textView25);
        txt2 = findViewById(R.id.textView34);
        txt3 = findViewById(R.id.textView36);
        txt4 = findViewById(R.id.textView39);
        btn1 = findViewById(R.id.button3);


        Intent i = getIntent();
        txt1_namein = i.getStringExtra("NAME");
        txt2_phonein = i.getStringExtra("PHONE");
        txt3_emailin = i.getStringExtra("EMAIL");
        txt4_messagein = i.getStringExtra("MESSAGE");

        txt1.setText(txt1_namein);
        txt2.setText(txt2_phonein);
        txt3.setText(txt3_emailin);
        txt4.setText(txt4_messagein);

        //updatefdb = new UpdateFeedback();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(txt3_emailin))
                    Toast.makeText(getApplicationContext(), "Check You Email", Toast.LENGTH_LONG).show();
                else
                {
                    updatereff = FirebaseDatabase.getInstance().getReference();
                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/email").setValue(txt3_emailin);
                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/name").setValue(txt1_namein);
                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/phoneNo").setValue(txt2_phonein);

                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/message").setValue(txt4_messagein);
                    Toast.makeText(getApplicationContext(), "Data update successfully..", Toast.LENGTH_SHORT).show();

                }
                if (TextUtils.isEmpty(txt1_namein))
                    Toast.makeText(getApplicationContext(), "Check You Name", Toast.LENGTH_LONG).show();
                else
                {
                    updatereff = FirebaseDatabase.getInstance().getReference();
                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/email").setValue(txt3_emailin);
                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/name").setValue(txt1_namein);
                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/phoneNo").setValue(txt2_phonein);

                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/message").setValue(txt4_messagein);
                    Toast.makeText(getApplicationContext(), "Data update successfully..", Toast.LENGTH_SHORT).show();

                }
                if (TextUtils.isEmpty(txt2_phonein))
                    Toast.makeText(getApplicationContext(), "Check You phone number", Toast.LENGTH_LONG).show();
                else
                {
                    updatereff = FirebaseDatabase.getInstance().getReference();
                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/email").setValue(txt3_emailin);
                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/name").setValue(txt1_namein);
                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/phoneNo").setValue(txt2_phonein);

                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/message").setValue(txt4_messagein);
                    Toast.makeText(getApplicationContext(), "Data update successfully..", Toast.LENGTH_SHORT).show();

                }
                if (TextUtils.isEmpty(txt4_messagein))
                    Toast.makeText(getApplicationContext(), "Check You message", Toast.LENGTH_LONG).show();
                else
                {
                    updatereff = FirebaseDatabase.getInstance().getReference();
                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/email").setValue(txt3_emailin);
                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/name").setValue(txt1_namein);
                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/phoneNo").setValue(txt2_phonein);

                    updatereff.child("easy-tickets-f6b2e/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/message").setValue(txt4_messagein);
                    Toast.makeText(getApplicationContext(), "Data update successfully..", Toast.LENGTH_SHORT).show();

                }

            }
        });

      /* btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DatabaseReference updatereff = FirebaseDatabase.getInstance().getReference().child("easy-tickets-f6b2e").child("feedback");
                updatereff = FirebaseDatabase.getInstance().getReference();

                updatereff.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if (TextUtils.isEmpty(txt3_emailin)) {
                            try {
                                   *//* feedback.setName(txt1.getText().toString().trim());
                                feedback.setPhoneNo(Integer.parseInt(txt2.getText().toString().trim()));
                                feedback.setEmail(txt3.getText().toString().trim());
                                feedback.setMessage(txt4.getText().toString().trim());*//*
                                updatereff.child("theater-management/feedback/feedback/-MIgfSLSS2hpvlmaBCm_/email").setValue(txt3_emailin);
                                //updatefdb = FirebaseDatabase.getInstance().getReference().child("easy-tickets-f6b2e").child("feedback");
                                //updatefdb.setValue(feedback);
                                Toast.makeText(getApplicationContext(), "Data update successfully..", Toast.LENGTH_SHORT).show();

                            } catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(), "Invalid contact number", Toast.LENGTH_SHORT).show();
                            }

                        } else
                            Toast.makeText(getApplicationContext(), "no source to update", Toast.LENGTH_SHORT).show();


                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                *//*new code
                if (TextUtils.isEmpty(txt1.getText().toString()))
                    Toast.makeText(getApplicationContext(),"Check your name",Toast.LENGTH_LONG).show();
                else{
                    updatereff = FirebaseDatabase.getInstance().getReference();
                    updatereff.child("AddFeedback/" +txt1.getText().toString().trim() + "/name").setValue(txt1.getText().toString().trim());
                    updatereff.child("AddFeedback/" +txt2.getText().toString().trim() + "/phoneNo").setValue(txt1.getText().toString().trim());
                    updatereff.child("AddFeedback/" +txt3.getText().toString().trim() + "/email").setValue(txt1.getText().toString().trim());
                    updatereff.child("AddFeedback/" +txt4.getText().toString().trim() + "/message").setValue(txt1.getText().toString().trim());

                    Toast.makeText(getApplicationContext(),"Successfully updated",Toast.LENGTH_LONG).show();

                }*//*

            }
        });*/
    }
}