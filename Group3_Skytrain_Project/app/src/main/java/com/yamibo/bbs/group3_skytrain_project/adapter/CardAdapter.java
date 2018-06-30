package com.yamibo.bbs.group3_skytrain_project.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.models.Stop;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    List<Stop> mItems;
    public CardAdapter(ArrayList<Stop> mItems) {
        this.mItems = mItems;
    }

    public void addData(Stop stop) {
        mItems.add(stop);
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        Stop stop = mItems.get(position);
        String stopName = stop.getOnStreet()+" FS " + stop.getOnStreet();
        holder.stop_name.setText(stopName);
        holder.dist.setText(stop.getDistance());
        holder.routes.setText(stop.getRoutes());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView stop_name;
        public TextView dist;
        public TextView routes;

        public ViewHolder(View itemView) {
            super(itemView);
            stop_name = (TextView) itemView.findViewById(R.id.stop_name);
            dist = (TextView) itemView.findViewById(R.id.dist);
            routes = (TextView) itemView.findViewById(R.id.routes);
        }
    }
}
