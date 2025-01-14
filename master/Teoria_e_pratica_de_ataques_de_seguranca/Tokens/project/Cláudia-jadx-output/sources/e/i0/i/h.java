package e.i0.i;

import f.q;
import f.r;
import f.s;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.http2.StreamResetException;
/* compiled from: Http2Stream.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: b  reason: collision with root package name */
    public long f5779b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5780c;

    /* renamed from: d  reason: collision with root package name */
    public final f f5781d;

    /* renamed from: e  reason: collision with root package name */
    public List<e.i0.i.b> f5782e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5783f;

    /* renamed from: g  reason: collision with root package name */
    public final b f5784g;

    /* renamed from: h  reason: collision with root package name */
    public final a f5785h;

    /* renamed from: a  reason: collision with root package name */
    public long f5778a = 0;

    /* renamed from: i  reason: collision with root package name */
    public final c f5786i = new c();
    public final c j = new c();
    public e.i0.i.a k = null;

    /* compiled from: Http2Stream.java */
    /* loaded from: classes.dex */
    public class c extends f.a {
        public c() {
        }

        @Override // f.a
        public IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // f.a
        public void i() {
            h.this.c(e.i0.i.a.CANCEL);
        }

        public void k() {
            if (h()) {
                throw b((IOException) null);
            }
        }
    }

    public h(int i2, f fVar, boolean z, boolean z2, List<e.i0.i.b> list) {
        if (fVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list != null) {
            this.f5780c = i2;
            this.f5781d = fVar;
            this.f5779b = fVar.o.c();
            this.f5784g = new b(fVar.n.c());
            this.f5785h = new a();
            this.f5784g.f5795e = z2;
            this.f5785h.f5789c = z;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    public void a(e.i0.i.a aVar) {
        if (b(aVar)) {
            this.f5781d.b(this.f5780c, aVar);
        }
    }

    public final boolean b(e.i0.i.a aVar) {
        synchronized (this) {
            if (this.k != null) {
                return false;
            }
            if (this.f5784g.f5795e && this.f5785h.f5789c) {
                return false;
            }
            this.k = aVar;
            notifyAll();
            this.f5781d.d(this.f5780c);
            return true;
        }
    }

    public int c() {
        return this.f5780c;
    }

    public q d() {
        synchronized (this) {
            if (!this.f5783f && !f()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f5785h;
    }

    public r e() {
        return this.f5784g;
    }

    public boolean f() {
        return this.f5781d.f5717a == ((this.f5780c & 1) == 1);
    }

    public synchronized boolean g() {
        if (this.k != null) {
            return false;
        }
        if ((this.f5784g.f5795e || this.f5784g.f5794d) && (this.f5785h.f5789c || this.f5785h.f5788b)) {
            if (this.f5783f) {
                return false;
            }
        }
        return true;
    }

    public s h() {
        return this.f5786i;
    }

    public void i() {
        boolean g2;
        synchronized (this) {
            this.f5784g.f5795e = true;
            g2 = g();
            notifyAll();
        }
        if (g2) {
            return;
        }
        this.f5781d.d(this.f5780c);
    }

    public synchronized List<e.i0.i.b> j() {
        List<e.i0.i.b> list;
        if (f()) {
            this.f5786i.g();
            while (this.f5782e == null && this.k == null) {
                k();
            }
            this.f5786i.k();
            list = this.f5782e;
            if (list != null) {
                this.f5782e = null;
            } else {
                throw new StreamResetException(this.k);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    public void k() {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public s l() {
        return this.j;
    }

    public void c(e.i0.i.a aVar) {
        if (b(aVar)) {
            this.f5781d.c(this.f5780c, aVar);
        }
    }

    /* compiled from: Http2Stream.java */
    /* loaded from: classes.dex */
    public final class a implements q {

        /* renamed from: a  reason: collision with root package name */
        public final f.c f5787a = new f.c();

        /* renamed from: b  reason: collision with root package name */
        public boolean f5788b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5789c;

        public a() {
        }

        public final void a(boolean z) {
            long min;
            synchronized (h.this) {
                h.this.j.g();
                while (h.this.f5779b <= 0 && !this.f5789c && !this.f5788b && h.this.k == null) {
                    h.this.k();
                }
                h.this.j.k();
                h.this.b();
                min = Math.min(h.this.f5779b, this.f5787a.s());
                h.this.f5779b -= min;
            }
            h.this.j.g();
            try {
                h.this.f5781d.a(h.this.f5780c, z && min == this.f5787a.s(), this.f5787a, min);
            } finally {
                h.this.j.k();
            }
        }

        @Override // f.q
        public void b(f.c cVar, long j) {
            this.f5787a.b(cVar, j);
            while (this.f5787a.s() >= 16384) {
                a(false);
            }
        }

        @Override // f.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (h.this) {
                if (this.f5788b) {
                    return;
                }
                if (!h.this.f5785h.f5789c) {
                    if (this.f5787a.s() > 0) {
                        while (this.f5787a.s() > 0) {
                            a(true);
                        }
                    } else {
                        h hVar = h.this;
                        hVar.f5781d.a(hVar.f5780c, true, (f.c) null, 0L);
                    }
                }
                synchronized (h.this) {
                    this.f5788b = true;
                }
                h.this.f5781d.flush();
                h.this.a();
            }
        }

        @Override // f.q, java.io.Flushable
        public void flush() {
            synchronized (h.this) {
                h.this.b();
            }
            while (this.f5787a.s() > 0) {
                a(false);
                h.this.f5781d.flush();
            }
        }

        @Override // f.q
        public s b() {
            return h.this.j;
        }
    }

    public void a(List<e.i0.i.b> list) {
        boolean z;
        synchronized (this) {
            z = true;
            this.f5783f = true;
            if (this.f5782e == null) {
                this.f5782e = list;
                z = g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f5782e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f5782e = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.f5781d.d(this.f5780c);
    }

    public synchronized void d(e.i0.i.a aVar) {
        if (this.k == null) {
            this.k = aVar;
            notifyAll();
        }
    }

    public void b() {
        a aVar = this.f5785h;
        if (!aVar.f5788b) {
            if (!aVar.f5789c) {
                e.i0.i.a aVar2 = this.k;
                if (aVar2 != null) {
                    throw new StreamResetException(aVar2);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public void a(f.e eVar, int i2) {
        this.f5784g.a(eVar, i2);
    }

    public void a() {
        boolean z;
        boolean g2;
        synchronized (this) {
            z = !this.f5784g.f5795e && this.f5784g.f5794d && (this.f5785h.f5789c || this.f5785h.f5788b);
            g2 = g();
        }
        if (z) {
            a(e.i0.i.a.CANCEL);
        } else if (g2) {
        } else {
            this.f5781d.d(this.f5780c);
        }
    }

    /* compiled from: Http2Stream.java */
    /* loaded from: classes.dex */
    public final class b implements r {

        /* renamed from: a  reason: collision with root package name */
        public final f.c f5791a = new f.c();

        /* renamed from: b  reason: collision with root package name */
        public final f.c f5792b = new f.c();

        /* renamed from: c  reason: collision with root package name */
        public final long f5793c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5794d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5795e;

        public b(long j) {
            this.f5793c = j;
        }

        @Override // f.r
        public long a(f.c cVar, long j) {
            if (j >= 0) {
                synchronized (h.this) {
                    j();
                    i();
                    if (this.f5792b.s() == 0) {
                        return -1L;
                    }
                    long a2 = this.f5792b.a(cVar, Math.min(j, this.f5792b.s()));
                    h.this.f5778a += a2;
                    if (h.this.f5778a >= h.this.f5781d.n.c() / 2) {
                        h.this.f5781d.a(h.this.f5780c, h.this.f5778a);
                        h.this.f5778a = 0L;
                    }
                    synchronized (h.this.f5781d) {
                        h.this.f5781d.k += a2;
                        if (h.this.f5781d.k >= h.this.f5781d.n.c() / 2) {
                            h.this.f5781d.a(0, h.this.f5781d.k);
                            h.this.f5781d.k = 0L;
                        }
                    }
                    return a2;
                }
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // f.r
        public s b() {
            return h.this.f5786i;
        }

        @Override // f.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (h.this) {
                this.f5794d = true;
                this.f5792b.l();
                h.this.notifyAll();
            }
            h.this.a();
        }

        public final void i() {
            if (!this.f5794d) {
                e.i0.i.a aVar = h.this.k;
                if (aVar != null) {
                    throw new StreamResetException(aVar);
                }
                return;
            }
            throw new IOException("stream closed");
        }

        public final void j() {
            h.this.f5786i.g();
            while (this.f5792b.s() == 0 && !this.f5795e && !this.f5794d && h.this.k == null) {
                try {
                    h.this.k();
                } finally {
                    h.this.f5786i.k();
                }
            }
        }

        public void a(f.e eVar, long j) {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (h.this) {
                    z = this.f5795e;
                    z2 = true;
                    z3 = this.f5792b.s() + j > this.f5793c;
                }
                if (z3) {
                    eVar.skip(j);
                    h.this.c(e.i0.i.a.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.skip(j);
                    return;
                } else {
                    long a2 = eVar.a(this.f5791a, j);
                    if (a2 != -1) {
                        j -= a2;
                        synchronized (h.this) {
                            if (this.f5792b.s() != 0) {
                                z2 = false;
                            }
                            this.f5792b.a((r) this.f5791a);
                            if (z2) {
                                h.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }
    }

    public void a(long j) {
        this.f5779b += j;
        if (j > 0) {
            notifyAll();
        }
    }
}
