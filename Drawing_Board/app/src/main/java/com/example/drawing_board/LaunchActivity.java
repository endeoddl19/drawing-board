package com.example.drawing_board;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class LaunchActivity extends AppCompatActivity {

    DatabaseReference DB;

    private static final int splash = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        Room baseroom = new Room();

        DB = FirebaseDatabase.getInstance().getReference("room");
        DB.setValue(baseroom);

        new Handler().postDelayed(()->{
                startActivity(new Intent(this, Menu.class));
                finish();
            },splash);
    }
}