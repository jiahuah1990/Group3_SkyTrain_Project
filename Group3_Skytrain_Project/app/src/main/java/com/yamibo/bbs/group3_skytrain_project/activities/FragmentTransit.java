package com.yamibo.bbs.group3_skytrain_project.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.adapter.ImgPagerAdp;
import com.yamibo.bbs.group3_skytrain_project.adapter.MultiViewRecAdapter;
import com.yamibo.bbs.group3_skytrain_project.models.BaseModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentTransit extends Fragment {
    private View v;
    private ViewPager viewPager;
    private ImgPagerAdp pagerAdp;
    private List<Integer> imgIdList;
    private RecyclerView pagerRecView;
    private MultiViewRecAdapter pagerRecAdp;
    private List<BaseModel> pagersList;
    public FragmentTransit(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceStat){
        v=inflater.inflate(R.layout.tab_transit,container,false);
        return v;
    }
    @Override
    public void onViewCreated(View v,Bundle savedInstanceState){
        super.onViewCreated(v,savedInstanceState);
        pagersList=new ArrayList<>();

        ExtendedViewPager mViewPager = (ExtendedViewPager)v.findViewById(R.id.extendedMapPager);
        ExtendedViewPager extendedVp2=(ExtendedViewPager)v.findViewById(R.id.extendedSchedulePager);
        mViewPager.setAdapter(new ZoomableMapAdapter());
        extendedVp2.setAdapter(new ZoomableScheduleAdapter());

        pagersList.add(extendedVp2);
        pagerRecView=(RecyclerView)v.findViewById(R.id.viewPagersRecView);
        pagerRecAdp=new MultiViewRecAdapter(pagersList,getContext());

        pagerRecView.setAdapter(pagerRecAdp);
    }

   static class ZoomableMapAdapter extends PagerAdapter {

       private static int[] maps = { R.drawable.skytrain_map, R.drawable.sea_bus,
               R.mipmap.bline_sea_bus};
       @Override
       public int getCount() {
           return maps.length;
       }

       @Override
       public View instantiateItem(ViewGroup container, int position) {
           TouchImgView1 img = new TouchImgView1(container.getContext());

           img.setImageResource(maps[position]);
           container.addView(img, LinearLayout.LayoutParams.MATCH_PARENT,
                   LinearLayout.LayoutParams.MATCH_PARENT);
           return img;
       }

       @Override
       public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView((View) object);
       }

       @Override
       public boolean isViewFromObject(View view, Object object) {
           return view == object;
       }

   }
    static class ZoomableScheduleAdapter extends PagerAdapter {
        private static int[] schedules={R.drawable.seabus_schedule1,R.drawable.seabus_schedule2
                ,R.drawable.schedule3};
        @Override
        public int getCount() {
            return schedules.length;
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            TouchImgView1 schedule=new TouchImgView1(container.getContext());

            schedule.setImageResource(schedules[position]);
            container.addView(schedule, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            return schedule;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }
}
