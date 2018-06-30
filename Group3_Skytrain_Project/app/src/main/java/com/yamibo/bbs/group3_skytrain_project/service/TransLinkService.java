package com.yamibo.bbs.group3_skytrain_project.service;

import com.yamibo.bbs.group3_skytrain_project.models.JSONResponse;
import com.yamibo.bbs.group3_skytrain_project.models.Stop;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TransLinkService {
    //String SERVICE_ENDPOINT = "http://api.translink.ca";

    @GET("/stops")
    Call<JSONResponse> getStop(@Query("apikey") String apikey, @Query("lat") double lat, @Query("long") double longt);

    //@GET("stops?apikey=fH8nhLCTC142J3YXmtLC&{lat}&{longt}")
    //Call<JSONResponse> getStop(@Path("lat") double lat, @Path("longt") double longt);
}
