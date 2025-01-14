package g.a.a.n;

import android.os.Bundle;
/* compiled from: MonitoringData.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f6101a;

    /* renamed from: b  reason: collision with root package name */
    public final g.a.a.j f6102b;

    public d(boolean z, g.a.a.j jVar) {
        this.f6101a = z;
        this.f6102b = jVar;
    }

    public g.a.a.j a() {
        return this.f6102b;
    }

    public boolean b() {
        return this.f6101a;
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("region", this.f6102b);
        bundle.putBoolean("inside", this.f6101a);
        return bundle;
    }

    public static d a(Bundle bundle) {
        bundle.setClassLoader(g.a.a.j.class.getClassLoader());
        return new d(Boolean.valueOf(bundle.getBoolean("inside")).booleanValue(), bundle.get("region") != null ? (g.a.a.j) bundle.getSerializable("region") : null);
    }
}
