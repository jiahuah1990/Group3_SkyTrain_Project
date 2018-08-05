package com.yamibo.bbs.group3_skytrain_project.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.JsonObject;
import com.squareup.picasso.Downloader;
import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.adapter.MultiViewRecAdapter;
import com.yamibo.bbs.group3_skytrain_project.models.BaseModel;
import com.yamibo.bbs.group3_skytrain_project.models.TranslinkFeed;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utils.VolleySingleton;

public class FragmentTransFeed extends android.support.v4.app.Fragment{
    private static String dataAtPointURL =
            "https://rtdsapi.translink.ca/rtdsapi/v1/LiveDataTimestampUtc?apikey=fH8nhLCTC142J3YXmtLC";
    private static RecyclerView feedRecView;
    private static View v;
    private static MultiViewRecAdapter feedRecAdp;
    private static List<BaseModel> feedsList;
    private static ViewPager pager;
    private static int NOT_FOUND_RESPONSE_CODE=404;
    private static ProgressDialog dialog;
    private static ProgressBar progressBar;

    public FragmentTransFeed(){}//Empty Constructor
    @Override
    public View onCreateView
            (LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.tab_trans_feed,container,false);

        return v;
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        feedsList=new ArrayList<>();
        //can preform any program here,avoiding IllegalStateException
        feedRecView=(RecyclerView)view.findViewById(R.id.feed_recView);
        feedRecView.setLayoutManager(new LinearLayoutManager(getContext()));

        getTranslinkFeed();
    }
    private void getTranslinkFeed() {
        JsonObjectRequest feedRequest=new JsonObjectRequest(Request.Method.GET, dataAtPointURL,
                null,new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String timeStampUTC=response.getString("timestampUtc");
                            Log.d("BODY",response+"\n");
                            //String msg=jObj.getString("Message");
                                TranslinkFeed feeds=new TranslinkFeed(timeStampUTC);
                                feedsList.add(feeds);
                                feedRecAdp=new MultiViewRecAdapter(feedsList,getContext());
                                feedRecView.setAdapter(feedRecAdp);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse response=error.networkResponse;
              //  int responseCode=error.networkResponse.statusCode;
                if(error instanceof ClientError&&response!=null){
                   try{
                       String res=new String(response.data, HttpHeaderParser
                               .parseCharset(response.headers,"utf-8"));
                        JSONObject obj=new JSONObject(res);
                   }catch (UnsupportedEncodingException se){
                       se.printStackTrace();
                   }catch (JSONException jsonE){
                       jsonE.printStackTrace();
                   }
                    Toast.makeText(getContext(),"Error: "+
                            error.getMessage()+"\n",Toast.LENGTH_LONG).show();

                    TranslinkFeed feeds=new TranslinkFeed("Fail to get live data at point");
                    feedsList.add(feeds);
                    feedRecAdp=new MultiViewRecAdapter(feedsList,getContext());
                    feedRecView.setAdapter(feedRecAdp);
                }else{
                    //response == null
                    Toast.makeText(getContext(),"Ok "+
                            error.getMessage()+"\n",Toast.LENGTH_LONG).show();
                }

            }
        }){
            @Override
            public Map<String,String> getHeaders() throws AuthFailureError{
                Map<String,String> headers=new HashMap<>();
                headers.put("Accept-Charset","utf-8");
                headers.put("Cache-Control","no-cache");
               // headers.put("apikey","fH8nhLCTC142J3YXmtLC");
               // headers.put("Content-Transfer-Encoding","charset=utf-8");
                headers.put("Content-Type","application/json");
                return headers;
            }
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("username","kiranofans");
                params.put("password","5149625801");
                return params;
            }
        };
        feedRequest.setShouldCache(false);
        VolleySingleton.getInstance(getContext()).addToRequestQueue(feedRequest);
    }

    private void processResponse(JSONObject response) {
        try {

            JSONObject obj = response.getJSONObject("timestampUtc");
            Toast.makeText(getContext(),"JSON Body: "+obj,Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
