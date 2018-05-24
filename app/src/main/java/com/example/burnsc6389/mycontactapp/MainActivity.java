package com.example.burnsc6389.mycontactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   DatabaseHelper myDb;
   EditText editName;
   EditText editNumber;
   EditText editAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editText_name);
        editNumber = findViewById(R.id.editText_phone);
        editAddress = findViewById(R.id.editText_address);

        myDb = new DatabaseHelper( this);
        Log.d("MyContactApp", "Databasehelper: instantiated DatabaseHelper");
    }

    public void addData(View view){
        Log.d("MyContactApp", "MainActivty: Add contact button pressed");
        boolean isInserted = myDb.insertData(editName.getText().toString(), editNumber.getText().toString(), editAddress.getText().toString());

        if(isInserted == true){
            Toast.makeText(MainActivity.this, "Success - contact inserted", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this, "Failed - contact not inserted", Toast.LENGTH_LONG).show();
        }
    }
}
