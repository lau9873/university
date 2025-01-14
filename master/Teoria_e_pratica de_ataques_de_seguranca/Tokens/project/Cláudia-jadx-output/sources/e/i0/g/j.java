package e.i0.g;

import e.b0;
import e.c0;
import e.d0;
import e.e0;
import e.f0;
import e.u;
import e.v;
import e.y;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
/* compiled from: RetryAndFollowUpInterceptor.java */
/* loaded from: classes.dex */
public final class j implements v {

    /* renamed from: a  reason: collision with root package name */
    public final y f5636a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5637b;

    /* renamed from: c  reason: collision with root package name */
    public e.i0.f.f f5638c;

    /* renamed from: d  reason: collision with root package name */
    public Object f5639d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f5640e;

    public j(y yVar, boolean z) {
        this.f5636a = yVar;
        this.f5637b = z;
    }

    public void a() {
        this.f5640e = true;
        e.i0.f.f fVar = this.f5638c;
        if (fVar != null) {
            fVar.a();
        }
    }

    public boolean b() {
        return this.f5640e;
    }

    @Override // e.v
    public d0 intercept(v.a aVar) {
        b0 a2 = aVar.a();
        this.f5638c = new e.i0.f.f(this.f5636a.d(), a(a2.g()), this.f5639d);
        d0 d0Var = null;
        int i2 = 0;
        while (!this.f5640e) {
            try {
                try {
                    d0 a3 = ((g) aVar).a(a2, this.f5638c, null, null);
                    if (d0Var != null) {
                        d0.a q = a3.q();
                        d0.a q2 = d0Var.q();
                        q2.a((e0) null);
                        q.d(q2.a());
                        a3 = q.a();
                    }
                    d0Var = a3;
                    a2 = a(d0Var);
                } catch (IOException e2) {
                    if (!a(e2, !(e2 instanceof ConnectionShutdownException), a2)) {
                        throw e2;
                    }
                } catch (RouteException e3) {
                    if (!a(e3.a(), false, a2)) {
                        throw e3.a();
                    }
                }
                if (a2 == null) {
                    if (!this.f5637b) {
                        this.f5638c.f();
                    }
                    return d0Var;
                }
                e.i0.c.a(d0Var.j());
                i2++;
                if (i2 <= 20) {
                    a2.a();
                    if (!a(d0Var, a2.g())) {
                        this.f5638c.f();
                        this.f5638c = new e.i0.f.f(this.f5636a.d(), a(a2.g()), this.f5639d);
                    } else if (this.f5638c.b() != null) {
                        throw new IllegalStateException("Closing the body of " + d0Var + " didn't close its backing stream. Bad interceptor?");
                    }
                } else {
                    this.f5638c.f();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                }
            } catch (Throwable th) {
                this.f5638c.a((IOException) null);
                this.f5638c.f();
                throw th;
            }
        }
        this.f5638c.f();
        throw new IOException("Canceled");
    }

    public void a(Object obj) {
        this.f5639d = obj;
    }

    public final e.a a(u uVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        e.g gVar;
        if (uVar.h()) {
            SSLSocketFactory y = this.f5636a.y();
            hostnameVerifier = this.f5636a.n();
            sSLSocketFactory = y;
            gVar = this.f5636a.b();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new e.a(uVar.g(), uVar.k(), this.f5636a.h(), this.f5636a.x(), sSLSocketFactory, hostnameVerifier, gVar, this.f5636a.t(), this.f5636a.s(), this.f5636a.r(), this.f5636a.e(), this.f5636a.u());
    }

    public final boolean a(IOException iOException, boolean z, b0 b0Var) {
        this.f5638c.a(iOException);
        if (this.f5636a.w()) {
            if (z) {
                b0Var.a();
            }
            return a(iOException, z) && this.f5638c.d();
        }
        return false;
    }

    public final boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    public final b0 a(d0 d0Var) {
        String b2;
        u b3;
        Proxy s;
        if (d0Var != null) {
            e.i0.f.c c2 = this.f5638c.c();
            f0 b4 = c2 != null ? c2.b() : null;
            int l = d0Var.l();
            String e2 = d0Var.s().e();
            if (l == 307 || l == 308) {
                if (!e2.equals("GET") && !e2.equals("HEAD")) {
                    return null;
                }
            } else if (l != 401) {
                if (l == 407) {
                    if (b4 != null) {
                        s = b4.b();
                    } else {
                        s = this.f5636a.s();
                    }
                    if (s.type() == Proxy.Type.HTTP) {
                        return this.f5636a.t().a(b4, d0Var);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (l == 408) {
                    d0Var.s().a();
                    return d0Var.s();
                } else {
                    switch (l) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                }
            } else {
                return this.f5636a.a().a(b4, d0Var);
            }
            if (!this.f5636a.l() || (b2 = d0Var.b("Location")) == null || (b3 = d0Var.s().g().b(b2)) == null) {
                return null;
            }
            if (b3.n().equals(d0Var.s().g().n()) || this.f5636a.m()) {
                b0.a f2 = d0Var.s().f();
                if (f.b(e2)) {
                    boolean d2 = f.d(e2);
                    if (f.c(e2)) {
                        f2.a("GET", (c0) null);
                    } else {
                        f2.a(e2, d2 ? d0Var.s().a() : null);
                    }
                    if (!d2) {
                        f2.a("Transfer-Encoding");
                        f2.a("Content-Length");
                        f2.a("Content-Type");
                    }
                }
                if (!a(d0Var, b3)) {
                    f2.a("Authorization");
                }
                f2.a(b3);
                return f2.a();
            }
            return null;
        }
        throw new IllegalStateException();
    }

    public final boolean a(d0 d0Var, u uVar) {
        u g2 = d0Var.s().g();
        return g2.g().equals(uVar.g()) && g2.k() == uVar.k() && g2.n().equals(uVar.n());
    }
}
