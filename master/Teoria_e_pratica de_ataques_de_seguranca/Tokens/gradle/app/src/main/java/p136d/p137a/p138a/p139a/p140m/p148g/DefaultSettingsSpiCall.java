package p136d.p137a.p138a.p139a.p140m.p148g;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p142b.AbstractSpiCall;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpMethod;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory;

/* renamed from: d.a.a.a.m.g.m */
/* loaded from: classes.dex */
public class DefaultSettingsSpiCall extends AbstractSpiCall implements SettingsSpiCall {
    public DefaultSettingsSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        this(kit, str, str2, httpRequestFactory, HttpMethod.GET);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
    /* JADX WARN: Type inference failed for: r3v0, types: [io.fabric.sdk.android.services.network.HttpRequest] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v3, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // p136d.p137a.p138a.p139a.p140m.p148g.SettingsSpiCall
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject mo3862a(p136d.p137a.p138a.p139a.p140m.p148g.SettingsRequest r9) {
        /*
            r8 = this;
            java.lang.String r0 = "X-REQUEST-ID"
            java.lang.String r1 = "Settings request ID: "
            java.lang.String r2 = "Fabric"
            r3 = 0
            java.util.Map r4 = r8.m3876b(r9)     // Catch: java.lang.Throwable -> L69 io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6c
            io.fabric.sdk.android.services.network.HttpRequest r5 = r8.m4138a(r4)     // Catch: java.lang.Throwable -> L69 io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6c
            r8.m3878a(r5, r9)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            d.a.a.a.k r9 = p136d.p137a.p138a.p139a.Fabric.m4197h()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r6.<init>()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r7 = "Requesting settings from "
            r6.append(r7)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r7 = r8.m4137b()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r6.append(r7)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r6 = r6.toString()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r9.mo4157e(r2, r6)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            d.a.a.a.k r9 = p136d.p137a.p138a.p139a.Fabric.m4197h()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r6.<init>()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r7 = "Settings query params were: "
            r6.append(r7)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r6.append(r4)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r4 = r6.toString()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r9.mo4157e(r2, r4)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            org.json.JSONObject r3 = r8.m3879a(r5)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            if (r5 == 0) goto L83
            d.a.a.a.k r9 = p136d.p137a.p138a.p139a.Fabric.m4197h()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L55:
            r4.append(r1)
            java.lang.String r0 = r5.m531c(r0)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r9.mo4157e(r2, r0)
            goto L83
        L67:
            r9 = move-exception
            goto L6e
        L69:
            r9 = move-exception
            r5 = r3
            goto L85
        L6c:
            r9 = move-exception
            r5 = r3
        L6e:
            d.a.a.a.k r4 = p136d.p137a.p138a.p139a.Fabric.m4197h()     // Catch: java.lang.Throwable -> L84
            java.lang.String r6 = "Settings request failed."
            r4.mo4159c(r2, r6, r9)     // Catch: java.lang.Throwable -> L84
            if (r5 == 0) goto L83
            d.a.a.a.k r9 = p136d.p137a.p138a.p139a.Fabric.m4197h()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L55
        L83:
            return r3
        L84:
            r9 = move-exception
        L85:
            if (r5 == 0) goto La1
            d.a.a.a.k r3 = p136d.p137a.p138a.p139a.Fabric.m4197h()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r0 = r5.m531c(r0)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.mo4157e(r2, r0)
        La1:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p136d.p137a.p138a.p139a.p140m.p148g.DefaultSettingsSpiCall.mo3862a(d.a.a.a.m.g.x):org.json.JSONObject");
    }

    /* renamed from: a */
    public boolean m3880a(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    /* renamed from: b */
    public final JSONObject m3875b(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            Logger m4197h = Fabric.m4197h();
            m4197h.mo4163a("Fabric", "Failed to parse settings JSON from " + m4137b(), e);
            Logger m4197h2 = Fabric.m4197h();
            m4197h2.mo4157e("Fabric", "Settings response " + str);
            return null;
        }
    }

    public DefaultSettingsSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        super(kit, str, str2, httpRequestFactory, httpMethod);
    }

    /* renamed from: b */
    public final Map<String, String> m3876b(SettingsRequest settingsRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", settingsRequest.f6674j);
        hashMap.put("display_version", settingsRequest.f6673i);
        hashMap.put("source", Integer.toString(settingsRequest.f6675k));
        String str = settingsRequest.f6676l;
        if (str != null) {
            hashMap.put("icon_hash", str);
        }
        String str2 = settingsRequest.f6672h;
        if (!CommonUtils.m4085b(str2)) {
            hashMap.put("instance", str2);
        }
        return hashMap;
    }

    /* renamed from: a */
    public JSONObject m3879a(HttpRequest httpRequest) {
        int m517g = httpRequest.m517g();
        Logger m4197h = Fabric.m4197h();
        m4197h.mo4157e("Fabric", "Settings result was: " + m517g);
        if (m3880a(m517g)) {
            return m3875b(httpRequest.m559a());
        }
        Logger m4197h2 = Fabric.m4197h();
        m4197h2.mo4160c("Fabric", "Failed to retrieve settings from " + m4137b());
        return null;
    }

    /* renamed from: a */
    public final HttpRequest m3878a(HttpRequest httpRequest, SettingsRequest settingsRequest) {
        m3877a(httpRequest, "X-CRASHLYTICS-API-KEY", settingsRequest.f6665a);
        m3877a(httpRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        m3877a(httpRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", this.f6422e.mo4148k());
        m3877a(httpRequest, "Accept", "application/json");
        m3877a(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.f6666b);
        m3877a(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest.f6667c);
        m3877a(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest.f6668d);
        m3877a(httpRequest, "X-CRASHLYTICS-ADVERTISING-TOKEN", settingsRequest.f6669e);
        m3877a(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", settingsRequest.f6670f);
        m3877a(httpRequest, "X-CRASHLYTICS-ANDROID-ID", settingsRequest.f6671g);
        return httpRequest;
    }

    /* renamed from: a */
    public final void m3877a(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.m530c(str, str2);
        }
    }
}
