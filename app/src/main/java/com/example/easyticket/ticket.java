package com.example.easyticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ticket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        Spinner spinner=(Spinner)findViewById(R.id.spinner);

        List<String> categories=new ArrayList<String>();
        categories.add("1");
        categories.add("2");


    }
}