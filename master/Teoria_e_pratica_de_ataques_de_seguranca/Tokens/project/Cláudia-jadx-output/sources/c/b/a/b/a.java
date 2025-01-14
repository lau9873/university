package c.b.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import d.a.a.a.m.b.j;
import java.io.File;
/* compiled from: Answers.java */
/* loaded from: classes.dex */
public class a extends d.a.a.a.h<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public u f2850g;

    public static a p() {
        return (a) d.a.a.a.c.a(a.class);
    }

    public void a(k kVar) {
        if (kVar != null) {
            u uVar = this.f2850g;
            if (uVar != null) {
                uVar.a(kVar);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    @Override // d.a.a.a.h
    public String i() {
        return "com.crashlytics.sdk.android:answers";
    }

    @Override // d.a.a.a.h
    public String k() {
        return "1.3.12.dev";
    }

    @Override // d.a.a.a.h
    @SuppressLint({"NewApi"})
    public boolean n() {
        long lastModified;
        try {
            Context e2 = e();
            PackageManager packageManager = e2.getPackageManager();
            String packageName = e2.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String num = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (Build.VERSION.SDK_INT >= 9) {
                lastModified = packageInfo.firstInstallTime;
            } else {
                lastModified = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.f2850g = u.a(this, e2, h(), num, str, lastModified);
            this.f2850g.c();
            return true;
        } catch (Exception e3) {
            d.a.a.a.c.h().c("Answers", "Error retrieving app properties", e3);
            return false;
        }
    }

    public String o() {
        return d.a.a.a.m.b.i.b(e(), "com.crashlytics.ApiEndpoint");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.a.a.h
    public Boolean d() {
        try {
            d.a.a.a.m.g.u a2 = d.a.a.a.m.g.r.d().a();
            if (a2 == null) {
                d.a.a.a.c.h().c("Answers", "Failed to retrieve settings");
                return false;
            } else if (a2.f4454d.f4428c) {
                d.a.a.a.c.h().e("Answers", "Analytics collection enabled");
                this.f2850g.a(a2.f4455e, o());
                return true;
            } else {
                d.a.a.a.c.h().e("Answers", "Analytics collection disabled");
                this.f2850g.b();
                return false;
            }
        } catch (Exception e2) {
            d.a.a.a.c.h().c("Answers", "Error dealing with settings", e2);
            return false;
        }
    }

    public void a(j.b bVar) {
        u uVar = this.f2850g;
        if (uVar != null) {
            uVar.a(bVar.b());
        }
    }

    public void a(j.a aVar) {
        u uVar = this.f2850g;
        if (uVar != null) {
            uVar.a(aVar.b(), aVar.a());
        }
    }
}
