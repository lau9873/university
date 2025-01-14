package p181e.p182i0.p187i;

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
import p181e.p182i0.NamedRunnable;
import p181e.p182i0.Util;
import p181e.p182i0.p187i.Http2Reader;
import p181e.p182i0.p188j.Platform;
import p192f.Buffer;
import p192f.BufferedSink;
import p192f.BufferedSource;
import p192f.C1822f;

/* renamed from: e.i0.i.f */
/* loaded from: classes.dex */
public final class Http2Connection implements Closeable {

    /* renamed from: u */
    public static final ExecutorService f8111u = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.m3162a("OkHttp Http2Connection", true));

    /* renamed from: a */
    public final boolean f8112a;

    /* renamed from: b */
    public final AbstractC1778i f8113b;

    /* renamed from: d */
    public final String f8115d;

    /* renamed from: e */
    public int f8116e;

    /* renamed from: f */
    public int f8117f;

    /* renamed from: g */
    public boolean f8118g;

    /* renamed from: h */
    public final ExecutorService f8119h;

    /* renamed from: i */
    public Map<Integer, Ping> f8120i;

    /* renamed from: j */
    public final PushObserver f8121j;

    /* renamed from: m */
    public long f8123m;

    /* renamed from: q */
    public final Socket f8127q;

    /* renamed from: r */
    public final Http2Writer f8128r;

    /* renamed from: s */
    public final C1780j f8129s;

    /* renamed from: c */
    public final Map<Integer, Http2Stream> f8114c = new LinkedHashMap();

    /* renamed from: k */
    public long f8122k = 0;

    /* renamed from: n */
    public C1791m f8124n = new C1791m();

    /* renamed from: o */
    public final C1791m f8125o = new C1791m();

    /* renamed from: p */
    public boolean f8126p = false;

    /* renamed from: t */
    public final Set<Integer> f8130t = new LinkedHashSet();

    /* compiled from: Http2Connection.java */
    /* renamed from: e.i0.i.f$a */
    /* loaded from: classes.dex */
    public class C1770a extends NamedRunnable {

        /* renamed from: b */
        public final /* synthetic */ int f8131b;

        /* renamed from: c */
        public final /* synthetic */ ErrorCode f8132c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1770a(String str, Object[] objArr, int i, ErrorCode errorCode) {
            super(str, objArr);
            this.f8131b = i;
            this.f8132c = errorCode;
        }

        @Override // p181e.p182i0.NamedRunnable
        /* renamed from: b */
        public void mo2965b() {
            try {
                Http2Connection.this.m2981b(this.f8131b, this.f8132c);
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: e.i0.i.f$b */
    /* loaded from: classes.dex */
    public class C1771b extends NamedRunnable {

        /* renamed from: b */
        public final /* synthetic */ int f8134b;

        /* renamed from: c */
        public final /* synthetic */ long f8135c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1771b(String str, Object[] objArr, int i, long j) {
            super(str, objArr);
            this.f8134b = i;
            this.f8135c = j;
        }

        @Override // p181e.p182i0.NamedRunnable
        /* renamed from: b */
        public void mo2965b() {
            try {
                Http2Connection.this.f8128r.m2911a(this.f8134b, this.f8135c);
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: e.i0.i.f$c */
    /* loaded from: classes.dex */
    public class C1772c extends NamedRunnable {

        /* renamed from: b */
        public final /* synthetic */ boolean f8137b;

        /* renamed from: c */
        public final /* synthetic */ int f8138c;

        /* renamed from: d */
        public final /* synthetic */ int f8139d;

        /* renamed from: e */
        public final /* synthetic */ Ping f8140e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1772c(String str, Object[] objArr, boolean z, int i, int i2, Ping ping) {
            super(str, objArr);
            this.f8137b = z;
            this.f8138c = i;
            this.f8139d = i2;
            this.f8140e = ping;
        }

        @Override // p181e.p182i0.NamedRunnable
        /* renamed from: b */
        public void mo2965b() {
            try {
                Http2Connection.this.m2983a(this.f8137b, this.f8138c, this.f8139d, this.f8140e);
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: e.i0.i.f$d */
    /* loaded from: classes.dex */
    public class C1773d extends NamedRunnable {

        /* renamed from: b */
        public final /* synthetic */ int f8142b;

        /* renamed from: c */
        public final /* synthetic */ List f8143c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1773d(String str, Object[] objArr, int i, List list) {
            super(str, objArr);
            this.f8142b = i;
            this.f8143c = list;
        }

        @Override // p181e.p182i0.NamedRunnable
        /* renamed from: b */
        public void mo2965b() {
            if (Http2Connection.this.f8121j.mo2887a(this.f8142b, this.f8143c)) {
                try {
                    Http2Connection.this.f8128r.m2910a(this.f8142b, ErrorCode.CANCEL);
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.f8130t.remove(Integer.valueOf(this.f8142b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: e.i0.i.f$e */
    /* loaded from: classes.dex */
    public class C1774e extends NamedRunnable {

        /* renamed from: b */
        public final /* synthetic */ int f8145b;

        /* renamed from: c */
        public final /* synthetic */ List f8146c;

        /* renamed from: d */
        public final /* synthetic */ boolean f8147d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1774e(String str, Object[] objArr, int i, List list, boolean z) {
            super(str, objArr);
            this.f8145b = i;
            this.f8146c = list;
            this.f8147d = z;
        }

        @Override // p181e.p182i0.NamedRunnable
        /* renamed from: b */
        public void mo2965b() {
            boolean mo2886a = Http2Connection.this.f8121j.mo2886a(this.f8145b, this.f8146c, this.f8147d);
            if (mo2886a) {
                try {
                    Http2Connection.this.f8128r.m2910a(this.f8145b, ErrorCode.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (mo2886a || this.f8147d) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f8130t.remove(Integer.valueOf(this.f8145b));
                }
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: e.i0.i.f$f */
    /* loaded from: classes.dex */
    public class C1775f extends NamedRunnable {

        /* renamed from: b */
        public final /* synthetic */ int f8149b;

        /* renamed from: c */
        public final /* synthetic */ Buffer f8150c;

        /* renamed from: d */
        public final /* synthetic */ int f8151d;

        /* renamed from: e */
        public final /* synthetic */ boolean f8152e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1775f(String str, Object[] objArr, int i, Buffer buffer, int i2, boolean z) {
            super(str, objArr);
            this.f8149b = i;
            this.f8150c = buffer;
            this.f8151d = i2;
            this.f8152e = z;
        }

        @Override // p181e.p182i0.NamedRunnable
        /* renamed from: b */
        public void mo2965b() {
            try {
                boolean mo2888a = Http2Connection.this.f8121j.mo2888a(this.f8149b, this.f8150c, this.f8151d, this.f8152e);
                if (mo2888a) {
                    Http2Connection.this.f8128r.m2910a(this.f8149b, ErrorCode.CANCEL);
                }
                if (mo2888a || this.f8152e) {
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.f8130t.remove(Integer.valueOf(this.f8149b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: e.i0.i.f$g */
    /* loaded from: classes.dex */
    public class C1776g extends NamedRunnable {

        /* renamed from: b */
        public final /* synthetic */ int f8154b;

        /* renamed from: c */
        public final /* synthetic */ ErrorCode f8155c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1776g(String str, Object[] objArr, int i, ErrorCode errorCode) {
            super(str, objArr);
            this.f8154b = i;
            this.f8155c = errorCode;
        }

        @Override // p181e.p182i0.NamedRunnable
        /* renamed from: b */
        public void mo2965b() {
            Http2Connection.this.f8121j.mo2889a(this.f8154b, this.f8155c);
            synchronized (Http2Connection.this) {
                Http2Connection.this.f8130t.remove(Integer.valueOf(this.f8154b));
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: e.i0.i.f$i */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1778i {

        /* renamed from: a */
        public static final AbstractC1778i f8164a = new C1779a();

        /* compiled from: Http2Connection.java */
        /* renamed from: e.i0.i.f$i$a */
        /* loaded from: classes.dex */
        public class C1779a extends AbstractC1778i {
            @Override // p181e.p182i0.p187i.Http2Connection.AbstractC1778i
            /* renamed from: a */
            public void mo2967a(Http2Stream http2Stream) {
                http2Stream.m2936a(ErrorCode.REFUSED_STREAM);
            }
        }

        /* renamed from: a */
        public void mo2968a(Http2Connection http2Connection) {
        }

        /* renamed from: a */
        public abstract void mo2967a(Http2Stream http2Stream);
    }

    public Http2Connection(C1777h c1777h) {
        this.f8121j = c1777h.f8162f;
        boolean z = c1777h.f8163g;
        this.f8112a = z;
        this.f8113b = c1777h.f8161e;
        this.f8117f = z ? 1 : 2;
        if (c1777h.f8163g) {
            this.f8117f += 2;
        }
        boolean z2 = c1777h.f8163g;
        if (c1777h.f8163g) {
            this.f8124n.m2883a(7, 16777216);
        }
        this.f8115d = c1777h.f8158b;
        this.f8119h = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.m3162a(Util.m3161a("OkHttp %s Push Observer", this.f8115d), true));
        this.f8125o.m2883a(7, 65535);
        this.f8125o.m2883a(5, 16384);
        this.f8123m = this.f8125o.m2879c();
        this.f8127q = c1777h.f8157a;
        this.f8128r = new Http2Writer(c1777h.f8160d, this.f8112a);
        this.f8129s = new C1780j(new Http2Reader(c1777h.f8159c, this.f8112a));
    }

    /* renamed from: a */
    public synchronized Http2Stream m2994a(int i) {
        return this.f8114c.get(Integer.valueOf(i));
    }

    /* renamed from: b */
    public void m2981b(int i, ErrorCode errorCode) {
        this.f8128r.m2910a(i, errorCode);
    }

    /* renamed from: b */
    public boolean m2982b(int i) {
        return i != 0 && (i & 1) == 0;
    }

    /* renamed from: c */
    public void m2977c(int i, ErrorCode errorCode) {
        f8111u.execute(new C1770a("OkHttp %s stream %d", new Object[]{this.f8115d, Integer.valueOf(i)}, i, errorCode));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m2986a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* renamed from: d */
    public synchronized Http2Stream m2976d(int i) {
        Http2Stream remove;
        remove = this.f8114c.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public void flush() {
        this.f8128r.flush();
    }

    /* renamed from: g */
    public void m2975g(long j) {
        this.f8123m += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* renamed from: j */
    public synchronized boolean m2974j() {
        return this.f8118g;
    }

    /* renamed from: k */
    public synchronized int m2973k() {
        return this.f8125o.m2880b(Integer.MAX_VALUE);
    }

    /* renamed from: l */
    public void m2972l() {
        m2984a(true);
    }

    /* renamed from: a */
    public Http2Stream m2985a(List<C1766b> list, boolean z) {
        return m2989a(0, list, z);
    }

    /* renamed from: b */
    public void m2979b(boolean z, int i, int i2, Ping ping) {
        f8111u.execute(new C1772c("OkHttp %s ping %08x%08x", new Object[]{this.f8115d, Integer.valueOf(i), Integer.valueOf(i2)}, z, i, i2, ping));
    }

    /* renamed from: c */
    public synchronized Ping m2978c(int i) {
        return this.f8120i != null ? this.f8120i.remove(Integer.valueOf(i)) : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037 A[Catch: all -> 0x0069, TryCatch #1 {, blocks: (B:4:0x0006, B:21:0x0043, B:25:0x0052, B:22:0x0049, B:24:0x004d, B:29:0x005b, B:30:0x0062, B:5:0x0007, B:7:0x000b, B:9:0x001f, B:11:0x0027, B:16:0x0031, B:18:0x0037, B:19:0x0040, B:31:0x0063, B:32:0x0068), top: B:39:0x0006 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p181e.p182i0.p187i.Http2Stream m2989a(int r11, java.util.List<p181e.p182i0.p187i.C1766b> r12, boolean r13) {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            e.i0.i.i r7 = r10.f8128r
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L6c
            boolean r0 = r10.f8118g     // Catch: java.lang.Throwable -> L69
            if (r0 != 0) goto L63
            int r8 = r10.f8117f     // Catch: java.lang.Throwable -> L69
            int r0 = r10.f8117f     // Catch: java.lang.Throwable -> L69
            int r0 = r0 + 2
            r10.f8117f = r0     // Catch: java.lang.Throwable -> L69
            e.i0.i.h r9 = new e.i0.i.h     // Catch: java.lang.Throwable -> L69
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L69
            if (r13 == 0) goto L30
            long r0 = r10.f8123m     // Catch: java.lang.Throwable -> L69
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L30
            long r0 = r9.f8184b     // Catch: java.lang.Throwable -> L69
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L2e
            goto L30
        L2e:
            r13 = 0
            goto L31
        L30:
            r13 = 1
        L31:
            boolean r0 = r9.m2925g()     // Catch: java.lang.Throwable -> L69
            if (r0 == 0) goto L40
            java.util.Map<java.lang.Integer, e.i0.i.h> r0 = r10.f8114c     // Catch: java.lang.Throwable -> L69
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L69
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L69
        L40:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L69
            if (r11 != 0) goto L49
            e.i0.i.i r0 = r10.f8128r     // Catch: java.lang.Throwable -> L6c
            r0.m2905a(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L6c
            goto L52
        L49:
            boolean r0 = r10.f8112a     // Catch: java.lang.Throwable -> L6c
            if (r0 != 0) goto L5b
            e.i0.i.i r0 = r10.f8128r     // Catch: java.lang.Throwable -> L6c
            r0.m2912a(r11, r8, r12)     // Catch: java.lang.Throwable -> L6c
        L52:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L6c
            if (r13 == 0) goto L5a
            e.i0.i.i r11 = r10.f8128r
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
        throw new UnsupportedOperationException("Method not decompiled: p181e.p182i0.p187i.Http2Connection.m2989a(int, java.util.List, boolean):e.i0.i.h");
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: e.i0.i.f$h */
    /* loaded from: classes.dex */
    public static class C1777h {

        /* renamed from: a */
        public Socket f8157a;

        /* renamed from: b */
        public String f8158b;

        /* renamed from: c */
        public BufferedSource f8159c;

        /* renamed from: d */
        public BufferedSink f8160d;

        /* renamed from: e */
        public AbstractC1778i f8161e = AbstractC1778i.f8164a;

        /* renamed from: f */
        public PushObserver f8162f = PushObserver.f8222a;

        /* renamed from: g */
        public boolean f8163g;

        public C1777h(boolean z) {
            this.f8163g = z;
        }

        /* renamed from: a */
        public C1777h m2969a(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f8157a = socket;
            this.f8158b = str;
            this.f8159c = bufferedSource;
            this.f8160d = bufferedSink;
            return this;
        }

        /* renamed from: a */
        public C1777h m2970a(AbstractC1778i abstractC1778i) {
            this.f8161e = abstractC1778i;
            return this;
        }

        /* renamed from: a */
        public Http2Connection m2971a() {
            return new Http2Connection(this);
        }
    }

    /* renamed from: b */
    public void m2980b(int i, List<C1766b> list, boolean z) {
        this.f8119h.execute(new C1774e("OkHttp %s Push Headers[%s]", new Object[]{this.f8115d, Integer.valueOf(i)}, i, list, z));
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: e.i0.i.f$j */
    /* loaded from: classes.dex */
    public class C1780j extends NamedRunnable implements Http2Reader.InterfaceC1785b {

        /* renamed from: b */
        public final Http2Reader f8165b;

        /* compiled from: Http2Connection.java */
        /* renamed from: e.i0.i.f$j$a */
        /* loaded from: classes.dex */
        public class C1781a extends NamedRunnable {

            /* renamed from: b */
            public final /* synthetic */ Http2Stream f8167b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1781a(String str, Object[] objArr, Http2Stream http2Stream) {
                super(str, objArr);
                this.f8167b = http2Stream;
            }

            @Override // p181e.p182i0.NamedRunnable
            /* renamed from: b */
            public void mo2965b() {
                try {
                    Http2Connection.this.f8113b.mo2967a(this.f8167b);
                } catch (IOException e) {
                    Platform m2853b = Platform.m2853b();
                    m2853b.mo2861a(4, "Http2Connection.Listener failure for " + Http2Connection.this.f8115d, e);
                    try {
                        this.f8167b.m2936a(ErrorCode.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* compiled from: Http2Connection.java */
        /* renamed from: e.i0.i.f$j$b */
        /* loaded from: classes.dex */
        public class C1782b extends NamedRunnable {
            public C1782b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // p181e.p182i0.NamedRunnable
            /* renamed from: b */
            public void mo2965b() {
                Http2Connection http2Connection = Http2Connection.this;
                http2Connection.f8113b.mo2968a(http2Connection);
            }
        }

        /* compiled from: Http2Connection.java */
        /* renamed from: e.i0.i.f$j$c */
        /* loaded from: classes.dex */
        public class C1783c extends NamedRunnable {

            /* renamed from: b */
            public final /* synthetic */ C1791m f8170b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1783c(String str, Object[] objArr, C1791m c1791m) {
                super(str, objArr);
                this.f8170b = c1791m;
            }

            @Override // p181e.p182i0.NamedRunnable
            /* renamed from: b */
            public void mo2965b() {
                try {
                    Http2Connection.this.f8128r.m2908a(this.f8170b);
                } catch (IOException unused) {
                }
            }
        }

        public C1780j(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.f8115d);
            this.f8165b = http2Reader;
        }

        @Override // p181e.p182i0.p187i.Http2Reader.InterfaceC1785b
        /* renamed from: a */
        public void mo2948a() {
        }

        @Override // p181e.p182i0.p187i.Http2Reader.InterfaceC1785b
        /* renamed from: a */
        public void mo2947a(int i, int i2, int i3, boolean z) {
        }

        @Override // p181e.p182i0.p187i.Http2Reader.InterfaceC1785b
        /* renamed from: a */
        public void mo2940a(boolean z, int i, BufferedSource bufferedSource, int i2) {
            if (Http2Connection.this.m2982b(i)) {
                Http2Connection.this.m2991a(i, bufferedSource, i2, z);
                return;
            }
            Http2Stream m2994a = Http2Connection.this.m2994a(i);
            if (m2994a == null) {
                Http2Connection.this.m2977c(i, ErrorCode.PROTOCOL_ERROR);
                bufferedSource.skip(i2);
                return;
            }
            m2994a.m2935a(bufferedSource, i2);
            if (z) {
                m2994a.m2923i();
            }
        }

        @Override // p181e.p182i0.NamedRunnable
        /* renamed from: b */
        public void mo2965b() {
            ErrorCode errorCode;
            Http2Connection http2Connection;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.f8165b.m2962a(this);
                        while (this.f8165b.m2958a(false, (Http2Reader.InterfaceC1785b) this)) {
                        }
                        errorCode = ErrorCode.NO_ERROR;
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        th = th;
                        errorCode = errorCode2;
                        try {
                            Http2Connection.this.m2986a(errorCode, errorCode2);
                        } catch (IOException unused2) {
                        }
                        Util.m3169a(this.f8165b);
                        throw th;
                    }
                    try {
                        errorCode2 = ErrorCode.CANCEL;
                        http2Connection = Http2Connection.this;
                    } catch (IOException unused3) {
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                        errorCode2 = ErrorCode.PROTOCOL_ERROR;
                        http2Connection = Http2Connection.this;
                        http2Connection.m2986a(errorCode, errorCode2);
                        Util.m3169a(this.f8165b);
                    }
                    http2Connection.m2986a(errorCode, errorCode2);
                } catch (IOException unused4) {
                }
                Util.m3169a(this.f8165b);
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // p181e.p182i0.p187i.Http2Reader.InterfaceC1785b
        /* renamed from: a */
        public void mo2941a(boolean z, int i, int i2, List<C1766b> list) {
            if (Http2Connection.this.m2982b(i)) {
                Http2Connection.this.m2980b(i, list, z);
                return;
            }
            synchronized (Http2Connection.this) {
                if (Http2Connection.this.f8118g) {
                    return;
                }
                Http2Stream m2994a = Http2Connection.this.m2994a(i);
                if (m2994a == null) {
                    if (i <= Http2Connection.this.f8116e) {
                        return;
                    }
                    if (i % 2 == Http2Connection.this.f8117f % 2) {
                        return;
                    }
                    Http2Stream http2Stream = new Http2Stream(i, Http2Connection.this, false, z, list);
                    Http2Connection.this.f8116e = i;
                    Http2Connection.this.f8114c.put(Integer.valueOf(i), http2Stream);
                    Http2Connection.f8111u.execute(new C1781a("OkHttp %s stream %d", new Object[]{Http2Connection.this.f8115d, Integer.valueOf(i)}, http2Stream));
                    return;
                }
                m2994a.m2934a(list);
                if (z) {
                    m2994a.m2923i();
                }
            }
        }

        @Override // p181e.p182i0.p187i.Http2Reader.InterfaceC1785b
        /* renamed from: a */
        public void mo2944a(int i, ErrorCode errorCode) {
            if (Http2Connection.this.m2982b(i)) {
                Http2Connection.this.m2992a(i, errorCode);
                return;
            }
            Http2Stream m2976d = Http2Connection.this.m2976d(i);
            if (m2976d != null) {
                m2976d.m2928d(errorCode);
            }
        }

        @Override // p181e.p182i0.p187i.Http2Reader.InterfaceC1785b
        /* renamed from: a */
        public void mo2939a(boolean z, C1791m c1791m) {
            Http2Stream[] http2StreamArr;
            long j;
            int i;
            synchronized (Http2Connection.this) {
                int m2879c = Http2Connection.this.f8125o.m2879c();
                if (z) {
                    Http2Connection.this.f8125o.m2885a();
                }
                Http2Connection.this.f8125o.m2882a(c1791m);
                m2966a(c1791m);
                int m2879c2 = Http2Connection.this.f8125o.m2879c();
                http2StreamArr = null;
                if (m2879c2 == -1 || m2879c2 == m2879c) {
                    j = 0;
                } else {
                    j = m2879c2 - m2879c;
                    if (!Http2Connection.this.f8126p) {
                        Http2Connection.this.m2975g(j);
                        Http2Connection.this.f8126p = true;
                    }
                    if (!Http2Connection.this.f8114c.isEmpty()) {
                        http2StreamArr = (Http2Stream[]) Http2Connection.this.f8114c.values().toArray(new Http2Stream[Http2Connection.this.f8114c.size()]);
                    }
                }
                Http2Connection.f8111u.execute(new C1782b("OkHttp %s settings", Http2Connection.this.f8115d));
            }
            if (http2StreamArr == null || j == 0) {
                return;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                synchronized (http2Stream) {
                    http2Stream.m2937a(j);
                }
            }
        }

        /* renamed from: a */
        public final void m2966a(C1791m c1791m) {
            Http2Connection.f8111u.execute(new C1783c("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.f8115d}, c1791m));
        }

        @Override // p181e.p182i0.p187i.Http2Reader.InterfaceC1785b
        /* renamed from: a */
        public void mo2942a(boolean z, int i, int i2) {
            if (z) {
                Ping m2978c = Http2Connection.this.m2978c(i);
                if (m2978c != null) {
                    m2978c.m2891b();
                    return;
                }
                return;
            }
            Http2Connection.this.m2979b(true, i, i2, null);
        }

        @Override // p181e.p182i0.p187i.Http2Reader.InterfaceC1785b
        /* renamed from: a */
        public void mo2943a(int i, ErrorCode errorCode, C1822f c1822f) {
            Http2Stream[] http2StreamArr;
            c1822f.mo2535f();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.f8114c.values().toArray(new Http2Stream[Http2Connection.this.f8114c.size()]);
                Http2Connection.this.f8118g = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.m2931c() > i && http2Stream.m2926f()) {
                    http2Stream.m2928d(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.m2976d(http2Stream.m2931c());
                }
            }
        }

        @Override // p181e.p182i0.p187i.Http2Reader.InterfaceC1785b
        /* renamed from: a */
        public void mo2945a(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f8123m += j;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream m2994a = Http2Connection.this.m2994a(i);
            if (m2994a != null) {
                synchronized (m2994a) {
                    m2994a.m2937a(j);
                }
            }
        }

        @Override // p181e.p182i0.p187i.Http2Reader.InterfaceC1785b
        /* renamed from: a */
        public void mo2946a(int i, int i2, List<C1766b> list) {
            Http2Connection.this.m2990a(i2, list);
        }
    }

    /* renamed from: a */
    public void m2988a(int i, boolean z, Buffer buffer, long j) {
        int min;
        long j2;
        if (j == 0) {
            this.f8128r.m2904a(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.f8123m <= 0) {
                    try {
                        if (this.f8114c.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.f8123m), this.f8128r.m2899k());
                j2 = min;
                this.f8123m -= j2;
            }
            j -= j2;
            this.f8128r.m2904a(z && j == 0, i, buffer, min);
        }
    }

    /* renamed from: a */
    public void m2993a(int i, long j) {
        f8111u.execute(new C1771b("OkHttp Window Update %s stream %d", new Object[]{this.f8115d, Integer.valueOf(i)}, i, j));
    }

    /* renamed from: a */
    public void m2983a(boolean z, int i, int i2, Ping ping) {
        synchronized (this.f8128r) {
            if (ping != null) {
                ping.m2890c();
            }
            this.f8128r.m2906a(z, i, i2);
        }
    }

    /* renamed from: a */
    public void m2987a(ErrorCode errorCode) {
        synchronized (this.f8128r) {
            synchronized (this) {
                if (this.f8118g) {
                    return;
                }
                this.f8118g = true;
                this.f8128r.m2909a(this.f8116e, errorCode, Util.f7934a);
            }
        }
    }

    /* renamed from: a */
    public void m2986a(ErrorCode errorCode, ErrorCode errorCode2) {
        Http2Stream[] http2StreamArr;
        Ping[] pingArr = null;
        try {
            m2987a(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (this.f8114c.isEmpty()) {
                http2StreamArr = null;
            } else {
                http2StreamArr = (Http2Stream[]) this.f8114c.values().toArray(new Http2Stream[this.f8114c.size()]);
                this.f8114c.clear();
            }
            if (this.f8120i != null) {
                this.f8120i = null;
                pingArr = (Ping[]) this.f8120i.values().toArray(new Ping[this.f8120i.size()]);
            }
        }
        if (http2StreamArr != null) {
            IOException iOException = e;
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.m2936a(errorCode2);
                } catch (IOException e2) {
                    if (iOException != null) {
                        iOException = e2;
                    }
                }
            }
            e = iOException;
        }
        if (pingArr != null) {
            for (Ping ping : pingArr) {
                ping.m2892a();
            }
        }
        try {
            this.f8128r.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.f8127q.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    /* renamed from: a */
    public void m2984a(boolean z) {
        if (z) {
            this.f8128r.m2900j();
            this.f8128r.m2901b(this.f8124n);
            int m2879c = this.f8124n.m2879c();
            if (m2879c != 65535) {
                this.f8128r.m2911a(0, m2879c - 65535);
            }
        }
        new Thread(this.f8129s).start();
    }

    /* renamed from: a */
    public void m2990a(int i, List<C1766b> list) {
        synchronized (this) {
            if (this.f8130t.contains(Integer.valueOf(i))) {
                m2977c(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f8130t.add(Integer.valueOf(i));
            this.f8119h.execute(new C1773d("OkHttp %s Push Request[%s]", new Object[]{this.f8115d, Integer.valueOf(i)}, i, list));
        }
    }

    /* renamed from: a */
    public void m2991a(int i, BufferedSource bufferedSource, int i2, boolean z) {
        Buffer buffer = new Buffer();
        long j = i2;
        bufferedSource.mo2558d(j);
        bufferedSource.mo673a(buffer, j);
        if (buffer.m2605s() == j) {
            this.f8119h.execute(new C1775f("OkHttp %s Push Data[%s]", new Object[]{this.f8115d, Integer.valueOf(i)}, i, buffer, i2, z));
            return;
        }
        throw new IOException(buffer.m2605s() + " != " + i2);
    }

    /* renamed from: a */
    public void m2992a(int i, ErrorCode errorCode) {
        this.f8119h.execute(new C1776g("OkHttp %s Push Reset[%s]", new Object[]{this.f8115d, Integer.valueOf(i)}, i, errorCode));
    }
}
