package com.brunel.group30.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class SplashScreenActivity extends AppCompatActivity {
    private SharedPreferences pref; //int pref

    private final int SPLASH_DISPLAY_LENGTH = 5000; //Increased Splash Display  from 1 second to 5
private Boolean startup; //Int variable start up
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen); // Set view


        //If First start up show the Splash for 5 seconds, then WelcomeActivity then login else prompt login
         pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if(pref.getBoolean("activity_executed2", true)) {
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("activity_executed2", false);
                    editor.apply();
                    Intent mainIntent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            }, this.SPLASH_DISPLAY_LENGTH);
        }else {
            Intent mainIntent = new Intent(getApplicationContext(), WelcomeActivity.class);
            startActivity(mainIntent);
            finish();

        }



        //First time running

    }
}
