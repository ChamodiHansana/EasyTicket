package com.example.easyticket;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Theater_Add extends AppCompatActivity{
    public Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theaters_add);

        button1 = (Button)findViewById(R.id.btn2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent (Theater_Add.this,MoreInfo.class);

                startActivity(intent1);

            }
        });

        button2 = (Button)findViewById(R.id.btn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent2 = new Intent (Theater_Add.this,MoreInfo1.class);

                startActivity(intent2);

            }
        });

        button3 = (Button)findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent3 = new Intent (Theater_Add.this,MoreInfo2.class);

                startActivity(intent3);

            }
        });



    }

}
