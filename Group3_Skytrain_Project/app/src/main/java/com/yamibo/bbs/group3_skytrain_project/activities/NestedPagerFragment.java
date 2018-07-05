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

@SuppressLint("ValidFragment")
public class NestedPagerFragment extends Fragment {
    public NestedPagerFragment(){}
    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdp;
    private static View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_pager_schedule,container,false);
        viewPager = (ViewPager)v.findViewById(R.id.pager_schedule);
        //ViewPager with images
        pagerAdp = new ViewPagerAdapter(getContext());
        viewPager.setAdapter(pagerAdp);
        return v;
    }
}

