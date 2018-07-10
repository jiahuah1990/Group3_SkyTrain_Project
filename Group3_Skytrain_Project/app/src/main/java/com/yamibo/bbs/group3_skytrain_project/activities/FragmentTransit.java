package com.yamibo.bbs.group3_skytrain_project.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.adapter.ImgPagerAdp;

import java.util.ArrayList;
import java.util.List;

public class FragmentTransit extends Fragment {
    private View v;
    private ViewPager viewPager;
    private ImgPagerAdp pagerAdp;
    private List<Integer> imgIdList;

    public FragmentTransit(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceStat){
        v=inflater.inflate(R.layout.tab_transit,container,false);


        return v;
    }
    @Override
    public void onViewCreated(View v,Bundle savedInstanceStat){
        viewPager = (ViewPager)v.findViewById(R.id.pager_schedule);
        imgIdList=new ArrayList<>();
        imgIdList.add(R.drawable.seabus_schedule1);
        imgIdList.add(R.drawable.seabus_schedule2);
        imgIdList.add(R.drawable.schedule3);

        //ViewPager with images
        pagerAdp=new ImgPagerAdp(getContext(),imgIdList);
    }
}
