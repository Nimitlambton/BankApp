package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class    allAccounts extends AppCompatActivity {


    TextView showbal1,showbal2,showbal3;
    Integer currentuser;

    ListView listv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_accounts);


        showbal1 = findViewById(R.id.checkbal);
        showbal2 = findViewById(R.id.savingBal);
        showbal3 = findViewById(R.id.CreditBal);

        currentuser = MainActivity.userIndex;

        showbal1.setText(""+MainActivity.newuser[currentuser].getCheckacc());

        showbal2.setText(""+MainActivity.newuser[currentuser].getAccbal());

        showbal3.setText(""+MainActivity.newuser[currentuser].getcCbalance());

        listv = findViewById(R.id.listView);

        this.setTitle("All Accounts");

        
    }
}
