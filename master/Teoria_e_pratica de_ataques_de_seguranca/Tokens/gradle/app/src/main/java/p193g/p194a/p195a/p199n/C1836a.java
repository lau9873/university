package p193g.p194a.p195a.p199n;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.io.Serializable;
import org.altbeacon.beacon.BeaconManager;
import p000a.p006b.p030g.p032b.LocalBroadcastManager;
import p193g.p194a.p195a.p198m.LogManager;

/* compiled from: Callback.java */
/* renamed from: g.a.a.n.a */
/* loaded from: classes.dex */
public class C1836a implements Serializable {
    public C1836a(String str) {
    }

    /* renamed from: a */
    public boolean m2419a(Context context, String str, Bundle bundle) {
        if (BeaconManager.m477a(context).m434y()) {
            String str2 = str == "rangingData" ? "org.altbeacon.beacon.range_notification" : "org.altbeacon.beacon.monitor_notification";
            Intent intent = new Intent(str2);
            intent.putExtra(str, bundle);
            LogManager.m2432a("Callback", "attempting callback via local broadcast intent: %s", str2);
            return LocalBroadcastManager.m10011a(context).m10010a(intent);
        }
        Intent intent2 = new Intent();
        intent2.setComponent(new ComponentName(context.getPackageName(), "org.altbeacon.beacon.BeaconIntentProcessor"));
        intent2.putExtra(str, bundle);
        LogManager.m2432a("Callback", "attempting callback via global broadcast intent: %s", intent2.getComponent());
        try {
            context.startService(intent2);
            return true;
        } catch (Exception e) {
            LogManager.m2430b("Callback", "Failed attempting to start service: " + intent2.getComponent().flattenToString(), e);
            return false;
        }
    }
}
