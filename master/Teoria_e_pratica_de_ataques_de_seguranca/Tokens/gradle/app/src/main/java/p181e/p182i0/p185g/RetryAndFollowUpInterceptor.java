package p181e.p182i0.p185g;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import p181e.Address;
import p181e.C1737b0;
import p181e.C1744d0;
import p181e.CertificatePinner;
import p181e.HttpUrl;
import p181e.Interceptor;
import p181e.OkHttpClient;
import p181e.RequestBody;
import p181e.ResponseBody;
import p181e.Route;
import p181e.p182i0.Util;
import p181e.p182i0.p184f.RealConnection;
import p181e.p182i0.p184f.StreamAllocation;

/* renamed from: e.i0.g.j */
/* loaded from: classes.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* renamed from: a */
    public final OkHttpClient f8025a;

    /* renamed from: b */
    public final boolean f8026b;

    /* renamed from: c */
    public StreamAllocation f8027c;

    /* renamed from: d */
    public Object f8028d;

    /* renamed from: e */
    public volatile boolean f8029e;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.f8025a = okHttpClient;
        this.f8026b = z;
    }

    /* renamed from: a */
    public void m3054a() {
        this.f8029e = true;
        StreamAllocation streamAllocation = this.f8027c;
        if (streamAllocation != null) {
            streamAllocation.m3092a();
        }
    }

    /* renamed from: b */
    public boolean m3047b() {
        return this.f8029e;
    }

    @Override // p181e.Interceptor
    public C1744d0 intercept(Interceptor.InterfaceC1812a interfaceC1812a) {
        C1737b0 mo2696a = interfaceC1812a.mo2696a();
        this.f8027c = new StreamAllocation(this.f8025a.m2676d(), m3051a(mo2696a.m3254g()), this.f8028d);
        C1744d0 c1744d0 = null;
        int i = 0;
        while (!this.f8029e) {
            try {
                try {
                    C1744d0 m3060a = ((RealInterceptorChain) interfaceC1812a).m3060a(mo2696a, this.f8027c, null, null);
                    if (c1744d0 != null) {
                        C1744d0.C1745a m3218q = m3060a.m3218q();
                        C1744d0.C1745a m3218q2 = c1744d0.m3218q();
                        m3218q2.m3209a((ResponseBody) null);
                        m3218q.m3199d(m3218q2.m3214a());
                        m3060a = m3218q.m3214a();
                    }
                    c1744d0 = m3060a;
                    mo2696a = m3053a(c1744d0);
                } catch (IOException e) {
                    if (!m3049a(e, !(e instanceof ConnectionShutdownException), mo2696a)) {
                        throw e;
                    }
                } catch (RouteException e2) {
                    if (!m3049a(e2.m493a(), false, mo2696a)) {
                        throw e2.m493a();
                    }
                }
                if (mo2696a == null) {
                    if (!this.f8026b) {
                        this.f8027c.m3078f();
                    }
                    return c1744d0;
                }
                Util.m3169a(c1744d0.m3225j());
                i++;
                if (i <= 20) {
                    mo2696a.m3261a();
                    if (!m3052a(c1744d0, mo2696a.m3254g())) {
                        this.f8027c.m3078f();
                        this.f8027c = new StreamAllocation(this.f8025a.m2676d(), m3051a(mo2696a.m3254g()), this.f8028d);
                    } else if (this.f8027c.m3084b() != null) {
                        throw new IllegalStateException("Closing the body of " + c1744d0 + " didn't close its backing stream. Bad interceptor?");
                    }
                } else {
                    this.f8027c.m3078f();
                    throw new ProtocolException("Too many follow-up requests: " + i);
                }
            } catch (Throwable th) {
                this.f8027c.m3087a((IOException) null);
                this.f8027c.m3078f();
                throw th;
            }
        }
        this.f8027c.m3078f();
        throw new IOException("Canceled");
    }

    /* renamed from: a */
    public void m3048a(Object obj) {
        this.f8028d = obj;
    }

    /* renamed from: a */
    public final Address m3051a(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.m2729h()) {
            SSLSocketFactory m2657y = this.f8025a.m2657y();
            hostnameVerifier = this.f8025a.m2668n();
            sSLSocketFactory = m2657y;
            certificatePinner = this.f8025a.m2678b();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.m2730g(), httpUrl.m2726k(), this.f8025a.m2672h(), this.f8025a.m2658x(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.f8025a.m2662t(), this.f8025a.m2663s(), this.f8025a.m2664r(), this.f8025a.m2675e(), this.f8025a.m2661u());
    }

    /* renamed from: a */
    public final boolean m3049a(IOException iOException, boolean z, C1737b0 c1737b0) {
        this.f8027c.m3087a(iOException);
        if (this.f8025a.m2659w()) {
            if (z) {
                c1737b0.m3261a();
            }
            return m3050a(iOException, z) && this.f8027c.m3080d();
        }
        return false;
    }

    /* renamed from: a */
    public final boolean m3050a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    /* renamed from: a */
    public final C1737b0 m3053a(C1744d0 c1744d0) {
        String m3226b;
        HttpUrl m2739b;
        Proxy m2663s;
        if (c1744d0 != null) {
            RealConnection m3082c = this.f8027c.m3082c();
            Route mo3114b = m3082c != null ? m3082c.mo3114b() : null;
            int m3223l = c1744d0.m3223l();
            String m3256e = c1744d0.m3216s().m3256e();
            if (m3223l == 307 || m3223l == 308) {
                if (!m3256e.equals("GET") && !m3256e.equals("HEAD")) {
                    return null;
                }
            } else if (m3223l != 401) {
                if (m3223l == 407) {
                    if (mo3114b != null) {
                        m2663s = mo3114b.m3190b();
                    } else {
                        m2663s = this.f8025a.m2663s();
                    }
                    if (m2663s.type() == Proxy.Type.HTTP) {
                        return this.f8025a.m2662t().mo3262a(mo3114b, c1744d0);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (m3223l == 408) {
                    c1744d0.m3216s().m3261a();
                    return c1744d0.m3216s();
                } else {
                    switch (m3223l) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                }
            } else {
                return this.f8025a.m2681a().mo3262a(mo3114b, c1744d0);
            }
            if (!this.f8025a.m2670l() || (m3226b = c1744d0.m3226b("Location")) == null || (m2739b = c1744d0.m3216s().m3254g().m2739b(m3226b)) == null) {
                return null;
            }
            if (m2739b.m2723n().equals(c1744d0.m3216s().m3254g().m2723n()) || this.f8025a.m2669m()) {
                C1737b0.C1738a m3255f = c1744d0.m3216s().m3255f();
                if (C1758f.m3064b(m3256e)) {
                    boolean m3062d = C1758f.m3062d(m3256e);
                    if (C1758f.m3063c(m3256e)) {
                        m3255f.m3249a("GET", (RequestBody) null);
                    } else {
                        m3255f.m3249a(m3256e, m3062d ? c1744d0.m3216s().m3261a() : null);
                    }
                    if (!m3062d) {
                        m3255f.m3250a("Transfer-Encoding");
                        m3255f.m3250a("Content-Length");
                        m3255f.m3250a("Content-Type");
                    }
                }
                if (!m3052a(c1744d0, m2739b)) {
                    m3255f.m3250a("Authorization");
                }
                m3255f.m3251a(m2739b);
                return m3255f.m3253a();
            }
            return null;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public final boolean m3052a(C1744d0 c1744d0, HttpUrl httpUrl) {
        HttpUrl m3254g = c1744d0.m3216s().m3254g();
        return m3254g.m2730g().equals(httpUrl.m2730g()) && m3254g.m2726k() == httpUrl.m2726k() && m3254g.m2723n().equals(httpUrl.m2723n());
    }
}
