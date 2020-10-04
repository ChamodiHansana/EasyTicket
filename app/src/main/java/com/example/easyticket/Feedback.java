package com.example.easyticket;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Feedback extends AppCompatActivity {

    EditText txtName,txtPhone,txtEmail,txtMessage;
    Button btnsee,btnsend;
    DatabaseReference reff;
    AddFeedback fdb;
    //ListView listView;

    private void clearControls(){
        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtMessage.setText("");
    }

    private Boolean validateName(){
        String val = txtName.getText().toString();
        if(val.isEmpty()){
            txtName.setError("Field cannot be empty");
            return false;
        }
        else{
            txtName.setError(null);
            return true;
        }
    }

    private Boolean validatePhone(){
        String val = txtPhone.getText().toString();
        if(val.isEmpty()){
            txtPhone.setError("Field cannot be empty");
            return false;
        }
        else{
            txtPhone.setError(null);
            return true;
        }
    }

    private Boolean validateEmail(){
        String val = txtEmail.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty()){
            txtEmail.setError("Field cannot be empty");
            return false;
        }
        else if (!val.matches(emailPattern)){
            txtEmail.setError("Invalid email address");
            return false;
        }
        else{
            txtEmail.setError(null);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        txtName = findViewById(R.id.inputTxt1);
        txtPhone = findViewById(R.id.inputTxt2);
        txtEmail = findViewById(R.id.inputTxt5);
        txtMessage = findViewById(R.id.textView7);

        btnsend = findViewById(R.id.formbtn2);
        btnsee = findViewById(R.id.formbtn);
        fdb = new AddFeedback();

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff = FirebaseDatabase.getInstance().getReference().child("easy-tickets-f6b2e").child("feedback");
                //validation
                try {
                    if (TextUtils.isEmpty(txtName.getText().toString())) {
                        txtName.setError("Name is required..");
                        return;
                    } else if (TextUtils.isEmpty(txtPhone.getText().toString())) {
                        txtName.setError("Phone is required..");
                        return;
                    } else if (TextUtils.isEmpty(txtEmail.getText().toString())) {
                        txtName.setError("Email is required..");
                        return;
                    } else if (TextUtils.isEmpty(txtMessage.getText().toString())) {
                        txtMessage.setError("Message is required..");
                        return;
                    } else {
                        fdb.setEmail(txtEmail.getText().toString().trim());
                        fdb.setName(txtName.getText().toString().trim());
                        fdb.setMessage(txtMessage.getText().toString().trim());
                        fdb.setPhoneNo(Integer.parseInt(txtPhone.getText().toString().trim()));
                        //reff.child(txtEmail.getText().toString().trim()).setValue(fdb);
                        //reff.push().setValue(fdb);
                        reff.child("feedback").push().setValue(fdb);


                        Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                        clearControls();


                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid contact number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnsee = (Button)findViewById(R.id.formbtn);
        btnsee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent (Feedback.this,ViewFeedback.class);

                startActivity(intent1);

            }
        });












    }
}


