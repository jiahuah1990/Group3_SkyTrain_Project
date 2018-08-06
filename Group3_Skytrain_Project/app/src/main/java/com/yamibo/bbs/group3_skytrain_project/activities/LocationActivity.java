package com.yamibo.bbs.group3_skytrain_project.activities;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.yamibo.bbs.group3_skytrain_project.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class LocationActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public static final int LOCATION_REQUEST = 500;
    ArrayList<LatLng>listpoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        listpoints = new ArrayList<>();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST);
            return;
        }
        mMap.setMyLocationEnabled(true);
mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
    @Override
    public void onMapLongClick(LatLng latLng) { // reset market when arealry  2
        if(listpoints.size()==2){
            listpoints.clear();
            mMap.clear();
        }
        //save first point select
        listpoints.add(latLng);
        // Create marker
MarkerOptions markerOptions = new MarkerOptions();
markerOptions.position(latLng);
if (listpoints.size()==1){
    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
}else{
    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
}
        mMap.addMarker(markerOptions);
        //todo request get direction code bellow
        if(listpoints.size()==2){
            //create url , request first marker to second marker
            String url = getRequestUrl(listpoints.get(0), listpoints.get(1));
        }
    }
});
    }

   private String getRequestUrl(LatLng origin, LatLng des){
//value of location
String str_org = "origin=" + origin.latitude+ "," + origin.longitude;
//value of dest
String str_des = "destination="+ des.latitude + "," +des.longitude;
//set value enable to sensor
String snsor = "sensor= false";
//find direction
       String mode = "mode=driving";
       //build full para
       String param = str_org +"g"+str_des+ "g"+snsor +"&" +mode;
       //output
       String output ="json";
       //Create URL
       String url = "http://maps.googleapis.com/maps/directions/" + output + "?" + param;
       return  url;
   }


    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case LOCATION_REQUEST:
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                mMap.setMyLocationEnabled(true);
            }break;
        }
    }
}
