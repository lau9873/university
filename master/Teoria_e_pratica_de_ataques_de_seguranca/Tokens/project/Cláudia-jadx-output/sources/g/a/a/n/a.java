package g.a.a.n;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.io.Serializable;
import org.altbeacon.beacon.BeaconManager;
/* compiled from: Callback.java */
/* loaded from: classes.dex */
public class a implements Serializable {
    public a(String str) {
    }

    public boolean a(Context context, String str, Bundle bundle) {
        if (BeaconManager.a(context).y()) {
            String str2 = str == "rangingData" ? "org.altbeacon.beacon.range_notification" : "org.altbeacon.beacon.monitor_notification";
            Intent intent = new Intent(str2);
            intent.putExtra(str, bundle);
            g.a.a.m.d.a("Callback", "attempting callback via local broadcast intent: %s", str2);
            return a.b.g.b.d.a(context).a(intent);
        }
        Intent intent2 = new Intent();
        intent2.setComponent(new ComponentName(context.getPackageName(), "org.altbeacon.beacon.BeaconIntentProcessor"));
        intent2.putExtra(str, bundle);
        g.a.a.m.d.a("Callback", "attempting callback via global broadcast intent: %s", intent2.getComponent());
        try {
            context.startService(intent2);
            return true;
        } catch (Exception e2) {
            g.a.a.m.d.b("Callback", "Failed attempting to start service: " + intent2.getComponent().flattenToString(), e2);
            return false;
        }
    }
}
