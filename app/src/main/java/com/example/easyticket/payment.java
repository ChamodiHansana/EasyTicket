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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class payment extends AppCompatActivity {

    EditText editTextamount, editTextccode, editTextcname, editTextcnumber, editTextDate, editTextpass;
    Button btnpay;
    DatabaseReference dbRef;
    PaymentDetails pd;

    private void clearControls() {
        editTextamount.setText("");
        editTextccode.setText("");
        editTextcname.setText("");
        editTextcnumber.setText("");
        editTextDate.setText("");
        editTextpass.setText("");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        editTextamount = findViewById(R.id.editTextamount);
        editTextccode = findViewById(R.id.editTextccode);
        editTextcname = findViewById(R.id.editTextcname);
        editTextcnumber = findViewById(R.id.editTextcnumber);
        editTextDate = findViewById(R.id.editTextDate);
        editTextpass = findViewById(R.id.editTextpass);

        btnpay = findViewById(R.id.btnpay);

        pd = new PaymentDetails();

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("TicketDetails").child("tkt1");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.hasChildren()) {

                    editTextamount.setText(dataSnapshot.child("cost").getValue().toString());

                } else
                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("PaymentDetails");
                try {
                    if (TextUtils.isEmpty(editTextamount.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Amount", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextccode.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter coupon code", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextcname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter card name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextcnumber.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter card number", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextDate.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please select date", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextpass.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter cvv", Toast.LENGTH_SHORT).show();

                    else {

                        pd.setAmount(editTextamount.getText().toString().trim());
                        pd.setCouponCode(editTextccode.getText().toString().trim());
                        pd.setCardname(editTextcname.getText().toString().trim());
                        pd.setCardnum(editTextcnumber.getText().toString().trim());
                        pd.setExDate(editTextDate.getText().toString().trim());
                        pd.setPasscode(editTextpass.getText().toString().trim());


                        //dbRef.push().setValue(std);
                        dbRef.child("pd1").setValue(pd);

                        Toast.makeText(getApplicationContext(), "Payed success", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(new Intent(payment.this, deletepayment.class));
                        startActivity(i);


                        clearControls();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Payed unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}