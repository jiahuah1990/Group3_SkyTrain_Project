package com.yamibo.bbs.group3_skytrain_project.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.activities.StopDetailActivity;
import com.yamibo.bbs.group3_skytrain_project.models.Stop;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    List<Stop> mItems = new ArrayList<>();
    public static int HIGHLIGHTED = -1;

    public CardAdapter(List<Stop> mItems) {
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
                .inflate(R.layout.card_view_stop, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, final int position) {
        Stop stop = mItems.get(position);
        String stopName = stop.getOnStreet()+" FS " + stop.getOnStreet();
        holder.stop_name.setText(stopName);
        holder.dist.setText(""+stop.getDistance());
        holder.routes.setText(stop.getRoutes());
        TextView tv =
                (TextView) holder.mView.findViewById(R.id.item_card).findViewById(R.id.stop_name);
        int color = tv.getResources().getColor(android.R.color.primary_text_light);
        if(position == HIGHLIGHTED)
            tv.setTextColor(Color.BLUE);


        else
          tv.setTextColor(color);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, StopDetailActivity.class);
                intent.putExtra("stopNo", mItems.get(position).getStopNo());
                context.startActivity(intent);
            }
        });
        //TODO: add mTwoPane code to add marker on map


    }



    @Override
    public int getItemCount() {
        return mItems.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        public TextView stop_name;
        public TextView dist;
        public TextView routes;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            stop_name = (TextView) itemView.findViewById(R.id.stop_name);
            dist = (TextView) itemView.findViewById(R.id.dist);
            routes = (TextView) itemView.findViewById(R.id.routes);
        }
    }
}
