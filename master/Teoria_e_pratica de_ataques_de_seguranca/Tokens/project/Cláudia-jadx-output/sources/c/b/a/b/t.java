package c.b.a.b;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.util.List;
/* compiled from: SessionAnalyticsFilesSender.java */
/* loaded from: classes.dex */
public class t extends d.a.a.a.m.b.a implements d.a.a.a.m.d.f {

    /* renamed from: g  reason: collision with root package name */
    public final String f2906g;

    public t(d.a.a.a.h hVar, String str, String str2, d.a.a.a.m.e.d dVar, String str3) {
        super(hVar, str, str2, dVar, d.a.a.a.m.e.c.POST);
        this.f2906g = str3;
    }

    @Override // d.a.a.a.m.d.f
    public boolean a(List<File> list) {
        HttpRequest a2 = a();
        a2.c("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        a2.c("X-CRASHLYTICS-API-CLIENT-VERSION", this.f4230e.k());
        a2.c("X-CRASHLYTICS-API-KEY", this.f2906g);
        int i2 = 0;
        for (File file : list) {
            a2.a("session_analytics_file_" + i2, file.getName(), "application/vnd.crashlytics.android.events", file);
            i2++;
        }
        d.a.a.a.k h2 = d.a.a.a.c.h();
        h2.e("Answers", "Sending " + list.size() + " analytics files to " + b());
        int g2 = a2.g();
        d.a.a.a.k h3 = d.a.a.a.c.h();
        h3.e("Answers", "Response code for analytics file send is " + g2);
        return d.a.a.a.m.b.r.a(g2) == 0;
    }
}
