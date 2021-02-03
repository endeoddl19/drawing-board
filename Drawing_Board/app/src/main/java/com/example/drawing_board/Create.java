package com.example.drawing_board;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class Create extends AppCompatActivity {

    private EditText roomname_et,roompwd_et;
    private Button four,five,six,seven,create;
    DatabaseReference DB;

    protected String roomname,roompwd,roomid,players;
    protected int curplayers,maxplayers;
    protected boolean key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        roomname_et = findViewById(R.id.roomname_et);
        roompwd_et = findViewById(R.id.roompwd_et);
        four = findViewById(R.id.four_btn);
        five = findViewById(R.id.five_btn);
        six = findViewById(R.id.six_btn);
        seven = findViewById(R.id.seven_btn);
        create = findViewById(R.id.create_btn);

        DB = FirebaseDatabase.getInstance().getReference("room");

        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                roomname = roomname_et.getText().toString();
                roompwd = roompwd_et.getText().toString();
                if(roomname ==null&&maxplayers==0){
                    Toast.makeText(getApplicationContext(),"정보가 충분하지 않습니다", Toast.LENGTH_LONG).show();
                }
                int random = (int)(Math.random()*1000);
                roomid = Integer.toString(random);
                if(roompwd != null) {key=true;}
                curplayers=1;
                players = (curplayers + " / " + maxplayers);

                Room newroom = new Room(roomid,roomname,curplayers,maxplayers,players,key,roompwd);
                DB.child(roomid).setValue(newroom);

                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);
            }
        });
    }

    public void selectPlayers(View view){
        if(view == four){
            maxplayers = 4;
            view.setBackgroundColor(Color.parseColor("#AA1ABD"));
            five.setBackgroundColor(Color.parseColor("#3d65d3"));
            six.setBackgroundColor(Color.parseColor("#3d65d3"));
            seven.setBackgroundColor(Color.parseColor("#3d65d3"));
        }
        else if(view == five){
            maxplayers = 5;
            view.setBackgroundColor(Color.parseColor("#AA1ABD"));
            six.setBackgroundColor(Color.parseColor("#3d65d3"));
            four.setBackgroundColor(Color.parseColor("#3d65d3"));
            seven.setBackgroundColor(Color.parseColor("#3d65d3"));
        }
        else if(view == six){
            maxplayers = 6;
            view.setBackgroundColor(Color.parseColor("#AA1ABD"));
            five.setBackgroundColor(Color.parseColor("#3d65d3"));
            four.setBackgroundColor(Color.parseColor("#3d65d3"));
            seven.setBackgroundColor(Color.parseColor("#3d65d3"));
        }
        else if(view == seven){
            maxplayers = 7;
            view.setBackgroundColor(Color.parseColor("#AA1ABD"));
            five.setBackgroundColor(Color.parseColor("#3d65d3"));
            six.setBackgroundColor(Color.parseColor("#3d65d3"));
            four.setBackgroundColor(Color.parseColor("#3d65d3"));
        }
    }
}