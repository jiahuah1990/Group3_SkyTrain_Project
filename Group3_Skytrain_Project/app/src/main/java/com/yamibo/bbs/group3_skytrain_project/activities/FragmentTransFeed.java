package com.yamibo.bbs.group3_skytrain_project.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.adapter.MultiViewRecAdapter;
import com.yamibo.bbs.group3_skytrain_project.models.BaseModel;
import com.yamibo.bbs.group3_skytrain_project.models.TranslinkFeed;

import java.util.List;

public class FragmentTransFeed extends android.support.v4.app.Fragment{
    private static String timeStampURl=
            "https://rtdsapi.translink.ca/rtdsapi/v1/AllLiveData?apikey=fH8nhLCTC142J3YXmtLC";
    private static TranslinkFeed feeds;
    private RecyclerView feedRecView;
    private static View v;
    private static MultiViewRecAdapter feedRecAdp;
    private static List<BaseModel> feedsList;
    private static ViewPager pager;
    public FragmentTransFeed(){}//Empty Constructor
    @Override
    public View onCreateView
            (LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.tab_trans_feed,container,false);
        return v;
    }
    @Override
    public void onViewCreated(View v,Bundle savedInstanceState){
        //can preform any program here,avoiding IllegalStateException
        feedRecView=(RecyclerView)v.findViewById(R.id.feed_recView);
        feedRecView.setLayoutManager(new LinearLayoutManager(getContext()));

    }
    private void getTranslinkFeed() {
    }

}
