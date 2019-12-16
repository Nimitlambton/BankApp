package com.example.bankapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class payUtilityAct extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spin;
    TextView finalamt;
    List<String> bills = new ArrayList<>();
    Button btnpay;
    int amount;
    int deduct;
    int fromAcc;
    int value;
    ArrayList<String> paybills = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_utility);
        bills.add("Hydro");
        bills.add("Water");
        bills.add("Gas");
        bills.add("Phone");
        fromAcc = MainActivity.newuser[MainActivity.userIndex].getCheckacc();
        finalamt = findViewById(R.id.finalamt);
        btnpay = findViewById(R.id.payB);
        spin = findViewById(R.id.spinner);
        //create an adapter and fill it from the list
        ArrayAdapter<String> billAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,bills);
        //make the drop down style
        billAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //fill the spinner with the adapter items
        spin.setAdapter(billAdapter);
        spin.setOnItemSelectedListener(this);
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        //parimalSystem.out.println(position);


        if(position==0){
            finalamt.setText("Your Amount"+MainActivity.newuser[MainActivity.userIndex].getHyrdo());
            deduct = MainActivity.newuser[MainActivity.userIndex].getHyrdo();
            value =  getvalue(position);
            paybills.add("paid $" + MainActivity.newuser[MainActivity.userIndex].getHyrdo() + "for hydro");

        }else if(position == 1){
            finalamt.setText("Your Amount "+MainActivity.newuser[MainActivity.userIndex].getWater());
            deduct = MainActivity.newuser[MainActivity.userIndex].getWater();
            value =     getvalue(position);
            paybills.add("paid $" + MainActivity.newuser[MainActivity.userIndex].getWater() + "for water");
        }else if(position == 2){
            finalamt.setText("Your Amount "+MainActivity.newuser[MainActivity.userIndex].getGas());
            deduct = MainActivity.newuser[MainActivity.userIndex].getGas();
            value =     getvalue(position);
            paybills.add("paid $" + MainActivity.newuser[MainActivity.userIndex].getGas() + "for Gas");
        }else if(position == 3){
            finalamt.setText("Your Amount "+MainActivity.newuser[MainActivity.userIndex].getPhonebill());
            deduct = MainActivity.newuser[MainActivity.userIndex].getPhonebill();
            value =     getvalue(position);
            paybills.add("paid $" + MainActivity.newuser[MainActivity.userIndex].getPhonebill() + "for PhoneBill");
        }

    }


    public int    getvalue(int v){

        return v;

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        finalamt.setText("Select any utility");
    }

    public void pay(View view) {
       if (view.getId()  == R.id.payB){

           amount = fromAcc-deduct;
           deduct = MainActivity.newuser[MainActivity.userIndex].getHyrdo();

           MainActivity.newuser[MainActivity.userIndex].setCheckacc(amount);

           System.out.println(value+"idrsecghdtdh");
           if(value == 0 ){
               System.out.println(value+"idrse");
               MainActivity.newuser[MainActivity.userIndex].setHyrdo(0);
               finalamt.setText(""+MainActivity.newuser[MainActivity.userIndex].getHyrdo());
              Toast.makeText(this, "Paid Hydro Bill Successfully", Toast.LENGTH_SHORT).show();
           }else if(value == 1 ){
               System.out.println(value+"idrse");
               MainActivity.newuser[MainActivity.userIndex].setWater(0);
               finalamt.setText(""+MainActivity.newuser[MainActivity.userIndex].getWater());
               Toast.makeText(this, "Paid water Bill Successfully", Toast.LENGTH_SHORT).show();
           }else if(value == 2 ){
               System.out.println(value+"idrse");
               MainActivity.newuser[MainActivity.userIndex].setGas(0);
               finalamt.setText(""+MainActivity.newuser[MainActivity.userIndex].getGas());
               Toast.makeText(this, "Paid Gas Bill Successfully", Toast.LENGTH_SHORT).show();
           }else if(value == 3 ){
               System.out.println(value+"idrse");
               MainActivity.newuser[MainActivity.userIndex].setPhonebill(0);
               finalamt.setText(""+MainActivity.newuser[MainActivity.userIndex].getPhonebill());
               Toast.makeText(this, "Paid Phone Bill Successfully", Toast.LENGTH_SHORT).show();
           }


       }
    }
}