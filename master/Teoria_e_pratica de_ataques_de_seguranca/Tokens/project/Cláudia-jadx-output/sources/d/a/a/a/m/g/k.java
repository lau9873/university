package d.a.a.a.m.g;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import org.json.JSONObject;
/* compiled from: DefaultSettingsController.java */
/* loaded from: classes.dex */
public class k implements t {

    /* renamed from: a  reason: collision with root package name */
    public final x f4419a;

    /* renamed from: b  reason: collision with root package name */
    public final w f4420b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.a.m.b.k f4421c;

    /* renamed from: d  reason: collision with root package name */
    public final h f4422d;

    /* renamed from: e  reason: collision with root package name */
    public final y f4423e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.a.h f4424f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.a.m.f.c f4425g;

    public k(d.a.a.a.h hVar, x xVar, d.a.a.a.m.b.k kVar, w wVar, h hVar2, y yVar) {
        this.f4424f = hVar;
        this.f4419a = xVar;
        this.f4421c = kVar;
        this.f4420b = wVar;
        this.f4422d = hVar2;
        this.f4423e = yVar;
        this.f4425g = new d.a.a.a.m.f.d(this.f4424f);
    }

    @Override // d.a.a.a.m.g.t
    public u a() {
        return a(s.USE_CACHE);
    }

    public final u b(s sVar) {
        u uVar = null;
        try {
            if (!s.SKIP_CACHE_LOOKUP.equals(sVar)) {
                JSONObject a2 = this.f4422d.a();
                if (a2 != null) {
                    u a3 = this.f4420b.a(this.f4421c, a2);
                    if (a3 != null) {
                        a(a2, "Loaded cached settings: ");
                        long a4 = this.f4421c.a();
                        if (!s.IGNORE_CACHE_EXPIRATION.equals(sVar) && a3.a(a4)) {
                            d.a.a.a.c.h().e("Fabric", "Cached settings have expired.");
                        }
                        try {
                            d.a.a.a.c.h().e("Fabric", "Returning cached settings.");
                            uVar = a3;
                        } catch (Exception e2) {
                            e = e2;
                            uVar = a3;
                            d.a.a.a.c.h().c("Fabric", "Failed to get cached settings", e);
                            return uVar;
                        }
                    } else {
                        d.a.a.a.c.h().c("Fabric", "Failed to transform cached settings data.", null);
                    }
                } else {
                    d.a.a.a.c.h().e("Fabric", "No cached settings data found.");
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        return uVar;
    }

    public String c() {
        return d.a.a.a.m.b.i.a(d.a.a.a.m.b.i.n(this.f4424f.e()));
    }

    public String d() {
        return this.f4425g.get().getString("existing_instance_identifier", "");
    }

    @Override // d.a.a.a.m.g.t
    public u a(s sVar) {
        JSONObject a2;
        u uVar = null;
        try {
            if (!d.a.a.a.c.i() && !b()) {
                uVar = b(sVar);
            }
            if (uVar == null && (a2 = this.f4423e.a(this.f4419a)) != null) {
                uVar = this.f4420b.a(this.f4421c, a2);
                this.f4422d.a(uVar.f4457g, a2);
                a(a2, "Loaded settings: ");
                a(c());
            }
            return uVar == null ? b(s.IGNORE_CACHE_EXPIRATION) : uVar;
        } catch (Exception e2) {
            d.a.a.a.c.h().c("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", e2);
            return null;
        }
    }

    public final void a(JSONObject jSONObject, String str) {
        d.a.a.a.k h2 = d.a.a.a.c.h();
        h2.e("Fabric", str + jSONObject.toString());
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean a(String str) {
        SharedPreferences.Editor edit = this.f4425g.edit();
        edit.putString("existing_instance_identifier", str);
        return this.f4425g.a(edit);
    }

    public boolean b() {
        return !d().equals(c());
    }
}
