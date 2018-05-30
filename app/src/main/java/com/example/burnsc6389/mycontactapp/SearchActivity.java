package com.example.burnsc6389.mycontactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //Get the intent that initiated this activity
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //*
        //Intent intent2 = getIntent();
        //String message2 = intent2.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Intent intent3 = getIntent();
        //String message3 = intent3.getStringExtra(MainActivity.EXTRA_MESSAGE);


        //Capture the layout's textView and set the string as the text
        TextView textView = findViewById(R.id.textView2);
        textView.setText(message);

        //TextView textView2 = findViewById(R.id.textView3);
        //textView2.setText(message2);

        //TextView textView3 = findViewById(R.id.textView4);
        //textView3.setText(message3);
    }
}
