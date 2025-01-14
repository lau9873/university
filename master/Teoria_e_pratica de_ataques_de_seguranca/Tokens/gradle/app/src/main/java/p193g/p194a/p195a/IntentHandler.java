package p193g.p194a.p195a;

import android.content.Context;
import android.content.Intent;
import java.util.Collection;
import java.util.Set;
import org.altbeacon.beacon.BeaconManager;
import p193g.p194a.p195a.p198m.LogManager;
import p193g.p194a.p195a.p199n.MonitoringData;
import p193g.p194a.p195a.p199n.MonitoringStatus;
import p193g.p194a.p195a.p199n.RangingData;

/* renamed from: g.a.a.g */
/* loaded from: classes.dex */
public class IntentHandler {

    /* renamed from: a */
    public static final String f8527a = "g";

    /* renamed from: a */
    public void m2473a(Context context, Intent intent) {
        MonitoringData monitoringData;
        RangingData rangingData = null;
        if (intent == null || intent.getExtras() == null) {
            monitoringData = null;
        } else {
            monitoringData = intent.getExtras().getBundle("monitoringData") != null ? MonitoringData.m2410a(intent.getExtras().getBundle("monitoringData")) : null;
            if (intent.getExtras().getBundle("rangingData") != null) {
                rangingData = RangingData.m2369a(intent.getExtras().getBundle("rangingData"));
            }
        }
        if (rangingData != null) {
            LogManager.m2432a(f8527a, "got ranging data", new Object[0]);
            if (rangingData.m2370a() == null) {
                LogManager.m2427d(f8527a, "Ranging data has a null beacons collection", new Object[0]);
            }
            Set<RangeNotifier> m440s = BeaconManager.m477a(context).m440s();
            Collection<Beacon> m2370a = rangingData.m2370a();
            if (m440s != null) {
                for (RangeNotifier rangeNotifier : m440s) {
                    rangeNotifier.didRangeBeaconsInRegion(m2370a, rangingData.m2368b());
                }
            } else {
                LogManager.m2432a(f8527a, "but ranging notifier is null, so we're dropping it.", new Object[0]);
            }
            RangeNotifier m449j = BeaconManager.m477a(context).m449j();
            if (m449j != null) {
                m449j.didRangeBeaconsInRegion(m2370a, rangingData.m2368b());
            }
        }
        if (monitoringData != null) {
            LogManager.m2432a(f8527a, "got monitoring data", new Object[0]);
            Set<MonitorNotifier> m443p = BeaconManager.m477a(context).m443p();
            if (m443p != null) {
                for (MonitorNotifier monitorNotifier : m443p) {
                    LogManager.m2432a(f8527a, "Calling monitoring notifier: %s", monitorNotifier);
                    Region m2411a = monitoringData.m2411a();
                    Integer valueOf = Integer.valueOf(monitoringData.m2409b() ? 1 : 0);
                    monitorNotifier.didDetermineStateForRegion(valueOf.intValue(), m2411a);
                    MonitoringStatus.m2405a(context).m2401a(m2411a, valueOf);
                    if (monitoringData.m2409b()) {
                        monitorNotifier.didEnterRegion(monitoringData.m2411a());
                    } else {
                        monitorNotifier.didExitRegion(monitoringData.m2411a());
                    }
                }
            }
        }
    }
}
