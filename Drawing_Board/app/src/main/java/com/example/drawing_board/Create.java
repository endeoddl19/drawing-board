package com.example.drawing_board;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    private TextView roomname_tv,roompwd_tv,players_tv;
    private EditText roomname_et,roompwd_et;
    private Button four,five,six,seven,create;
    DatabaseReference DB;

    protected String roomname,roompwd;
    protected int roomid,curplayers,maxplayers;
    protected boolean key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        roomname_tv = findViewById(R.id.roomname_tv);
        roomname_et = findViewById(R.id.roomname_et);
        roompwd_tv = findViewById(R.id.roompwd_tv);
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
                else{
                    DB.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            roomid = (int)(Math.random()*1000);
                            key = roompwd != null;
                            curplayers=1;
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    Room newroom = new Room(roomid,roomname,curplayers,maxplayers,key,roompwd);

                    DB.push().setValue(newroom);

                    Intent intent = new Intent(getApplicationContext(), Menu.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void selectPlayers(Button button){
        if(button == four){
            maxplayers = 4;
        }
        else if(button == five){
            maxplayers = 5;
        }
        else if(button == six){
            maxplayers = 6;
        }
        else if(button == seven){
            maxplayers = 7;
        }
    }
}