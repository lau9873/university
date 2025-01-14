package e.i0.f;

import e.b0;
import e.d0;
import e.f0;
import e.g;
import e.i;
import e.i0.i.f;
import e.i0.i.h;
import e.j;
import e.s;
import e.u;
import e.y;
import e.z;
import f.k;
import f.r;
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
/* compiled from: RealConnection.java */
/* loaded from: classes.dex */
public final class c extends f.i implements i {

    /* renamed from: b  reason: collision with root package name */
    public final j f5594b;

    /* renamed from: c  reason: collision with root package name */
    public final f0 f5595c;

    /* renamed from: d  reason: collision with root package name */
    public Socket f5596d;

    /* renamed from: e  reason: collision with root package name */
    public Socket f5597e;

    /* renamed from: f  reason: collision with root package name */
    public s f5598f;

    /* renamed from: g  reason: collision with root package name */
    public z f5599g;

    /* renamed from: h  reason: collision with root package name */
    public e.i0.i.f f5600h;

    /* renamed from: i  reason: collision with root package name */
    public f.e f5601i;
    public f.d j;
    public boolean k;
    public int l;
    public int m = 1;
    public final List<Reference<f>> n = new ArrayList();
    public long o = Long.MAX_VALUE;

    public c(j jVar, f0 f0Var) {
        this.f5594b = jVar;
        this.f5595c = f0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0078 A[Catch: IOException -> 0x0097, TryCatch #0 {IOException -> 0x0097, blocks: (B:16:0x0070, B:18:0x0078, B:20:0x007f, B:19:0x007c), top: B:44:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c A[Catch: IOException -> 0x0097, TryCatch #0 {IOException -> 0x0097, blocks: (B:16:0x0070, B:18:0x0078, B:20:0x007f, B:19:0x007c), top: B:44:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r6, int r7, int r8, boolean r9) {
        /*
            r5 = this;
            e.z r0 = r5.f5599g
            if (r0 != 0) goto Lc5
            e.f0 r0 = r5.f5595c
            e.a r0 = r0.a()
            java.util.List r0 = r0.b()
            e.i0.f.b r1 = new e.i0.f.b
            r1.<init>(r0)
            e.f0 r2 = r5.f5595c
            e.a r2 = r2.a()
            javax.net.ssl.SSLSocketFactory r2 = r2.j()
            if (r2 != 0) goto L6e
            e.k r2 = e.k.f5881g
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L61
            e.f0 r0 = r5.f5595c
            e.a r0 = r0.a()
            e.u r0 = r0.k()
            java.lang.String r0 = r0.g()
            e.i0.j.e r2 = e.i0.j.e.b()
            boolean r2 = r2.b(r0)
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
            e.f0 r3 = r5.f5595c     // Catch: java.io.IOException -> L97
            boolean r3 = r3.c()     // Catch: java.io.IOException -> L97
            if (r3 == 0) goto L7c
            r5.a(r6, r7, r8)     // Catch: java.io.IOException -> L97
            goto L7f
        L7c:
            r5.a(r6, r7)     // Catch: java.io.IOException -> L97
        L7f:
            r5.b(r1)     // Catch: java.io.IOException -> L97
            e.i0.i.f r6 = r5.f5600h
            if (r6 == 0) goto L96
            e.j r6 = r5.f5594b
            monitor-enter(r6)
            e.i0.i.f r7 = r5.f5600h     // Catch: java.lang.Throwable -> L93
            int r7 = r7.k()     // Catch: java.lang.Throwable -> L93
            r5.m = r7     // Catch: java.lang.Throwable -> L93
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
            java.net.Socket r4 = r5.f5597e
            e.i0.c.a(r4)
            java.net.Socket r4 = r5.f5596d
            e.i0.c.a(r4)
            r5.f5597e = r0
            r5.f5596d = r0
            r5.f5601i = r0
            r5.j = r0
            r5.f5598f = r0
            r5.f5599g = r0
            r5.f5600h = r0
            if (r2 != 0) goto Lb8
            okhttp3.internal.connection.RouteException r2 = new okhttp3.internal.connection.RouteException
            r2.<init>(r3)
            goto Lbb
        Lb8:
            r2.a(r3)
        Lbb:
            if (r9 == 0) goto Lc4
            boolean r3 = r1.a(r3)
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
        throw new UnsupportedOperationException("Method not decompiled: e.i0.f.c.a(int, int, int, boolean):void");
    }

    public final void b(b bVar) {
        if (this.f5595c.a().j() == null) {
            this.f5599g = z.HTTP_1_1;
            this.f5597e = this.f5596d;
            return;
        }
        a(bVar);
        if (this.f5599g == z.HTTP_2) {
            this.f5597e.setSoTimeout(0);
            f.h hVar = new f.h(true);
            hVar.a(this.f5597e, this.f5595c.a().k().g(), this.f5601i, this.j);
            hVar.a(this);
            this.f5600h = hVar.a();
            this.f5600h.l();
        }
    }

    public void c() {
        e.i0.c.a(this.f5596d);
    }

    public final b0 d() {
        b0.a aVar = new b0.a();
        aVar.a(this.f5595c.a().k());
        aVar.b("Host", e.i0.c.a(this.f5595c.a().k(), true));
        aVar.b("Proxy-Connection", "Keep-Alive");
        aVar.b("User-Agent", e.i0.d.a());
        return aVar.a();
    }

    public s e() {
        return this.f5598f;
    }

    public boolean f() {
        return this.f5600h != null;
    }

    public Socket g() {
        return this.f5597e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f5595c.a().k().g());
        sb.append(":");
        sb.append(this.f5595c.a().k().k());
        sb.append(", proxy=");
        sb.append(this.f5595c.b());
        sb.append(" hostAddress=");
        sb.append(this.f5595c.d());
        sb.append(" cipherSuite=");
        s sVar = this.f5598f;
        sb.append(sVar != null ? sVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f5599g);
        sb.append('}');
        return sb.toString();
    }

    @Override // e.i
    public f0 b() {
        return this.f5595c;
    }

    public final void a(int i2, int i3, int i4) {
        b0 d2 = d();
        u g2 = d2.g();
        int i5 = 0;
        while (true) {
            i5++;
            if (i5 <= 21) {
                a(i2, i3);
                d2 = a(i3, i4, d2, g2);
                if (d2 == null) {
                    return;
                }
                e.i0.c.a(this.f5596d);
                this.f5596d = null;
                this.j = null;
                this.f5601i = null;
            } else {
                throw new ProtocolException("Too many tunnel connections attempted: 21");
            }
        }
    }

    public final void a(int i2, int i3) {
        Socket createSocket;
        Proxy b2 = this.f5595c.b();
        e.a a2 = this.f5595c.a();
        if (b2.type() != Proxy.Type.DIRECT && b2.type() != Proxy.Type.HTTP) {
            createSocket = new Socket(b2);
        } else {
            createSocket = a2.i().createSocket();
        }
        this.f5596d = createSocket;
        this.f5596d.setSoTimeout(i3);
        try {
            e.i0.j.e.b().a(this.f5596d, this.f5595c.d(), i2);
            try {
                this.f5601i = k.a(k.b(this.f5596d));
                this.j = k.a(k.a(this.f5596d));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f5595c.d());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    public final void a(b bVar) {
        SSLSocket sSLSocket;
        z zVar;
        e.a a2 = this.f5595c.a();
        try {
            try {
                sSLSocket = (SSLSocket) a2.j().createSocket(this.f5596d, a2.k().g(), a2.k().k(), true);
            } catch (AssertionError e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
            sSLSocket = null;
        }
        try {
            e.k a3 = bVar.a(sSLSocket);
            if (a3.c()) {
                e.i0.j.e.b().a(sSLSocket, a2.k().g(), a2.e());
            }
            sSLSocket.startHandshake();
            s a4 = s.a(sSLSocket.getSession());
            if (a2.d().verify(a2.k().g(), sSLSocket.getSession())) {
                a2.a().a(a2.k().g(), a4.b());
                String b2 = a3.c() ? e.i0.j.e.b().b(sSLSocket) : null;
                this.f5597e = sSLSocket;
                this.f5601i = k.a(k.b(this.f5597e));
                this.j = k.a(k.a(this.f5597e));
                this.f5598f = a4;
                if (b2 != null) {
                    zVar = z.a(b2);
                } else {
                    zVar = z.HTTP_1_1;
                }
                this.f5599g = zVar;
                if (sSLSocket != null) {
                    e.i0.j.e.b().a(sSLSocket);
                    return;
                }
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) a4.b().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + a2.k().g() + " not verified:\n    certificate: " + g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + e.i0.l.d.a(x509Certificate));
        } catch (AssertionError e3) {
            e = e3;
            if (!e.i0.c.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            if (sSLSocket != null) {
                e.i0.j.e.b().a(sSLSocket);
            }
            e.i0.c.a((Socket) sSLSocket);
            throw th;
        }
    }

    public final b0 a(int i2, int i3, b0 b0Var, u uVar) {
        String str = "CONNECT " + e.i0.c.a(uVar, true) + " HTTP/1.1";
        while (true) {
            e.i0.h.a aVar = new e.i0.h.a(null, null, this.f5601i, this.j);
            this.f5601i.b().a(i2, TimeUnit.MILLISECONDS);
            this.j.b().a(i3, TimeUnit.MILLISECONDS);
            aVar.a(b0Var.c(), str);
            aVar.a();
            d0.a a2 = aVar.a(false);
            a2.a(b0Var);
            d0 a3 = a2.a();
            long a4 = e.i0.g.e.a(a3);
            if (a4 == -1) {
                a4 = 0;
            }
            r b2 = aVar.b(a4);
            e.i0.c.b(b2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            b2.close();
            int l = a3.l();
            if (l == 200) {
                if (this.f5601i.a().e() && this.j.a().e()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (l == 407) {
                b0 a5 = this.f5595c.a().g().a(this.f5595c, a3);
                if (a5 != null) {
                    if ("close".equalsIgnoreCase(a3.b("Connection"))) {
                        return a5;
                    }
                    b0Var = a5;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + a3.l());
            }
        }
    }

    public boolean a(e.a aVar, f0 f0Var) {
        if (this.n.size() >= this.m || this.k || !e.i0.a.f5560a.a(this.f5595c.a(), aVar)) {
            return false;
        }
        if (aVar.k().g().equals(b().a().k().g())) {
            return true;
        }
        if (this.f5600h != null && f0Var != null && f0Var.b().type() == Proxy.Type.DIRECT && this.f5595c.b().type() == Proxy.Type.DIRECT && this.f5595c.d().equals(f0Var.d()) && f0Var.a().d() == e.i0.l.d.f5858a && a(aVar.k())) {
            try {
                aVar.a().a(aVar.k().g(), e().b());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
        return false;
    }

    public boolean a(u uVar) {
        if (uVar.k() != this.f5595c.a().k().k()) {
            return false;
        }
        if (uVar.g().equals(this.f5595c.a().k().g())) {
            return true;
        }
        return this.f5598f != null && e.i0.l.d.f5858a.a(uVar.g(), (X509Certificate) this.f5598f.b().get(0));
    }

    public e.i0.g.c a(y yVar, f fVar) {
        e.i0.i.f fVar2 = this.f5600h;
        if (fVar2 != null) {
            return new e.i0.i.e(yVar, fVar, fVar2);
        }
        this.f5597e.setSoTimeout(yVar.v());
        this.f5601i.b().a(yVar.v(), TimeUnit.MILLISECONDS);
        this.j.b().a(yVar.A(), TimeUnit.MILLISECONDS);
        return new e.i0.h.a(yVar, fVar, this.f5601i, this.j);
    }

    public boolean a(boolean z) {
        if (this.f5597e.isClosed() || this.f5597e.isInputShutdown() || this.f5597e.isOutputShutdown()) {
            return false;
        }
        e.i0.i.f fVar = this.f5600h;
        if (fVar != null) {
            return !fVar.j();
        }
        if (z) {
            try {
                int soTimeout = this.f5597e.getSoTimeout();
                try {
                    this.f5597e.setSoTimeout(1);
                    return !this.f5601i.e();
                } finally {
                    this.f5597e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // e.i0.i.f.i
    public void a(h hVar) {
        hVar.a(e.i0.i.a.REFUSED_STREAM);
    }

    @Override // e.i0.i.f.i
    public void a(e.i0.i.f fVar) {
        synchronized (this.f5594b) {
            this.m = fVar.k();
        }
    }

    @Override // e.i
    public z a() {
        return this.f5599g;
    }
}
