package d.a.a.a.m.g;

import android.content.res.Resources;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.Locale;
/* compiled from: AbstractAppSpiCall.java */
/* loaded from: classes.dex */
public abstract class a extends d.a.a.a.m.b.a implements f {
    public a(d.a.a.a.h hVar, String str, String str2, d.a.a.a.m.e.d dVar, d.a.a.a.m.e.c cVar) {
        super(hVar, str, str2, dVar, cVar);
    }

    public boolean a(d dVar) {
        HttpRequest a2 = a();
        a(a2, dVar);
        b(a2, dVar);
        d.a.a.a.k h2 = d.a.a.a.c.h();
        h2.e("Fabric", "Sending app info to " + b());
        if (dVar.j != null) {
            d.a.a.a.k h3 = d.a.a.a.c.h();
            h3.e("Fabric", "App icon hash is " + dVar.j.f4429a);
            d.a.a.a.k h4 = d.a.a.a.c.h();
            h4.e("Fabric", "App icon size is " + dVar.j.f4431c + "x" + dVar.j.f4432d);
        }
        int g2 = a2.g();
        String str = "POST".equals(a2.m()) ? "Create" : "Update";
        d.a.a.a.k h5 = d.a.a.a.c.h();
        h5.e("Fabric", str + " app request ID: " + a2.c("X-REQUEST-ID"));
        d.a.a.a.k h6 = d.a.a.a.c.h();
        h6.e("Fabric", "Result was " + g2);
        return d.a.a.a.m.b.r.a(g2) == 0;
    }

    public final HttpRequest b(HttpRequest httpRequest, d dVar) {
        httpRequest.e("app[identifier]", dVar.f4404b);
        httpRequest.e("app[name]", dVar.f4408f);
        httpRequest.e("app[display_version]", dVar.f4405c);
        httpRequest.e("app[build_version]", dVar.f4406d);
        httpRequest.a("app[source]", Integer.valueOf(dVar.f4409g));
        httpRequest.e("app[minimum_sdk_version]", dVar.f4410h);
        httpRequest.e("app[built_sdk_version]", dVar.f4411i);
        if (!d.a.a.a.m.b.i.b(dVar.f4407e)) {
            httpRequest.e("app[instance_identifier]", dVar.f4407e);
        }
        if (dVar.j != null) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = this.f4230e.e().getResources().openRawResource(dVar.j.f4430b);
                    httpRequest.e("app[icon][hash]", dVar.j.f4429a);
                    httpRequest.a("app[icon][data]", "icon.png", "application/octet-stream", inputStream);
                    httpRequest.a("app[icon][width]", Integer.valueOf(dVar.j.f4431c));
                    httpRequest.a("app[icon][height]", Integer.valueOf(dVar.j.f4432d));
                } catch (Resources.NotFoundException e2) {
                    d.a.a.a.k h2 = d.a.a.a.c.h();
                    h2.c("Fabric", "Failed to find app icon with resource ID: " + dVar.j.f4430b, e2);
                }
            } finally {
                d.a.a.a.m.b.i.a((Closeable) inputStream, "Failed to close app icon InputStream.");
            }
        }
        Collection<d.a.a.a.j> collection = dVar.k;
        if (collection != null) {
            for (d.a.a.a.j jVar : collection) {
                httpRequest.e(b(jVar), jVar.c());
                httpRequest.e(a(jVar), jVar.a());
            }
        }
        return httpRequest;
    }

    public final HttpRequest a(HttpRequest httpRequest, d dVar) {
        httpRequest.c("X-CRASHLYTICS-API-KEY", dVar.f4403a);
        httpRequest.c("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequest.c("X-CRASHLYTICS-API-CLIENT-VERSION", this.f4230e.k());
        return httpRequest;
    }

    public String a(d.a.a.a.j jVar) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", jVar.b());
    }

    public String b(d.a.a.a.j jVar) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", jVar.b());
    }
}
