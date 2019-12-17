package com.example.bankapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectAcc extends AppCompatActivity {


    Button saving,checking,transfer,paybills;
    TextView welcomebanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_acc);


        
        checking = findViewById(R.id.accounts);
        transfer = findViewById(R.id.transfer);
        paybills = findViewById(R.id.payBills);

        welcomebanner = findViewById(R.id.welcomeBanner);

        welcomebanner.setText("HI "+MainActivity.customername+" please select one of the following");
        this.setTitle("Select");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_file, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);

         if(item.getItemId() == R.id.signOut){
             Intent intent = new Intent(getApplicationContext(), MainActivity.class);
             startActivity(intent);
             return true;
         }
         return false;
    }

    public void selectAcc(View view) {

         String type = "SelectAcc";

         switch (view.getId()){

           case R.id.accounts:
               type = "allaccounts";
               System.out.println(type);
               Intent loggedIn = new Intent(getApplicationContext(), allAccounts.class);
               startActivity(loggedIn);
                break;
                

             case R.id.transfer:
                 type = "transfer";
                 System.out.println(type);

                 Intent transfer = new Intent(getApplicationContext(), TransferAct.class);
                 startActivity(transfer);
                 break;

             case R.id.payBills :
                 type = "payBills"  ;
                 System.out.println("type");
                 Intent toPayBills = new Intent(getApplicationContext(), payUtilityAct.class);
                 startActivity(toPayBills);
                 break;


    }


       

    }
}

