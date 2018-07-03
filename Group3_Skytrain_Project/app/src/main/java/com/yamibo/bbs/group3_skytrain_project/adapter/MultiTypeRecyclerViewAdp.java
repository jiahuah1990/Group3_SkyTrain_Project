package com.yamibo.bbs.group3_skytrain_project.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.models.BaseModel;
import com.yamibo.bbs.group3_skytrain_project.models.Constants;
import com.yamibo.bbs.group3_skytrain_project.models.Stop;

import java.util.Collection;
import java.util.List;

public class MultiTypeRecyclerViewAdp extends RecyclerView.Adapter<BaseViewHolder> {
    private List<? extends BaseModel> mList;
    private LayoutInflater mInflator;

    public MultiTypeRecyclerViewAdp(List<? extends BaseModel> list, Context context) {
        this.mList = list;
        this.mInflator = LayoutInflater.from(context);
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case Constants.ViewType.STOPS_TYPE:
                return new StopsHolder(mInflator.inflate(R.layout.type_recipe,parent,false));
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(mList.get(position));
    }


    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getViewType();
    }

    public int getItemCount() {
        return mList.size();
    }

    public static class StopsHolder extends BaseViewHolder<Stop> {
        private TextView mItem;

        public StopsHolder(View itemView) {
            super(itemView);
            mItem = (TextView) itemView.findViewById(R.id.item);
        }

        @Override
        public void bind(T object) {

        }

        @Override
        public void bind(Collection object) {
            mItem.setText(object.getClass());
        }
    }
    /** Will create viewHolder for each type of list
     * */
}
