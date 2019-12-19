package com.example.minimo2dsa_19_12_2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() { // To do the splash
            @Override
            public void run() {
                Intent intent = new Intent(splash.this,Login.class);//We call the login activity in the context of the first one
                startActivity(intent);//Start
                finish();

            }
        },2000);//ms
    }
}
