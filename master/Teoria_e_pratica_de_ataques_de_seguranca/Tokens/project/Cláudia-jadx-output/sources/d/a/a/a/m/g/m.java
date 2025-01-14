package d.a.a.a.m.g;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: DefaultSettingsSpiCall.java */
/* loaded from: classes.dex */
public class m extends d.a.a.a.m.b.a implements y {
    public m(d.a.a.a.h hVar, String str, String str2, d.a.a.a.m.e.d dVar) {
        this(hVar, str, str2, dVar, d.a.a.a.m.e.c.GET);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
    /* JADX WARN: Type inference failed for: r3v0, types: [io.fabric.sdk.android.services.network.HttpRequest] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v3, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // d.a.a.a.m.g.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject a(d.a.a.a.m.g.x r9) {
        /*
            r8 = this;
            java.lang.String r0 = "X-REQUEST-ID"
            java.lang.String r1 = "Settings request ID: "
            java.lang.String r2 = "Fabric"
            r3 = 0
            java.util.Map r4 = r8.b(r9)     // Catch: java.lang.Throwable -> L69 io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6c
            io.fabric.sdk.android.services.network.HttpRequest r5 = r8.a(r4)     // Catch: java.lang.Throwable -> L69 io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6c
            r8.a(r5, r9)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            d.a.a.a.k r9 = d.a.a.a.c.h()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r6.<init>()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r7 = "Requesting settings from "
            r6.append(r7)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r7 = r8.b()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r6.append(r7)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r6 = r6.toString()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r9.e(r2, r6)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            d.a.a.a.k r9 = d.a.a.a.c.h()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r6.<init>()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r7 = "Settings query params were: "
            r6.append(r7)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r6.append(r4)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r4 = r6.toString()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r9.e(r2, r4)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            org.json.JSONObject r3 = r8.a(r5)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            if (r5 == 0) goto L83
            d.a.a.a.k r9 = d.a.a.a.c.h()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L55:
            r4.append(r1)
            java.lang.String r0 = r5.c(r0)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r9.e(r2, r0)
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
            d.a.a.a.k r4 = d.a.a.a.c.h()     // Catch: java.lang.Throwable -> L84
            java.lang.String r6 = "Settings request failed."
            r4.c(r2, r6, r9)     // Catch: java.lang.Throwable -> L84
            if (r5 == 0) goto L83
            d.a.a.a.k r9 = d.a.a.a.c.h()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L55
        L83:
            return r3
        L84:
            r9 = move-exception
        L85:
            if (r5 == 0) goto La1
            d.a.a.a.k r3 = d.a.a.a.c.h()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r0 = r5.c(r0)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.e(r2, r0)
        La1:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.a.a.m.g.m.a(d.a.a.a.m.g.x):org.json.JSONObject");
    }

    public boolean a(int i2) {
        return i2 == 200 || i2 == 201 || i2 == 202 || i2 == 203;
    }

    public final JSONObject b(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e2) {
            d.a.a.a.k h2 = d.a.a.a.c.h();
            h2.a("Fabric", "Failed to parse settings JSON from " + b(), e2);
            d.a.a.a.k h3 = d.a.a.a.c.h();
            h3.e("Fabric", "Settings response " + str);
            return null;
        }
    }

    public m(d.a.a.a.h hVar, String str, String str2, d.a.a.a.m.e.d dVar, d.a.a.a.m.e.c cVar) {
        super(hVar, str, str2, dVar, cVar);
    }

    public final Map<String, String> b(x xVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", xVar.j);
        hashMap.put("display_version", xVar.f4467i);
        hashMap.put("source", Integer.toString(xVar.k));
        String str = xVar.l;
        if (str != null) {
            hashMap.put("icon_hash", str);
        }
        String str2 = xVar.f4466h;
        if (!d.a.a.a.m.b.i.b(str2)) {
            hashMap.put("instance", str2);
        }
        return hashMap;
    }

    public JSONObject a(HttpRequest httpRequest) {
        int g2 = httpRequest.g();
        d.a.a.a.k h2 = d.a.a.a.c.h();
        h2.e("Fabric", "Settings result was: " + g2);
        if (a(g2)) {
            return b(httpRequest.a());
        }
        d.a.a.a.k h3 = d.a.a.a.c.h();
        h3.c("Fabric", "Failed to retrieve settings from " + b());
        return null;
    }

    public final HttpRequest a(HttpRequest httpRequest, x xVar) {
        a(httpRequest, "X-CRASHLYTICS-API-KEY", xVar.f4459a);
        a(httpRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        a(httpRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", this.f4230e.k());
        a(httpRequest, "Accept", "application/json");
        a(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", xVar.f4460b);
        a(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", xVar.f4461c);
        a(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", xVar.f4462d);
        a(httpRequest, "X-CRASHLYTICS-ADVERTISING-TOKEN", xVar.f4463e);
        a(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", xVar.f4464f);
        a(httpRequest, "X-CRASHLYTICS-ANDROID-ID", xVar.f4465g);
        return httpRequest;
    }

    public final void a(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.c(str, str2);
        }
    }
}
