package p181e.p182i0.p184f;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import p181e.Address;
import p181e.ConnectionPool;
import p181e.OkHttpClient;
import p181e.Route;
import p181e.p182i0.Internal;
import p181e.p182i0.Util;
import p181e.p182i0.p185g.HttpCodec;
import p181e.p182i0.p187i.ErrorCode;

/* renamed from: e.i0.f.f */
/* loaded from: classes.dex */
public final class StreamAllocation {

    /* renamed from: a */
    public final Address f8000a;

    /* renamed from: b */
    public Route f8001b;

    /* renamed from: c */
    public final ConnectionPool f8002c;

    /* renamed from: d */
    public final Object f8003d;

    /* renamed from: e */
    public final RouteSelector f8004e;

    /* renamed from: f */
    public int f8005f;

    /* renamed from: g */
    public RealConnection f8006g;

    /* renamed from: h */
    public boolean f8007h;

    /* renamed from: i */
    public boolean f8008i;

    /* renamed from: j */
    public HttpCodec f8009j;

    /* compiled from: StreamAllocation.java */
    /* renamed from: e.i0.f.f$a */
    /* loaded from: classes.dex */
    public static final class C1756a extends WeakReference<StreamAllocation> {

        /* renamed from: a */
        public final Object f8010a;

        public C1756a(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.f8010a = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Object obj) {
        this.f8002c = connectionPool;
        this.f8000a = address;
        this.f8004e = new RouteSelector(address, m3077g());
        this.f8003d = obj;
    }

    /* renamed from: a */
    public HttpCodec m3088a(OkHttpClient okHttpClient, boolean z) {
        try {
            HttpCodec m3116a = m3090a(okHttpClient.m2677c(), okHttpClient.m2660v(), okHttpClient.m2682A(), okHttpClient.m2659w(), z).m3116a(okHttpClient, this);
            synchronized (this.f8002c) {
                this.f8009j = m3116a;
            }
            return m3116a;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* renamed from: b */
    public HttpCodec m3084b() {
        HttpCodec httpCodec;
        synchronized (this.f8002c) {
            httpCodec = this.f8009j;
        }
        return httpCodec;
    }

    /* renamed from: c */
    public synchronized RealConnection m3082c() {
        return this.f8006g;
    }

    /* renamed from: d */
    public boolean m3080d() {
        return this.f8001b != null || this.f8004e.m3104a();
    }

    /* renamed from: e */
    public void m3079e() {
        Socket m3085a;
        synchronized (this.f8002c) {
            m3085a = m3085a(true, false, false);
        }
        Util.m3160a(m3085a);
    }

    /* renamed from: f */
    public void m3078f() {
        Socket m3085a;
        synchronized (this.f8002c) {
            m3085a = m3085a(false, true, false);
        }
        Util.m3160a(m3085a);
    }

    /* renamed from: g */
    public final RouteDatabase m3077g() {
        return Internal.f7932a.mo2653a(this.f8002c);
    }

    public String toString() {
        RealConnection m3082c = m3082c();
        return m3082c != null ? m3082c.toString() : this.f8000a.toString();
    }

    /* renamed from: c */
    public Socket m3081c(RealConnection realConnection) {
        if (this.f8009j == null && this.f8006g.f7988n.size() == 1) {
            Socket m3085a = m3085a(true, false, false);
            this.f8006g = realConnection;
            realConnection.f7988n.add(this.f8006g.f7988n.get(0));
            return m3085a;
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public final void m3083b(RealConnection realConnection) {
        int size = realConnection.f7988n.size();
        for (int i = 0; i < size; i++) {
            if (realConnection.f7988n.get(i).get() == this) {
                realConnection.f7988n.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public final RealConnection m3090a(int i, int i2, int i3, boolean z, boolean z2) {
        while (true) {
            RealConnection m3091a = m3091a(i, i2, i3, z);
            synchronized (this.f8002c) {
                if (m3091a.f7986l == 0) {
                    return m3091a;
                }
                if (m3091a.m3115a(z2)) {
                    return m3091a;
                }
                m3079e();
            }
        }
    }

    /* renamed from: a */
    public final RealConnection m3091a(int i, int i2, int i3, boolean z) {
        synchronized (this.f8002c) {
            if (!this.f8007h) {
                if (this.f8009j == null) {
                    if (!this.f8008i) {
                        RealConnection realConnection = this.f8006g;
                        if (realConnection == null || realConnection.f7985k) {
                            Socket socket = null;
                            Internal.f7932a.mo2651a(this.f8002c, this.f8000a, this, null);
                            if (this.f8006g != null) {
                                return this.f8006g;
                            }
                            Route route = this.f8001b;
                            if (route == null) {
                                route = this.f8004e.m3096e();
                            }
                            synchronized (this.f8002c) {
                                if (!this.f8008i) {
                                    Internal.f7932a.mo2651a(this.f8002c, this.f8000a, this, route);
                                    if (this.f8006g != null) {
                                        return this.f8006g;
                                    }
                                    this.f8001b = route;
                                    this.f8005f = 0;
                                    RealConnection realConnection2 = new RealConnection(this.f8002c, route);
                                    m3089a(realConnection2);
                                    realConnection2.m3121a(i, i2, i3, z);
                                    m3077g().m3107a(realConnection2.mo3114b());
                                    synchronized (this.f8002c) {
                                        Internal.f7932a.mo2646b(this.f8002c, realConnection2);
                                        if (realConnection2.m3109f()) {
                                            socket = Internal.f7932a.mo2652a(this.f8002c, this.f8000a, this);
                                            realConnection2 = this.f8006g;
                                        }
                                    }
                                    Util.m3160a(socket);
                                    return realConnection2;
                                }
                                throw new IOException("Canceled");
                            }
                        }
                        return realConnection;
                    }
                    throw new IOException("Canceled");
                }
                throw new IllegalStateException("codec != null");
            }
            throw new IllegalStateException("released");
        }
    }

    /* renamed from: a */
    public void m3086a(boolean z, HttpCodec httpCodec) {
        Socket m3085a;
        synchronized (this.f8002c) {
            if (httpCodec != null) {
                if (httpCodec == this.f8009j) {
                    if (!z) {
                        this.f8006g.f7986l++;
                    }
                    m3085a = m3085a(z, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.f8009j + " but was " + httpCodec);
        }
        Util.m3160a(m3085a);
    }

    /* renamed from: a */
    public final Socket m3085a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.f8009j = null;
        }
        if (z2) {
            this.f8007h = true;
        }
        RealConnection realConnection = this.f8006g;
        if (realConnection != null) {
            if (z) {
                realConnection.f7985k = true;
            }
            if (this.f8009j == null && (this.f8007h || this.f8006g.f7985k)) {
                m3083b(this.f8006g);
                if (this.f8006g.f7988n.isEmpty()) {
                    this.f8006g.f7989o = System.nanoTime();
                    if (Internal.f7932a.mo2650a(this.f8002c, this.f8006g)) {
                        socket = this.f8006g.m3108g();
                        this.f8006g = null;
                        return socket;
                    }
                }
                socket = null;
                this.f8006g = null;
                return socket;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m3092a() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.f8002c) {
            this.f8008i = true;
            httpCodec = this.f8009j;
            realConnection = this.f8006g;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.m3112c();
        }
    }

    /* renamed from: a */
    public void m3087a(IOException iOException) {
        boolean z;
        Socket m3085a;
        synchronized (this.f8002c) {
            if (iOException instanceof StreamResetException) {
                StreamResetException streamResetException = (StreamResetException) iOException;
                if (streamResetException.f10570a == ErrorCode.REFUSED_STREAM) {
                    this.f8005f++;
                }
                if (streamResetException.f10570a != ErrorCode.REFUSED_STREAM || this.f8005f > 1) {
                    this.f8001b = null;
                    z = true;
                }
                z = false;
            } else {
                if (this.f8006g != null && (!this.f8006g.m3109f() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.f8006g.f7986l == 0) {
                        if (this.f8001b != null && iOException != null) {
                            this.f8004e.m3103a(this.f8001b, iOException);
                        }
                        this.f8001b = null;
                    }
                    z = true;
                }
                z = false;
            }
            m3085a = m3085a(z, false, true);
        }
        Util.m3160a(m3085a);
    }

    /* renamed from: a */
    public void m3089a(RealConnection realConnection) {
        if (this.f8006g == null) {
            this.f8006g = realConnection;
            realConnection.f7988n.add(new C1756a(this, this.f8003d));
            return;
        }
        throw new IllegalStateException();
    }
}
