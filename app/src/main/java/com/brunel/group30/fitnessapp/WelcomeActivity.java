package com.brunel.group30.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    private Button startBtn;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if(pref.getBoolean("show_welcome", true)) {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("show_welcome", false);
                    editor.apply();
        }else {
            Intent mainIntent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(mainIntent);
            finish();
        }

        this.startBtn = (Button) findViewById(R.id.button_start);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}