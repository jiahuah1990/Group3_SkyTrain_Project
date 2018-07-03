package com.yamibo.bbs.group3_skytrain_project.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.map.MapFragment;

public class StopDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_detail);

        if (savedInstanceState == null) {
            // Get the selected song position from the intent extra.
            int selectedStop =
                    getIntent().getIntExtra("stopNo", 0);
            // Create instance of the detail fragment and add it to the activity
            // using a fragment transaction.
           MapFragment fragment =
                    MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.stop_map_container, fragment)
                    .commit();
        }
    }
}
