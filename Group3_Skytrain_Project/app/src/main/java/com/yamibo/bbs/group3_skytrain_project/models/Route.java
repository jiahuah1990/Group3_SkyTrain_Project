package com.yamibo.bbs.group3_skytrain_project.models;

public class Route {
    public String getRouteNo() {
        return RouteNo;
    }

    public void setRouteNo(String routeNo) {
        RouteNo = routeNo;
    }

    public String getRouteName() {
        return RouteName;
    }

    public void setRouteName(String routeName) {
        RouteName = routeName;
    }

    public Schedule[] getSchedules() {
        return Schedules;
    }

    public void setSchedules(Schedule[] schedules) {
        Schedules = schedules;
    }

    public Route(String routeNo, String routeName, Schedule[] schedules) {
        RouteNo = routeNo;
        RouteName = routeName;
        Schedules = schedules;
    }

    private String RouteNo;
    private String RouteName;
    private Schedule[] Schedules;

}
