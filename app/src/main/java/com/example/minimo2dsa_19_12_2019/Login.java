package com.example.minimo2dsa_19_12_2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {


    Button buttonlog;
    private EditText usernametb;
    private EditText passwordtb;
    private String user;
    private String password;

//    SharedPreferences userDetails =getSharedPreferences("userdetails", MODE_PRIVATE);
//    SharedPreferences.Editor edit = userDetails.edit();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonlog = findViewById(R.id.btnlogin);
        usernametb = findViewById(R.id.edittextUsername);
        passwordtb = findViewById(R.id.edittextPassword);

//        SharedPreferences userDetails = getSharedPreferences("userdetails", MODE_PRIVATE);
//
//        String Uname;
//        String pass;
//
//        Uname = userDetails.getString("username", "");
//        pass = userDetails.getString("password", "");
//        if((Uname.equals("user"))&&(pass.equals("dsamola"))) {
//            Intent intent = new Intent(Login.this,MainActivity.class);
//            startActivity(intent);//Start
//
//
//        }

        buttonlog.setOnClickListener(new View.OnClickListener() { //When we are login
            @Override
            public void onClick(View v) {
                user = usernametb.getText().toString();
                password = passwordtb.getText().toString();
                if((user.equals("user"))&&(password.equals("dsamola"))){
//                    edit.putString("username", user);
//                    edit.putString("password",password);
//                    edit.commit();
                    Intent intent = new Intent(Login.this,MainActivity.class);
                    startActivity(intent);//Start
                }
            }
        });
    }

}
