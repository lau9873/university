package e.i0.i;

import e.i0.i.g;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: Http2Connection.java */
/* loaded from: classes.dex */
public final class f implements Closeable {
    public static final ExecutorService u = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), e.i0.c.a("OkHttp Http2Connection", true));

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5717a;

    /* renamed from: b  reason: collision with root package name */
    public final i f5718b;

    /* renamed from: d  reason: collision with root package name */
    public final String f5720d;

    /* renamed from: e  reason: collision with root package name */
    public int f5721e;

    /* renamed from: f  reason: collision with root package name */
    public int f5722f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5723g;

    /* renamed from: h  reason: collision with root package name */
    public final ExecutorService f5724h;

    /* renamed from: i  reason: collision with root package name */
    public Map<Integer, k> f5725i;
    public final l j;
    public long m;
    public final Socket q;
    public final e.i0.i.i r;
    public final j s;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, e.i0.i.h> f5719c = new LinkedHashMap();
    public long k = 0;
    public m n = new m();
    public final m o = new m();
    public boolean p = false;
    public final Set<Integer> t = new LinkedHashSet();

    /* compiled from: Http2Connection.java */
    /* loaded from: classes.dex */
    public class a extends e.i0.b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5726b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e.i0.i.a f5727c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Object[] objArr, int i2, e.i0.i.a aVar) {
            super(str, objArr);
            this.f5726b = i2;
            this.f5727c = aVar;
        }

        @Override // e.i0.b
        public void b() {
            try {
                f.this.b(this.f5726b, this.f5727c);
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes.dex */
    public class b extends e.i0.b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5729b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f5730c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Object[] objArr, int i2, long j) {
            super(str, objArr);
            this.f5729b = i2;
            this.f5730c = j;
        }

        @Override // e.i0.b
        public void b() {
            try {
                f.this.r.a(this.f5729b, this.f5730c);
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes.dex */
    public class c extends e.i0.b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f5732b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f5733c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f5734d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f5735e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Object[] objArr, boolean z, int i2, int i3, k kVar) {
            super(str, objArr);
            this.f5732b = z;
            this.f5733c = i2;
            this.f5734d = i3;
            this.f5735e = kVar;
        }

        @Override // e.i0.b
        public void b() {
            try {
                f.this.a(this.f5732b, this.f5733c, this.f5734d, this.f5735e);
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes.dex */
    public class d extends e.i0.b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5737b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f5738c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Object[] objArr, int i2, List list) {
            super(str, objArr);
            this.f5737b = i2;
            this.f5738c = list;
        }

        @Override // e.i0.b
        public void b() {
            if (f.this.j.a(this.f5737b, this.f5738c)) {
                try {
                    f.this.r.a(this.f5737b, e.i0.i.a.CANCEL);
                    synchronized (f.this) {
                        f.this.t.remove(Integer.valueOf(this.f5737b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes.dex */
    public class e extends e.i0.b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5740b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f5741c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f5742d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, Object[] objArr, int i2, List list, boolean z) {
            super(str, objArr);
            this.f5740b = i2;
            this.f5741c = list;
            this.f5742d = z;
        }

        @Override // e.i0.b
        public void b() {
            boolean a2 = f.this.j.a(this.f5740b, this.f5741c, this.f5742d);
            if (a2) {
                try {
                    f.this.r.a(this.f5740b, e.i0.i.a.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (a2 || this.f5742d) {
                synchronized (f.this) {
                    f.this.t.remove(Integer.valueOf(this.f5740b));
                }
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: e.i0.i.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0117f extends e.i0.b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5744b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f.c f5745c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f5746d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f5747e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0117f(String str, Object[] objArr, int i2, f.c cVar, int i3, boolean z) {
            super(str, objArr);
            this.f5744b = i2;
            this.f5745c = cVar;
            this.f5746d = i3;
            this.f5747e = z;
        }

        @Override // e.i0.b
        public void b() {
            try {
                boolean a2 = f.this.j.a(this.f5744b, this.f5745c, this.f5746d, this.f5747e);
                if (a2) {
                    f.this.r.a(this.f5744b, e.i0.i.a.CANCEL);
                }
                if (a2 || this.f5747e) {
                    synchronized (f.this) {
                        f.this.t.remove(Integer.valueOf(this.f5744b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes.dex */
    public class g extends e.i0.b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5749b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e.i0.i.a f5750c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, Object[] objArr, int i2, e.i0.i.a aVar) {
            super(str, objArr);
            this.f5749b = i2;
            this.f5750c = aVar;
        }

        @Override // e.i0.b
        public void b() {
            f.this.j.a(this.f5749b, this.f5750c);
            synchronized (f.this) {
                f.this.t.remove(Integer.valueOf(this.f5749b));
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes.dex */
    public static abstract class i {

        /* renamed from: a  reason: collision with root package name */
        public static final i f5759a = new a();

        /* compiled from: Http2Connection.java */
        /* loaded from: classes.dex */
        public class a extends i {
            @Override // e.i0.i.f.i
            public void a(e.i0.i.h hVar) {
                hVar.a(e.i0.i.a.REFUSED_STREAM);
            }
        }

        public void a(f fVar) {
        }

        public abstract void a(e.i0.i.h hVar);
    }

    public f(h hVar) {
        this.j = hVar.f5757f;
        boolean z = hVar.f5758g;
        this.f5717a = z;
        this.f5718b = hVar.f5756e;
        this.f5722f = z ? 1 : 2;
        if (hVar.f5758g) {
            this.f5722f += 2;
        }
        boolean z2 = hVar.f5758g;
        if (hVar.f5758g) {
            this.n.a(7, 16777216);
        }
        this.f5720d = hVar.f5753b;
        this.f5724h = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), e.i0.c.a(e.i0.c.a("OkHttp %s Push Observer", this.f5720d), true));
        this.o.a(7, 65535);
        this.o.a(5, 16384);
        this.m = this.o.c();
        this.q = hVar.f5752a;
        this.r = new e.i0.i.i(hVar.f5755d, this.f5717a);
        this.s = new j(new e.i0.i.g(hVar.f5754c, this.f5717a));
    }

    public synchronized e.i0.i.h a(int i2) {
        return this.f5719c.get(Integer.valueOf(i2));
    }

    public void b(int i2, e.i0.i.a aVar) {
        this.r.a(i2, aVar);
    }

    public boolean b(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public void c(int i2, e.i0.i.a aVar) {
        u.execute(new a("OkHttp %s stream %d", new Object[]{this.f5720d, Integer.valueOf(i2)}, i2, aVar));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(e.i0.i.a.NO_ERROR, e.i0.i.a.CANCEL);
    }

    public synchronized e.i0.i.h d(int i2) {
        e.i0.i.h remove;
        remove = this.f5719c.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    public void flush() {
        this.r.flush();
    }

    public void g(long j2) {
        this.m += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    public synchronized boolean j() {
        return this.f5723g;
    }

    public synchronized int k() {
        return this.o.b(Integer.MAX_VALUE);
    }

    public void l() {
        a(true);
    }

    public e.i0.i.h a(List<e.i0.i.b> list, boolean z) {
        return a(0, list, z);
    }

    public void b(boolean z, int i2, int i3, k kVar) {
        u.execute(new c("OkHttp %s ping %08x%08x", new Object[]{this.f5720d, Integer.valueOf(i2), Integer.valueOf(i3)}, z, i2, i3, kVar));
    }

    public synchronized k c(int i2) {
        return this.f5725i != null ? this.f5725i.remove(Integer.valueOf(i2)) : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037 A[Catch: all -> 0x0069, TryCatch #1 {, blocks: (B:4:0x0006, B:21:0x0043, B:25:0x0052, B:22:0x0049, B:24:0x004d, B:29:0x005b, B:30:0x0062, B:5:0x0007, B:7:0x000b, B:9:0x001f, B:11:0x0027, B:16:0x0031, B:18:0x0037, B:19:0x0040, B:31:0x0063, B:32:0x0068), top: B:39:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final e.i0.i.h a(int r11, java.util.List<e.i0.i.b> r12, boolean r13) {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            e.i0.i.i r7 = r10.r
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L6c
            boolean r0 = r10.f5723g     // Catch: java.lang.Throwable -> L69
            if (r0 != 0) goto L63
            int r8 = r10.f5722f     // Catch: java.lang.Throwable -> L69
            int r0 = r10.f5722f     // Catch: java.lang.Throwable -> L69
            int r0 = r0 + 2
            r10.f5722f = r0     // Catch: java.lang.Throwable -> L69
            e.i0.i.h r9 = new e.i0.i.h     // Catch: java.lang.Throwable -> L69
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L69
            if (r13 == 0) goto L30
            long r0 = r10.m     // Catch: java.lang.Throwable -> L69
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L30
            long r0 = r9.f5779b     // Catch: java.lang.Throwable -> L69
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L2e
            goto L30
        L2e:
            r13 = 0
            goto L31
        L30:
            r13 = 1
        L31:
            boolean r0 = r9.g()     // Catch: java.lang.Throwable -> L69
            if (r0 == 0) goto L40
            java.util.Map<java.lang.Integer, e.i0.i.h> r0 = r10.f5719c     // Catch: java.lang.Throwable -> L69
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L69
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L69
        L40:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L69
            if (r11 != 0) goto L49
            e.i0.i.i r0 = r10.r     // Catch: java.lang.Throwable -> L6c
            r0.a(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L6c
            goto L52
        L49:
            boolean r0 = r10.f5717a     // Catch: java.lang.Throwable -> L6c
            if (r0 != 0) goto L5b
            e.i0.i.i r0 = r10.r     // Catch: java.lang.Throwable -> L6c
            r0.a(r11, r8, r12)     // Catch: java.lang.Throwable -> L6c
        L52:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L6c
            if (r13 == 0) goto L5a
            e.i0.i.i r11 = r10.r
            r11.flush()
        L5a:
            return r9
        L5b:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L6c
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L6c
            throw r11     // Catch: java.lang.Throwable -> L6c
        L63:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L69
            r11.<init>()     // Catch: java.lang.Throwable -> L69
            throw r11     // Catch: java.lang.Throwable -> L69
        L69:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L69
            throw r11     // Catch: java.lang.Throwable -> L6c
        L6c:
            r11 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L6c
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i0.i.f.a(int, java.util.List, boolean):e.i0.i.h");
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public Socket f5752a;

        /* renamed from: b  reason: collision with root package name */
        public String f5753b;

        /* renamed from: c  reason: collision with root package name */
        public f.e f5754c;

        /* renamed from: d  reason: collision with root package name */
        public f.d f5755d;

        /* renamed from: e  reason: collision with root package name */
        public i f5756e = i.f5759a;

        /* renamed from: f  reason: collision with root package name */
        public l f5757f = l.f5814a;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5758g;

        public h(boolean z) {
            this.f5758g = z;
        }

        public h a(Socket socket, String str, f.e eVar, f.d dVar) {
            this.f5752a = socket;
            this.f5753b = str;
            this.f5754c = eVar;
            this.f5755d = dVar;
            return this;
        }

        public h a(i iVar) {
            this.f5756e = iVar;
            return this;
        }

        public f a() {
            return new f(this);
        }
    }

    public void b(int i2, List<e.i0.i.b> list, boolean z) {
        this.f5724h.execute(new e("OkHttp %s Push Headers[%s]", new Object[]{this.f5720d, Integer.valueOf(i2)}, i2, list, z));
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes.dex */
    public class j extends e.i0.b implements g.b {

        /* renamed from: b  reason: collision with root package name */
        public final e.i0.i.g f5760b;

        /* compiled from: Http2Connection.java */
        /* loaded from: classes.dex */
        public class a extends e.i0.b {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e.i0.i.h f5762b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, Object[] objArr, e.i0.i.h hVar) {
                super(str, objArr);
                this.f5762b = hVar;
            }

            @Override // e.i0.b
            public void b() {
                try {
                    f.this.f5718b.a(this.f5762b);
                } catch (IOException e2) {
                    e.i0.j.e b2 = e.i0.j.e.b();
                    b2.a(4, "Http2Connection.Listener failure for " + f.this.f5720d, e2);
                    try {
                        this.f5762b.a(e.i0.i.a.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* compiled from: Http2Connection.java */
        /* loaded from: classes.dex */
        public class b extends e.i0.b {
            public b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // e.i0.b
            public void b() {
                f fVar = f.this;
                fVar.f5718b.a(fVar);
            }
        }

        /* compiled from: Http2Connection.java */
        /* loaded from: classes.dex */
        public class c extends e.i0.b {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ m f5765b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, Object[] objArr, m mVar) {
                super(str, objArr);
                this.f5765b = mVar;
            }

            @Override // e.i0.b
            public void b() {
                try {
                    f.this.r.a(this.f5765b);
                } catch (IOException unused) {
                }
            }
        }

        public j(e.i0.i.g gVar) {
            super("OkHttp %s", f.this.f5720d);
            this.f5760b = gVar;
        }

        @Override // e.i0.i.g.b
        public void a() {
        }

        @Override // e.i0.i.g.b
        public void a(int i2, int i3, int i4, boolean z) {
        }

        @Override // e.i0.i.g.b
        public void a(boolean z, int i2, f.e eVar, int i3) {
            if (f.this.b(i2)) {
                f.this.a(i2, eVar, i3, z);
                return;
            }
            e.i0.i.h a2 = f.this.a(i2);
            if (a2 == null) {
                f.this.c(i2, e.i0.i.a.PROTOCOL_ERROR);
                eVar.skip(i3);
                return;
            }
            a2.a(eVar, i3);
            if (z) {
                a2.i();
            }
        }

        @Override // e.i0.b
        public void b() {
            e.i0.i.a aVar;
            f fVar;
            e.i0.i.a aVar2 = e.i0.i.a.INTERNAL_ERROR;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    this.f5760b.a(this);
                    while (this.f5760b.a(false, (g.b) this)) {
                    }
                    aVar = e.i0.i.a.NO_ERROR;
                } catch (IOException unused) {
                }
                try {
                    aVar2 = e.i0.i.a.CANCEL;
                    fVar = f.this;
                } catch (IOException unused2) {
                    aVar = e.i0.i.a.PROTOCOL_ERROR;
                    aVar2 = e.i0.i.a.PROTOCOL_ERROR;
                    fVar = f.this;
                    fVar.a(aVar, aVar2);
                    e.i0.c.a(this.f5760b);
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
                aVar = aVar2;
                try {
                    f.this.a(aVar, aVar2);
                } catch (IOException unused4) {
                }
                e.i0.c.a(this.f5760b);
                throw th;
            }
            fVar.a(aVar, aVar2);
            e.i0.c.a(this.f5760b);
        }

        @Override // e.i0.i.g.b
        public void a(boolean z, int i2, int i3, List<e.i0.i.b> list) {
            if (f.this.b(i2)) {
                f.this.b(i2, list, z);
                return;
            }
            synchronized (f.this) {
                if (f.this.f5723g) {
                    return;
                }
                e.i0.i.h a2 = f.this.a(i2);
                if (a2 == null) {
                    if (i2 <= f.this.f5721e) {
                        return;
                    }
                    if (i2 % 2 == f.this.f5722f % 2) {
                        return;
                    }
                    e.i0.i.h hVar = new e.i0.i.h(i2, f.this, false, z, list);
                    f.this.f5721e = i2;
                    f.this.f5719c.put(Integer.valueOf(i2), hVar);
                    f.u.execute(new a("OkHttp %s stream %d", new Object[]{f.this.f5720d, Integer.valueOf(i2)}, hVar));
                    return;
                }
                a2.a(list);
                if (z) {
                    a2.i();
                }
            }
        }

        @Override // e.i0.i.g.b
        public void a(int i2, e.i0.i.a aVar) {
            if (f.this.b(i2)) {
                f.this.a(i2, aVar);
                return;
            }
            e.i0.i.h d2 = f.this.d(i2);
            if (d2 != null) {
                d2.d(aVar);
            }
        }

        @Override // e.i0.i.g.b
        public void a(boolean z, m mVar) {
            e.i0.i.h[] hVarArr;
            long j;
            int i2;
            synchronized (f.this) {
                int c2 = f.this.o.c();
                if (z) {
                    f.this.o.a();
                }
                f.this.o.a(mVar);
                a(mVar);
                int c3 = f.this.o.c();
                hVarArr = null;
                if (c3 == -1 || c3 == c2) {
                    j = 0;
                } else {
                    j = c3 - c2;
                    if (!f.this.p) {
                        f.this.g(j);
                        f.this.p = true;
                    }
                    if (!f.this.f5719c.isEmpty()) {
                        hVarArr = (e.i0.i.h[]) f.this.f5719c.values().toArray(new e.i0.i.h[f.this.f5719c.size()]);
                    }
                }
                f.u.execute(new b("OkHttp %s settings", f.this.f5720d));
            }
            if (hVarArr == null || j == 0) {
                return;
            }
            for (e.i0.i.h hVar : hVarArr) {
                synchronized (hVar) {
                    hVar.a(j);
                }
            }
        }

        public final void a(m mVar) {
            f.u.execute(new c("OkHttp %s ACK Settings", new Object[]{f.this.f5720d}, mVar));
        }

        @Override // e.i0.i.g.b
        public void a(boolean z, int i2, int i3) {
            if (z) {
                k c2 = f.this.c(i2);
                if (c2 != null) {
                    c2.b();
                    return;
                }
                return;
            }
            f.this.b(true, i2, i3, null);
        }

        @Override // e.i0.i.g.b
        public void a(int i2, e.i0.i.a aVar, f.f fVar) {
            e.i0.i.h[] hVarArr;
            fVar.f();
            synchronized (f.this) {
                hVarArr = (e.i0.i.h[]) f.this.f5719c.values().toArray(new e.i0.i.h[f.this.f5719c.size()]);
                f.this.f5723g = true;
            }
            for (e.i0.i.h hVar : hVarArr) {
                if (hVar.c() > i2 && hVar.f()) {
                    hVar.d(e.i0.i.a.REFUSED_STREAM);
                    f.this.d(hVar.c());
                }
            }
        }

        @Override // e.i0.i.g.b
        public void a(int i2, long j) {
            if (i2 == 0) {
                synchronized (f.this) {
                    f.this.m += j;
                    f.this.notifyAll();
                }
                return;
            }
            e.i0.i.h a2 = f.this.a(i2);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j);
                }
            }
        }

        @Override // e.i0.i.g.b
        public void a(int i2, int i3, List<e.i0.i.b> list) {
            f.this.a(i3, list);
        }
    }

    public void a(int i2, boolean z, f.c cVar, long j2) {
        int min;
        long j3;
        if (j2 == 0) {
            this.r.a(z, i2, cVar, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (this.m <= 0) {
                    try {
                        if (this.f5719c.containsKey(Integer.valueOf(i2))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j2, this.m), this.r.k());
                j3 = min;
                this.m -= j3;
            }
            j2 -= j3;
            this.r.a(z && j2 == 0, i2, cVar, min);
        }
    }

    public void a(int i2, long j2) {
        u.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f5720d, Integer.valueOf(i2)}, i2, j2));
    }

    public void a(boolean z, int i2, int i3, k kVar) {
        synchronized (this.r) {
            if (kVar != null) {
                kVar.c();
            }
            this.r.a(z, i2, i3);
        }
    }

    public void a(e.i0.i.a aVar) {
        synchronized (this.r) {
            synchronized (this) {
                if (this.f5723g) {
                    return;
                }
                this.f5723g = true;
                this.r.a(this.f5721e, aVar, e.i0.c.f5562a);
            }
        }
    }

    public void a(e.i0.i.a aVar, e.i0.i.a aVar2) {
        e.i0.i.h[] hVarArr;
        k[] kVarArr = null;
        try {
            a(aVar);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (this.f5719c.isEmpty()) {
                hVarArr = null;
            } else {
                hVarArr = (e.i0.i.h[]) this.f5719c.values().toArray(new e.i0.i.h[this.f5719c.size()]);
                this.f5719c.clear();
            }
            if (this.f5725i != null) {
                this.f5725i = null;
                kVarArr = (k[]) this.f5725i.values().toArray(new k[this.f5725i.size()]);
            }
        }
        if (hVarArr != null) {
            IOException iOException = e;
            for (e.i0.i.h hVar : hVarArr) {
                try {
                    hVar.a(aVar2);
                } catch (IOException e3) {
                    if (iOException != null) {
                        iOException = e3;
                    }
                }
            }
            e = iOException;
        }
        if (kVarArr != null) {
            for (k kVar : kVarArr) {
                kVar.a();
            }
        }
        try {
            this.r.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.q.close();
        } catch (IOException e5) {
            e = e5;
        }
        if (e != null) {
            throw e;
        }
    }

    public void a(boolean z) {
        if (z) {
            this.r.j();
            this.r.b(this.n);
            int c2 = this.n.c();
            if (c2 != 65535) {
                this.r.a(0, c2 - 65535);
            }
        }
        new Thread(this.s).start();
    }

    public void a(int i2, List<e.i0.i.b> list) {
        synchronized (this) {
            if (this.t.contains(Integer.valueOf(i2))) {
                c(i2, e.i0.i.a.PROTOCOL_ERROR);
                return;
            }
            this.t.add(Integer.valueOf(i2));
            this.f5724h.execute(new d("OkHttp %s Push Request[%s]", new Object[]{this.f5720d, Integer.valueOf(i2)}, i2, list));
        }
    }

    public void a(int i2, f.e eVar, int i3, boolean z) {
        f.c cVar = new f.c();
        long j2 = i3;
        eVar.d(j2);
        eVar.a(cVar, j2);
        if (cVar.s() == j2) {
            this.f5724h.execute(new C0117f("OkHttp %s Push Data[%s]", new Object[]{this.f5720d, Integer.valueOf(i2)}, i2, cVar, i3, z));
            return;
        }
        throw new IOException(cVar.s() + " != " + i3);
    }

    public void a(int i2, e.i0.i.a aVar) {
        this.f5724h.execute(new g("OkHttp %s Push Reset[%s]", new Object[]{this.f5720d, Integer.valueOf(i2)}, i2, aVar));
    }
}
