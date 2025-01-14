package pt.card4b.backendbeacons;

import android.os.ParcelUuid;
import android.support.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class Constants {
    public static final String BROADCAST_ACTION = "broadcast_action";
    public static final String DEBUG_ACTIVITY_DECISION = "debug_activity_decision";
    public static final String DETECTED_ACTIVITY = "on_trip_detected_activity";
    public static final long DETECTION_INTERVAL_IN_MILLISECONDS = 500;
    public static final int REQUEST_ENABLE_BLUETOOTH = 1;
    public static final int REQUEST_ENABLE_COARSE_LOCATION = 2;
    public static final int REQUEST_ENABLE_NFC = 4;
    public static final int REQUEST_ENABLE_WRITE_EXTERNAL_STORAGE = 3;
    public static final ParcelUuid SERVICE_UUID = ParcelUuid.fromString("0000b81d-0000-1000-8000-00805f9b34fb");
    public static final int[] MONITORED_ACTIVITIES = {3, 2, 7, 8, 1, 0, 5, 4};

    public static String getActivityString(int i) {
        switch (i) {
            case 0:
                return "IN_VEHICLE";
            case 1:
                return "ON_BICYCLE";
            case 2:
                return "ON_FOOT";
            case 3:
                return "STILL";
            case 4:
                return "UNKNOWN";
            case 5:
                return "TILTING";
            case 6:
            default:
                return "Unidentifiable activity: " + i;
            case 7:
                return "WALKING";
            case 8:
                return "RUNNING";
        }
    }
}
