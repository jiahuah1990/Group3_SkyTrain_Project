package Utils;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static Utils.RecViewConstants.ViewType.FEED_TYPE;
import static Utils.RecViewConstants.ViewType.SCHEDULE;
import static Utils.RecViewConstants.ViewType.STOPS_TYPE;

public class RecViewConstants {
/***Class declaring different type of recyclerView content*/
    @IntDef({STOPS_TYPE,FEED_TYPE,SCHEDULE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewType{
        int STOPS_TYPE=100;
        int FEED_TYPE=200;
        int SCHEDULE=400;
        //can add more View Types
    }
}