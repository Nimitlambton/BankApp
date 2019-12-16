package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static Users newuser[] = new Users[3];

  

    Button login , load;
    EditText userName, password;
    TextView counterView;
    public static  String customername;
    public static  Integer customerbalance;
    public static int userIndex;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterView = findViewById(R.id.counterView);
        login = findViewById(R.id.loginBtn);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        counterView.setText("Numbers of turns left = " + Integer.toString(counter));

        //newuser[0] = new Users(18, 18445,0,1200,    2000,500,300,70,50,40,55,"Nimit96", "2901 kipligavenue", "Nimit","hello");
        //newuser[1] = new Users(23, 18445,1,1400, 3000,600,500,80,40,30,45,"parimal97", "2901 kipligavenue", "Parimal","hello2");
        //newuser[2] = new Users(22, 18445,2,1600,4000,700,300,55,90,88,105,"geeta93", "2901 kipligavenue", "Geeta","hello3");


    }




    public  void loginIn(View view) {



        String userEntry = userName.getText().toString(); //username sent
        String passEntry = password.getText().toString(); //password sent
        int userid = searchUser(newuser, userEntry, passEntry);

        System.out.println(userid);

        if (userid == -1) {

            Toast.makeText(getApplicationContext(), "INVALID USERNAME OR PASSWORD", Toast.LENGTH_LONG).show();

        } else {
            int i = userdetails(newuser,userid);
            userIndex=i;
            customername  = newuser[userIndex].getName();
            customerbalance  = newuser[userIndex].getAccbal();
            Toast.makeText(getApplicationContext(), "GOOD MORNING", Toast.LENGTH_LONG).show();
            Intent loggedIn = new Intent(getApplicationContext(), SelectAcc.class);
            startActivity(loggedIn);

        }
    }


    public  int  searchUser(Users newuser[], String user, String password) {

        int id;

        for (int i = 0; i < newuser.length; i++)

            if (user.equals(newuser[i].getUserName()) && password.equals(newuser[i].getPassword())) {
                MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.morning);
                mediaPlayer.start();
                id = newuser[i].getUserId();
                return id;
            }
        counter--;
        counterView.setText("Numbers of turns left = " + Integer.toString(counter));
            if(counter == 0){
                Toast.makeText(this, "PLEASE RE RUN THE APP", Toast.LENGTH_SHORT).show();
                login.setEnabled(false);
            }
        return -1;
    }


    public  static int userdetails(Users newuser[],int id){
        for(int i=0;i<newuser.length;i++)
            if(newuser[i].getUserId() == id)
             return id;
             return -1;
            }


    public void load(View view) {

        newuser[0] = new Users(18, 18445,0,1200,    2000,500,300,70,50,40,55,"Nimit96", "2901 kipligavenue", "Nimit","hello","pamnainimit16@gmail.com");
        newuser[1] = new Users(23, 18445,1,1400, 3000,600,500,80,40,30,45,"parimal97", "2901 kipligavenue", "Parimal","hello2","parimalpatel029@gmail.com");
        newuser[2] = new Users(22, 18445,2,1600,4000,700,300,55,90,88,105,"geeta93", "2901 kipligavenue", "Geeta","hello3","geetaarora9612gmail.com");

    }
}







