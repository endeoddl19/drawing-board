package com.example.drawing_board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class Waiting extends AppCompatActivity {

    private int curplayers,maxplayers;
    private TextView roomid, players_tv;
    private String room_id,players_st;
    DatabaseReference DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        Intent intent = new Intent(); // Create / Menu 에서 받아올 정보들
        intent.getIntExtra("playernum",1);
        intent.getIntExtra("maxplayers",4);
        room_id = intent.getStringExtra("roomid");

        roomid = findViewById(R.id.room_id_waiting);
        players_tv = findViewById(R.id.players_waiting);

        players_st = (curplayers+" / "+maxplayers);

        roomid.setText(room_id);
        players_tv.setText(players_st);

    }
}