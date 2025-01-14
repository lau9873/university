package g.a.a;

import android.content.Context;
import android.content.Intent;
import java.util.Collection;
import java.util.Set;
import org.altbeacon.beacon.BeaconManager;
/* compiled from: IntentHandler.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6065a = "g";

    public void a(Context context, Intent intent) {
        g.a.a.n.d dVar;
        g.a.a.n.h hVar = null;
        if (intent == null || intent.getExtras() == null) {
            dVar = null;
        } else {
            dVar = intent.getExtras().getBundle("monitoringData") != null ? g.a.a.n.d.a(intent.getExtras().getBundle("monitoringData")) : null;
            if (intent.getExtras().getBundle("rangingData") != null) {
                hVar = g.a.a.n.h.a(intent.getExtras().getBundle("rangingData"));
            }
        }
        if (hVar != null) {
            g.a.a.m.d.a(f6065a, "got ranging data", new Object[0]);
            if (hVar.a() == null) {
                g.a.a.m.d.d(f6065a, "Ranging data has a null beacons collection", new Object[0]);
            }
            Set<i> s = BeaconManager.a(context).s();
            Collection<c> a2 = hVar.a();
            if (s != null) {
                for (i iVar : s) {
                    iVar.didRangeBeaconsInRegion(a2, hVar.b());
                }
            } else {
                g.a.a.m.d.a(f6065a, "but ranging notifier is null, so we're dropping it.", new Object[0]);
            }
            i j = BeaconManager.a(context).j();
            if (j != null) {
                j.didRangeBeaconsInRegion(a2, hVar.b());
            }
        }
        if (dVar != null) {
            g.a.a.m.d.a(f6065a, "got monitoring data", new Object[0]);
            Set<h> p = BeaconManager.a(context).p();
            if (p != null) {
                for (h hVar2 : p) {
                    g.a.a.m.d.a(f6065a, "Calling monitoring notifier: %s", hVar2);
                    j a3 = dVar.a();
                    Integer valueOf = Integer.valueOf(dVar.b() ? 1 : 0);
                    hVar2.didDetermineStateForRegion(valueOf.intValue(), a3);
                    g.a.a.n.e.a(context).a(a3, valueOf);
                    if (dVar.b()) {
                        hVar2.didEnterRegion(dVar.a());
                    } else {
                        hVar2.didExitRegion(dVar.a());
                    }
                }
            }
        }
    }
}
