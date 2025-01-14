package p181e;

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
import p181e.C1744d0;
import p181e.Call;
import p181e.EventListener;
import p181e.Headers;
import p181e.p182i0.Internal;
import p181e.p182i0.Util;
import p181e.p182i0.p183e.InternalCache;
import p181e.p182i0.p184f.RealConnection;
import p181e.p182i0.p184f.RouteDatabase;
import p181e.p182i0.p184f.StreamAllocation;
import p181e.p182i0.p190l.AbstractC1795b;
import p181e.p182i0.p190l.OkHostnameVerifier;

/* renamed from: e.y */
/* loaded from: classes.dex */
public class OkHttpClient implements Cloneable, Call.InterfaceC1746a, WebSocket {

    /* renamed from: B */
    public static final List<Protocol> f8376B = Util.m3156a(Protocol.HTTP_2, Protocol.HTTP_1_1);

    /* renamed from: C */
    public static final List<ConnectionSpec> f8377C = Util.m3156a(ConnectionSpec.f8288f, ConnectionSpec.f8289g);

    /* renamed from: A */
    public final int f8378A;

    /* renamed from: a */
    public final Dispatcher f8379a;

    /* renamed from: b */
    public final Proxy f8380b;

    /* renamed from: c */
    public final List<Protocol> f8381c;

    /* renamed from: d */
    public final List<ConnectionSpec> f8382d;

    /* renamed from: e */
    public final List<Interceptor> f8383e;

    /* renamed from: f */
    public final List<Interceptor> f8384f;

    /* renamed from: g */
    public final EventListener.InterfaceC1807c f8385g;

    /* renamed from: h */
    public final ProxySelector f8386h;

    /* renamed from: i */
    public final CookieJar f8387i;

    /* renamed from: j */
    public final C1739c f8388j;

    /* renamed from: k */
    public final InternalCache f8389k;

    /* renamed from: m */
    public final SocketFactory f8390m;

    /* renamed from: n */
    public final SSLSocketFactory f8391n;

    /* renamed from: o */
    public final AbstractC1795b f8392o;

    /* renamed from: p */
    public final HostnameVerifier f8393p;

    /* renamed from: q */
    public final CertificatePinner f8394q;

    /* renamed from: r */
    public final Authenticator f8395r;

    /* renamed from: s */
    public final Authenticator f8396s;

    /* renamed from: t */
    public final ConnectionPool f8397t;

    /* renamed from: u */
    public final Dns f8398u;

    /* renamed from: v */
    public final boolean f8399v;

    /* renamed from: w */
    public final boolean f8400w;

    /* renamed from: x */
    public final boolean f8401x;

    /* renamed from: y */
    public final int f8402y;

    /* renamed from: z */
    public final int f8403z;

    /* compiled from: OkHttpClient.java */
    /* renamed from: e.y$a */
    /* loaded from: classes.dex */
    public class C1815a extends Internal {
        @Override // p181e.p182i0.Internal
        /* renamed from: a */
        public void mo2648a(Headers.C1809a c1809a, String str) {
            c1809a.m2758a(str);
        }

        @Override // p181e.p182i0.Internal
        /* renamed from: b */
        public void mo2646b(ConnectionPool connectionPool, RealConnection realConnection) {
            connectionPool.m2819b(realConnection);
        }

        @Override // p181e.p182i0.Internal
        /* renamed from: a */
        public void mo2647a(Headers.C1809a c1809a, String str, String str2) {
            c1809a.m2755b(str, str2);
        }

        @Override // p181e.p182i0.Internal
        /* renamed from: a */
        public boolean mo2650a(ConnectionPool connectionPool, RealConnection realConnection) {
            return connectionPool.m2821a(realConnection);
        }

        @Override // p181e.p182i0.Internal
        /* renamed from: a */
        public RealConnection mo2651a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
            return connectionPool.m2822a(address, streamAllocation, route);
        }

        @Override // p181e.p182i0.Internal
        /* renamed from: a */
        public boolean mo2655a(Address address, Address address2) {
            return address.m3278a(address2);
        }

        @Override // p181e.p182i0.Internal
        /* renamed from: a */
        public Socket mo2652a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
            return connectionPool.m2823a(address, streamAllocation);
        }

        @Override // p181e.p182i0.Internal
        /* renamed from: a */
        public RouteDatabase mo2653a(ConnectionPool connectionPool) {
            return connectionPool.f8275e;
        }

        @Override // p181e.p182i0.Internal
        /* renamed from: a */
        public int mo2654a(C1744d0.C1745a c1745a) {
            return c1745a.f7878c;
        }

        @Override // p181e.p182i0.Internal
        /* renamed from: a */
        public void mo2649a(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
            connectionSpec.m2812a(sSLSocket, z);
        }
    }

    /* compiled from: OkHttpClient.java */
    /* renamed from: e.y$b */
    /* loaded from: classes.dex */
    public static final class C1816b {

        /* renamed from: A */
        public int f8404A;

        /* renamed from: b */
        public Proxy f8406b;

        /* renamed from: j */
        public C1739c f8414j;

        /* renamed from: k */
        public InternalCache f8415k;

        /* renamed from: m */
        public SSLSocketFactory f8417m;

        /* renamed from: n */
        public AbstractC1795b f8418n;

        /* renamed from: q */
        public Authenticator f8421q;

        /* renamed from: r */
        public Authenticator f8422r;

        /* renamed from: s */
        public ConnectionPool f8423s;

        /* renamed from: t */
        public Dns f8424t;

        /* renamed from: u */
        public boolean f8425u;

        /* renamed from: v */
        public boolean f8426v;

        /* renamed from: w */
        public boolean f8427w;

        /* renamed from: x */
        public int f8428x;

        /* renamed from: y */
        public int f8429y;

        /* renamed from: z */
        public int f8430z;

        /* renamed from: e */
        public final List<Interceptor> f8409e = new ArrayList();

        /* renamed from: f */
        public final List<Interceptor> f8410f = new ArrayList();

        /* renamed from: a */
        public Dispatcher f8405a = new Dispatcher();

        /* renamed from: c */
        public List<Protocol> f8407c = OkHttpClient.f8376B;

        /* renamed from: d */
        public List<ConnectionSpec> f8408d = OkHttpClient.f8377C;

        /* renamed from: g */
        public EventListener.InterfaceC1807c f8411g = EventListener.m2776a(EventListener.f8320a);

        /* renamed from: h */
        public ProxySelector f8412h = ProxySelector.getDefault();

        /* renamed from: i */
        public CookieJar f8413i = CookieJar.f8311a;

        /* renamed from: l */
        public SocketFactory f8416l = SocketFactory.getDefault();

        /* renamed from: o */
        public HostnameVerifier f8419o = OkHostnameVerifier.f8266a;

        /* renamed from: p */
        public CertificatePinner f8420p = CertificatePinner.f7899c;

        public C1816b() {
            Authenticator authenticator = Authenticator.f7821a;
            this.f8421q = authenticator;
            this.f8422r = authenticator;
            this.f8423s = new ConnectionPool();
            this.f8424t = Dns.f8319a;
            this.f8425u = true;
            this.f8426v = true;
            this.f8427w = true;
            this.f8428x = 10000;
            this.f8429y = 10000;
            this.f8430z = 10000;
            this.f8404A = 0;
        }

        /* renamed from: a */
        public C1816b m2644a(long j, TimeUnit timeUnit) {
            this.f8428x = m2642a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: b */
        public C1816b m2641b(long j, TimeUnit timeUnit) {
            this.f8429y = m2642a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: c */
        public C1816b m2640c(long j, TimeUnit timeUnit) {
            this.f8430z = m2642a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: a */
        public static int m2642a(String str, long j, TimeUnit timeUnit) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException(str + " < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0 || i <= 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }

        /* renamed from: a */
        public C1816b m2643a(Interceptor interceptor) {
            this.f8409e.add(interceptor);
            return this;
        }

        /* renamed from: a */
        public OkHttpClient m2645a() {
            return new OkHttpClient(this);
        }
    }

    static {
        Internal.f7932a = new C1815a();
    }

    public OkHttpClient() {
        this(new C1816b());
    }

    /* renamed from: A */
    public int m2682A() {
        return this.f8378A;
    }

    /* renamed from: a */
    public final SSLSocketFactory m2679a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    public CertificatePinner m2678b() {
        return this.f8394q;
    }

    /* renamed from: c */
    public int m2677c() {
        return this.f8402y;
    }

    /* renamed from: d */
    public ConnectionPool m2676d() {
        return this.f8397t;
    }

    /* renamed from: e */
    public List<ConnectionSpec> m2675e() {
        return this.f8382d;
    }

    /* renamed from: f */
    public CookieJar m2674f() {
        return this.f8387i;
    }

    /* renamed from: g */
    public Dispatcher m2673g() {
        return this.f8379a;
    }

    /* renamed from: h */
    public Dns m2672h() {
        return this.f8398u;
    }

    /* renamed from: i */
    public EventListener.InterfaceC1807c m2671i() {
        return this.f8385g;
    }

    /* renamed from: l */
    public boolean m2670l() {
        return this.f8400w;
    }

    /* renamed from: m */
    public boolean m2669m() {
        return this.f8399v;
    }

    /* renamed from: n */
    public HostnameVerifier m2668n() {
        return this.f8393p;
    }

    /* renamed from: o */
    public List<Interceptor> m2667o() {
        return this.f8383e;
    }

    /* renamed from: p */
    public InternalCache m2666p() {
        C1739c c1739c = this.f8388j;
        return c1739c != null ? c1739c.f7833a : this.f8389k;
    }

    /* renamed from: q */
    public List<Interceptor> m2665q() {
        return this.f8384f;
    }

    /* renamed from: r */
    public List<Protocol> m2664r() {
        return this.f8381c;
    }

    /* renamed from: s */
    public Proxy m2663s() {
        return this.f8380b;
    }

    /* renamed from: t */
    public Authenticator m2662t() {
        return this.f8395r;
    }

    /* renamed from: u */
    public ProxySelector m2661u() {
        return this.f8386h;
    }

    /* renamed from: v */
    public int m2660v() {
        return this.f8403z;
    }

    /* renamed from: w */
    public boolean m2659w() {
        return this.f8401x;
    }

    /* renamed from: x */
    public SocketFactory m2658x() {
        return this.f8390m;
    }

    /* renamed from: y */
    public SSLSocketFactory m2657y() {
        return this.f8391n;
    }

    /* renamed from: z */
    public final X509TrustManager m2656z() {
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

    public OkHttpClient(C1816b c1816b) {
        boolean z;
        this.f8379a = c1816b.f8405a;
        this.f8380b = c1816b.f8406b;
        this.f8381c = c1816b.f8407c;
        this.f8382d = c1816b.f8408d;
        this.f8383e = Util.m3157a(c1816b.f8409e);
        this.f8384f = Util.m3157a(c1816b.f8410f);
        this.f8385g = c1816b.f8411g;
        this.f8386h = c1816b.f8412h;
        this.f8387i = c1816b.f8413i;
        this.f8388j = c1816b.f8414j;
        this.f8389k = c1816b.f8415k;
        this.f8390m = c1816b.f8416l;
        loop0: while (true) {
            for (ConnectionSpec connectionSpec : this.f8382d) {
                z = z || connectionSpec.m2811b();
            }
        }
        if (c1816b.f8417m == null && z) {
            X509TrustManager m2656z = m2656z();
            this.f8391n = m2679a(m2656z);
            this.f8392o = AbstractC1795b.m2842a(m2656z);
        } else {
            this.f8391n = c1816b.f8417m;
            this.f8392o = c1816b.f8418n;
        }
        this.f8393p = c1816b.f8419o;
        this.f8394q = c1816b.f8420p.m3187a(this.f8392o);
        this.f8395r = c1816b.f8421q;
        this.f8396s = c1816b.f8422r;
        this.f8397t = c1816b.f8423s;
        this.f8398u = c1816b.f8424t;
        this.f8399v = c1816b.f8425u;
        this.f8400w = c1816b.f8426v;
        this.f8401x = c1816b.f8427w;
        this.f8402y = c1816b.f8428x;
        this.f8403z = c1816b.f8429y;
        this.f8378A = c1816b.f8430z;
        int i = c1816b.f8404A;
    }

    /* renamed from: a */
    public Authenticator m2681a() {
        return this.f8396s;
    }

    @Override // p181e.Call.InterfaceC1746a
    /* renamed from: a */
    public Call mo2680a(C1737b0 c1737b0) {
        return new RealCall(this, c1737b0, false);
    }
}
