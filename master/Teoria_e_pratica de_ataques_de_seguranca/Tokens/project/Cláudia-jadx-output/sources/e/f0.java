package e;

import java.net.InetSocketAddress;
import java.net.Proxy;
/* compiled from: Route.java */
/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public final a f5533a;

    /* renamed from: b  reason: collision with root package name */
    public final Proxy f5534b;

    /* renamed from: c  reason: collision with root package name */
    public final InetSocketAddress f5535c;

    public f0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f5533a = aVar;
            this.f5534b = proxy;
            this.f5535c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public a a() {
        return this.f5533a;
    }

    public Proxy b() {
        return this.f5534b;
    }

    public boolean c() {
        return this.f5533a.f5461i != null && this.f5534b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f5535c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof f0) {
            f0 f0Var = (f0) obj;
            if (f0Var.f5533a.equals(this.f5533a) && f0Var.f5534b.equals(this.f5534b) && f0Var.f5535c.equals(this.f5535c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f5533a.hashCode()) * 31) + this.f5534b.hashCode()) * 31) + this.f5535c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f5535c + "}";
    }
}
