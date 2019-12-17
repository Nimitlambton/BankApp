package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class TransferAct extends AppCompatActivity {


    Button  transferIntra, transferOtherAcc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_transfer);

    transferIntra = findViewById(R.id.intra);
    transferOtherAcc = findViewById(R.id.external);

        this.setTitle("Select Transfer");

    }


    public void Selecttype(View view) {


        switch (view.getId()) {

            case R.id.intra:


                Intent intra = new Intent(getApplicationContext(), intraTransferAct.class);
                startActivity(intra);
                break;

            case R.id.external:

                Intent extra = new Intent(getApplicationContext(), extranalTransferAct.class);
                startActivity(extra);
                break;
        }



    }
}
