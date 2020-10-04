package com.example.easyticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    EditText txtname,txtphone,txtusername,txtemail,txtpsw;
    Button SignUpB1;
    //TextView textView3;
    DatabaseReference reff;
    CustomerL Cusp1;
    lvalue lval;
    FirebaseDatabase database;
    String username;

    private void clearControl(){
        txtname.setText("");
        txtphone.setText("");
        txtusername.setText("");
        txtemail.setText("");
        txtpsw.setText("");
    }

    private Boolean validateName(){
        String val = txtname.getText().toString();
        if(val.isEmpty()){
            txtname.setError("Field cannot be empty");
            return false;
        }
        else{
            txtname.setError(null);
            return true;
        }
    }

    private Boolean validatePhone(){
        String val = txtphone.getText().toString();
        if(val.isEmpty()){
            txtphone.setError("Field cannot be empty");
            return false;
        }
        else{
            txtphone.setError(null);
            return true;
        }
    }

    private Boolean validateUsername(){
        String val = txtusername.getText().toString();
        if(val.isEmpty()){
            txtusername.setError("Field cannot be empty");
            return false;
        }
        else{
            txtusername.setError(null);
            return true;
        }
    }

    private Boolean validateEmail(){
        String val = txtemail.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty()){
            txtemail.setError("Field cannot be empty");
            return false;
        }
        else if (!val.matches(emailPattern)){
            txtemail.setError("Invalid email address");
            return false;
        }
        else{
            txtemail.setError(null);
            return true;
        }
    }

    private Boolean validatePassword(){
        String val = txtpsw.getText().toString();
        if(val.isEmpty()){
            txtpsw.setError("Field cannot be empty");
            return false;
        }
        else if(val.length() <= 6){
            txtpsw.setError("password is weak.");
            return false;
        }
        else{
            txtpsw.setError(null);
            return true;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        txtname = findViewById(R.id.txtname);
        txtphone = findViewById(R.id.txtphone);
        txtusername = findViewById(R.id.txtusername);
        txtemail = findViewById(R.id.txtemail);
        txtpsw = findViewById(R.id.txtpsw);
        SignUpB1 = findViewById(R.id.SignUpB1);
        // listview = findViewById(R.id.listview)

        Cusp1 = new CustomerL();
        lval = new lvalue();

        SignUpB1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                reff = FirebaseDatabase.getInstance().getReference().child("Theater-Management").child("Cup2");

                //old one*/

                if(!validateName() | !validatePhone() | !validateUsername() | !validateEmail() | !validatePassword()){
                    return;
                }
                try{
                    if(TextUtils.isEmpty(txtname.getText().toString())){
                        validateName();
                    }
                    else if(TextUtils.isEmpty(txtphone.getText().toString())){
                        validatePhone();
                    }
                    else if(TextUtils.isEmpty(txtusername.getText().toString())){
                        validateUsername();
                    }
                    else if(TextUtils.isEmpty(txtemail.getText().toString())){
                        validateEmail();
                    }
                    else if(TextUtils.isEmpty(txtpsw.getText().toString())){
                        validatePassword();
                    }
                    else{
                        Cusp1.setName(txtname.getText().toString().trim());
                        Cusp1.setMobilenumber(txtphone.getText().toString().trim());
                        Cusp1.setUsername(txtusername.getText().toString().trim());
                        Cusp1.setEmail(txtemail.getText().toString().trim());
                        Cusp1.setPassword(txtpsw.getText().toString().trim());
                        //reff.child(txtemail.getText().toString().trim()).setValue(Cusp1);
                        lval.setLvalue(lval.toString());

                        //reff.child(txtemail.getText().toString().trim()).setValue(Cusp1);
                        reff.child("Cusp2").push().setValue(Cusp1);
                        //reff.child(Cusp2).setValue(Cusp1);
                        //reff.child(Cusp2).push().setValue(no);

                        Toast.makeText(SignUp.this, "data inserted successfully",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(new Intent(SignUp.this, CustomerProfile.class ));
                        startActivity(i);

                        clearControl();
                    }
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "SignUp Unsuccessfull", Toast.LENGTH_SHORT).show();
                }


            }

        });



    }
}