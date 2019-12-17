package com.example.bankapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class intraTransferAct extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner to, from;
    EditText amt;
    int type;
    int type2;
    List<String> Acoounttype = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //for (int i=0; i<MainActivity.newuser.length;i++)

        Acoounttype.add("cheqing(with balance  " + MainActivity.newuser[MainActivity.userIndex].getCheckacc() + ")");
        Acoounttype.add("saving (with balance  " + MainActivity.newuser[MainActivity.userIndex].getAccbal() + ")");
        // Acoounttype.add("credit");

        setContentView(R.layout.activity_intra_transfer);
        to = findViewById(R.id.to);
        from = findViewById(R.id.From);
        amt = findViewById(R.id.amount);


        //create an adapter and fill it from the list
        ArrayAdapter<String> billAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Acoounttype);
        //make the drop down style
        billAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //fill the spinner with the adapter items
        to.setAdapter(billAdapter);
        to.setOnItemSelectedListener(this);
        from.setAdapter(billAdapter);
        from.setOnItemSelectedListener(this);
        this.setTitle("Transfer");

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

        if (item.getItemId() == R.id.signOut) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        if (adapterView.getId() == R.id.to) {

            type = getpositon(i);

        } else if (adapterView.getId() == R.id.From) {
            System.out.println("second spinner" + i);
            type2 = getpositon(i);
        }

    }

    private int getpositon(int i) {

        return i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void trans(View view) {

        int fromTrans;
        int toTrans;
        if (view.getId() == R.id.trans) {


            if (type == 1 && type2 == 1) {

                System.out.println("cannot transfer money within same type of account");


                Toast.makeText(getApplicationContext(), "cannot transfer money within same type of account", Toast.LENGTH_LONG).show();

            } else if (type == 0 && type2 == 0) {


                Toast.makeText(getApplicationContext(), "cannot transfer money within same type of account", Toast.LENGTH_LONG).show();

            } else if (type == 0 && type2 == 1) {

                int finalamt = 0;
                int finalamt2 = 0;

                fromTrans = MainActivity.newuser[MainActivity.userIndex].getCheckacc();
                toTrans = MainActivity.newuser[MainActivity.userIndex].getAccbal();

                System.out.println("from c to s");
                String hello = String.valueOf(amt.getText());

                if (hello.equals("")){

                    Toast.makeText(getApplicationContext(), "please enter amount ", Toast.LENGTH_LONG).show();

                }
                else {

                    int result = Integer.parseInt(hello);

                    if (result > fromTrans) {
                        Toast.makeText(getApplicationContext(), "not sufficent amount ", Toast.LENGTH_LONG).show();

                    } else {


                        finalamt = fromTrans - result;
                        finalamt2 = toTrans + result;
                        System.out.println(finalamt);
                        System.out.println(finalamt2);
                        MainActivity.newuser[MainActivity.userIndex].setAccbal(finalamt);
                        MainActivity.newuser[MainActivity.userIndex].setCheckacc(finalamt2);

                    }
                }

            } else if (type == 1 && type2 == 0) {
                int finalamt = 0;
                int finalamt2 = 0;

                fromTrans = MainActivity.newuser[MainActivity.userIndex].getAccbal();
                ;
                toTrans = MainActivity.newuser[MainActivity.userIndex].getCheckacc();
                System.out.println("from s to c");

                String hello = String.valueOf(amt.getText());


                if (hello.equals("")) {

                    Toast.makeText(getApplicationContext(), "please enter amount ", Toast.LENGTH_LONG).show();

                } else {


                    int result = Integer.parseInt(hello);


                    if (result > fromTrans) {

                        Toast.makeText(getApplicationContext(), "not sufficent amount ", Toast.LENGTH_LONG).show();

                    } else {


                        finalamt = fromTrans + result;
                        finalamt2 = toTrans - result;
                        System.out.println(finalamt);
                        System.out.println(finalamt2);
                        MainActivity.newuser[MainActivity.userIndex].setAccbal(finalamt);
                        MainActivity.newuser[MainActivity.userIndex].setCheckacc(finalamt2);
                    }
                }


            }


        }
    }

}
