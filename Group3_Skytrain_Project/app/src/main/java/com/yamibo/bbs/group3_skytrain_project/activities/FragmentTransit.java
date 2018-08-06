package com.yamibo.bbs.group3_skytrain_project.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.adapter.ImgPagerAdp;

import java.util.List;

public class FragmentTransit extends Fragment {
    private View v;
    private ViewPager viewPager;
    private ImgPagerAdp pagerAdp;
    private List<Integer> imgIdList;
    private static TouchImgView1 imgTouch;

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

       /* imgTouch=(TouchImgView1)v.findViewById(R.id.extendedPager);
        imgTouch.setMaxZoom(4f);*/
        ExtendedViewPager mViewPager = (ExtendedViewPager)v.findViewById(R.id.extendedPager);
        mViewPager.setAdapter(new TouchImageAdapter());
        /*//ViewPager with images
        pagerAdp=new ImgPagerAdp(getContext(),imgIdList);*/

    }
   /* private void setZoomableMapFrag(){
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.transitMapFrm,new FragmentZoomableMap())
                .addToBackStack(null).commit();
    }*/
   static class TouchImageAdapter extends PagerAdapter {

       private static int[] images = { R.drawable.skytrain_map, R.drawable.sea_bus,
               R.mipmap.bline_sea_bus};

       @Override
       public int getCount() {
           return images.length;
       }

       @Override
       public View instantiateItem(ViewGroup container, int position) {
           TouchImgView1 img = new TouchImgView1(container.getContext());
           img.setImageResource(images[position]);
           container.addView(img, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
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
}
