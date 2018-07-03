package com.yamibo.bbs.group3_skytrain_project.models;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.yamibo.bbs.group3_skytrain_project.models.Constants.ViewType.STOPS_TYPE;

public class Constants {

    @IntDef({STOPS_TYPE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewType{
        int STOPS_TYPE=100;
        //can add more View Types
    }
}
