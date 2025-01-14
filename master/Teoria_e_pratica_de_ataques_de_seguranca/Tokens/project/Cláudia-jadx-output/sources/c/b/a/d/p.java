package c.b.a.d;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.util.Map;
/* compiled from: DefaultCreateReportSpiCall.java */
/* loaded from: classes.dex */
public class p extends d.a.a.a.m.b.a implements o {
    public p(d.a.a.a.h hVar, String str, String str2, d.a.a.a.m.e.d dVar) {
        super(hVar, str, str2, dVar, d.a.a.a.m.e.c.POST);
    }

    @Override // c.b.a.d.o
    public boolean a(n nVar) {
        HttpRequest a2 = a();
        a(a2, nVar);
        a(a2, nVar.f3090b);
        d.a.a.a.k h2 = d.a.a.a.c.h();
        h2.e("CrashlyticsCore", "Sending report to: " + b());
        int g2 = a2.g();
        d.a.a.a.k h3 = d.a.a.a.c.h();
        h3.e("CrashlyticsCore", "Create report request ID: " + a2.c("X-REQUEST-ID"));
        d.a.a.a.k h4 = d.a.a.a.c.h();
        h4.e("CrashlyticsCore", "Result was: " + g2);
        return d.a.a.a.m.b.r.a(g2) == 0;
    }

    public final HttpRequest a(HttpRequest httpRequest, n nVar) {
        httpRequest.c("X-CRASHLYTICS-API-KEY", nVar.f3089a);
        httpRequest.c("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequest.c("X-CRASHLYTICS-API-CLIENT-VERSION", this.f4230e.k());
        for (Map.Entry<String, String> entry : nVar.f3090b.a().entrySet()) {
            httpRequest.a(entry);
        }
        return httpRequest;
    }

    public final HttpRequest a(HttpRequest httpRequest, e0 e0Var) {
        File[] b2;
        httpRequest.e("report[identifier]", e0Var.d());
        if (e0Var.b().length == 1) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Adding single file " + e0Var.c() + " to report " + e0Var.d());
            httpRequest.a("report[file]", e0Var.c(), "application/octet-stream", e0Var.e());
            return httpRequest;
        }
        int i2 = 0;
        for (File file : e0Var.b()) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Adding file " + file.getName() + " to report " + e0Var.d());
            StringBuilder sb = new StringBuilder();
            sb.append("report[file");
            sb.append(i2);
            sb.append("]");
            httpRequest.a(sb.toString(), file.getName(), "application/octet-stream", file);
            i2++;
        }
        return httpRequest;
    }
}
