package p181e.p182i0.p184f;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import p181e.Address;
import p181e.HttpUrl;
import p181e.Route;
import p181e.p182i0.Util;

/* renamed from: e.i0.f.e */
/* loaded from: classes.dex */
public final class RouteSelector {

    /* renamed from: a */
    public final Address f7991a;

    /* renamed from: b */
    public final RouteDatabase f7992b;

    /* renamed from: c */
    public Proxy f7993c;

    /* renamed from: d */
    public InetSocketAddress f7994d;

    /* renamed from: f */
    public int f7996f;

    /* renamed from: h */
    public int f7998h;

    /* renamed from: e */
    public List<Proxy> f7995e = Collections.emptyList();

    /* renamed from: g */
    public List<InetSocketAddress> f7997g = Collections.emptyList();

    /* renamed from: i */
    public final List<Route> f7999i = new ArrayList();

    public RouteSelector(Address address, RouteDatabase routeDatabase) {
        this.f7991a = address;
        this.f7992b = routeDatabase;
        m3102a(address.m3268k(), address.m3273f());
    }

    /* renamed from: a */
    public boolean m3104a() {
        return m3099b() || m3097d() || m3098c();
    }

    /* renamed from: b */
    public final boolean m3099b() {
        return this.f7998h < this.f7997g.size();
    }

    /* renamed from: c */
    public final boolean m3098c() {
        return !this.f7999i.isEmpty();
    }

    /* renamed from: d */
    public final boolean m3097d() {
        return this.f7996f < this.f7995e.size();
    }

    /* renamed from: e */
    public Route m3096e() {
        if (!m3099b()) {
            if (!m3097d()) {
                if (m3098c()) {
                    return m3094g();
                }
                throw new NoSuchElementException();
            }
            this.f7993c = m3093h();
        }
        this.f7994d = m3095f();
        Route route = new Route(this.f7991a, this.f7993c, this.f7994d);
        if (this.f7992b.m3105c(route)) {
            this.f7999i.add(route);
            return m3096e();
        }
        return route;
    }

    /* renamed from: f */
    public final InetSocketAddress m3095f() {
        if (m3099b()) {
            List<InetSocketAddress> list = this.f7997g;
            int i = this.f7998h;
            this.f7998h = i + 1;
            return list.get(i);
        }
        throw new SocketException("No route to " + this.f7991a.m3268k().m2730g() + "; exhausted inet socket addresses: " + this.f7997g);
    }

    /* renamed from: g */
    public final Route m3094g() {
        return this.f7999i.remove(0);
    }

    /* renamed from: h */
    public final Proxy m3093h() {
        if (m3097d()) {
            List<Proxy> list = this.f7995e;
            int i = this.f7996f;
            this.f7996f = i + 1;
            Proxy proxy = list.get(i);
            m3100a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f7991a.m3268k().m2730g() + "; exhausted proxy configurations: " + this.f7995e);
    }

    /* renamed from: a */
    public void m3103a(Route route, IOException iOException) {
        if (route.m3190b().type() != Proxy.Type.DIRECT && this.f7991a.m3271h() != null) {
            this.f7991a.m3271h().connectFailed(this.f7991a.m3268k().m2722o(), route.m3190b().address(), iOException);
        }
        this.f7992b.m3106b(route);
    }

    /* renamed from: a */
    public final void m3102a(HttpUrl httpUrl, Proxy proxy) {
        if (proxy != null) {
            this.f7995e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f7991a.m3271h().select(httpUrl.m2722o());
            this.f7995e = (select == null || select.isEmpty()) ? Util.m3156a(Proxy.NO_PROXY) : Util.m3157a(select);
        }
        this.f7996f = 0;
    }

    /* renamed from: a */
    public final void m3100a(Proxy proxy) {
        String m2730g;
        int m2726k;
        this.f7997g = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                m2730g = m3101a(inetSocketAddress);
                m2726k = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            m2730g = this.f7991a.m3268k().m2730g();
            m2726k = this.f7991a.m3268k().m2726k();
        }
        if (m2726k >= 1 && m2726k <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f7997g.add(InetSocketAddress.createUnresolved(m2730g, m2726k));
            } else {
                List<InetAddress> mo2777a = this.f7991a.m3276c().mo2777a(m2730g);
                if (!mo2777a.isEmpty()) {
                    int size = mo2777a.size();
                    for (int i = 0; i < size; i++) {
                        this.f7997g.add(new InetSocketAddress(mo2777a.get(i), m2726k));
                    }
                } else {
                    throw new UnknownHostException(this.f7991a.m3276c() + " returned no addresses for " + m2730g);
                }
            }
            this.f7998h = 0;
            return;
        }
        throw new SocketException("No route to " + m2730g + ":" + m2726k + "; port is out of range");
    }

    /* renamed from: a */
    public static String m3101a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
