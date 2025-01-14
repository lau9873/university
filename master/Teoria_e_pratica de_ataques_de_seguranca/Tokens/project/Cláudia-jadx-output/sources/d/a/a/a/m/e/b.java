package d.a.a.a.m.e;

import d.a.a.a.k;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: DefaultHttpRequestFactory.java */
/* loaded from: classes.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public final k f4373a;

    /* renamed from: b  reason: collision with root package name */
    public f f4374b;

    /* renamed from: c  reason: collision with root package name */
    public SSLSocketFactory f4375c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4376d;

    /* compiled from: DefaultHttpRequestFactory.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4377a = new int[c.values().length];

        static {
            try {
                f4377a[c.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4377a[c.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4377a[c.PUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4377a[c.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public b() {
        this(new d.a.a.a.b());
    }

    @Override // d.a.a.a.m.e.d
    public void a(f fVar) {
        if (this.f4374b != fVar) {
            this.f4374b = fVar;
            c();
        }
    }

    public final synchronized SSLSocketFactory b() {
        SSLSocketFactory a2;
        this.f4376d = true;
        try {
            a2 = e.a(this.f4374b);
            this.f4373a.e("Fabric", "Custom SSL pinning enabled");
        } catch (Exception e2) {
            this.f4373a.c("Fabric", "Exception while validating pinned certs", e2);
            return null;
        }
        return a2;
    }

    public final synchronized void c() {
        this.f4376d = false;
        this.f4375c = null;
    }

    public b(k kVar) {
        this.f4373a = kVar;
    }

    @Override // d.a.a.a.m.e.d
    public HttpRequest a(c cVar, String str, Map<String, String> map) {
        HttpRequest a2;
        SSLSocketFactory a3;
        int i2 = a.f4377a[cVar.ordinal()];
        if (i2 == 1) {
            a2 = HttpRequest.a((CharSequence) str, (Map<?, ?>) map, true);
        } else if (i2 == 2) {
            a2 = HttpRequest.b((CharSequence) str, (Map<?, ?>) map, true);
        } else if (i2 == 3) {
            a2 = HttpRequest.f((CharSequence) str);
        } else if (i2 == 4) {
            a2 = HttpRequest.b((CharSequence) str);
        } else {
            throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (a(str) && this.f4374b != null && (a3 = a()) != null) {
            ((HttpsURLConnection) a2.l()).setSSLSocketFactory(a3);
        }
        return a2;
    }

    public final boolean a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    public final synchronized SSLSocketFactory a() {
        if (this.f4375c == null && !this.f4376d) {
            this.f4375c = b();
        }
        return this.f4375c;
    }
}
