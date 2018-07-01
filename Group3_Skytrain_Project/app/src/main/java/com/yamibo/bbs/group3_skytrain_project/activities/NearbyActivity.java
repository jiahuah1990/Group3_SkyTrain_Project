package com.yamibo.bbs.group3_skytrain_project.activities;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.adapter.CardAdapter;
import com.yamibo.bbs.group3_skytrain_project.map.MapFragment;
import com.yamibo.bbs.group3_skytrain_project.models.Stop;
import com.yamibo.bbs.group3_skytrain_project.service.TransLinkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NearbyActivity extends AppCompatActivity {

    private Button btn_test;
    private List<Stop> data;
    private RecyclerView mRecyclerView;
    private CardAdapter mCardAdapter;
    private boolean mTwoPane = false;
    Location mCurrentLocation;
    private long UPDATE_INTERVAL = 60000;  /* 60 secs */
    private long FASTEST_INTERVAL = 5000; /* 5 secs */

    private final static String KEY_LOCATION = "location";

    /*
     * Define a request code to send to Google Play services This code is
     * returned in Activity.onActivityResult
     */
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);

        loadNearbyStops();


     /*    if(findViewById(R.id.stop_map_container) != null){
            mTwoPane = true;


           MapFragment mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.stop_map_container, mapFragment)
                    .addToBackStack(null)
                    .commit();
        }
*/

    }



    public void loadNearbyStops(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.translink.ca/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TransLinkService service = retrofit.create(TransLinkService.class);
        //TODO: Add dynemic upload of current location
        Call<List<Stop>> call = service.getStop("fH8nhLCTC142J3YXmtLC",49.226258,-123.000436);
        call.enqueue(new Callback<List<Stop>>() {
            @Override
            public void onResponse(Call<List<Stop>> call, Response<List<Stop>> response) {
                data = response.body();
                mCardAdapter = new CardAdapter(data);
                mRecyclerView.setAdapter(mCardAdapter);
                Log.d("OnResponse", "hi");
            }

            @Override
            public void onFailure(Call<List<Stop>> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}
