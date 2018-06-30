package com.yamibo.bbs.group3_skytrain_project.service;

import com.yamibo.bbs.group3_skytrain_project.models.Stop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface TransLinkService {
    //String SERVICE_ENDPOINT = "http://api.translink.ca";
    @Headers("Accept: application/json")
    @GET("/rttiapi/v1/stops")
    Call<List<Stop>> getStop( @Query("apikey") String apikey, @Query("lat") double lat, @Query("long") double longt);

    //@GET("stops?apikey=fH8nhLCTC142J3YXmtLC&{lat}&{longt}")
    //Call<JSONResponse> getStop(@Path("lat") double lat, @Path("longt") double longt);
}
