package com.yamibo.bbs.group3_skytrain_project.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.yamibo.bbs.group3_skytrain_project.R;

public class TripPlanShowing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_plan_showing);
        TextView  text8 = findViewById(R.id.textView8);
        TextView  text9 = findViewById(R.id.textView9);
        TextView textView16 = findViewById(R.id.textView16);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String value = extras.getString("Message1");
            String valuee = extras.getString("Message2");
            String valedate = extras.getString("Message3");
            text8.setText(value);
            text9.setText(valuee);
            textView16.setText(valedate);
        }
    }
}
