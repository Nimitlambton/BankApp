package com.example.bankapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class extranalTransferAct extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Button transfer;
    Spinner type;
    EditText amt , acNo;
    TextView balance;
    int a = MainActivity.newuser[MainActivity.userIndex].getCheckacc();
    int b = MainActivity.newuser[MainActivity.userIndex].getAccbal();
    String email = MainActivity.newuser[MainActivity.userIndex].getEmail();
    int position1;
    int type0;
    int type1;
    int userAccInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extranal_transfer);

        type = findViewById(R.id.acTypeSpin);
        balance = findViewById(R.id.bal);
        transfer = findViewById(R.id.transfer);
        acNo = findViewById(R.id.acNo);
        amt = findViewById(R.id.amt);


        List<String> accounts = new ArrayList<>();
        accounts.add("cheqing(with balance  "+ MainActivity.newuser[MainActivity.userIndex].getCheckacc()+")");
        accounts.add("saving (with balance  "+ MainActivity.newuser[MainActivity.userIndex].getAccbal()+")");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,accounts);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        type.setAdapter(arrayAdapter);
        type.setOnItemSelectedListener(this);
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

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        if (adapterView.getId() == R.id.acTypeSpin){

            type0 = getpositon(i);
        }

    }
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    private int getpositon(int i) {

        return i;
    }


    public void TransferFunc(View view) {

        if (type0 == 0) {


            String userAccountno  =  String.valueOf(acNo.getText());
            userAccInt = !userAccountno.equals("")?Integer.parseInt(userAccountno):-1;   ;
            String userAccountamt  =  String.valueOf(amt.getText());


            if (userAccInt >= 0 && userAccInt< MainActivity.newuser.length  )
            {

                int userAmtInt = Integer.parseInt(userAccountamt);

                int toAmountTransfer = MainActivity.newuser[userAccInt].getAccbal();

                if(userAmtInt > toAmountTransfer){

                    Toast.makeText(getApplicationContext(), "not sufficent amount ", Toast.LENGTH_LONG).show();

                }
                else {

                    toAmountTransfer = MainActivity.newuser[userAccInt].getAccbal();
                    int toaddamount = toAmountTransfer + userAmtInt;
                    int deduct = a - userAmtInt;
                    System.out.println(toaddamount);
                    System.out.println(deduct);
                    MainActivity.newuser[MainActivity.userIndex].setCheckacc(deduct);
                    MainActivity.newuser[userAccInt].setAccbal(toaddamount);
                    Toast.makeText(getApplicationContext(), "succesfully tranferred", Toast.LENGTH_LONG).show();

                }
            }else{

                Toast.makeText(this, "Wrong account number", Toast.LENGTH_SHORT).show();

            }

            if (userAccountamt.equals("") )

            { Toast.makeText(getApplicationContext(), "please enter amount", Toast.LENGTH_LONG).show();
            }
        }

        else {

            String userAccountno = String.valueOf(acNo.getText());
            userAccInt = !userAccountno.equals("") ? Integer.parseInt(userAccountno) : -1;
            String userAccountamt = String.valueOf(amt.getText());

             if(userAccInt >= 0 && userAccInt< MainActivity.newuser.length){

                 int userAmtInt = Integer.parseInt(userAccountamt);
                 int toAmountTransfer = MainActivity.newuser[userAccInt].getAccbal();
                 if(userAmtInt > toAmountTransfer) {
                     Toast.makeText(getApplicationContext(), "not sufficent amount ", Toast.LENGTH_LONG).show();
                     }
                 else {


                     int toaddamount = toAmountTransfer + userAmtInt;
                     int deduct = b - userAmtInt;
                     System.out.println(toaddamount);
                     System.out.println(deduct);
                     MainActivity.newuser[MainActivity.userIndex].setCheckacc(deduct);
                     MainActivity.newuser[userAccInt].setAccbal(toaddamount);
                     Toast.makeText(getApplicationContext(), "succesfully tranferred", Toast.LENGTH_LONG).show();
                     String email = MainActivity.newuser[userAccInt].getEmail();
                     JavaMailApi javaMailApi = new JavaMailApi(this,email,"Transaction alert","test");
                     javaMailApi.execute();

                 }
             }
             else{

                 Toast.makeText(this, "Wrong account number", Toast.LENGTH_SHORT).show();

             }

            if (userAccountamt.equals("") )

            { Toast.makeText(getApplicationContext(), "please enter amount", Toast.LENGTH_LONG).show();
            }


        }





    }

}
