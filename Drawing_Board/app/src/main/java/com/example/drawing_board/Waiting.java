package com.example.drawing_board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Waiting extends AppCompatActivity {

    private int curplayers,maxplayers;
    private TextView roomid, players;
    private String room_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        Intent intent = new Intent();
        intent.getIntExtra("playernum",1);
        intent.getIntExtra("maxplayers",4);
        room_id = intent.getStringExtra("roomid");

        roomid = findViewById(R.id.room_id_waiting);
        players = findViewById(R.id.players_waiting);

        roomid.setText(room_id);

    }
}