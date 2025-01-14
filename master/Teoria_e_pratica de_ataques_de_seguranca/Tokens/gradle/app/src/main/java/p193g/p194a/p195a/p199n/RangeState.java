package p193g.p194a.p195a.p199n;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import p193g.p194a.p195a.Beacon;
import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.a.n.f */
/* loaded from: classes.dex */
public class RangeState implements Serializable {

    /* renamed from: c */
    public static boolean f8571c = false;

    /* renamed from: a */
    public C1836a f8572a;

    /* renamed from: b */
    public Map<Beacon, RangedBeacon> f8573b = new HashMap();

    public RangeState(C1836a c1836a) {
        this.f8572a = c1836a;
    }

    /* renamed from: c */
    public static boolean m2381c() {
        return f8571c;
    }

    /* renamed from: a */
    public void m2384a(Beacon beacon) {
        RangedBeacon rangedBeacon = this.f8573b.get(beacon);
        if (rangedBeacon != null) {
            if (LogManager.m2433a()) {
                LogManager.m2432a("RangeState", "adding %s to existing range for: %s", beacon, rangedBeacon);
            }
            rangedBeacon.m2379a(beacon);
            return;
        }
        if (LogManager.m2433a()) {
            LogManager.m2432a("RangeState", "adding %s to new rangedBeacon", beacon);
        }
        this.f8573b.put(beacon, new RangedBeacon(beacon));
    }

    /* renamed from: b */
    public C1836a m2382b() {
        return this.f8572a;
    }

    /* renamed from: a */
    public synchronized Collection<Beacon> m2385a() {
        ArrayList arrayList;
        HashMap hashMap = new HashMap();
        arrayList = new ArrayList();
        synchronized (this.f8573b) {
            for (Beacon beacon : this.f8573b.keySet()) {
                RangedBeacon rangedBeacon = this.f8573b.get(beacon);
                if (rangedBeacon != null) {
                    if (rangedBeacon.m2372f()) {
                        rangedBeacon.m2380a();
                        if (!rangedBeacon.m2371g()) {
                            arrayList.add(rangedBeacon.m2376b());
                        }
                    }
                    if (!rangedBeacon.m2371g()) {
                        if (!f8571c || rangedBeacon.m2373e()) {
                            rangedBeacon.m2377a(false);
                        }
                        hashMap.put(beacon, rangedBeacon);
                    } else {
                        LogManager.m2432a("RangeState", "Dumping beacon from RangeState because it has no recent measurements.", new Object[0]);
                    }
                }
            }
            this.f8573b = hashMap;
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m2383a(boolean z) {
        f8571c = z;
    }
}
