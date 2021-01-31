package com.example.drawing_board;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Dictionary;

public class Menu extends AppCompatActivity {

    private TextView room_id, room_name, players;
    private ImageView key;
    private LinearLayout room;
    private ArrayList<Room> mArrayList;
    private CustomAdapter mAdapter;
    DatabaseReference DB;
    protected String roomname,player;
    protected int roomid,roompwd;
    protected boolean key_bool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.room_list);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        DB = FirebaseDatabase.getInstance().getReference("room");
        DB.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mArrayList.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren() ){
                    roomid = (Integer) dataSnapshot.child("Room_id").getValue();
                    roomname = (String) dataSnapshot.child("Room_name").getValue();
                    player = (String) dataSnapshot.child("Players").getValue();
                    key_bool = (Boolean) dataSnapshot.child("Key").getValue();
                    roompwd = (Integer) dataSnapshot.child("Password").getValue();

                    Room newroom = new Room(roomid,roomname,player,key_bool,roompwd);
                    mArrayList.add(newroom);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        room = findViewById(R.id.room);
        room_id = findViewById(R.id.room_id);
        room_name = findViewById(R.id.room_name);

        mArrayList = new ArrayList<>();
        mAdapter = new CustomAdapter( mArrayList);
        mRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        Button buttonInsert = (Button)findViewById(R.id.create);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Create.class);
                startActivity(intent);
                }
        });
    }
}