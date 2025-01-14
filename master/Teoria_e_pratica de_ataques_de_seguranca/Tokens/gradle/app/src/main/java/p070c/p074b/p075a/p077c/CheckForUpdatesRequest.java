package p070c.p074b.p075a.p077c;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.p140m.p142b.AbstractSpiCall;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpMethod;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory;

/* renamed from: c.b.a.c.e */
/* loaded from: classes.dex */
public class CheckForUpdatesRequest extends AbstractSpiCall {

    /* renamed from: g */
    public final CheckForUpdatesResponseTransform f4781g;

    public CheckForUpdatesRequest(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, CheckForUpdatesResponseTransform checkForUpdatesResponseTransform) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.GET);
        this.f4781g = checkForUpdatesResponseTransform;
    }

    /* renamed from: b */
    public static String m5983b(String str) {
        return "3:" + str;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f2  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p070c.p074b.p075a.p077c.CheckForUpdatesResponse m5984a(java.lang.String r8, java.lang.String r9, p070c.p074b.p075a.p077c.BuildProperties r10) {
        /*
            r7 = this;
            java.lang.String r0 = "Checking for updates request ID: "
            java.lang.String r1 = "Fabric"
            java.lang.String r2 = "X-REQUEST-ID"
            java.lang.String r3 = "Beta"
            r4 = 0
            java.util.Map r10 = r7.m5986a(r10)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            io.fabric.sdk.android.services.network.HttpRequest r5 = r7.m4138a(r10)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            r7.m5985a(r5, r8, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            d.a.a.a.k r8 = p136d.p137a.p138a.p139a.Fabric.m4197h()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.<init>()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r6 = "Checking for updates from "
            r9.append(r6)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r6 = r7.m4137b()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.append(r6)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r8.mo4157e(r3, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            d.a.a.a.k r8 = p136d.p137a.p138a.p139a.Fabric.m4197h()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.<init>()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r6 = "Checking for updates query params are: "
            r9.append(r6)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.append(r10)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r8.mo4157e(r3, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            boolean r8 = r5.m510n()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            if (r8 == 0) goto L83
            d.a.a.a.k r8 = p136d.p137a.p138a.p139a.Fabric.m4197h()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = "Checking for updates was successful"
            r8.mo4157e(r3, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = r5.m559a()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r8.<init>(r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            c.b.a.c.g r9 = r7.f4781g     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            c.b.a.c.f r8 = r9.m5982a(r8)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            if (r5 == 0) goto L82
            java.lang.String r9 = r5.m531c(r2)
            d.a.a.a.k r10 = p136d.p137a.p138a.p139a.Fabric.m4197h()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            r10.mo4157e(r1, r9)
        L82:
            return r8
        L83:
            d.a.a.a.k r8 = p136d.p137a.p138a.p139a.Fabric.m4197h()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.<init>()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r10 = "Checking for updates failed. Response code: "
            r9.append(r10)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            int r10 = r5.m517g()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.append(r10)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r8.mo4160c(r3, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            if (r5 == 0) goto Lee
            java.lang.String r8 = r5.m531c(r2)
            d.a.a.a.k r9 = p136d.p137a.p138a.p139a.Fabric.m4197h()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            goto Le1
        Laf:
            r8 = move-exception
            goto Lb6
        Lb1:
            r8 = move-exception
            r5 = r4
            goto Lf0
        Lb4:
            r8 = move-exception
            r5 = r4
        Lb6:
            d.a.a.a.k r9 = p136d.p137a.p138a.p139a.Fabric.m4197h()     // Catch: java.lang.Throwable -> Lef
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lef
            r10.<init>()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r6 = "Error while checking for updates from "
            r10.append(r6)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r6 = r7.m4137b()     // Catch: java.lang.Throwable -> Lef
            r10.append(r6)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> Lef
            r9.mo4159c(r3, r10, r8)     // Catch: java.lang.Throwable -> Lef
            if (r5 == 0) goto Lee
            java.lang.String r8 = r5.m531c(r2)
            d.a.a.a.k r9 = p136d.p137a.p138a.p139a.Fabric.m4197h()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
        Le1:
            r10.append(r0)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.mo4157e(r1, r8)
        Lee:
            return r4
        Lef:
            r8 = move-exception
        Lf0:
            if (r5 == 0) goto L10c
            java.lang.String r9 = r5.m531c(r2)
            d.a.a.a.k r10 = p136d.p137a.p138a.p139a.Fabric.m4197h()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            r10.mo4157e(r1, r9)
        L10c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p074b.p075a.p077c.CheckForUpdatesRequest.m5984a(java.lang.String, java.lang.String, c.b.a.c.d):c.b.a.c.f");
    }

    /* renamed from: a */
    public final HttpRequest m5985a(HttpRequest httpRequest, String str, String str2) {
        httpRequest.m530c("Accept", "application/json");
        httpRequest.m530c("User-Agent", "Crashlytics Android SDK/" + this.f6422e.mo4148k());
        httpRequest.m530c("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
        httpRequest.m530c("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequest.m530c("X-CRASHLYTICS-API-CLIENT-VERSION", this.f6422e.mo4148k());
        httpRequest.m530c("X-CRASHLYTICS-API-KEY", str);
        httpRequest.m530c("X-CRASHLYTICS-BETA-TOKEN", m5983b(str2));
        return httpRequest;
    }

    /* renamed from: a */
    public final Map<String, String> m5986a(BuildProperties buildProperties) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", buildProperties.f4777a);
        hashMap.put("display_version", buildProperties.f4778b);
        hashMap.put("instance", buildProperties.f4779c);
        hashMap.put("source", "3");
        return hashMap;
    }
}
