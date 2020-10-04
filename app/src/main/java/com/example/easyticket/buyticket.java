package com.example.easyticket;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class buyticket extends AppCompatActivity {
    TextView movieName;
    EditText date,theater,time;
    Button button29;
    DatabaseReference ref;
    MovieDetails moviedetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyticket);
        movieName = findViewById(R.id.textView);
        date = findViewById(R.id.editTextDate);
        time = findViewById(R.id.editTextTime);
        theater = findViewById(R.id.editTextTextPersonName);
        button29 = findViewById(R.id.button29);
        moviedetails = new MovieDetails();
        ref = FirebaseDatabase.getInstance().getReference().child("MovieDetails").child("mv2");
        button29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String fn=movieName.getText().toString();
              String ln=date.getText().toString();
              String fullname=time.getText().toString();
              String theater1=theater.getText().toString();

              if (fn.isEmpty() || ln.isEmpty() || fullname.isEmpty() || theater1.isEmpty() )
              {
                  Toast.makeText(buyticket.this,  "Please Complete", Toast.LENGTH_SHORT).show();
              }else {
                  DatabaseReference mref = ref;
                  mref.child("movie name").setValue(fn);
                  mref.child("date").setValue(ln);
                  mref.child("time").setValue(fullname);
                  mref.child("theater").setValue(theater1).addOnCompleteListener(new OnCompleteListener<Void>() {
                      @Override
                      public void onComplete(@NonNull Task<Void> task) {
                          if (task.isSuccessful()) {
                              Toast.makeText(buyticket.this, "ss", Toast.LENGTH_SHORT).show();
                          } else {
                              Toast.makeText(buyticket.this, "ff", Toast.LENGTH_SHORT).show();

                          }
                      }
                  });
              }

            }
        });






    }
}