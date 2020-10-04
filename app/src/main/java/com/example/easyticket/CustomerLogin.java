package com.example.easyticket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class CustomerLogin extends AppCompatActivity {

    EditText editPassword,editUsername;
    Button login_btn;
    DatabaseReference reff;
    Customer Cusp1;
    DatabaseReference nreff;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        login_btn = findViewById(R.id.login_btn);
        fAuth = FirebaseAuth.getInstance();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                if (TextUtils.isEmpty(username)){
                    editUsername.setError("User name is Required.");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    editPassword.setError("Password is Required.");
                    return;
                }

                //Authenticate the user
                fAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(CustomerLogin.this,"Logged in successfully.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),CustomerProfile.class));
                        }else{
                            Toast.makeText(CustomerLogin.this,"Error..!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    public void callLoginScreen(View viev){

    }
    }
