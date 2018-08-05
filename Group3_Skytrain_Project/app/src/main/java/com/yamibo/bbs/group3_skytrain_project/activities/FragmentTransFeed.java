package com.yamibo.bbs.group3_skytrain_project.activities;

import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.gson.JsonArray;
import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.adapter.MultiViewRecAdapter;
import com.yamibo.bbs.group3_skytrain_project.models.BaseModel;
import com.yamibo.bbs.group3_skytrain_project.models.TranslinkFeed;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utils.SimpleXmlRequest;
import Utils.VolleySingleton;

import static Utils.AppConstants.*;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class FragmentTransFeed extends android.support.v4.app.Fragment {
    private static String dataAtPointURL =
            "https://rtdsapi.translink.ca/rtdsapi/v1/LiveDataAtPoint?apikey=fH8nhLCTC142J3YXmtLC&x=-123.04550170898438&y=49.23194729854554&z=12&types=6";
    private static final String RSS_EVENT_FEED_LINK="https://www.translink.ca/en/Utilities/TL-Event-RSS-Feed.aspx";
    private static final String RSS_NEWSFEED_LINK="https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Fwww.translink.ca%2Fen%2FUtilities%2FWhatsNewRSS.aspx";
    private static final String RSS_MEDIA_LINK="https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Fwww.translink.ca%2FUtilities%2FMedia-RSS.aspx";

    private static RecyclerView feedRecView,mediaRecView,eventRecView;
    private static View v;
    private static MultiViewRecAdapter feedRecAdp,feedRecAdp1,feedRecAdp2;
    private static ImageView icImgView;

    private static List<BaseModel> feedsList;
    private static ProgressDialog dialog;
    private static ProgressBar progressBar;

    private static LocationManager locationMgr;
    private static FusedLocationProviderClient client;
    private static String locationInfo;
    private static double latitude,longtitude;
    public FragmentTransFeed() {
    }//Empty Constructor

    @Override
    public View onCreateView
            (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_trans_feed, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        feedsList = new ArrayList<>();
        feedRecView = (RecyclerView) view.findViewById(R.id.feed_recView);
        mediaRecView=(RecyclerView) view.findViewById(R.id.media_feed_rec);
        eventRecView=(RecyclerView) view.findViewById(R.id.event_feed_rec);

        feedRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        mediaRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        eventRecView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Location handling
        requestPermission();
        client = LocationServices.getFusedLocationProviderClient(getContext());
        dialog = new ProgressDialog(getContext());
        loadRSS();
        getMediaFeed();
    }
    private void loadRSS(){
        JsonObjectRequest request=new JsonObjectRequest
                (Request.Method.GET, RSS_NEWSFEED_LINK, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("RESPONSE",response.toString());
                        try {
                            //JSONObject feedObj=response.getJSONObject("feed");
                            JSONArray itemArr=response.getJSONArray("items");
                            for(int i=0;i<itemArr.length();i++){
                                JSONObject itemObj=itemArr.getJSONObject(i);
                                String titles=itemObj.getString("title");
                                String publishDate=itemObj.getString("pubDate");
                                //String link=itemObj.getString("link");
                                String content=itemObj.getString("content");
                                JSONArray categories=itemObj.getJSONArray("categories");
                                String category=categories.getString(0);
                                if(category.equals("News")){
                                        //icImgView.setImageResource(R.drawable.ic_news);
                                        TranslinkFeed feed1=new TranslinkFeed(titles,"Publish Date: "
                                                +publishDate,content,category);
                                        feedsList.add(feed1);
                                }
                            }
                            feedRecAdp=new MultiViewRecAdapter(feedsList,getContext());
                            feedRecView.setAdapter(feedRecAdp);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    Log.d("ERROR",error.getMessage());
            }
        });
        VolleySingleton.getInstance(getContext()).addToRequestQueue(request);
    }

    private void getMediaFeed() {
        JsonObjectRequest feedRequest = new JsonObjectRequest(Request.Method.GET, RSS_MEDIA_LINK,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                dialog.setMessage("Loading...");
                dialog.show();
                try {
                    JSONArray items=response.getJSONArray("items");
                    for(int i=0;i<items.length();i++){
                        JSONObject itemsObj=items.getJSONObject(i);

                        TranslinkFeed feeds = new TranslinkFeed(itemsObj.getString("title"),
                                "Publish Date: "+itemsObj.getString("pubDate"),
                                itemsObj.getString("content"), itemsObj.getString("categories"));
                        feedsList.add(feeds);
                    }
                    feedRecAdp1 = new MultiViewRecAdapter(feedsList, getContext());
                    mediaRecView.setAdapter(feedRecAdp1);
                    dialog.dismiss();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.getMessage());
            }
        });
        VolleySingleton.getInstance(getContext()).addToRequestQueue(feedRequest);
    }
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(getActivity(), ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        client.getLastLocation().addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    latitude=location.getLatitude();
                    longtitude=location.getLongitude();
                    locationInfo=location.toString();
                }
            }
        });
    }
    private void requestPermission(){
        ActivityCompat.requestPermissions(getActivity(),new String[]{ACCESS_FINE_LOCATION},
                        LOCATION_PERMISSION_REQUEST_CODE);
    }
}
