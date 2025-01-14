package p193g.p194a.p195a.p199n;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import p193g.p194a.p195a.Beacon;
import p193g.p194a.p195a.Region;

/* renamed from: g.a.a.n.h */
/* loaded from: classes.dex */
public class RangingData {

    /* renamed from: a */
    public final Collection<Beacon> f8580a;

    /* renamed from: b */
    public final Region f8581b;

    public RangingData(Collection<Beacon> collection, Region region) {
        synchronized (collection) {
            this.f8580a = collection;
        }
        this.f8581b = region;
    }

    /* renamed from: a */
    public Collection<Beacon> m2370a() {
        return this.f8580a;
    }

    /* renamed from: b */
    public Region m2368b() {
        return this.f8581b;
    }

    /* renamed from: c */
    public Bundle m2367c() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("region", this.f8581b);
        ArrayList arrayList = new ArrayList();
        for (Beacon beacon : this.f8580a) {
            arrayList.add(beacon);
        }
        bundle.putSerializable("beacons", arrayList);
        return bundle;
    }

    /* renamed from: a */
    public static RangingData m2369a(Bundle bundle) {
        bundle.setClassLoader(Region.class.getClassLoader());
        return new RangingData(bundle.get("beacons") != null ? (Collection) bundle.getSerializable("beacons") : null, bundle.get("region") != null ? (Region) bundle.getSerializable("region") : null);
    }
}
