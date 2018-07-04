package com.yamibo.bbs.group3_skytrain_project.models;

public class TranslinkFeed implements BaseModel {
    String timeStamp,status,location,schedule;
    int travelTime,speedKmph,linkedId;

    public TranslinkFeed (){
        //put am empty constructor just in case of declaration
    }

    public TranslinkFeed(String timeStamp){
        this.timeStamp=timeStamp;
    }
    @Override
    public int getViewType() {
        return Constants.ViewType.FEED_TYPE;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public int getSpeedKmph() {
        return speedKmph;
    }

    public void setSpeedKmph(int speedKmph) {
        this.speedKmph = speedKmph;
    }

    public int getLinkedId() {
        return linkedId;
    }

    public void setLinkedId(int linkedId) {
        this.linkedId = linkedId;
    }
}
