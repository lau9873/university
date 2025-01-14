package g.a.a.n;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
/* compiled from: RangingData.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final Collection<g.a.a.c> f6118a;

    /* renamed from: b  reason: collision with root package name */
    public final g.a.a.j f6119b;

    public h(Collection<g.a.a.c> collection, g.a.a.j jVar) {
        synchronized (collection) {
            this.f6118a = collection;
        }
        this.f6119b = jVar;
    }

    public Collection<g.a.a.c> a() {
        return this.f6118a;
    }

    public g.a.a.j b() {
        return this.f6119b;
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("region", this.f6119b);
        ArrayList arrayList = new ArrayList();
        for (g.a.a.c cVar : this.f6118a) {
            arrayList.add(cVar);
        }
        bundle.putSerializable("beacons", arrayList);
        return bundle;
    }

    public static h a(Bundle bundle) {
        bundle.setClassLoader(g.a.a.j.class.getClassLoader());
        return new h(bundle.get("beacons") != null ? (Collection) bundle.getSerializable("beacons") : null, bundle.get("region") != null ? (g.a.a.j) bundle.getSerializable("region") : null);
    }
}
