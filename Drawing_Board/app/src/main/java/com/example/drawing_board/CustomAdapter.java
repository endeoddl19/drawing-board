package com.example.drawing_board;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Room> mList;


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView room_id,room_name,players;
        protected ImageView key;
        public CustomViewHolder(View view) {
            super(view);
            this.room_id = view.findViewById(R.id.room_id);
            this.room_name = view.findViewById(R.id.room_name);
            this.players = view.findViewById(R.id.players);
            this.key = view.findViewById(R.id.key);
        }
    }

    public CustomAdapter(ArrayList<Room> list) {
        this.mList = list;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.room_list, viewGroup, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {
        long curplayer,maxplayer;

        curplayer = mList.get(position).getcurPlayers();
        maxplayer = mList.get(position).getmaxPlayers();
        String str_players = curplayer + " / " + maxplayer;
        viewholder.room_name.setText(mList.get(position).getRoom_name());
        viewholder.players.setText(str_players);
        if(!mList.get(position).isKey()) {
            viewholder.key.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
