package com.yamibo.bbs.group3_skytrain_project.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.activities.AppBaseActivity;

public class BusStopNoActivities extends AppBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_stop_no);
        Button searchbtn =findViewById(R.id.search1);
        EditText inputtext = findViewById(R.id.inputstop);


        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {}


        });



    }
}
