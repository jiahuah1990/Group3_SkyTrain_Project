package com.yamibo.bbs.group3_skytrain_project.activities;

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
import com.yamibo.bbs.group3_skytrain_project.models.JSONResponse;
import com.yamibo.bbs.group3_skytrain_project.models.Stop;
import com.yamibo.bbs.group3_skytrain_project.service.ServiceFactory;
import com.yamibo.bbs.group3_skytrain_project.service.TransLinkService;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NearbyActivity extends AppCompatActivity {

    private Button btn_test;
    private ArrayList<Stop> data;
    private RecyclerView mRecyclerView;
    private CardAdapter mCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        btn_test = findViewById(R.id.btn_test);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://api.translink.ca")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                TransLinkService service = retrofit.create(TransLinkService.class);
                Call<JSONResponse> call = service.getStop("fH8nhLCTC142J3YXmtLC",49.226258,-123.000436 );
                call.enqueue(new Callback<JSONResponse>() {
                    @Override
                    public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                      /*  JSONResponse jsonResponse = response.body();
                        data = new ArrayList<>(Arrays.asList(jsonResponse.getStops()));
                        mCardAdapter = new CardAdapter(data);
                        mRecyclerView.setAdapter(mCardAdapter); */
                        Toast.makeText(getApplicationContext(), "OnResponse", Toast.LENGTH_SHORT).show();

                        
                    }

                    @Override
                    public void onFailure(Call<JSONResponse> call, Throwable t) {
                        Log.d("Error",t.getMessage());
                    }
                });
            }
        });




    }
}
