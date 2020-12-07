package com.example.obatind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashSreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sreen);

        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(2000); //2 detik
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashSreen.this, MainActivity.class);
                    startActivity(intent);

                    finish();
                }
            }
        };
        thread.start();
    }
}