package com.yamibo.bbs.group3_skytrain_project.models;

import android.widget.ImageView;

public class Schedule implements BaseModel {
    private int imgIds;
    public Schedule(int imgIds){
        this.imgIds=imgIds;
    }
    @Override
    public int getViewType() {
        return Constants.ViewType.SCHEDULE;
    }

    public int getImgIds() {
        return imgIds;
    }

    public void setImgIds(int imgIds) {
        this.imgIds = imgIds;
    }
}
