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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;


import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    RecyclerView recyclerview;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<Integer> roomList;
    private TextView room_id, room_name, players;
    private ImageView key;
    private LinearLayout room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerview = findViewById(R.id.room_list);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setHasFixedSize(true);
        roomList = new ArrayList<>();
        recyclerview.setAdapter(adapter);

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
    }


    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

        private ArrayList<Integer> localDataSet;
        private TextView view;

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
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
            localDataSet = dataSet;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view, which defines the UI of the list item
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.room_list, viewGroup, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.getTextView(view).setText((CharSequence) localDataSet);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return localDataSet.size();
        }
    }

}