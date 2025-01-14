package d.a.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import d.a.a.a.m.g.o;
import d.a.a.a.m.g.r;
import d.a.a.a.m.g.u;
import d.a.a.a.m.g.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
/* compiled from: Onboarding.java */
/* loaded from: classes.dex */
public class l extends h<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.a.m.e.d f4220g = new d.a.a.a.m.e.b();

    /* renamed from: h  reason: collision with root package name */
    public PackageManager f4221h;

    /* renamed from: i  reason: collision with root package name */
    public String f4222i;
    public PackageInfo j;
    public String k;
    public String m;
    public String n;
    public String o;
    public String p;
    public final Future<Map<String, j>> q;
    public final Collection<h> r;

    public l(Future<Map<String, j>> future, Collection<h> collection) {
        this.q = future;
        this.r = collection;
    }

    public Map<String, j> a(Map<String, j> map, Collection<h> collection) {
        for (h hVar : collection) {
            if (!map.containsKey(hVar.i())) {
                map.put(hVar.i(), new j(hVar.i(), hVar.k(), "binary"));
            }
        }
        return map;
    }

    public final boolean b(String str, d.a.a.a.m.g.e eVar, Collection<j> collection) {
        return new d.a.a.a.m.g.i(this, o(), eVar.f4413b, this.f4220g).a(a(o.a(e(), str), collection));
    }

    public final boolean c(String str, d.a.a.a.m.g.e eVar, Collection<j> collection) {
        return a(eVar, o.a(e(), str), collection);
    }

    @Override // d.a.a.a.h
    public String i() {
        return "io.fabric.sdk.android:fabric";
    }

    @Override // d.a.a.a.h
    public String k() {
        return "1.3.16.dev";
    }

    @Override // d.a.a.a.h
    public boolean n() {
        try {
            this.n = h().i();
            this.f4221h = e().getPackageManager();
            this.f4222i = e().getPackageName();
            this.j = this.f4221h.getPackageInfo(this.f4222i, 0);
            this.k = Integer.toString(this.j.versionCode);
            this.m = this.j.versionName == null ? "0.0" : this.j.versionName;
            this.o = this.f4221h.getApplicationLabel(e().getApplicationInfo()).toString();
            this.p = Integer.toString(e().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            c.h().c("Fabric", "Failed init", e2);
            return false;
        }
    }

    public String o() {
        return d.a.a.a.m.b.i.b(e(), "com.crashlytics.ApiEndpoint");
    }

    public final u p() {
        try {
            r d2 = r.d();
            d2.a(this, this.f4215e, this.f4220g, this.k, this.m, o());
            d2.b();
            return r.d().a();
        } catch (Exception e2) {
            c.h().c("Fabric", "Error dealing with settings", e2);
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.a.a.h
    public Boolean d() {
        Map<String, j> hashMap;
        boolean a2;
        String c2 = d.a.a.a.m.b.i.c(e());
        u p = p();
        if (p != null) {
            try {
                if (this.q != null) {
                    hashMap = this.q.get();
                } else {
                    hashMap = new HashMap<>();
                }
                a(hashMap, this.r);
                a2 = a(c2, p.f4451a, hashMap.values());
            } catch (Exception e2) {
                c.h().c("Fabric", "Error performing auto configuration.", e2);
            }
            return Boolean.valueOf(a2);
        }
        a2 = false;
        return Boolean.valueOf(a2);
    }

    public final boolean a(String str, d.a.a.a.m.g.e eVar, Collection<j> collection) {
        if ("new".equals(eVar.f4412a)) {
            if (b(str, eVar, collection)) {
                return r.d().c();
            }
            c.h().c("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        } else if ("configured".equals(eVar.f4412a)) {
            return r.d().c();
        } else {
            if (eVar.f4415d) {
                c.h().e("Fabric", "Server says an update is required - forcing a full App update.");
                c(str, eVar, collection);
            }
            return true;
        }
    }

    public final boolean a(d.a.a.a.m.g.e eVar, o oVar, Collection<j> collection) {
        return new z(this, o(), eVar.f4413b, this.f4220g).a(a(oVar, collection));
    }

    public final d.a.a.a.m.g.d a(o oVar, Collection<j> collection) {
        Context e2 = e();
        return new d.a.a.a.m.g.d(new d.a.a.a.m.b.g().c(e2), h().e(), this.m, this.k, d.a.a.a.m.b.i.a(d.a.a.a.m.b.i.n(e2)), this.o, d.a.a.a.m.b.l.a(this.n).b(), this.p, "0", oVar, collection);
    }
}
