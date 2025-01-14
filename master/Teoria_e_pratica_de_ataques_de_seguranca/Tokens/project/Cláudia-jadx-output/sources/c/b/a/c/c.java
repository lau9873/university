package c.b.a.c;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import d.a.a.a.k;
import d.a.a.a.m.b.m;
import d.a.a.a.m.b.o;
import d.a.a.a.m.b.s;
import d.a.a.a.m.g.r;
import d.a.a.a.m.g.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
/* compiled from: Beta.java */
/* loaded from: classes.dex */
public class c extends d.a.a.a.h<Boolean> implements m {

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.a.m.a.b<String> f2961g = new d.a.a.a.m.a.b<>();

    /* renamed from: h  reason: collision with root package name */
    public final h f2962h = new h();

    /* renamed from: i  reason: collision with root package name */
    public j f2963i;

    @TargetApi(14)
    public j a(int i2, Application application) {
        if (i2 >= 14) {
            return new b(g().a(), g().c());
        }
        return new i();
    }

    @Override // d.a.a.a.m.b.m
    public Map<o.a, String> c() {
        String a2 = a(e(), h().i());
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(a2)) {
            hashMap.put(o.a.FONT_TOKEN, a2);
        }
        return hashMap;
    }

    @Override // d.a.a.a.h
    public String i() {
        return "com.crashlytics.sdk.android:beta";
    }

    @Override // d.a.a.a.h
    public String k() {
        return "1.2.4.dev";
    }

    @Override // d.a.a.a.h
    @TargetApi(14)
    public boolean n() {
        this.f2963i = a(Build.VERSION.SDK_INT, (Application) e().getApplicationContext());
        return true;
    }

    public final d.a.a.a.m.g.g o() {
        u a2 = r.d().a();
        if (a2 != null) {
            return a2.f4456f;
        }
        return null;
    }

    public String p() {
        return d.a.a.a.m.b.i.b(e(), "com.crashlytics.ApiEndpoint");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.a.a.h
    public Boolean d() {
        d.a.a.a.c.h().e("Beta", "Beta kit initializing...");
        Context e2 = e();
        o h2 = h();
        if (TextUtils.isEmpty(a(e2, h2.i()))) {
            d.a.a.a.c.h().e("Beta", "A Beta device token was not found for this app");
            return false;
        }
        d.a.a.a.c.h().e("Beta", "Beta device token is present, checking for app updates.");
        d.a.a.a.m.g.g o = o();
        d a2 = a(e2);
        if (a(o, a2)) {
            this.f2963i.a(e2, this, h2, o, a2, new d.a.a.a.m.f.d(this), new s(), new d.a.a.a.m.e.b(d.a.a.a.c.h()));
        }
        return true;
    }

    public boolean a(d.a.a.a.m.g.g gVar, d dVar) {
        return (gVar == null || TextUtils.isEmpty(gVar.f4416a) || dVar == null) ? false : true;
    }

    public final String a(Context context, String str) {
        String str2 = null;
        try {
            String a2 = this.f2961g.a(context, this.f2962h);
            if (!"".equals(a2)) {
                str2 = a2;
            }
        } catch (Exception e2) {
            d.a.a.a.c.h().c("Beta", "Failed to load the Beta device token", e2);
        }
        k h2 = d.a.a.a.c.h();
        StringBuilder sb = new StringBuilder();
        sb.append("Beta device token present: ");
        sb.append(!TextUtils.isEmpty(str2));
        h2.e("Beta", sb.toString());
        return str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r3v3, types: [d.a.a.a.k] */
    public final d a(Context context) {
        d dVar;
        Throwable th;
        InputStream inputStream;
        ?? e2 = 0;
        r2 = null;
        d dVar2 = null;
        InputStream inputStream2 = null;
        try {
            try {
                inputStream = context.getAssets().open("crashlytics-build.properties");
                if (inputStream != null) {
                    try {
                        dVar2 = d.a(inputStream);
                        d.a.a.a.c.h().e("Beta", dVar2.f2967d + " build properties: " + dVar2.f2965b + " (" + dVar2.f2964a + ") - " + dVar2.f2966c);
                    } catch (Exception e3) {
                        e = e3;
                        d dVar3 = dVar2;
                        inputStream2 = inputStream;
                        dVar = dVar3;
                        d.a.a.a.c.h().c("Beta", "Error reading Beta build properties", e);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                                return dVar;
                            } catch (IOException e4) {
                                e2 = e4;
                                d.a.a.a.c.h().c("Beta", "Error closing Beta build properties asset", e2);
                                return dVar;
                            }
                        }
                        return dVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                                d.a.a.a.c.h().c("Beta", "Error closing Beta build properties asset", e5);
                            }
                        }
                        throw th;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        d.a.a.a.c.h().c("Beta", "Error closing Beta build properties asset", e6);
                    }
                }
                return dVar2;
            } catch (Throwable th3) {
                InputStream inputStream3 = e2;
                th = th3;
                inputStream = inputStream3;
            }
        } catch (Exception e7) {
            e = e7;
            dVar = null;
        }
    }
}
