package com.example.calculator.activites;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.calculator.R;


public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(Splash.this,MainPage.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        thread.start();
    }
    }

