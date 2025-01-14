package e.i0.h;

import e.b0;
import e.d0;
import e.e0;
import e.i0.g.i;
import e.t;
import e.u;
import e.y;
import f.h;
import f.k;
import f.q;
import f.r;
import f.s;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
/* compiled from: Http1Codec.java */
/* loaded from: classes.dex */
public final class a implements e.i0.g.c {

    /* renamed from: a  reason: collision with root package name */
    public final y f5644a;

    /* renamed from: b  reason: collision with root package name */
    public final e.i0.f.f f5645b;

    /* renamed from: c  reason: collision with root package name */
    public final f.e f5646c;

    /* renamed from: d  reason: collision with root package name */
    public final f.d f5647d;

    /* renamed from: e  reason: collision with root package name */
    public int f5648e = 0;

    /* compiled from: Http1Codec.java */
    /* loaded from: classes.dex */
    public abstract class b implements r {

        /* renamed from: a  reason: collision with root package name */
        public final h f5649a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5650b;

        public b() {
            this.f5649a = new h(a.this.f5646c.b());
        }

        public final void a(boolean z) {
            a aVar = a.this;
            int i2 = aVar.f5648e;
            if (i2 == 6) {
                return;
            }
            if (i2 == 5) {
                aVar.a(this.f5649a);
                a aVar2 = a.this;
                aVar2.f5648e = 6;
                e.i0.f.f fVar = aVar2.f5645b;
                if (fVar != null) {
                    fVar.a(!z, aVar2);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + a.this.f5648e);
        }

        @Override // f.r
        public s b() {
            return this.f5649a;
        }
    }

    /* compiled from: Http1Codec.java */
    /* loaded from: classes.dex */
    public final class c implements q {

        /* renamed from: a  reason: collision with root package name */
        public final h f5652a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5653b;

        public c() {
            this.f5652a = new h(a.this.f5647d.b());
        }

        @Override // f.q
        public s b() {
            return this.f5652a;
        }

        @Override // f.q, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f5653b) {
                return;
            }
            this.f5653b = true;
            a.this.f5647d.a("0\r\n\r\n");
            a.this.a(this.f5652a);
            a.this.f5648e = 3;
        }

        @Override // f.q, java.io.Flushable
        public synchronized void flush() {
            if (this.f5653b) {
                return;
            }
            a.this.f5647d.flush();
        }

        @Override // f.q
        public void b(f.c cVar, long j) {
            if (this.f5653b) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            a.this.f5647d.e(j);
            a.this.f5647d.a("\r\n");
            a.this.f5647d.b(cVar, j);
            a.this.f5647d.a("\r\n");
        }
    }

    /* compiled from: Http1Codec.java */
    /* loaded from: classes.dex */
    public class d extends b {

        /* renamed from: d  reason: collision with root package name */
        public final u f5655d;

        /* renamed from: e  reason: collision with root package name */
        public long f5656e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f5657f;

        public d(u uVar) {
            super();
            this.f5656e = -1L;
            this.f5657f = true;
            this.f5655d = uVar;
        }

        @Override // f.r
        public long a(f.c cVar, long j) {
            if (j >= 0) {
                if (!this.f5650b) {
                    if (this.f5657f) {
                        long j2 = this.f5656e;
                        if (j2 == 0 || j2 == -1) {
                            i();
                            if (!this.f5657f) {
                                return -1L;
                            }
                        }
                        long a2 = a.this.f5646c.a(cVar, Math.min(j, this.f5656e));
                        if (a2 != -1) {
                            this.f5656e -= a2;
                            return a2;
                        }
                        a(false);
                        throw new ProtocolException("unexpected end of stream");
                    }
                    return -1L;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // f.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5650b) {
                return;
            }
            if (this.f5657f && !e.i0.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false);
            }
            this.f5650b = true;
        }

        public final void i() {
            if (this.f5656e != -1) {
                a.this.f5646c.c();
            }
            try {
                this.f5656e = a.this.f5646c.g();
                String trim = a.this.f5646c.c().trim();
                if (this.f5656e >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                    if (this.f5656e == 0) {
                        this.f5657f = false;
                        e.i0.g.e.a(a.this.f5644a.f(), this.f5655d, a.this.e());
                        a(true);
                        return;
                    }
                    return;
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f5656e + trim + "\"");
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }
    }

    /* compiled from: Http1Codec.java */
    /* loaded from: classes.dex */
    public final class e implements q {

        /* renamed from: a  reason: collision with root package name */
        public final h f5659a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5660b;

        /* renamed from: c  reason: collision with root package name */
        public long f5661c;

        public e(long j) {
            this.f5659a = new h(a.this.f5647d.b());
            this.f5661c = j;
        }

        @Override // f.q
        public s b() {
            return this.f5659a;
        }

        @Override // f.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5660b) {
                return;
            }
            this.f5660b = true;
            if (this.f5661c <= 0) {
                a.this.a(this.f5659a);
                a.this.f5648e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // f.q, java.io.Flushable
        public void flush() {
            if (this.f5660b) {
                return;
            }
            a.this.f5647d.flush();
        }

        @Override // f.q
        public void b(f.c cVar, long j) {
            if (!this.f5660b) {
                e.i0.c.a(cVar.s(), 0L, j);
                if (j <= this.f5661c) {
                    a.this.f5647d.b(cVar, j);
                    this.f5661c -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f5661c + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }
    }

    /* compiled from: Http1Codec.java */
    /* loaded from: classes.dex */
    public class f extends b {

        /* renamed from: d  reason: collision with root package name */
        public long f5663d;

        public f(long j) {
            super();
            this.f5663d = j;
            if (this.f5663d == 0) {
                a(true);
            }
        }

        @Override // f.r
        public long a(f.c cVar, long j) {
            if (j >= 0) {
                if (!this.f5650b) {
                    long j2 = this.f5663d;
                    if (j2 == 0) {
                        return -1L;
                    }
                    long a2 = a.this.f5646c.a(cVar, Math.min(j2, j));
                    if (a2 != -1) {
                        this.f5663d -= a2;
                        if (this.f5663d == 0) {
                            a(true);
                        }
                        return a2;
                    }
                    a(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // f.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5650b) {
                return;
            }
            if (this.f5663d != 0 && !e.i0.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false);
            }
            this.f5650b = true;
        }
    }

    /* compiled from: Http1Codec.java */
    /* loaded from: classes.dex */
    public class g extends b {

        /* renamed from: d  reason: collision with root package name */
        public boolean f5665d;

        public g() {
            super();
        }

        @Override // f.r
        public long a(f.c cVar, long j) {
            if (j >= 0) {
                if (!this.f5650b) {
                    if (this.f5665d) {
                        return -1L;
                    }
                    long a2 = a.this.f5646c.a(cVar, j);
                    if (a2 == -1) {
                        this.f5665d = true;
                        a(true);
                        return -1L;
                    }
                    return a2;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // f.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5650b) {
                return;
            }
            if (!this.f5665d) {
                a(false);
            }
            this.f5650b = true;
        }
    }

    public a(y yVar, e.i0.f.f fVar, f.e eVar, f.d dVar) {
        this.f5644a = yVar;
        this.f5645b = fVar;
        this.f5646c = eVar;
        this.f5647d = dVar;
    }

    @Override // e.i0.g.c
    public q a(b0 b0Var, long j) {
        if ("chunked".equalsIgnoreCase(b0Var.a("Transfer-Encoding"))) {
            return c();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public final r b(d0 d0Var) {
        if (!e.i0.g.e.b(d0Var)) {
            return b(0L);
        }
        if ("chunked".equalsIgnoreCase(d0Var.b("Transfer-Encoding"))) {
            return a(d0Var.s().g());
        }
        long a2 = e.i0.g.e.a(d0Var);
        if (a2 != -1) {
            return b(a2);
        }
        return d();
    }

    public q c() {
        if (this.f5648e == 1) {
            this.f5648e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f5648e);
    }

    @Override // e.i0.g.c
    public void cancel() {
        e.i0.f.c c2 = this.f5645b.c();
        if (c2 != null) {
            c2.c();
        }
    }

    public r d() {
        if (this.f5648e == 4) {
            e.i0.f.f fVar = this.f5645b;
            if (fVar != null) {
                this.f5648e = 5;
                fVar.e();
                return new g();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f5648e);
    }

    public t e() {
        t.a aVar = new t.a();
        while (true) {
            String c2 = this.f5646c.c();
            if (c2.length() != 0) {
                e.i0.a.f5560a.a(aVar, c2);
            } else {
                return aVar.a();
            }
        }
    }

    @Override // e.i0.g.c
    public void a(b0 b0Var) {
        a(b0Var.c(), i.a(b0Var, this.f5645b.c().b().b().type()));
    }

    @Override // e.i0.g.c
    public void b() {
        this.f5647d.flush();
    }

    @Override // e.i0.g.c
    public e0 a(d0 d0Var) {
        return new e.i0.g.h(d0Var.n(), k.a(b(d0Var)));
    }

    public r b(long j) {
        if (this.f5648e == 4) {
            this.f5648e = 5;
            return new f(j);
        }
        throw new IllegalStateException("state: " + this.f5648e);
    }

    @Override // e.i0.g.c
    public void a() {
        this.f5647d.flush();
    }

    public void a(t tVar, String str) {
        if (this.f5648e == 0) {
            this.f5647d.a(str).a("\r\n");
            int b2 = tVar.b();
            for (int i2 = 0; i2 < b2; i2++) {
                this.f5647d.a(tVar.a(i2)).a(": ").a(tVar.b(i2)).a("\r\n");
            }
            this.f5647d.a("\r\n");
            this.f5648e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f5648e);
    }

    @Override // e.i0.g.c
    public d0.a a(boolean z) {
        int i2 = this.f5648e;
        if (i2 != 1 && i2 != 3) {
            throw new IllegalStateException("state: " + this.f5648e);
        }
        try {
            e.i0.g.k a2 = e.i0.g.k.a(this.f5646c.c());
            d0.a aVar = new d0.a();
            aVar.a(a2.f5641a);
            aVar.a(a2.f5642b);
            aVar.a(a2.f5643c);
            aVar.a(e());
            if (z && a2.f5642b == 100) {
                return null;
            }
            this.f5648e = 4;
            return aVar;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f5645b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    public q a(long j) {
        if (this.f5648e == 1) {
            this.f5648e = 2;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.f5648e);
    }

    public r a(u uVar) {
        if (this.f5648e == 4) {
            this.f5648e = 5;
            return new d(uVar);
        }
        throw new IllegalStateException("state: " + this.f5648e);
    }

    public void a(h hVar) {
        s g2 = hVar.g();
        hVar.a(s.f6041d);
        g2.a();
        g2.b();
    }
}
