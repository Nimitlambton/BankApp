package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {


   TextView welcomeBanner,tv;
   Integer currentuser,value;
    EditText tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeBanner = findViewById(R.id.welcomeBanner);
        welcomeBanner.setText("Welcome"+MainActivity.customername);
        tv = findViewById(R.id.tv);



        currentuser = MainActivity.userIndex;



        tv.setText("your account balance"+MainActivity.newuser[currentuser].getAccbal());



    }


}
