package com.yamibo.bbs.group3_skytrain_project.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.map.MapFragment;

public class StopDetailActivity extends AppCompatActivity {

    private TextView stop_no_tv;
    private TextView stop_name_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_detail);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Stop Details");
        Intent intent = getIntent();
        String number = intent.getStringExtra("stopNo");
        String name = intent.getStringExtra("stopName");
        stop_no_tv = findViewById(R.id.stop_no_label);
        stop_name_tv = findViewById(R.id.stop_name);
        stop_no_tv.setText(number);
        stop_name_tv.setText(name);
        if (savedInstanceState == null) {
            // Get the selected song position from the intent extra.
            int selectedStop =
                    getIntent().getIntExtra("stopNo", 0);
            // Create instance of the detail fragment and add it to the activity
            // using a fragment transaction.



        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
