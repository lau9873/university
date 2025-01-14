package p193g.p194a.p195a.p199n;

import java.io.Serializable;
import java.util.HashMap;
import p193g.p194a.p195a.Beacon;

/* renamed from: g.a.a.n.c */
/* loaded from: classes.dex */
public class ExtraDataBeaconTracker implements Serializable {

    /* renamed from: a */
    public final HashMap<String, HashMap<Integer, Beacon>> f8561a;

    /* renamed from: b */
    public final boolean f8562b;

    public ExtraDataBeaconTracker() {
        this(true);
    }

    /* renamed from: a */
    public final String m2415a(Beacon beacon) {
        if (this.f8562b) {
            return beacon.m2506b() + beacon.m2495j();
        }
        return beacon.m2506b();
    }

    /* renamed from: b */
    public synchronized Beacon m2414b(Beacon beacon) {
        if (beacon.m2492m() || beacon.m2495j() != -1) {
            beacon = m2413c(beacon);
        }
        return beacon;
    }

    /* renamed from: c */
    public final Beacon m2413c(Beacon beacon) {
        if (beacon.m2493l()) {
            m2412d(beacon);
            return null;
        }
        String m2415a = m2415a(beacon);
        HashMap<Integer, Beacon> hashMap = this.f8561a.get(m2415a);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        } else {
            beacon.m2508a(hashMap.values().iterator().next().m2499f());
        }
        hashMap.put(Integer.valueOf(beacon.hashCode()), beacon);
        this.f8561a.put(m2415a, hashMap);
        return beacon;
    }

    /* renamed from: d */
    public final void m2412d(Beacon beacon) {
        HashMap<Integer, Beacon> hashMap = this.f8561a.get(m2415a(beacon));
        if (hashMap != null) {
            for (Beacon beacon2 : hashMap.values()) {
                beacon2.m2503c(beacon.m2496i());
                beacon2.m2508a(beacon.m2502d());
            }
        }
    }

    public ExtraDataBeaconTracker(boolean z) {
        this.f8561a = new HashMap<>();
        this.f8562b = z;
    }
}
