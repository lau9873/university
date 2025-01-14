package p181e;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* renamed from: e.f0 */
/* loaded from: classes.dex */
public final class Route {

    /* renamed from: a */
    public final Address f7896a;

    /* renamed from: b */
    public final Proxy f7897b;

    /* renamed from: c */
    public final InetSocketAddress f7898c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f7896a = address;
            this.f7897b = proxy;
            this.f7898c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    /* renamed from: a */
    public Address m3191a() {
        return this.f7896a;
    }

    /* renamed from: b */
    public Proxy m3190b() {
        return this.f7897b;
    }

    /* renamed from: c */
    public boolean m3189c() {
        return this.f7896a.f7811i != null && this.f7897b.type() == Proxy.Type.HTTP;
    }

    /* renamed from: d */
    public InetSocketAddress m3188d() {
        return this.f7898c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (route.f7896a.equals(this.f7896a) && route.f7897b.equals(this.f7897b) && route.f7898c.equals(this.f7898c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f7896a.hashCode()) * 31) + this.f7897b.hashCode()) * 31) + this.f7898c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f7898c + "}";
    }
}
