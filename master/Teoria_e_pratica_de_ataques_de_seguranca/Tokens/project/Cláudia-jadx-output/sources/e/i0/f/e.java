package e.i0.f;

import e.f0;
import e.u;
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
/* compiled from: RouteSelector.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final e.a f5603a;

    /* renamed from: b  reason: collision with root package name */
    public final d f5604b;

    /* renamed from: c  reason: collision with root package name */
    public Proxy f5605c;

    /* renamed from: d  reason: collision with root package name */
    public InetSocketAddress f5606d;

    /* renamed from: f  reason: collision with root package name */
    public int f5608f;

    /* renamed from: h  reason: collision with root package name */
    public int f5610h;

    /* renamed from: e  reason: collision with root package name */
    public List<Proxy> f5607e = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public List<InetSocketAddress> f5609g = Collections.emptyList();

    /* renamed from: i  reason: collision with root package name */
    public final List<f0> f5611i = new ArrayList();

    public e(e.a aVar, d dVar) {
        this.f5603a = aVar;
        this.f5604b = dVar;
        a(aVar.k(), aVar.f());
    }

    public boolean a() {
        return b() || d() || c();
    }

    public final boolean b() {
        return this.f5610h < this.f5609g.size();
    }

    public final boolean c() {
        return !this.f5611i.isEmpty();
    }

    public final boolean d() {
        return this.f5608f < this.f5607e.size();
    }

    public f0 e() {
        if (!b()) {
            if (!d()) {
                if (c()) {
                    return g();
                }
                throw new NoSuchElementException();
            }
            this.f5605c = h();
        }
        this.f5606d = f();
        f0 f0Var = new f0(this.f5603a, this.f5605c, this.f5606d);
        if (this.f5604b.c(f0Var)) {
            this.f5611i.add(f0Var);
            return e();
        }
        return f0Var;
    }

    public final InetSocketAddress f() {
        if (b()) {
            List<InetSocketAddress> list = this.f5609g;
            int i2 = this.f5610h;
            this.f5610h = i2 + 1;
            return list.get(i2);
        }
        throw new SocketException("No route to " + this.f5603a.k().g() + "; exhausted inet socket addresses: " + this.f5609g);
    }

    public final f0 g() {
        return this.f5611i.remove(0);
    }

    public final Proxy h() {
        if (d()) {
            List<Proxy> list = this.f5607e;
            int i2 = this.f5608f;
            this.f5608f = i2 + 1;
            Proxy proxy = list.get(i2);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f5603a.k().g() + "; exhausted proxy configurations: " + this.f5607e);
    }

    public void a(f0 f0Var, IOException iOException) {
        if (f0Var.b().type() != Proxy.Type.DIRECT && this.f5603a.h() != null) {
            this.f5603a.h().connectFailed(this.f5603a.k().o(), f0Var.b().address(), iOException);
        }
        this.f5604b.b(f0Var);
    }

    public final void a(u uVar, Proxy proxy) {
        if (proxy != null) {
            this.f5607e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f5603a.h().select(uVar.o());
            this.f5607e = (select == null || select.isEmpty()) ? e.i0.c.a(Proxy.NO_PROXY) : e.i0.c.a(select);
        }
        this.f5608f = 0;
    }

    public final void a(Proxy proxy) {
        String g2;
        int k;
        this.f5609g = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                g2 = a(inetSocketAddress);
                k = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            g2 = this.f5603a.k().g();
            k = this.f5603a.k().k();
        }
        if (k >= 1 && k <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f5609g.add(InetSocketAddress.createUnresolved(g2, k));
            } else {
                List<InetAddress> a2 = this.f5603a.c().a(g2);
                if (!a2.isEmpty()) {
                    int size = a2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.f5609g.add(new InetSocketAddress(a2.get(i2), k));
                    }
                } else {
                    throw new UnknownHostException(this.f5603a.c() + " returned no addresses for " + g2);
                }
            }
            this.f5610h = 0;
            return;
        }
        throw new SocketException("No route to " + g2 + ":" + k + "; port is out of range");
    }

    public static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
