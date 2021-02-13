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

    private ImageView key;
    private LinearLayout room;
    private ArrayList<Room> mArrayList;
    private CustomAdapter mAdapter;
    DatabaseReference DB;
    private String roomname,roompwd,players,roomid;
    private long curplayer,maxplayer;
    private boolean key_bool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.room_list);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mArrayList = new ArrayList<>();

        DB = FirebaseDatabase.getInstance().getReference("room");
        DB.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mArrayList.clear();
                // 완탐하며 모든 방 정보 가져와서 recyclerview 리스트에 추가
                for(DataSnapshot dataSnapshot : snapshot.getChildren() ){
                    roomid = dataSnapshot.getKey();
                    roomname = (String)snapshot.child(roomid).child("room_name").getValue();
                    roompwd = (String)snapshot.child(roomid).child("password").getValue();
                    curplayer = (long)snapshot.child(roomid).child("curPlayers").getValue();
                    maxplayer = (long)snapshot.child(roomid).child("maxPlayers").getValue();
                    key_bool = (boolean)snapshot.child(roomid).child("key").getValue();
                    players = curplayer + " / " + maxplayer;
                    Room room = new Room(roomid,roomname,curplayer,maxplayer,players,key_bool,roompwd);
                    mArrayList.add(room);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        mAdapter = new CustomAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        Button buttonInsert = findViewById(R.id.create);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Create.class);
                startActivity(intent);
                }
        });

//        room.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }
}