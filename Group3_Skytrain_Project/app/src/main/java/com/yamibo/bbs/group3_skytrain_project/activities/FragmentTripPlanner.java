package com.yamibo.bbs.group3_skytrain_project.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.yamibo.bbs.group3_skytrain_project.R;

import java.util.Calendar;
public class FragmentTripPlanner extends Fragment_Tabs {
    private View v;
    Calendar calendar = Calendar.getInstance();
    public FragmentTripPlanner(){}
    private TimePicker timePicker;
    private DatePicker datePicker;
    private Calendar cal;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStat){
        v=inflater.inflate(R.layout.tab_trip_planner,container,false);
        return v;
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceStat){
        /*super.onViewCreated(view,savedInstanceStat);
        Button btn = (Button) view.findViewById(R.id.btnfind);
        EditText deps = (EditText)view.findViewById(R.id.clbtn);
        EditText dest = (EditText)view.findViewById(R.id.dlbtn);
*/
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String depstx = deps.getText().toString();
                String desttx = dest.getText().toString();
                String message1 = depstx;
                String message2 = desttx;
                if((message1 == null)||( message2 == null)){
                    Toast.makeText(getActivity(),"please enter city", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent1 = new Intent();
                    intent1.putExtra("Message1", message1);
                    intent1.putExtra("Message2", message2);
                    intent1.setClass(getActivity().getApplicationContext(), TripPlanShowing.class);
                    startActivity(intent1);
                }
            }
        });*/

    }
}