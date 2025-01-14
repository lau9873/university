package p136d.p137a.p138a.p139a.p140m.p142b;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpMethod;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory;

/* renamed from: d.a.a.a.m.b.a */
/* loaded from: classes.dex */
public abstract class AbstractSpiCall {

    /* renamed from: f */
    public static final Pattern f6417f = Pattern.compile("http(s?)://[^\\/]+", 2);

    /* renamed from: a */
    public final String f6418a;

    /* renamed from: b */
    public final HttpRequestFactory f6419b;

    /* renamed from: c */
    public final HttpMethod f6420c;

    /* renamed from: d */
    public final String f6421d;

    /* renamed from: e */
    public final Kit f6422e;

    public AbstractSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (httpRequestFactory != null) {
            this.f6422e = kit;
            this.f6421d = str;
            this.f6418a = m4139a(str2);
            this.f6419b = httpRequestFactory;
            this.f6420c = httpMethod;
            return;
        }
        throw new IllegalArgumentException("requestFactory must not be null.");
    }

    /* renamed from: a */
    public HttpRequest m4140a() {
        return m4138a(Collections.emptyMap());
    }

    /* renamed from: b */
    public String m4137b() {
        return this.f6418a;
    }

    /* renamed from: a */
    public HttpRequest m4138a(Map<String, String> map) {
        HttpRequest mo3920a = this.f6419b.mo3920a(this.f6420c, m4137b(), map);
        mo3920a.m541a(false);
        mo3920a.m558a(10000);
        mo3920a.m530c("User-Agent", "Crashlytics Android SDK/" + this.f6422e.mo4148k());
        mo3920a.m530c("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
        return mo3920a;
    }

    /* renamed from: a */
    public final String m4139a(String str) {
        return !CommonUtils.m4085b(this.f6421d) ? f6417f.matcher(str).replaceFirst(this.f6421d) : str;
    }
}
