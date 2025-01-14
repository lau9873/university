package p136d.p137a.p138a.p139a.p140m.p148g;

import android.content.res.Resources;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.Locale;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.KitInfo;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p142b.AbstractSpiCall;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.ResponseParser;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpMethod;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory;

/* renamed from: d.a.a.a.m.g.a */
/* loaded from: classes.dex */
public abstract class AbstractAppSpiCall extends AbstractSpiCall implements AppSpiCall {
    public AbstractAppSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        super(kit, str, str2, httpRequestFactory, httpMethod);
    }

    /* renamed from: a */
    public boolean m3900a(AppRequestData appRequestData) {
        HttpRequest m4140a = m4140a();
        m3899a(m4140a, appRequestData);
        m3897b(m4140a, appRequestData);
        Logger m4197h = Fabric.m4197h();
        m4197h.mo4157e("Fabric", "Sending app info to " + m4137b());
        if (appRequestData.f6616j != null) {
            Logger m4197h2 = Fabric.m4197h();
            m4197h2.mo4157e("Fabric", "App icon hash is " + appRequestData.f6616j.f6635a);
            Logger m4197h3 = Fabric.m4197h();
            m4197h3.mo4157e("Fabric", "App icon size is " + appRequestData.f6616j.f6637c + "x" + appRequestData.f6616j.f6638d);
        }
        int m517g = m4140a.m517g();
        String str = "POST".equals(m4140a.m511m()) ? "Create" : "Update";
        Logger m4197h4 = Fabric.m4197h();
        m4197h4.mo4157e("Fabric", str + " app request ID: " + m4140a.m531c("X-REQUEST-ID"));
        Logger m4197h5 = Fabric.m4197h();
        m4197h5.mo4157e("Fabric", "Result was " + m517g);
        return ResponseParser.m4008a(m517g) == 0;
    }

    /* renamed from: b */
    public final HttpRequest m3897b(HttpRequest httpRequest, AppRequestData appRequestData) {
        httpRequest.m522e("app[identifier]", appRequestData.f6608b);
        httpRequest.m522e("app[name]", appRequestData.f6612f);
        httpRequest.m522e("app[display_version]", appRequestData.f6609c);
        httpRequest.m522e("app[build_version]", appRequestData.f6610d);
        httpRequest.m550a("app[source]", Integer.valueOf(appRequestData.f6613g));
        httpRequest.m522e("app[minimum_sdk_version]", appRequestData.f6614h);
        httpRequest.m522e("app[built_sdk_version]", appRequestData.f6615i);
        if (!CommonUtils.m4085b(appRequestData.f6611e)) {
            httpRequest.m522e("app[instance_identifier]", appRequestData.f6611e);
        }
        if (appRequestData.f6616j != null) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = this.f6422e.m4178e().getResources().openRawResource(appRequestData.f6616j.f6636b);
                    httpRequest.m522e("app[icon][hash]", appRequestData.f6616j.f6635a);
                    httpRequest.m545a("app[icon][data]", "icon.png", "application/octet-stream", inputStream);
                    httpRequest.m550a("app[icon][width]", Integer.valueOf(appRequestData.f6616j.f6637c));
                    httpRequest.m550a("app[icon][height]", Integer.valueOf(appRequestData.f6616j.f6638d));
                } catch (Resources.NotFoundException e) {
                    Logger m4197h = Fabric.m4197h();
                    m4197h.mo4159c("Fabric", "Failed to find app icon with resource ID: " + appRequestData.f6616j.f6636b, e);
                }
            } finally {
                CommonUtils.m4103a((Closeable) inputStream, "Failed to close app icon InputStream.");
            }
        }
        Collection<KitInfo> collection = appRequestData.f6617k;
        if (collection != null) {
            for (KitInfo kitInfo : collection) {
                httpRequest.m522e(m3898b(kitInfo), kitInfo.m4168c());
                httpRequest.m522e(m3901a(kitInfo), kitInfo.m4170a());
            }
        }
        return httpRequest;
    }

    /* renamed from: a */
    public final HttpRequest m3899a(HttpRequest httpRequest, AppRequestData appRequestData) {
        httpRequest.m530c("X-CRASHLYTICS-API-KEY", appRequestData.f6607a);
        httpRequest.m530c("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequest.m530c("X-CRASHLYTICS-API-CLIENT-VERSION", this.f6422e.mo4148k());
        return httpRequest;
    }

    /* renamed from: a */
    public String m3901a(KitInfo kitInfo) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", kitInfo.m4169b());
    }

    /* renamed from: b */
    public String m3898b(KitInfo kitInfo) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", kitInfo.m4169b());
    }
}
