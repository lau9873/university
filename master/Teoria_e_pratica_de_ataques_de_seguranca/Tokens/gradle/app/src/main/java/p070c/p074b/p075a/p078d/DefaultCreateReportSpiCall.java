package p070c.p074b.p075a.p078d;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.util.Map;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p142b.AbstractSpiCall;
import p136d.p137a.p138a.p139a.p140m.p142b.ResponseParser;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpMethod;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory;

/* renamed from: c.b.a.d.p */
/* loaded from: classes.dex */
public class DefaultCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {
    public DefaultCreateReportSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.POST);
    }

    @Override // p070c.p074b.p075a.p078d.CreateReportSpiCall
    /* renamed from: a */
    public boolean mo5745a(CreateReportRequest createReportRequest) {
        HttpRequest m4140a = m4140a();
        m5743a(m4140a, createReportRequest);
        m5744a(m4140a, createReportRequest.f4928b);
        Logger m4197h = Fabric.m4197h();
        m4197h.mo4157e("CrashlyticsCore", "Sending report to: " + m4137b());
        int m517g = m4140a.m517g();
        Logger m4197h2 = Fabric.m4197h();
        m4197h2.mo4157e("CrashlyticsCore", "Create report request ID: " + m4140a.m531c("X-REQUEST-ID"));
        Logger m4197h3 = Fabric.m4197h();
        m4197h3.mo4157e("CrashlyticsCore", "Result was: " + m517g);
        return ResponseParser.m4008a(m517g) == 0;
    }

    /* renamed from: a */
    public final HttpRequest m5743a(HttpRequest httpRequest, CreateReportRequest createReportRequest) {
        httpRequest.m530c("X-CRASHLYTICS-API-KEY", createReportRequest.f4927a);
        httpRequest.m530c("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequest.m530c("X-CRASHLYTICS-API-CLIENT-VERSION", this.f6422e.mo4148k());
        for (Map.Entry<String, String> entry : createReportRequest.f4928b.mo5731a().entrySet()) {
            httpRequest.m542a(entry);
        }
        return httpRequest;
    }

    /* renamed from: a */
    public final HttpRequest m5744a(HttpRequest httpRequest, Report report) {
        File[] mo5730b;
        httpRequest.m522e("report[identifier]", report.mo5728d());
        if (report.mo5730b().length == 1) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Adding single file " + report.mo5729c() + " to report " + report.mo5728d());
            httpRequest.m546a("report[file]", report.mo5729c(), "application/octet-stream", report.mo5727e());
            return httpRequest;
        }
        int i = 0;
        for (File file : report.mo5730b()) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Adding file " + file.getName() + " to report " + report.mo5728d());
            StringBuilder sb = new StringBuilder();
            sb.append("report[file");
            sb.append(i);
            sb.append("]");
            httpRequest.m546a(sb.toString(), file.getName(), "application/octet-stream", file);
            i++;
        }
        return httpRequest;
    }
}
