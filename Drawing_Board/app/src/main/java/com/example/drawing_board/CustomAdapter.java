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
        protected TextView room_id;
        protected TextView room_name;
        protected TextView players;
        public CustomViewHolder(View view) {
            super(view);
            this.room_id = (TextView) view.findViewById(R.id.room_id);
            this.room_name = (TextView) view.findViewById(R.id.room_name);
            this.players = (TextView) view.findViewById(R.id.players);
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
        viewholder.room_id.setText(mList.get(position).getRoom_id());
        viewholder.room_name.setText(mList.get(position).getRoom_name());
        viewholder.players.setText(mList.get(position).getPlayers());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
