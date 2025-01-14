package e.i0.f;

import e.f0;
import e.j;
import e.y;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
/* compiled from: StreamAllocation.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final e.a f5612a;

    /* renamed from: b  reason: collision with root package name */
    public f0 f5613b;

    /* renamed from: c  reason: collision with root package name */
    public final j f5614c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f5615d;

    /* renamed from: e  reason: collision with root package name */
    public final e f5616e;

    /* renamed from: f  reason: collision with root package name */
    public int f5617f;

    /* renamed from: g  reason: collision with root package name */
    public c f5618g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5619h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5620i;
    public e.i0.g.c j;

    /* compiled from: StreamAllocation.java */
    /* loaded from: classes.dex */
    public static final class a extends WeakReference<f> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f5621a;

        public a(f fVar, Object obj) {
            super(fVar);
            this.f5621a = obj;
        }
    }

    public f(j jVar, e.a aVar, Object obj) {
        this.f5614c = jVar;
        this.f5612a = aVar;
        this.f5616e = new e(aVar, g());
        this.f5615d = obj;
    }

    public e.i0.g.c a(y yVar, boolean z) {
        try {
            e.i0.g.c a2 = a(yVar.c(), yVar.v(), yVar.A(), yVar.w(), z).a(yVar, this);
            synchronized (this.f5614c) {
                this.j = a2;
            }
            return a2;
        } catch (IOException e2) {
            throw new RouteException(e2);
        }
    }

    public e.i0.g.c b() {
        e.i0.g.c cVar;
        synchronized (this.f5614c) {
            cVar = this.j;
        }
        return cVar;
    }

    public synchronized c c() {
        return this.f5618g;
    }

    public boolean d() {
        return this.f5613b != null || this.f5616e.a();
    }

    public void e() {
        Socket a2;
        synchronized (this.f5614c) {
            a2 = a(true, false, false);
        }
        e.i0.c.a(a2);
    }

    public void f() {
        Socket a2;
        synchronized (this.f5614c) {
            a2 = a(false, true, false);
        }
        e.i0.c.a(a2);
    }

    public final d g() {
        return e.i0.a.f5560a.a(this.f5614c);
    }

    public String toString() {
        c c2 = c();
        return c2 != null ? c2.toString() : this.f5612a.toString();
    }

    public Socket c(c cVar) {
        if (this.j == null && this.f5618g.n.size() == 1) {
            Socket a2 = a(true, false, false);
            this.f5618g = cVar;
            cVar.n.add(this.f5618g.n.get(0));
            return a2;
        }
        throw new IllegalStateException();
    }

    public final void b(c cVar) {
        int size = cVar.n.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (cVar.n.get(i2).get() == this) {
                cVar.n.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public final c a(int i2, int i3, int i4, boolean z, boolean z2) {
        while (true) {
            c a2 = a(i2, i3, i4, z);
            synchronized (this.f5614c) {
                if (a2.l == 0) {
                    return a2;
                }
                if (a2.a(z2)) {
                    return a2;
                }
                e();
            }
        }
    }

    public final c a(int i2, int i3, int i4, boolean z) {
        synchronized (this.f5614c) {
            if (!this.f5619h) {
                if (this.j == null) {
                    if (!this.f5620i) {
                        c cVar = this.f5618g;
                        if (cVar == null || cVar.k) {
                            Socket socket = null;
                            e.i0.a.f5560a.a(this.f5614c, this.f5612a, this, null);
                            if (this.f5618g != null) {
                                return this.f5618g;
                            }
                            f0 f0Var = this.f5613b;
                            if (f0Var == null) {
                                f0Var = this.f5616e.e();
                            }
                            synchronized (this.f5614c) {
                                if (!this.f5620i) {
                                    e.i0.a.f5560a.a(this.f5614c, this.f5612a, this, f0Var);
                                    if (this.f5618g != null) {
                                        return this.f5618g;
                                    }
                                    this.f5613b = f0Var;
                                    this.f5617f = 0;
                                    c cVar2 = new c(this.f5614c, f0Var);
                                    a(cVar2);
                                    cVar2.a(i2, i3, i4, z);
                                    g().a(cVar2.b());
                                    synchronized (this.f5614c) {
                                        e.i0.a.f5560a.b(this.f5614c, cVar2);
                                        if (cVar2.f()) {
                                            socket = e.i0.a.f5560a.a(this.f5614c, this.f5612a, this);
                                            cVar2 = this.f5618g;
                                        }
                                    }
                                    e.i0.c.a(socket);
                                    return cVar2;
                                }
                                throw new IOException("Canceled");
                            }
                        }
                        return cVar;
                    }
                    throw new IOException("Canceled");
                }
                throw new IllegalStateException("codec != null");
            }
            throw new IllegalStateException("released");
        }
    }

    public void a(boolean z, e.i0.g.c cVar) {
        Socket a2;
        synchronized (this.f5614c) {
            if (cVar != null) {
                if (cVar == this.j) {
                    if (!z) {
                        this.f5618g.l++;
                    }
                    a2 = a(z, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.j + " but was " + cVar);
        }
        e.i0.c.a(a2);
    }

    public final Socket a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.j = null;
        }
        if (z2) {
            this.f5619h = true;
        }
        c cVar = this.f5618g;
        if (cVar != null) {
            if (z) {
                cVar.k = true;
            }
            if (this.j == null && (this.f5619h || this.f5618g.k)) {
                b(this.f5618g);
                if (this.f5618g.n.isEmpty()) {
                    this.f5618g.o = System.nanoTime();
                    if (e.i0.a.f5560a.a(this.f5614c, this.f5618g)) {
                        socket = this.f5618g.g();
                        this.f5618g = null;
                        return socket;
                    }
                }
                socket = null;
                this.f5618g = null;
                return socket;
            }
        }
        return null;
    }

    public void a() {
        e.i0.g.c cVar;
        c cVar2;
        synchronized (this.f5614c) {
            this.f5620i = true;
            cVar = this.j;
            cVar2 = this.f5618g;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            cVar2.c();
        }
    }

    public void a(IOException iOException) {
        boolean z;
        Socket a2;
        synchronized (this.f5614c) {
            if (iOException instanceof StreamResetException) {
                StreamResetException streamResetException = (StreamResetException) iOException;
                if (streamResetException.f7593a == e.i0.i.a.REFUSED_STREAM) {
                    this.f5617f++;
                }
                if (streamResetException.f7593a != e.i0.i.a.REFUSED_STREAM || this.f5617f > 1) {
                    this.f5613b = null;
                    z = true;
                }
                z = false;
            } else {
                if (this.f5618g != null && (!this.f5618g.f() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.f5618g.l == 0) {
                        if (this.f5613b != null && iOException != null) {
                            this.f5616e.a(this.f5613b, iOException);
                        }
                        this.f5613b = null;
                    }
                    z = true;
                }
                z = false;
            }
            a2 = a(z, false, true);
        }
        e.i0.c.a(a2);
    }

    public void a(c cVar) {
        if (this.f5618g == null) {
            this.f5618g = cVar;
            cVar.n.add(new a(this, this.f5615d));
            return;
        }
        throw new IllegalStateException();
    }
}
