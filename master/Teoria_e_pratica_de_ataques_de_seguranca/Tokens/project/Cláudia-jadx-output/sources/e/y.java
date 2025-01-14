package e;

import e.d0;
import e.e;
import e.q;
import e.t;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* compiled from: OkHttpClient.java */
/* loaded from: classes.dex */
public class y implements Cloneable, e.a, h0 {
    public static final List<z> B = e.i0.c.a(z.HTTP_2, z.HTTP_1_1);
    public static final List<k> C = e.i0.c.a(k.f5880f, k.f5881g);
    public final int A;

    /* renamed from: a  reason: collision with root package name */
    public final o f5963a;

    /* renamed from: b  reason: collision with root package name */
    public final Proxy f5964b;

    /* renamed from: c  reason: collision with root package name */
    public final List<z> f5965c;

    /* renamed from: d  reason: collision with root package name */
    public final List<k> f5966d;

    /* renamed from: e  reason: collision with root package name */
    public final List<v> f5967e;

    /* renamed from: f  reason: collision with root package name */
    public final List<v> f5968f;

    /* renamed from: g  reason: collision with root package name */
    public final q.c f5969g;

    /* renamed from: h  reason: collision with root package name */
    public final ProxySelector f5970h;

    /* renamed from: i  reason: collision with root package name */
    public final m f5971i;
    public final c j;
    public final e.i0.e.d k;
    public final SocketFactory m;
    public final SSLSocketFactory n;
    public final e.i0.l.b o;
    public final HostnameVerifier p;
    public final g q;
    public final e.b r;
    public final e.b s;
    public final j t;
    public final p u;
    public final boolean v;
    public final boolean w;
    public final boolean x;
    public final int y;
    public final int z;

    /* compiled from: OkHttpClient.java */
    /* loaded from: classes.dex */
    public class a extends e.i0.a {
        @Override // e.i0.a
        public void a(t.a aVar, String str) {
            aVar.a(str);
        }

        @Override // e.i0.a
        public void b(j jVar, e.i0.f.c cVar) {
            jVar.b(cVar);
        }

        @Override // e.i0.a
        public void a(t.a aVar, String str, String str2) {
            aVar.b(str, str2);
        }

        @Override // e.i0.a
        public boolean a(j jVar, e.i0.f.c cVar) {
            return jVar.a(cVar);
        }

        @Override // e.i0.a
        public e.i0.f.c a(j jVar, e.a aVar, e.i0.f.f fVar, f0 f0Var) {
            return jVar.a(aVar, fVar, f0Var);
        }

        @Override // e.i0.a
        public boolean a(e.a aVar, e.a aVar2) {
            return aVar.a(aVar2);
        }

        @Override // e.i0.a
        public Socket a(j jVar, e.a aVar, e.i0.f.f fVar) {
            return jVar.a(aVar, fVar);
        }

        @Override // e.i0.a
        public e.i0.f.d a(j jVar) {
            return jVar.f5867e;
        }

        @Override // e.i0.a
        public int a(d0.a aVar) {
            return aVar.f5518c;
        }

        @Override // e.i0.a
        public void a(k kVar, SSLSocket sSLSocket, boolean z) {
            kVar.a(sSLSocket, z);
        }
    }

    /* compiled from: OkHttpClient.java */
    /* loaded from: classes.dex */
    public static final class b {
        public int A;

        /* renamed from: b  reason: collision with root package name */
        public Proxy f5973b;
        public c j;
        public e.i0.e.d k;
        public SSLSocketFactory m;
        public e.i0.l.b n;
        public e.b q;
        public e.b r;
        public j s;
        public p t;
        public boolean u;
        public boolean v;
        public boolean w;
        public int x;
        public int y;
        public int z;

        /* renamed from: e  reason: collision with root package name */
        public final List<v> f5976e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        public final List<v> f5977f = new ArrayList();

        /* renamed from: a  reason: collision with root package name */
        public o f5972a = new o();

        /* renamed from: c  reason: collision with root package name */
        public List<z> f5974c = y.B;

        /* renamed from: d  reason: collision with root package name */
        public List<k> f5975d = y.C;

        /* renamed from: g  reason: collision with root package name */
        public q.c f5978g = q.a(q.f5908a);

        /* renamed from: h  reason: collision with root package name */
        public ProxySelector f5979h = ProxySelector.getDefault();

        /* renamed from: i  reason: collision with root package name */
        public m f5980i = m.f5899a;
        public SocketFactory l = SocketFactory.getDefault();
        public HostnameVerifier o = e.i0.l.d.f5858a;
        public g p = g.f5536c;

        public b() {
            e.b bVar = e.b.f5469a;
            this.q = bVar;
            this.r = bVar;
            this.s = new j();
            this.t = p.f5907a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 10000;
            this.y = 10000;
            this.z = 10000;
            this.A = 0;
        }

        public b a(long j, TimeUnit timeUnit) {
            this.x = a("timeout", j, timeUnit);
            return this;
        }

        public b b(long j, TimeUnit timeUnit) {
            this.y = a("timeout", j, timeUnit);
            return this;
        }

        public b c(long j, TimeUnit timeUnit) {
            this.z = a("timeout", j, timeUnit);
            return this;
        }

        public static int a(String str, long j, TimeUnit timeUnit) {
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException(str + " < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0 || i2 <= 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }

        public b a(v vVar) {
            this.f5976e.add(vVar);
            return this;
        }

        public y a() {
            return new y(this);
        }
    }

    static {
        e.i0.a.f5560a = new a();
    }

    public y() {
        this(new b());
    }

    public int A() {
        return this.A;
    }

    public final SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    public g b() {
        return this.q;
    }

    public int c() {
        return this.y;
    }

    public j d() {
        return this.t;
    }

    public List<k> e() {
        return this.f5966d;
    }

    public m f() {
        return this.f5971i;
    }

    public o g() {
        return this.f5963a;
    }

    public p h() {
        return this.u;
    }

    public q.c i() {
        return this.f5969g;
    }

    public boolean l() {
        return this.w;
    }

    public boolean m() {
        return this.v;
    }

    public HostnameVerifier n() {
        return this.p;
    }

    public List<v> o() {
        return this.f5967e;
    }

    public e.i0.e.d p() {
        c cVar = this.j;
        return cVar != null ? cVar.f5481a : this.k;
    }

    public List<v> q() {
        return this.f5968f;
    }

    public List<z> r() {
        return this.f5965c;
    }

    public Proxy s() {
        return this.f5964b;
    }

    public e.b t() {
        return this.r;
    }

    public ProxySelector u() {
        return this.f5970h;
    }

    public int v() {
        return this.z;
    }

    public boolean w() {
        return this.x;
    }

    public SocketFactory x() {
        return this.m;
    }

    public SSLSocketFactory y() {
        return this.n;
    }

    public final X509TrustManager z() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    public y(b bVar) {
        boolean z;
        this.f5963a = bVar.f5972a;
        this.f5964b = bVar.f5973b;
        this.f5965c = bVar.f5974c;
        this.f5966d = bVar.f5975d;
        this.f5967e = e.i0.c.a(bVar.f5976e);
        this.f5968f = e.i0.c.a(bVar.f5977f);
        this.f5969g = bVar.f5978g;
        this.f5970h = bVar.f5979h;
        this.f5971i = bVar.f5980i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.m = bVar.l;
        loop0: while (true) {
            for (k kVar : this.f5966d) {
                z = z || kVar.b();
            }
        }
        if (bVar.m == null && z) {
            X509TrustManager z2 = z();
            this.n = a(z2);
            this.o = e.i0.l.b.a(z2);
        } else {
            this.n = bVar.m;
            this.o = bVar.n;
        }
        this.p = bVar.o;
        this.q = bVar.p.a(this.o);
        this.r = bVar.q;
        this.s = bVar.r;
        this.t = bVar.s;
        this.u = bVar.t;
        this.v = bVar.u;
        this.w = bVar.v;
        this.x = bVar.w;
        this.y = bVar.x;
        this.z = bVar.y;
        this.A = bVar.z;
        int i2 = bVar.A;
    }

    public e.b a() {
        return this.s;
    }

    @Override // e.e.a
    public e a(b0 b0Var) {
        return new a0(this, b0Var, false);
    }
}
