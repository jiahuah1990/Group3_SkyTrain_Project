package com.yamibo.bbs.group3_skytrain_project.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.adapter.CardAdapter;
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
        });
    }
}
