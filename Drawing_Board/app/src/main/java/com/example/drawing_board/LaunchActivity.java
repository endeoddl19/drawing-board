package com.example.drawing_board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LaunchActivity extends AppCompatActivity {

    private static final int splash = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        new Handler().postDelayed(()->{
                startActivity(new Intent(this, Menu.class));
                finish();
            },splash);
    }
}