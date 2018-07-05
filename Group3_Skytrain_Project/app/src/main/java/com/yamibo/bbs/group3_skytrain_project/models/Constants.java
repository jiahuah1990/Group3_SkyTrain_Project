package com.yamibo.bbs.group3_skytrain_project.models;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.yamibo.bbs.group3_skytrain_project.models.Constants.ViewType.FEED_TYPE;
import static com.yamibo.bbs.group3_skytrain_project.models.Constants.ViewType.SCHEDULE;
import static com.yamibo.bbs.group3_skytrain_project.models.Constants.ViewType.STOPS_TYPE;

public class Constants {
/***Class declaring different type of recyclerView content*/
    @IntDef({STOPS_TYPE,FEED_TYPE,SCHEDULE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewType{
        int STOPS_TYPE=100;
        int FEED_TYPE=200;
        int SCHEDULE=400;
        //can add more View Types
    }
}
