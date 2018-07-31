package com.yamibo.bbs.group3_skytrain_project.models;

import android.widget.ImageView;

public class Schedule implements BaseModel {
    private int imgIds;

    public Schedule(String destination, int expectedCountdown) {
        Destination = destination;
        ExpectedCountdown = expectedCountdown;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public int getExpectedCountdown() {
        return ExpectedCountdown;
    }

    public void setExpectedCountdown(int expectedCountdown) {
        ExpectedCountdown = expectedCountdown;
    }

    private String Destination;
    private int ExpectedCountdown;

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
