package com.yamibo.bbs.group3_skytrain_project.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.adapter.ImgPagerAdp;
import com.yamibo.bbs.group3_skytrain_project.adapter.MultiViewRecAdapter;
import com.yamibo.bbs.group3_skytrain_project.models.BaseModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentTransit extends Fragment {
    private View v;
    private RecyclerView pagerRecView;
    private MultiViewRecAdapter pagerRecAdp,pagerRecAdp1;
    public static List<BaseModel> pagersList;
    private static FragmentTransit fragTransit;
    private static ExtendedViewPager mViewPager,extendedVp2;
    private static String scheduleTitle,mapTitle;
    static int pos=0;
    private ImageButton backBtn,nextBtn;

    public FragmentTransit(){}

    public static FragmentTransit getInstance(){
        if(fragTransit==null){
            fragTransit=new FragmentTransit();
        }
        return fragTransit;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceStat){
        v=inflater.inflate(R.layout.tab_transit,container,false);
        backBtn=(ImageButton)v.findViewById(R.id.backBtn);
        nextBtn=(ImageButton)v.findViewById(R.id.forthBtn);

        return v;
    }
    @Override
    public void onViewCreated(View v,Bundle savedInstanceState){
        super.onViewCreated(v,savedInstanceState);
        pagersList=new ArrayList<>();
        pagerRecView=(RecyclerView)v.findViewById(R.id.viewPagersRecView);
        pagerRecView.setLayoutManager(new LinearLayoutManager(getContext()));

        mViewPager = new ExtendedViewPager(getContext());
        extendedVp2 =new ExtendedViewPager(getContext());
        //mViewPager.setAdapter(new ZoomableScheduleAdapter());
        //extendedVp2.setAdapter(new ZoomableScheduleAdapter());
        scheduleTitle="SkyTrain And SeaBus Schedules";
        mapTitle="SkyTrain, SeaBus, And Bus Maps";
        for(int i=0;i<2;i++) {
            switch (i){
                case 0:
                    mViewPager = new ExtendedViewPager(getContext(), scheduleTitle,R.id.backBtn, R.id.forthBtn);
                    break;
                case 1:
                    mViewPager = new ExtendedViewPager(getContext(), mapTitle, R.id.backBtn, R.id.forthBtn);
                break;
            }
            pagersList.add(mViewPager);
        }

        pagerRecAdp=new MultiViewRecAdapter(pagersList,getContext());
        pagerRecView.setAdapter(pagerRecAdp);
        Log.d("SIZE","pos: "+pos);
    }
    public static class ZoomPager extends PagerAdapter {
        List<Integer> imgLists=new ArrayList<>();
        private static int[] maps = { R.drawable.skytrain_map, R.drawable.sea_bus,
                R.mipmap.bline_sea_bus};
        private static int[] schedules={R.drawable.seabus_schedule1,R.drawable.seabus_schedule2
                ,R.drawable.schedule3};
        @Override
        public int getCount() {
            return imgLists.size();
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            imgLists.add(schedules[position]);
            imgLists.add(maps[position]);
            TouchImgView1 img = new TouchImgView1(container.getContext());
            //   TouchImgView1 img1=new TouchImgView1(container.getContext());

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
   public static class ZoomableMapAdapter extends PagerAdapter {
        List<Integer> imgLists=new ArrayList<>();
       private static int[] maps = { R.drawable.skytrain_map, R.drawable.sea_bus,
               R.mipmap.bline_sea_bus};
       private static int[] schedules={R.drawable.seabus_schedule1,R.drawable.seabus_schedule2
               ,R.drawable.schedule3};
       @Override
       public int getCount() {
           return maps.length;
       }

       @Override
       public View instantiateItem(ViewGroup container, int position) {
           imgLists.add(schedules[position]);
           imgLists.add(maps[position]);
           TouchImgView1 img = new TouchImgView1(container.getContext());
        //   TouchImgView1 img1=new TouchImgView1(container.getContext());

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
    public static class ZoomableScheduleAdapter extends PagerAdapter {
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
