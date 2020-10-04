package com.example.easyticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ticket<a, c> extends AppCompatActivity {


    EditText  editTexttotal,editTextFull,editTextHalf;
    Button btnnext;
    DatabaseReference dbRef;
    TicketDetails tkt;

    private void clearControls() {

        editTexttotal.setText("");
        editTextFull.setText("");
        editTextHalf.setText("");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);





        editTextFull=findViewById(R.id.editTextFull);
        editTextHalf=findViewById(R.id.editTextHalf);
        editTexttotal = findViewById(R.id.editTexttotal);

        btnnext = findViewById(R.id.btnnext);

        TextWatcher textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!editTextFull.getText().toString().equals("") && !editTextHalf.getText().toString().equals("")){
                    int temp1=Integer.parseInt(editTextFull.getText().toString().trim());
                    int temp2=Integer.parseInt(editTextHalf.getText().toString().trim());
                    editTexttotal.setText(String.valueOf(temp1+temp2));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        editTextFull.addTextChangedListener(textWatcher);
        editTextHalf.addTextChangedListener(textWatcher);



        //tkt = new TicketDetails();

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tkt = new TicketDetails();
                dbRef = FirebaseDatabase.getInstance().getReference().child("TicketDetails");
                try {
                    if (TextUtils.isEmpty(editTextFull.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Number of full tickets", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextHalf.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Number of half tickets", Toast.LENGTH_SHORT).show();

                    else {

                        tkt.setFull(Integer.parseInt(editTextFull.getText().toString().trim()));
                        tkt.setHalf(Integer.parseInt(editTextHalf.getText().toString().trim()));
                        tkt.setTotal(Integer.parseInt(editTexttotal.getText().toString().trim()));

                        int a = Integer.parseInt(editTextFull.getText().toString());
                        int b = Integer.parseInt(editTextHalf.getText().toString());
                        int c ;

                        c=a*500+b*250;

                        tkt.setCost(c);

                        //dbRef.push().setValue(tkt);
                        //String StudentRecordIDFromServer = dbRef.push().getKey();
                        dbRef.child("tkt1").setValue(tkt);
                        //dbRef.child(StudentRecordIDFromServer).setValue(tkt);

                        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(new Intent(ticket.this, booking.class));
                        startActivity(i);


                        clearControls();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Data saved unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}