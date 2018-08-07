package com.yamibo.bbs.group3_skytrain_project.models;

import Utils.RecViewConstants;

public class Stop implements BaseModel {
    private String BayNo,City,OnStreet,AtStreet;
    private String Routes,stopsName;
    private double Latitude,Longitude;
    private int StopNo,Distance, WheelchairAccess;
    private String expectedLeaveTime;
    private int expectedCountDown;
    private String nextBus;

    public Stop(int stopNo, int distance, int wheelchairAccess, String bayNo, String city, String onStreet, String atStreet, String routes, double lat, double longt) {
        this.StopNo = stopNo;
        this.Distance = distance;
        this.WheelchairAccess = wheelchairAccess;
        this.BayNo = bayNo;
        this.City = city;
        this.OnStreet = onStreet;
        this.AtStreet = atStreet;
        this.Routes = routes;
        this.Latitude = lat;
        this.Longitude = longt;
    }

    public Stop(int stopNo){
        this.StopNo=stopNo;
    }
    public Stop(String stopsName){
        this.stopsName=stopsName;
    }

    public int getStopNo() {
        return StopNo;
    }

    public void setStopNo(int stopNo) {
        this.StopNo = stopNo;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int distance) {
        this.Distance = distance;
    }

    public int getWheelchairAccess() {
        return WheelchairAccess;
    }

    public void setWheelchairAccess(int wheelchairAccess) {
        this.WheelchairAccess = wheelchairAccess;
    }

    public String getBayNo() {
        return BayNo;
    }

    public void setBayNo(String bayNo) {
        this.BayNo = bayNo;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public String getOnStreet() {
        return OnStreet;
    }

    public void setOnStreet(String onStreet) {
        this.OnStreet = onStreet;
    }

    public String getAtStreet() {
        return AtStreet;
    }

    public void setAtStreet(String atStreet) {
        this.AtStreet = atStreet;
    }

    public String getRoutes() {
        return Routes;
    }

    public void setRoutes(String routes) {
        this.Routes = routes;
    }

    public double getLat() {
        return Latitude;
    }

    public void setLat(double lat) {
        this.Latitude = lat;
    }

    public double getLongt() {
        return Longitude;
    }

    public void setLongt(double longt) {
        this.Longitude = longt;
    }
    public void setStopsNames(String stopsName){
        this.stopsName=stopsName;
    }
    public String getStopsName(){
        return stopsName;
    }

    public void setStopsName(String stopsName) {
        this.stopsName = stopsName;
    }

    public String getExpectedLeaveTime() {
        return expectedLeaveTime;
    }

    public void setExpectedLeaveTime(String expectedLeaveTime) {
        this.expectedLeaveTime = expectedLeaveTime;
    }

    public int getExpectedCountDown() {
        return expectedCountDown;
    }

    public void setExpectedCountDown(int expectedCountDown) {
        this.expectedCountDown = expectedCountDown;
    }

    public String getNextBus() {
        return nextBus;
    }

    public void setNextBus(String nextBus) {
        this.nextBus = nextBus;
    }

    @Override
    public int getViewType() {
        return RecViewConstants.ViewType.STOPS_TYPE;
    }
}
