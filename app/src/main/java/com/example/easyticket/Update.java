package com.example.easyticket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Update extends AppCompatActivity {

    DatabaseReference updatereff;
    DatabaseReference reff;
    EditText txt1,txt2,txt3,txt4,txt5,txt6;
    Button Edit,delete,button4,delete_btn;
    Customer Cusp2;
    String txt1_namein,txt2_phonein,txt3_usernamein,txt4_emailin,txt5_passwordin,txt6_username;

    private void clearControl(){
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);


        txt1 = findViewById(R.id.rName);
        txt2 = findViewById(R.id.rPhone);
        txt3 = findViewById(R.id.rUsername);
        txt4 = findViewById(R.id.rEmail);
        txt5 = findViewById(R.id.rPassword);
        txt6 = findViewById(R.id.textView4);

        Edit= findViewById(R.id.button4);

        Intent i = getIntent();
        txt1_namein = i.getStringExtra("name");
        txt2_phonein = i.getStringExtra("mobilenumber");
        txt3_usernamein = i.getStringExtra("username");
        txt4_emailin = i.getStringExtra("email");
        txt5_passwordin = i.getStringExtra("password");
        txt3_usernamein = i.getStringExtra("username");

        txt1.setText(txt1_namein);
        txt2.setText(txt2_phonein);
        txt3.setText(txt3_usernamein);
        txt4.setText(txt4_emailin);
        txt5.setText(txt5_passwordin);
        txt6.setText(txt3_usernamein);

        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(txt4_emailin)){
                    Toast.makeText(getApplicationContext(),"Check your email",Toast.LENGTH_LONG).show();
                }else{
                    updatereff = FirebaseDatabase.getInstance().getReference();

                    updatereff.child("Cup2/Cusp2/-MIiAZXXqyhxvb-ayehA/email").setValue(txt4_emailin);
                    Toast.makeText(getApplicationContext(),"Data update Successfully",Toast.LENGTH_LONG).show();
                }
                if (TextUtils.isEmpty(txt1_namein)){
                    Toast.makeText(getApplicationContext(),"Check your name",Toast.LENGTH_LONG).show();
                }else{
                    updatereff = FirebaseDatabase.getInstance().getReference();

                    updatereff.child("Cup2/Cusp2/-MIiAZXXqyhxvb-ayehA/name").setValue(txt1_namein);
                    Toast.makeText(getApplicationContext(),"Data update Successfully",Toast.LENGTH_LONG).show();
                }
                if (TextUtils.isEmpty(txt2_phonein)){
                    Toast.makeText(getApplicationContext(),"Check your phone number",Toast.LENGTH_LONG).show();
                }else{
                    updatereff = FirebaseDatabase.getInstance().getReference();

                    updatereff.child("Cup2/Cusp2/-MIiAZXXqyhxvb-ayehA/mobilenumber").setValue(txt2_phonein);
                    Toast.makeText(getApplicationContext(),"Data update Successfully",Toast.LENGTH_LONG).show();
                }
                if (TextUtils.isEmpty(txt3_usernamein)){
                    Toast.makeText(getApplicationContext(),"Check your username",Toast.LENGTH_LONG).show();
                }else{
                    updatereff = FirebaseDatabase.getInstance().getReference();

                    updatereff.child("Cup2/Cusp2/-MIiAZXXqyhxvb-ayehA/username").setValue(txt3_usernamein);
                    Toast.makeText(getApplicationContext(),"Data update Successfully",Toast.LENGTH_LONG).show();
                }
                if (TextUtils.isEmpty(txt5_passwordin)){
                    Toast.makeText(getApplicationContext(),"Check your password",Toast.LENGTH_LONG).show();
                }else{
                    updatereff = FirebaseDatabase.getInstance().getReference();

                    updatereff.child("Cup2/Cusp2/-MIiAZXXqyhxvb-ayehA/password").setValue(txt5_passwordin);
                    Toast.makeText(getApplicationContext(),"Data update Successfully",Toast.LENGTH_LONG).show();
                }


            }
        });

        /*DatabaseReference updatereff =FirebaseDatabase.getInstance().getReference().child("Cup2/Cusp2/-MIiAZXXqyhxvb-ayehA");
        updatereff.addListenerForSingleValueEvent(new V);*/
       delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(txt4.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Check your name",Toast.LENGTH_SHORT).show();
                }
                else {
                    updatereff = FirebaseDatabase.getInstance().getReference("Cup2/Cusp2/-MIiAZXXqyhxvb-ayehA");
                    updatereff.removeValue();
                    Toast.makeText(getApplicationContext(),"successfully deleted",Toast.LENGTH_LONG).show();
                    clearControl();
                }
            }
        });

    }
}