package p181e.p182i0.p184f;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import p181e.Address;
import p181e.C1737b0;
import p181e.C1744d0;
import p181e.CertificatePinner;
import p181e.Connection;
import p181e.ConnectionPool;
import p181e.ConnectionSpec;
import p181e.Handshake;
import p181e.HttpUrl;
import p181e.OkHttpClient;
import p181e.Protocol;
import p181e.Route;
import p181e.p182i0.Internal;
import p181e.p182i0.Util;
import p181e.p182i0.Version;
import p181e.p182i0.p185g.HttpCodec;
import p181e.p182i0.p185g.HttpHeaders;
import p181e.p182i0.p186h.Http1Codec;
import p181e.p182i0.p187i.ErrorCode;
import p181e.p182i0.p187i.Http2Codec;
import p181e.p182i0.p187i.Http2Connection;
import p181e.p182i0.p187i.Http2Stream;
import p181e.p182i0.p188j.Platform;
import p181e.p182i0.p190l.OkHostnameVerifier;
import p192f.BufferedSink;
import p192f.BufferedSource;
import p192f.Okio;
import p192f.Source;

/* renamed from: e.i0.f.c */
/* loaded from: classes.dex */
public final class RealConnection extends Http2Connection.AbstractC1778i implements Connection {

    /* renamed from: b */
    public final ConnectionPool f7976b;

    /* renamed from: c */
    public final Route f7977c;

    /* renamed from: d */
    public Socket f7978d;

    /* renamed from: e */
    public Socket f7979e;

    /* renamed from: f */
    public Handshake f7980f;

    /* renamed from: g */
    public Protocol f7981g;

    /* renamed from: h */
    public Http2Connection f7982h;

    /* renamed from: i */
    public BufferedSource f7983i;

    /* renamed from: j */
    public BufferedSink f7984j;

    /* renamed from: k */
    public boolean f7985k;

    /* renamed from: l */
    public int f7986l;

    /* renamed from: m */
    public int f7987m = 1;

    /* renamed from: n */
    public final List<Reference<StreamAllocation>> f7988n = new ArrayList();

    /* renamed from: o */
    public long f7989o = Long.MAX_VALUE;

    public RealConnection(ConnectionPool connectionPool, Route route) {
        this.f7976b = connectionPool;
        this.f7977c = route;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0078 A[Catch: IOException -> 0x0097, TryCatch #0 {IOException -> 0x0097, blocks: (B:16:0x0070, B:18:0x0078, B:20:0x007f, B:19:0x007c), top: B:44:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c A[Catch: IOException -> 0x0097, TryCatch #0 {IOException -> 0x0097, blocks: (B:16:0x0070, B:18:0x0078, B:20:0x007f, B:19:0x007c), top: B:44:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096 A[ORIG_RETURN, RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3121a(int r6, int r7, int r8, boolean r9) {
        /*
            r5 = this;
            e.z r0 = r5.f7981g
            if (r0 != 0) goto Lc5
            e.f0 r0 = r5.f7977c
            e.a r0 = r0.m3191a()
            java.util.List r0 = r0.m3277b()
            e.i0.f.b r1 = new e.i0.f.b
            r1.<init>(r0)
            e.f0 r2 = r5.f7977c
            e.a r2 = r2.m3191a()
            javax.net.ssl.SSLSocketFactory r2 = r2.m3269j()
            if (r2 != 0) goto L6e
            e.k r2 = p181e.ConnectionSpec.f8289g
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L61
            e.f0 r0 = r5.f7977c
            e.a r0 = r0.m3191a()
            e.u r0 = r0.m3268k()
            java.lang.String r0 = r0.m2730g()
            e.i0.j.e r2 = p181e.p182i0.p188j.Platform.m2853b()
            boolean r2 = r2.mo2852b(r0)
            if (r2 == 0) goto L40
            goto L6e
        L40:
            okhttp3.internal.connection.RouteException r6 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r7 = new java.net.UnknownServiceException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "CLEARTEXT communication to "
            r8.append(r9)
            r8.append(r0)
            java.lang.String r9 = " not permitted by network security policy"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            r6.<init>(r7)
            throw r6
        L61:
            okhttp3.internal.connection.RouteException r6 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r7 = new java.net.UnknownServiceException
            java.lang.String r8 = "CLEARTEXT communication not enabled for client"
            r7.<init>(r8)
            r6.<init>(r7)
            throw r6
        L6e:
            r0 = 0
            r2 = r0
        L70:
            e.f0 r3 = r5.f7977c     // Catch: java.io.IOException -> L97
            boolean r3 = r3.m3189c()     // Catch: java.io.IOException -> L97
            if (r3 == 0) goto L7c
            r5.m3122a(r6, r7, r8)     // Catch: java.io.IOException -> L97
            goto L7f
        L7c:
            r5.m3123a(r6, r7)     // Catch: java.io.IOException -> L97
        L7f:
            r5.m3113b(r1)     // Catch: java.io.IOException -> L97
            e.i0.i.f r6 = r5.f7982h
            if (r6 == 0) goto L96
            e.j r6 = r5.f7976b
            monitor-enter(r6)
            e.i0.i.f r7 = r5.f7982h     // Catch: java.lang.Throwable -> L93
            int r7 = r7.m2973k()     // Catch: java.lang.Throwable -> L93
            r5.f7987m = r7     // Catch: java.lang.Throwable -> L93
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L93
            goto L96
        L93:
            r7 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L93
            throw r7
        L96:
            return
        L97:
            r3 = move-exception
            java.net.Socket r4 = r5.f7979e
            p181e.p182i0.Util.m3160a(r4)
            java.net.Socket r4 = r5.f7978d
            p181e.p182i0.Util.m3160a(r4)
            r5.f7979e = r0
            r5.f7978d = r0
            r5.f7983i = r0
            r5.f7984j = r0
            r5.f7980f = r0
            r5.f7981g = r0
            r5.f7982h = r0
            if (r2 != 0) goto Lb8
            okhttp3.internal.connection.RouteException r2 = new okhttp3.internal.connection.RouteException
            r2.<init>(r3)
            goto Lbb
        Lb8:
            r2.m492a(r3)
        Lbb:
            if (r9 == 0) goto Lc4
            boolean r3 = r1.m3127a(r3)
            if (r3 == 0) goto Lc4
            goto L70
        Lc4:
            throw r2
        Lc5:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "already connected"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p181e.p182i0.p184f.RealConnection.m3121a(int, int, int, boolean):void");
    }

    /* renamed from: b */
    public final void m3113b(ConnectionSpecSelector connectionSpecSelector) {
        if (this.f7977c.m3191a().m3269j() == null) {
            this.f7981g = Protocol.HTTP_1_1;
            this.f7979e = this.f7978d;
            return;
        }
        m3118a(connectionSpecSelector);
        if (this.f7981g == Protocol.HTTP_2) {
            this.f7979e.setSoTimeout(0);
            Http2Connection.C1777h c1777h = new Http2Connection.C1777h(true);
            c1777h.m2969a(this.f7979e, this.f7977c.m3191a().m3268k().m2730g(), this.f7983i, this.f7984j);
            c1777h.m2970a(this);
            this.f7982h = c1777h.m2971a();
            this.f7982h.m2972l();
        }
    }

    /* renamed from: c */
    public void m3112c() {
        Util.m3160a(this.f7978d);
    }

    /* renamed from: d */
    public final C1737b0 m3111d() {
        C1737b0.C1738a c1738a = new C1737b0.C1738a();
        c1738a.m3251a(this.f7977c.m3191a().m3268k());
        c1738a.m3247b("Host", Util.m3172a(this.f7977c.m3191a().m3268k(), true));
        c1738a.m3247b("Proxy-Connection", "Keep-Alive");
        c1738a.m3247b("User-Agent", Version.m3146a());
        return c1738a.m3253a();
    }

    /* renamed from: e */
    public Handshake m3110e() {
        return this.f7980f;
    }

    /* renamed from: f */
    public boolean m3109f() {
        return this.f7982h != null;
    }

    /* renamed from: g */
    public Socket m3108g() {
        return this.f7979e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f7977c.m3191a().m3268k().m2730g());
        sb.append(":");
        sb.append(this.f7977c.m3191a().m3268k().m2726k());
        sb.append(", proxy=");
        sb.append(this.f7977c.m3190b());
        sb.append(" hostAddress=");
        sb.append(this.f7977c.m3188d());
        sb.append(" cipherSuite=");
        Handshake handshake = this.f7980f;
        sb.append(handshake != null ? handshake.m2770a() : "none");
        sb.append(" protocol=");
        sb.append(this.f7981g);
        sb.append('}');
        return sb.toString();
    }

    @Override // p181e.Connection
    /* renamed from: b */
    public Route mo3114b() {
        return this.f7977c;
    }

    /* renamed from: a */
    public final void m3122a(int i, int i2, int i3) {
        C1737b0 m3111d = m3111d();
        HttpUrl m3254g = m3111d.m3254g();
        int i4 = 0;
        while (true) {
            i4++;
            if (i4 <= 21) {
                m3123a(i, i2);
                m3111d = m3120a(i2, i3, m3111d, m3254g);
                if (m3111d == null) {
                    return;
                }
                Util.m3160a(this.f7978d);
                this.f7978d = null;
                this.f7984j = null;
                this.f7983i = null;
            } else {
                throw new ProtocolException("Too many tunnel connections attempted: 21");
            }
        }
    }

    /* renamed from: a */
    public final void m3123a(int i, int i2) {
        Socket createSocket;
        Proxy m3190b = this.f7977c.m3190b();
        Address m3191a = this.f7977c.m3191a();
        if (m3190b.type() != Proxy.Type.DIRECT && m3190b.type() != Proxy.Type.HTTP) {
            createSocket = new Socket(m3190b);
        } else {
            createSocket = m3191a.m3270i().createSocket();
        }
        this.f7978d = createSocket;
        this.f7978d.setSoTimeout(i2);
        try {
            Platform.m2853b().mo2858a(this.f7978d, this.f7977c.m3188d(), i);
            try {
                this.f7983i = Okio.m2586a(Okio.m2579b(this.f7978d));
                this.f7984j = Okio.m2587a(Okio.m2580a(this.f7978d));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f7977c.m3188d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* renamed from: a */
    public final void m3118a(ConnectionSpecSelector connectionSpecSelector) {
        SSLSocket sSLSocket;
        Protocol protocol;
        Address m3191a = this.f7977c.m3191a();
        try {
            try {
                sSLSocket = (SSLSocket) m3191a.m3269j().createSocket(this.f7978d, m3191a.m3268k().m2730g(), m3191a.m3268k().m2726k(), true);
                try {
                    ConnectionSpec m3126a = connectionSpecSelector.m3126a(sSLSocket);
                    if (m3126a.m2809c()) {
                        Platform.m2853b().mo2855a(sSLSocket, m3191a.m3268k().m2730g(), m3191a.m3274e());
                    }
                    sSLSocket.startHandshake();
                    Handshake m2769a = Handshake.m2769a(sSLSocket.getSession());
                    if (m3191a.m3275d().verify(m3191a.m3268k().m2730g(), sSLSocket.getSession())) {
                        m3191a.m3279a().m3185a(m3191a.m3268k().m2730g(), m2769a.m2768b());
                        String mo2850b = m3126a.m2809c() ? Platform.m2853b().mo2850b(sSLSocket) : null;
                        this.f7979e = sSLSocket;
                        this.f7983i = Okio.m2586a(Okio.m2579b(this.f7979e));
                        this.f7984j = Okio.m2587a(Okio.m2580a(this.f7979e));
                        this.f7980f = m2769a;
                        if (mo2850b != null) {
                            protocol = Protocol.m2639a(mo2850b);
                        } else {
                            protocol = Protocol.HTTP_1_1;
                        }
                        this.f7981g = protocol;
                        if (sSLSocket != null) {
                            Platform.m2853b().mo2856a(sSLSocket);
                            return;
                        }
                        return;
                    }
                    X509Certificate x509Certificate = (X509Certificate) m2769a.m2768b().get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + m3191a.m3268k().m2730g() + " not verified:\n    certificate: " + CertificatePinner.m3184a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.m2831a(x509Certificate));
                } catch (AssertionError e) {
                    e = e;
                    if (!Util.m3168a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    if (sSLSocket != null) {
                        Platform.m2853b().mo2856a(sSLSocket);
                    }
                    Util.m3160a((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                sSLSocket = null;
            }
        } catch (AssertionError e2) {
            e = e2;
        }
    }

    /* renamed from: a */
    public final C1737b0 m3120a(int i, int i2, C1737b0 c1737b0, HttpUrl httpUrl) {
        String str = "CONNECT " + Util.m3172a(httpUrl, true) + " HTTP/1.1";
        while (true) {
            Http1Codec http1Codec = new Http1Codec(null, null, this.f7983i, this.f7984j);
            this.f7983i.mo2528b().mo2521a(i, TimeUnit.MILLISECONDS);
            this.f7984j.mo2530b().mo2521a(i2, TimeUnit.MILLISECONDS);
            http1Codec.m3044a(c1737b0.m3258c(), str);
            http1Codec.mo3002a();
            C1744d0.C1745a mo2997a = http1Codec.mo2997a(false);
            mo2997a.m3211a(c1737b0);
            C1744d0 m3214a = mo2997a.m3214a();
            long m3073a = HttpHeaders.m3073a(m3214a);
            if (m3073a == -1) {
                m3073a = 0;
            }
            Source m3041b = http1Codec.m3041b(m3073a);
            Util.m3154b(m3041b, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            m3041b.close();
            int m3223l = m3214a.m3223l();
            if (m3223l == 200) {
                if (this.f7983i.mo2569a().mo2557e() && this.f7984j.mo2569a().mo2557e()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (m3223l == 407) {
                C1737b0 mo3262a = this.f7977c.m3191a().m3272g().mo3262a(this.f7977c, m3214a);
                if (mo3262a != null) {
                    if ("close".equalsIgnoreCase(m3214a.m3226b("Connection"))) {
                        return mo3262a;
                    }
                    c1737b0 = mo3262a;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + m3214a.m3223l());
            }
        }
    }

    /* renamed from: a */
    public boolean m3119a(Address address, Route route) {
        if (this.f7988n.size() >= this.f7987m || this.f7985k || !Internal.f7932a.mo2655a(this.f7977c.m3191a(), address)) {
            return false;
        }
        if (address.m3268k().m2730g().equals(mo3114b().m3191a().m3268k().m2730g())) {
            return true;
        }
        if (this.f7982h != null && route != null && route.m3190b().type() == Proxy.Type.DIRECT && this.f7977c.m3190b().type() == Proxy.Type.DIRECT && this.f7977c.m3188d().equals(route.m3188d()) && route.m3191a().m3275d() == OkHostnameVerifier.f8266a && m3117a(address.m3268k())) {
            try {
                address.m3279a().m3185a(address.m3268k().m2730g(), m3110e().m2768b());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3117a(HttpUrl httpUrl) {
        if (httpUrl.m2726k() != this.f7977c.m3191a().m3268k().m2726k()) {
            return false;
        }
        if (httpUrl.m2730g().equals(this.f7977c.m3191a().m3268k().m2730g())) {
            return true;
        }
        return this.f7980f != null && OkHostnameVerifier.f8266a.m2832a(httpUrl.m2730g(), (X509Certificate) this.f7980f.m2768b().get(0));
    }

    /* renamed from: a */
    public HttpCodec m3116a(OkHttpClient okHttpClient, StreamAllocation streamAllocation) {
        Http2Connection http2Connection = this.f7982h;
        if (http2Connection != null) {
            return new Http2Codec(okHttpClient, streamAllocation, http2Connection);
        }
        this.f7979e.setSoTimeout(okHttpClient.m2660v());
        this.f7983i.mo2528b().mo2521a(okHttpClient.m2660v(), TimeUnit.MILLISECONDS);
        this.f7984j.mo2530b().mo2521a(okHttpClient.m2682A(), TimeUnit.MILLISECONDS);
        return new Http1Codec(okHttpClient, streamAllocation, this.f7983i, this.f7984j);
    }

    /* renamed from: a */
    public boolean m3115a(boolean z) {
        if (this.f7979e.isClosed() || this.f7979e.isInputShutdown() || this.f7979e.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.f7982h;
        if (http2Connection != null) {
            return !http2Connection.m2974j();
        }
        if (z) {
            try {
                int soTimeout = this.f7979e.getSoTimeout();
                try {
                    this.f7979e.setSoTimeout(1);
                    return !this.f7983i.mo2557e();
                } finally {
                    this.f7979e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // p181e.p182i0.p187i.Http2Connection.AbstractC1778i
    /* renamed from: a */
    public void mo2967a(Http2Stream http2Stream) {
        http2Stream.m2936a(ErrorCode.REFUSED_STREAM);
    }

    @Override // p181e.p182i0.p187i.Http2Connection.AbstractC1778i
    /* renamed from: a */
    public void mo2968a(Http2Connection http2Connection) {
        synchronized (this.f7976b) {
            this.f7987m = http2Connection.m2973k();
        }
    }

    @Override // p181e.Connection
    /* renamed from: a */
    public Protocol mo3124a() {
        return this.f7981g;
    }
}
