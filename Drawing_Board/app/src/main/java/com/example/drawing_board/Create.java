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

import java.util.Iterator;
import java.util.Random;

public class Create extends AppCompatActivity {

    private EditText roomname_et,roompwd_et;
    private Button four,five,six,seven,create,back_create;
    DatabaseReference DB;

    protected String roomname,roompwd,roomid,players;
    protected int curplayers,maxplayers=0;
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
        back_create = findViewById(R.id.back_create);

        DB = FirebaseDatabase.getInstance().getReference("room");

        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                roomname = roomname_et.getText().toString();
                roompwd = roompwd_et.getText().toString();
                if(roomname.equals("") || maxplayers == 0){
                    Toast.makeText(getApplicationContext(),"정보가 충분하지 않습니다", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), Create.class);
                    startActivity(intent);
                }
                else {
                    int random = (int) (Math.random() * 1000);
                    roomid = Integer.toString(random);
                    check(roomid);
                    if (!roompwd.equals("")) {
                        key = true;
                    }
                    curplayers = 1;
                    players = (curplayers + " / " + maxplayers);

                    Room newroom = new Room(roomid, roomname, curplayers, maxplayers, players, key, roompwd);
                    DB.child(roomid).setValue(newroom);

                    Intent intent = new Intent(getApplicationContext(), Menu.class);
                    intent.putExtra("playernum",1);
                    intent.putExtra("maxplayers",maxplayers);
                    intent.putExtra("roomid",roomid);
                    startActivity(intent);
                }
            }
        });

        back_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

    public void check(String room_id){
        DB.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean exist = false;

                Iterator<DataSnapshot> child = snapshot.getChildren().iterator();

                while (child.hasNext()) {
                    //존재할때
                    if (child.next().getKey().equals(room_id)) {
                        int random = (int)(Math.random()*1000);
                        roomid = Integer.toString(random);
                        check(roomid);
                    }
                }

                if(!exist){
                    return;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}