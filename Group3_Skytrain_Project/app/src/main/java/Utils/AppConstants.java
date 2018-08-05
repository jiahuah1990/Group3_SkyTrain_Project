package Utils;

import android.app.Application;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AppConstants extends AppCompatActivity{
    //Location constants
    Location location;
    private static double latitude,longtitude;
    public static double X_VALUE= latitude;
    public static double Y_VALUE= longtitude;
    public static int LOCATION_REFRESH_TIME=4000;
    public static int LOCATION_REFRESH_MINMUM_DISTANCE=10;
    public static int LOCATION_PERMISSION_REQUEST_CODE=1;

    public static int NOT_FOUND_RESPONSE_CODE = 404;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(location!=null){
            latitude=location.getLatitude();
            longtitude=location.getLatitude();
        }

    }
}
