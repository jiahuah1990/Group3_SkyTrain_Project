package com.yamibo.bbs.group3_skytrain_project.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.models.BaseModel;
import com.yamibo.bbs.group3_skytrain_project.models.Constants;
import com.yamibo.bbs.group3_skytrain_project.models.Schedule;
import com.yamibo.bbs.group3_skytrain_project.models.Stop;
import com.yamibo.bbs.group3_skytrain_project.models.TranslinkFeed;

import java.util.List;

import retrofit2.http.Query;

public class MultiViewRecAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<? extends BaseModel> baseList;
    private LayoutInflater inflater;
    private View v;
    public MultiViewRecAdapter(List<? extends BaseModel> list, Context context) {
        this.baseList = list;
        /**baseList is a multi-type list which means one recView adapter
         * can adapt multiple defined types (models)*/
        this.inflater = LayoutInflater.from(context);
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case Constants.ViewType.STOPS_TYPE:
                v = LayoutInflater.from(parent.getContext()).inflate
                    (R.layout.stops_list, parent, false);
                return new StopsHolder(v,viewType);
            case Constants.ViewType.FEED_TYPE:
                v = LayoutInflater.from(parent.getContext()).inflate
                    (R.layout.list_trans_feed, parent, false);
                return new TransFeedHolder(v,viewType);
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(baseList.get(position));
    }


    @Override
    public int getItemViewType(int position) {
        return baseList.get(position).getViewType();
    }

    public int getItemCount() {
        return baseList.size();
    }

    public static class TransFeedHolder extends BaseViewHolder<TranslinkFeed>{
        private TextView timeStampTv;
        public TransFeedHolder(View itemView,int viewType){
            super(itemView);
            timeStampTv=(TextView)itemView.findViewById(R.id.timeStampTxt);
        }
        @Override
        public void bind(TranslinkFeed object) {
            timeStampTv.setText(object.getTimeStamp());
        }
    }
    public static class StopsHolder extends BaseViewHolder<Stop> {
        private TextView mItem;

        public StopsHolder(View itemView,int viewType) {
            super(itemView);
            mItem = (TextView) itemView.findViewById(R.id.item_card);
        }

        @Override
        public void bind(Stop object) {
            mItem.setText(object.getStopNo());
        }
    }

    /** Will create viewHolder for each type of lists */
}
