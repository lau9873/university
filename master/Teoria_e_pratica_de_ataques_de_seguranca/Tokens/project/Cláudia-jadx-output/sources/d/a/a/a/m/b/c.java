package d.a.a.a.m.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
/* compiled from: AdvertisingInfoProvider.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4233a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.a.m.f.c f4234b;

    /* compiled from: AdvertisingInfoProvider.java */
    /* loaded from: classes.dex */
    public class a extends h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f4235a;

        public a(b bVar) {
            this.f4235a = bVar;
        }

        @Override // d.a.a.a.m.b.h
        public void a() {
            b b2 = c.this.b();
            if (this.f4235a.equals(b2)) {
                return;
            }
            d.a.a.a.c.h().e("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
            c.this.c(b2);
        }
    }

    public c(Context context) {
        this.f4233a = context.getApplicationContext();
        this.f4234b = new d.a.a.a.m.f.d(context, "TwitterAdvertisingInfoPreferences");
    }

    public final void b(b bVar) {
        new Thread(new a(bVar)).start();
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void c(b bVar) {
        if (a(bVar)) {
            d.a.a.a.m.f.c cVar = this.f4234b;
            cVar.a(cVar.edit().putString("advertising_id", bVar.f4231a).putBoolean("limit_ad_tracking_enabled", bVar.f4232b));
            return;
        }
        d.a.a.a.m.f.c cVar2 = this.f4234b;
        cVar2.a(cVar2.edit().remove("advertising_id").remove("limit_ad_tracking_enabled"));
    }

    public f d() {
        return new d(this.f4233a);
    }

    public f e() {
        return new e(this.f4233a);
    }

    public b a() {
        b c2 = c();
        if (a(c2)) {
            d.a.a.a.c.h().e("Fabric", "Using AdvertisingInfo from Preference Store");
            b(c2);
            return c2;
        }
        b b2 = b();
        c(b2);
        return b2;
    }

    public final b b() {
        b a2 = d().a();
        if (!a(a2)) {
            a2 = e().a();
            if (!a(a2)) {
                d.a.a.a.c.h().e("Fabric", "AdvertisingInfo not present");
            } else {
                d.a.a.a.c.h().e("Fabric", "Using AdvertisingInfo from Service Provider");
            }
        } else {
            d.a.a.a.c.h().e("Fabric", "Using AdvertisingInfo from Reflection Provider");
        }
        return a2;
    }

    public final boolean a(b bVar) {
        return (bVar == null || TextUtils.isEmpty(bVar.f4231a)) ? false : true;
    }

    public b c() {
        return new b(this.f4234b.get().getString("advertising_id", ""), this.f4234b.get().getBoolean("limit_ad_tracking_enabled", false));
    }
}
