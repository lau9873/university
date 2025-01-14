package p136d.p137a.p138a.p139a.p140m.p146e;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import p136d.p137a.p138a.p139a.DefaultLogger;
import p136d.p137a.p138a.p139a.Logger;

/* renamed from: d.a.a.a.m.e.b */
/* loaded from: classes.dex */
public class DefaultHttpRequestFactory implements HttpRequestFactory {

    /* renamed from: a */
    public final Logger f6577a;

    /* renamed from: b */
    public InterfaceC1521f f6578b;

    /* renamed from: c */
    public SSLSocketFactory f6579c;

    /* renamed from: d */
    public boolean f6580d;

    /* compiled from: DefaultHttpRequestFactory.java */
    /* renamed from: d.a.a.a.m.e.b$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C1520a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f6581a = new int[HttpMethod.values().length];

        static {
            try {
                f6581a[HttpMethod.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6581a[HttpMethod.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6581a[HttpMethod.PUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6581a[HttpMethod.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public DefaultHttpRequestFactory() {
        this(new DefaultLogger());
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory
    /* renamed from: a */
    public void mo3919a(InterfaceC1521f interfaceC1521f) {
        if (this.f6578b != interfaceC1521f) {
            this.f6578b = interfaceC1521f;
            m3921c();
        }
    }

    /* renamed from: b */
    public final synchronized SSLSocketFactory m3922b() {
        SSLSocketFactory m3918a;
        this.f6580d = true;
        try {
            m3918a = NetworkUtils.m3918a(this.f6578b);
            this.f6577a.mo4157e("Fabric", "Custom SSL pinning enabled");
        } catch (Exception e) {
            this.f6577a.mo4159c("Fabric", "Exception while validating pinned certs", e);
            return null;
        }
        return m3918a;
    }

    /* renamed from: c */
    public final synchronized void m3921c() {
        this.f6580d = false;
        this.f6579c = null;
    }

    public DefaultHttpRequestFactory(Logger logger) {
        this.f6577a = logger;
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory
    /* renamed from: a */
    public HttpRequest mo3920a(HttpMethod httpMethod, String str, Map<String, String> map) {
        HttpRequest m553a;
        SSLSocketFactory m3924a;
        int i = C1520a.f6581a[httpMethod.ordinal()];
        if (i == 1) {
            m553a = HttpRequest.m553a((CharSequence) str, (Map<?, ?>) map, true);
        } else if (i == 2) {
            m553a = HttpRequest.m538b((CharSequence) str, (Map<?, ?>) map, true);
        } else if (i == 3) {
            m553a = HttpRequest.m520f((CharSequence) str);
        } else if (i == 4) {
            m553a = HttpRequest.m539b((CharSequence) str);
        } else {
            throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (m3923a(str) && this.f6578b != null && (m3924a = m3924a()) != null) {
            ((HttpsURLConnection) m553a.m512l()).setSSLSocketFactory(m3924a);
        }
        return m553a;
    }

    /* renamed from: a */
    public final boolean m3923a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    /* renamed from: a */
    public final synchronized SSLSocketFactory m3924a() {
        if (this.f6579c == null && !this.f6580d) {
            this.f6579c = m3922b();
        }
        return this.f6579c;
    }
}
