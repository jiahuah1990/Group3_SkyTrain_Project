package com.yamibo.bbs.group3_skytrain_project.activities;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.models.BaseModel;

import Utils.RecViewConstants;


public class ExtendedViewPager extends ViewPager implements BaseModel{
    private View v;
    private LayoutInflater inflater;
    private ExtendedViewPager extendedVP;
    public ExtendedViewPager(Context context) {
        super(context);
    }

    public ExtendedViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public ExtendedViewPager(Context context,ViewGroup container, LayoutInflater inflater){
        super(context);
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.extendedVP.v=inflater.inflate(R.layout.pager_items,container);
    }
    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v instanceof TouchImgView1) {
            //
            // canScrollHorizontally is not supported for Api < 14. To get around this issue,
            // ViewPager is extended and canScrollHorizontallyFroyo, a wrapper around
            // canScrollHorizontally supporting Api >= 8, is called.
            //
            return ((TouchImgView1) v).canScrollHorizontallyFroyo(-dx);

        } else {
            return super.canScroll(v, checkV, dx, x, y);
        }
    }

    @Override
    public int getViewType() {
        return RecViewConstants.ViewType.VIEW_PAGER_TYPE;
    }
}