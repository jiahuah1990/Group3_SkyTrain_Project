package com.yamibo.bbs.group3_skytrain_project.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yamibo.bbs.group3_skytrain_project.R;

public class FragmentTripPlan extends Fragment {
    private View v;
    public FragmentTripPlan(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceStat){
        v=inflater.inflate(R.layout.tab_trip_plan,container,false);
        return v;
    }
    @Override
    public void onViewCreated(View v,Bundle savedInstanceStat){

    }
}
