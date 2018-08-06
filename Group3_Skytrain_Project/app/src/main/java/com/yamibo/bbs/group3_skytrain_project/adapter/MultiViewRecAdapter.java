package com.yamibo.bbs.group3_skytrain_project.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.models.BaseModel;
import Utils.RecViewConstants;

import com.yamibo.bbs.group3_skytrain_project.models.Favorites;
import com.yamibo.bbs.group3_skytrain_project.models.Stop;
import com.yamibo.bbs.group3_skytrain_project.models.TranslinkFeed;

import java.util.List;

public class MultiViewRecAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static List<? extends BaseModel> baseList;
    private LayoutInflater inflater;
    private View v;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public MultiViewRecAdapter(List<? extends BaseModel> list, Context context) {
        this.baseList = list;
        /**baseList is a multi-type list which means one recView adapter
         * can adapt multiple defined types (models)*/
        this.inflater = LayoutInflater.from(context);
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case RecViewConstants.ViewType.STOPS_TYPE:
                v = LayoutInflater.from(parent.getContext()).inflate
                    (R.layout.stops_list, parent, false);
                return new StopsHolder(v,viewType);
            case RecViewConstants.ViewType.FEED_TYPE:
                v = LayoutInflater.from(parent.getContext()).inflate
                    (R.layout.list_trans_feed, parent, false);
                return new TransFeedHolder(v,viewType);
            case RecViewConstants.ViewType.FAVE_TYPE:
                v=LayoutInflater.from(parent.getContext()).inflate
                        (R.layout.list_favorites,parent,false);
                return new FavoriteHolder(v,viewType);
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

    public class TransFeedHolder extends BaseViewHolder<TranslinkFeed>{
        private TextView timeStampTv,contentTv,titleTv,categoryTv;
        private ImageView icFeedsImgView;
        private CardView card;
        public TransFeedHolder(View itemView,int viewType){
            super(itemView);
            contentTv=(TextView)itemView.findViewById(R.id.contentTV);
            titleTv=(TextView)itemView.findViewById(R.id.titleTv);
            timeStampTv=(TextView)itemView.findViewById(R.id.timeStampTxt);
            icFeedsImgView=(ImageView)itemView.findViewById(R.id.imgView_feed);
            categoryTv=(TextView)itemView.findViewById(R.id.categoryTV);

            card=(CardView)itemView.findViewById(R.id.feedsCardView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
        @Override
        public void bind(TranslinkFeed object) {
            titleTv.setText(object.getTitle());
            contentTv.setText(object.getFeedsContent());
            timeStampTv.setText(object.getTimeStamp());
            categoryTv.setText(object.getCategory());

            if(titleTv.getText().toString().equals("")){
            }else if(categoryTv.getText().toString().equals("News")){
                icFeedsImgView.setImageResource(R.drawable.ic_news_feed);
            }else if(categoryTv.getText().toString().equals("")){
                icFeedsImgView.setImageResource(R.drawable.ic_media);
                categoryTv.setVisibility(View.INVISIBLE);
            }

        }
    }
    public class StopsHolder extends BaseViewHolder<Stop> {
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

    //Faves
    public class FavoriteHolder extends BaseViewHolder<Favorites>{
        private TextView titleTv,categoryTv;
        private ImageView icImgView,mainImg;
        public FavoriteHolder(View itemView,int viewType) {
            super(itemView);
            titleTv=(TextView)itemView.findViewById(R.id.faveTitleTv);
            categoryTv=(TextView)itemView.findViewById(R.id.faveCategory);
            icImgView=(ImageView)itemView.findViewById(R.id.faveOnImgView);
            mainImg=(ImageView)itemView.findViewById(R.id.faveImgView);
        }

        @Override
        public void bind(Favorites object) {
            titleTv.setText(object.getFaveTitle());
            categoryTv.setText(object.getCategory());
            Picasso.with(itemView.getContext()).load(object.getImgUrl()).fit().into(mainImg);
            icImgView.setImageResource(object.getImgResId());
        }
    }
    /** Will create viewHolder for each type of lists */
}
