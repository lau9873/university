package p181e;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import p181e.HttpUrl;
import p181e.p182i0.Util;

/* renamed from: e.a */
/* loaded from: classes.dex */
public final class Address {

    /* renamed from: a */
    public final HttpUrl f7803a;

    /* renamed from: b */
    public final Dns f7804b;

    /* renamed from: c */
    public final SocketFactory f7805c;

    /* renamed from: d */
    public final Authenticator f7806d;

    /* renamed from: e */
    public final List<Protocol> f7807e;

    /* renamed from: f */
    public final List<ConnectionSpec> f7808f;

    /* renamed from: g */
    public final ProxySelector f7809g;

    /* renamed from: h */
    public final Proxy f7810h;

    /* renamed from: i */
    public final SSLSocketFactory f7811i;

    /* renamed from: j */
    public final HostnameVerifier f7812j;

    /* renamed from: k */
    public final CertificatePinner f7813k;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        HttpUrl.C1810a c1810a = new HttpUrl.C1810a();
        c1810a.m2700f(sSLSocketFactory != null ? "https" : "http");
        c1810a.m2711b(str);
        c1810a.m2720a(i);
        this.f7803a = c1810a.m2721a();
        if (dns != null) {
            this.f7804b = dns;
            if (socketFactory != null) {
                this.f7805c = socketFactory;
                if (authenticator != null) {
                    this.f7806d = authenticator;
                    if (list != null) {
                        this.f7807e = Util.m3157a(list);
                        if (list2 != null) {
                            this.f7808f = Util.m3157a(list2);
                            if (proxySelector != null) {
                                this.f7809g = proxySelector;
                                this.f7810h = proxy;
                                this.f7811i = sSLSocketFactory;
                                this.f7812j = hostnameVerifier;
                                this.f7813k = certificatePinner;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    /* renamed from: a */
    public CertificatePinner m3279a() {
        return this.f7813k;
    }

    /* renamed from: b */
    public List<ConnectionSpec> m3277b() {
        return this.f7808f;
    }

    /* renamed from: c */
    public Dns m3276c() {
        return this.f7804b;
    }

    /* renamed from: d */
    public HostnameVerifier m3275d() {
        return this.f7812j;
    }

    /* renamed from: e */
    public List<Protocol> m3274e() {
        return this.f7807e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (this.f7803a.equals(address.f7803a) && m3278a(address)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public Proxy m3273f() {
        return this.f7810h;
    }

    /* renamed from: g */
    public Authenticator m3272g() {
        return this.f7806d;
    }

    /* renamed from: h */
    public ProxySelector m3271h() {
        return this.f7809g;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f7803a.hashCode()) * 31) + this.f7804b.hashCode()) * 31) + this.f7806d.hashCode()) * 31) + this.f7807e.hashCode()) * 31) + this.f7808f.hashCode()) * 31) + this.f7809g.hashCode()) * 31;
        Proxy proxy = this.f7810h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f7811i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f7812j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner = this.f7813k;
        return hashCode4 + (certificatePinner != null ? certificatePinner.hashCode() : 0);
    }

    /* renamed from: i */
    public SocketFactory m3270i() {
        return this.f7805c;
    }

    /* renamed from: j */
    public SSLSocketFactory m3269j() {
        return this.f7811i;
    }

    /* renamed from: k */
    public HttpUrl m3268k() {
        return this.f7803a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f7803a.m2730g());
        sb.append(":");
        sb.append(this.f7803a.m2726k());
        if (this.f7810h != null) {
            sb.append(", proxy=");
            sb.append(this.f7810h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f7809g);
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public boolean m3278a(Address address) {
        return this.f7804b.equals(address.f7804b) && this.f7806d.equals(address.f7806d) && this.f7807e.equals(address.f7807e) && this.f7808f.equals(address.f7808f) && this.f7809g.equals(address.f7809g) && Util.m3167a(this.f7810h, address.f7810h) && Util.m3167a(this.f7811i, address.f7811i) && Util.m3167a(this.f7812j, address.f7812j) && Util.m3167a(this.f7813k, address.f7813k) && m3268k().m2726k() == address.m3268k().m2726k();
    }
}
