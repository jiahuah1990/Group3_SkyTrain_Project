package com.yamibo.bbs.group3_skytrain_project.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.adapter.ViewPagerAdapter;

public class FragmentTransit extends Fragment {
    private View v;
    private ViewPager pager; private ViewPagerAdapter pagerAdp;
    public FragmentTransit(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceStat){
        v=inflater.inflate(R.layout.tab_transit,container,false);


        return v;
    }
    @Override
    public void onViewCreated(View v,Bundle savedInstanceStat){

    }
}
