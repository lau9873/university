package c.b.a.c;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
/* compiled from: CheckForUpdatesRequest.java */
/* loaded from: classes.dex */
public class e extends d.a.a.a.m.b.a {

    /* renamed from: g  reason: collision with root package name */
    public final g f2968g;

    public e(d.a.a.a.h hVar, String str, String str2, d.a.a.a.m.e.d dVar, g gVar) {
        super(hVar, str, str2, dVar, d.a.a.a.m.e.c.GET);
        this.f2968g = gVar;
    }

    public static String b(String str) {
        return "3:" + str;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c.b.a.c.f a(java.lang.String r8, java.lang.String r9, c.b.a.c.d r10) {
        /*
            r7 = this;
            java.lang.String r0 = "Checking for updates request ID: "
            java.lang.String r1 = "Fabric"
            java.lang.String r2 = "X-REQUEST-ID"
            java.lang.String r3 = "Beta"
            r4 = 0
            java.util.Map r10 = r7.a(r10)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            io.fabric.sdk.android.services.network.HttpRequest r5 = r7.a(r10)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            r7.a(r5, r8, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            d.a.a.a.k r8 = d.a.a.a.c.h()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.<init>()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r6 = "Checking for updates from "
            r9.append(r6)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r6 = r7.b()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.append(r6)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r8.e(r3, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            d.a.a.a.k r8 = d.a.a.a.c.h()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.<init>()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r6 = "Checking for updates query params are: "
            r9.append(r6)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.append(r10)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r8.e(r3, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            boolean r8 = r5.n()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            if (r8 == 0) goto L83
            d.a.a.a.k r8 = d.a.a.a.c.h()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = "Checking for updates was successful"
            r8.e(r3, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = r5.a()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r8.<init>(r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            c.b.a.c.g r9 = r7.f2968g     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            c.b.a.c.f r8 = r9.a(r8)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            if (r5 == 0) goto L82
            java.lang.String r9 = r5.c(r2)
            d.a.a.a.k r10 = d.a.a.a.c.h()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            r10.e(r1, r9)
        L82:
            return r8
        L83:
            d.a.a.a.k r8 = d.a.a.a.c.h()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.<init>()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r10 = "Checking for updates failed. Response code: "
            r9.append(r10)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            int r10 = r5.g()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.append(r10)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r8.c(r3, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            if (r5 == 0) goto Lee
            java.lang.String r8 = r5.c(r2)
            d.a.a.a.k r9 = d.a.a.a.c.h()
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
            d.a.a.a.k r9 = d.a.a.a.c.h()     // Catch: java.lang.Throwable -> Lef
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lef
            r10.<init>()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r6 = "Error while checking for updates from "
            r10.append(r6)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r6 = r7.b()     // Catch: java.lang.Throwable -> Lef
            r10.append(r6)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> Lef
            r9.c(r3, r10, r8)     // Catch: java.lang.Throwable -> Lef
            if (r5 == 0) goto Lee
            java.lang.String r8 = r5.c(r2)
            d.a.a.a.k r9 = d.a.a.a.c.h()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
        Le1:
            r10.append(r0)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.e(r1, r8)
        Lee:
            return r4
        Lef:
            r8 = move-exception
        Lf0:
            if (r5 == 0) goto L10c
            java.lang.String r9 = r5.c(r2)
            d.a.a.a.k r10 = d.a.a.a.c.h()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            r10.e(r1, r9)
        L10c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.c.e.a(java.lang.String, java.lang.String, c.b.a.c.d):c.b.a.c.f");
    }

    public final HttpRequest a(HttpRequest httpRequest, String str, String str2) {
        httpRequest.c("Accept", "application/json");
        httpRequest.c("User-Agent", "Crashlytics Android SDK/" + this.f4230e.k());
        httpRequest.c("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
        httpRequest.c("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequest.c("X-CRASHLYTICS-API-CLIENT-VERSION", this.f4230e.k());
        httpRequest.c("X-CRASHLYTICS-API-KEY", str);
        httpRequest.c("X-CRASHLYTICS-BETA-TOKEN", b(str2));
        return httpRequest;
    }

    public final Map<String, String> a(d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", dVar.f2964a);
        hashMap.put("display_version", dVar.f2965b);
        hashMap.put("instance", dVar.f2966c);
        hashMap.put("source", "3");
        return hashMap;
    }
}
