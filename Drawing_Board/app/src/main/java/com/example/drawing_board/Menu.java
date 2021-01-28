package com.example.drawing_board;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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


import java.util.ArrayList;
import java.util.Dictionary;

public class Menu extends AppCompatActivity {

    RecyclerView recyclerview;
    private CustomAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private TextView room_id, room_name, players;
    private ImageView key;
    private LinearLayout room;
    private ArrayList<Room> roomList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerview = findViewById(R.id.room_list);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setHasFixedSize(true);
        adapter = new CustomAdapter(roomList);
        recyclerview.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerview.getContext(),
                layoutManager.getLayoutDirection());
        recyclerview.addItemDecoration(dividerItemDecoration);

        room = findViewById(R.id.room);
        room_id = findViewById(R.id.room_id);
        String str_room_id = room_id.toString();
        room_name = findViewById(R.id.room_name);
        String str_room_name = room_name.toString();
        room.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("room_id",str_room_id);
            intent.putExtra("room_name",str_room_name);
        });

        Button buttonInsert = (Button)findViewById(R.id.create);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Room data = new Room(count+"","Apple" + count, "사과" + count);

                //roomList.add(data); // RecyclerView의 마지막 줄에 삽입

                adapter.notifyDataSetChanged();             }
        });
    }


    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

        public class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(View view) {
                super(view);

                room_id = (TextView) view.findViewById(R.id.room_id);
                room_name = (TextView) view.findViewById(R.id.room_name);
                players = (TextView) view.findViewById(R.id.players);
            }

            public TextView getTextView(TextView view) {
                return view;
            }
        }

        public CustomAdapter(ArrayList dataSet) {
            roomList = dataSet;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view, which defines the UI of the list item
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.room_list, viewGroup, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
            viewHolder.getTextView(room_id).setText(roomList.get(position).getRoom_id());
            viewHolder.getTextView(room_name).setText(roomList.get(position).getRoom_name());
            viewHolder.getTextView(players).setText(roomList.get(position).getPlayers());
        }

        @Override
        public int getItemCount() {
            return roomList.size();
        }
    }
}