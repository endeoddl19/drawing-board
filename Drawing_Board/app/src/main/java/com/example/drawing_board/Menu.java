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


import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Dictionary;

public class Menu extends AppCompatActivity {

    private TextView room_id, room_name, players;
    private ImageView key;
    private LinearLayout room;
    private ArrayList<Room> mArrayList;
    private CustomAdapter mAdapter;
    DatabaseReference DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.room_list);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mArrayList = new ArrayList<>();
        mAdapter = new CustomAdapter( mArrayList);
        mRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);


        room = findViewById(R.id.room);
        room_id = findViewById(R.id.room_id);
        //String str_room_id = room_id.getText().toString();
        room_name = findViewById(R.id.room_name);
        //String str_room_name = room_name.getText().toString();
//        room.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            //intent.putExtra("room_id",str_room_id);
//            //intent.putExtra("room_name",str_room_name);
//        });

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