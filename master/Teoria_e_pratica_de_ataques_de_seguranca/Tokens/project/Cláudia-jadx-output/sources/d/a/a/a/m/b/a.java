package d.a.a.a.m.b;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
/* compiled from: AbstractSpiCall.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f4225f = Pattern.compile("http(s?)://[^\\/]+", 2);

    /* renamed from: a  reason: collision with root package name */
    public final String f4226a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.a.m.e.d f4227b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.a.m.e.c f4228c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4229d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.a.h f4230e;

    public a(d.a.a.a.h hVar, String str, String str2, d.a.a.a.m.e.d dVar, d.a.a.a.m.e.c cVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (dVar != null) {
            this.f4230e = hVar;
            this.f4229d = str;
            this.f4226a = a(str2);
            this.f4227b = dVar;
            this.f4228c = cVar;
            return;
        }
        throw new IllegalArgumentException("requestFactory must not be null.");
    }

    public HttpRequest a() {
        return a(Collections.emptyMap());
    }

    public String b() {
        return this.f4226a;
    }

    public HttpRequest a(Map<String, String> map) {
        HttpRequest a2 = this.f4227b.a(this.f4228c, b(), map);
        a2.a(false);
        a2.a(10000);
        a2.c("User-Agent", "Crashlytics Android SDK/" + this.f4230e.k());
        a2.c("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
        return a2;
    }

    public final String a(String str) {
        return !i.b(this.f4229d) ? f4225f.matcher(str).replaceFirst(this.f4229d) : str;
    }
}
