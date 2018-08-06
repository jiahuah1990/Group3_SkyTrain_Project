package com.yamibo.bbs.group3_skytrain_project.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.yamibo.bbs.group3_skytrain_project.R;

import org.w3c.dom.Text;

public class TripPlanShowing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_plan_showing);
        TextView  text8 = (TextView)findViewById(R.id.textView8);
        TextView  text9 = (TextView) findViewById(R.id.textView9);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String value = extras.getString("Message1");
            String valuee = extras.getString("Message2");
            text8.setText(value);
            text9.setText(valuee);
        }
    }
}
