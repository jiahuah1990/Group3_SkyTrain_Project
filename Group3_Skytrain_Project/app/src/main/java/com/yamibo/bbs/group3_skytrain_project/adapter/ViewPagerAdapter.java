package com.yamibo.bbs.group3_skytrain_project.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.models.BaseModel;
import com.yamibo.bbs.group3_skytrain_project.models.Schedule;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    public Context context;
    private LayoutInflater inflater;
    RecyclerView recyclerView;
    MultiTypeRecyclerViewAdp recAdp;
    List<BaseModel> schedule;
    private ScrollView scrollView;
    private int[] imgIds={R.drawable.seabus_schedule1,
            R.drawable.seabus_schedule2,R.drawable.schedule3};
    public ViewPagerAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount(){
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;//View is logically equal to object
    }
    @Override
    public Object instantiateItem(ViewGroup container,int pos){

        inflater=(LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View v= inflater.inflate(R.layout.pager_items,null);
        scrollView=(ScrollView)v.findViewById(R.id.scrollView);
                schedule=new ArrayList<>();

        ImageView imgView=(ImageView)v.findViewById(R.id.pagerImgView);
        ViewPager vp=(ViewPager)container;

        container.addView(v,0);
        imgView.setImageResource(imgIds[pos]);
        return v;
    }
    @Override
    public void destroyItem(ViewGroup container,int pos,Object object){
        ((ViewPager)container).removeView((View)(object));
    }

}