package p070c.p074b.p075a.p076b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.File;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.Crash;
import p136d.p137a.p138a.p139a.p140m.p148g.Settings;
import p136d.p137a.p138a.p139a.p140m.p148g.SettingsData;

/* renamed from: c.b.a.b.a */
/* loaded from: classes.dex */
public class Answers extends Kit<Boolean> {

    /* renamed from: g */
    public SessionAnalyticsManager f4651g;

    /* renamed from: p */
    public static Answers m6074p() {
        return (Answers) Fabric.m4212a(Answers.class);
    }

    /* renamed from: a */
    public void m6078a(CustomEvent customEvent) {
        if (customEvent != null) {
            SessionAnalyticsManager sessionAnalyticsManager = this.f4651g;
            if (sessionAnalyticsManager != null) {
                sessionAnalyticsManager.m6025a(customEvent);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: i */
    public String mo4149i() {
        return "com.crashlytics.sdk.android:answers";
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: k */
    public String mo4148k() {
        return "1.3.12.dev";
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    @SuppressLint({"NewApi"})
    /* renamed from: n */
    public boolean mo4147n() {
        long lastModified;
        try {
            Context m4178e = m4178e();
            PackageManager packageManager = m4178e.getPackageManager();
            String packageName = m4178e.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String num = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (Build.VERSION.SDK_INT >= 9) {
                lastModified = packageInfo.firstInstallTime;
            } else {
                lastModified = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.f4651g = SessionAnalyticsManager.m6024a(this, m4178e, m4175h(), num, str, lastModified);
            this.f4651g.m6019c();
            return true;
        } catch (Exception e) {
            Fabric.m4197h().mo4159c("Answers", "Error retrieving app properties", e);
            return false;
        }
    }

    /* renamed from: o */
    public String m6075o() {
        return CommonUtils.m4087b(m4178e(), "com.crashlytics.ApiEndpoint");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: d */
    public Boolean mo4150d() {
        try {
            SettingsData m3873a = Settings.m3868d().m3873a();
            if (m3873a == null) {
                Fabric.m4197h().mo4160c("Answers", "Failed to retrieve settings");
                return false;
            } else if (m3873a.f6660d.f6634c) {
                Fabric.m4197h().mo4157e("Answers", "Analytics collection enabled");
                this.f4651g.m6023a(m3873a.f6661e, m6075o());
                return true;
            } else {
                Fabric.m4197h().mo4157e("Answers", "Analytics collection disabled");
                this.f4651g.m6020b();
                return false;
            }
        } catch (Exception e) {
            Fabric.m4197h().mo4159c("Answers", "Error dealing with settings", e);
            return false;
        }
    }

    /* renamed from: a */
    public void m6076a(Crash.C1493b c1493b) {
        SessionAnalyticsManager sessionAnalyticsManager = this.f4651g;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.m6022a(c1493b.m4066b());
        }
    }

    /* renamed from: a */
    public void m6077a(Crash.C1492a c1492a) {
        SessionAnalyticsManager sessionAnalyticsManager = this.f4651g;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.m6021a(c1492a.m4066b(), c1492a.m4067a());
        }
    }
}
