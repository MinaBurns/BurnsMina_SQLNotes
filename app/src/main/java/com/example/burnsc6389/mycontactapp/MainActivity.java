package com.example.burnsc6389.mycontactapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
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

    public void viewData(View view){
        Cursor res = myDb.getAllData();
        Log.d("MyContactApp", "MainActivty: viewData: received cursor " + res.getCount());
        if(res.getCount()==0){
            showMessage("Error", "No data found in database");
        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
           buffer.append(res.getString(0)+ "\n" + res.getString(1)+ "\n" + res.getString(2)+ "\n" + res.getString(3)+"\n");
            //Append res column 0,1,2,3 to buffer 4 lines appending each column, delimited by "\n"
        }
        Log.d("MyContactApp", "MainActivty: viewData: assembled stringbuffer");
        showMessage("Data", buffer.toString());

    }

    public void showMessage(String title, String message) {
        Log.d("MyContactApp", "MainActivty: showMessage: building alert dialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
