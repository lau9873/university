package p193g.p194a.p195a.p199n;

import android.os.Bundle;
import p193g.p194a.p195a.Region;

/* renamed from: g.a.a.n.d */
/* loaded from: classes.dex */
public class MonitoringData {

    /* renamed from: a */
    public final boolean f8563a;

    /* renamed from: b */
    public final Region f8564b;

    public MonitoringData(boolean z, Region region) {
        this.f8563a = z;
        this.f8564b = region;
    }

    /* renamed from: a */
    public Region m2411a() {
        return this.f8564b;
    }

    /* renamed from: b */
    public boolean m2409b() {
        return this.f8563a;
    }

    /* renamed from: c */
    public Bundle m2408c() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("region", this.f8564b);
        bundle.putBoolean("inside", this.f8563a);
        return bundle;
    }

    /* renamed from: a */
    public static MonitoringData m2410a(Bundle bundle) {
        bundle.setClassLoader(Region.class.getClassLoader());
        return new MonitoringData(Boolean.valueOf(bundle.getBoolean("inside")).booleanValue(), bundle.get("region") != null ? (Region) bundle.getSerializable("region") : null);
    }
}
