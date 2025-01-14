package e;

import e.u;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: Address.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final u f5453a;

    /* renamed from: b  reason: collision with root package name */
    public final p f5454b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f5455c;

    /* renamed from: d  reason: collision with root package name */
    public final b f5456d;

    /* renamed from: e  reason: collision with root package name */
    public final List<z> f5457e;

    /* renamed from: f  reason: collision with root package name */
    public final List<k> f5458f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f5459g;

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f5460h;

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f5461i;
    public final HostnameVerifier j;
    public final g k;

    public a(String str, int i2, p pVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b bVar, Proxy proxy, List<z> list, List<k> list2, ProxySelector proxySelector) {
        u.a aVar = new u.a();
        aVar.f(sSLSocketFactory != null ? "https" : "http");
        aVar.b(str);
        aVar.a(i2);
        this.f5453a = aVar.a();
        if (pVar != null) {
            this.f5454b = pVar;
            if (socketFactory != null) {
                this.f5455c = socketFactory;
                if (bVar != null) {
                    this.f5456d = bVar;
                    if (list != null) {
                        this.f5457e = e.i0.c.a(list);
                        if (list2 != null) {
                            this.f5458f = e.i0.c.a(list2);
                            if (proxySelector != null) {
                                this.f5459g = proxySelector;
                                this.f5460h = proxy;
                                this.f5461i = sSLSocketFactory;
                                this.j = hostnameVerifier;
                                this.k = gVar;
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

    public g a() {
        return this.k;
    }

    public List<k> b() {
        return this.f5458f;
    }

    public p c() {
        return this.f5454b;
    }

    public HostnameVerifier d() {
        return this.j;
    }

    public List<z> e() {
        return this.f5457e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f5453a.equals(aVar.f5453a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public Proxy f() {
        return this.f5460h;
    }

    public b g() {
        return this.f5456d;
    }

    public ProxySelector h() {
        return this.f5459g;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f5453a.hashCode()) * 31) + this.f5454b.hashCode()) * 31) + this.f5456d.hashCode()) * 31) + this.f5457e.hashCode()) * 31) + this.f5458f.hashCode()) * 31) + this.f5459g.hashCode()) * 31;
        Proxy proxy = this.f5460h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f5461i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        g gVar = this.k;
        return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
    }

    public SocketFactory i() {
        return this.f5455c;
    }

    public SSLSocketFactory j() {
        return this.f5461i;
    }

    public u k() {
        return this.f5453a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f5453a.g());
        sb.append(":");
        sb.append(this.f5453a.k());
        if (this.f5460h != null) {
            sb.append(", proxy=");
            sb.append(this.f5460h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f5459g);
        }
        sb.append("}");
        return sb.toString();
    }

    public boolean a(a aVar) {
        return this.f5454b.equals(aVar.f5454b) && this.f5456d.equals(aVar.f5456d) && this.f5457e.equals(aVar.f5457e) && this.f5458f.equals(aVar.f5458f) && this.f5459g.equals(aVar.f5459g) && e.i0.c.a(this.f5460h, aVar.f5460h) && e.i0.c.a(this.f5461i, aVar.f5461i) && e.i0.c.a(this.j, aVar.j) && e.i0.c.a(this.k, aVar.k) && k().k() == aVar.k().k();
    }
}
