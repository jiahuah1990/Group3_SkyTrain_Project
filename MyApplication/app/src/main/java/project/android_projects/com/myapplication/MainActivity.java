package project.android_projects.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private static String dataAtPointURL =
            "https://rtdsapi.translink.ca/rtdsapi/v1/LiveDataTimestampUtc?apikey=fH8nhLCTC142J3YXmtLC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getTranslinkFeed();
    }
    private void getTranslinkFeed() {
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, dataAtPointURL,
                null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //  JSONObject jsonObj=new JSONObject(response);
                try {
                    String timeStampUTC=response.getString("timestampUtc");
                    Log.d("RES",timeStampUTC);
                    Toast.makeText(getApplicationContext(),timeStampUTC, Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),"Error: "+
                        error.getMessage(),Toast.LENGTH_LONG).show();
                Log.e("ERROR", "Error occurred: ", error);
            }
        });
        VolleySingleton.getInstance(this).addToRequestQueue(request);
    }
}
